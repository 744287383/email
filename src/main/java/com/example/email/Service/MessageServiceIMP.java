package com.example.email.Service;

import com.example.email.Enum.*;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MinMessageDTO;
import com.example.email.entity.MessageExample;
import com.example.email.entity.Staff;
import com.example.email.entity.StaffExample;
import com.example.email.mapper.MessageMapper;
import com.example.email.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.mail.pop3.POP3Folder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import com.example.email.entity.Message;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageServiceIMP {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    @Qualifier("addJavaMailSenderImpl")
    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    @Value("${spring.mail.host}")
    private String host;
    @Autowired
    private StaffMapper staffMapper;

    public long getUserALLMessageCount(LoginUser loginUser) {
        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginUser.getEmail());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }

    public long getUserUnreadMessageCount(LoginUser loginUser) {
        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginUser.getEmail()).andReadedEqualTo(ReadStatus.UNREAD.getStatus());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }

    public long getUserDeletedMessageCount(LoginUser loginUser) {
        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginUser.getEmail()).andRecStatusEqualTo(RecStatus.DELETED.getStatus());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }

    public long getUserNewMessageCount(LoginUser loginUser) {
        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginUser.getEmail()).andNewMsgEqualTo(NewMsgStatus.NEW_MSG.getStatus());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }

    public PageInfo<MinMessageDTO> getUserUndeleteMsgList(int indexPage, int size, LoginUser loginUser)  {

        PageHelper.startPage(indexPage, size);
        List<Message> messages = getUndeleteMessageListByDB(loginUser.getEmail());
        PageInfo pageInfo = new PageInfo<>(messages,5);
        Map<String, MinMessageDTO> msgMap = getFloderMSG(loginUser.getUserName(),loginUser.getEmailPassword());
        List<MinMessageDTO> collect=new ArrayList<>();
        if (null!=messages){

        collect = messages.stream().map(message -> {
            MinMessageDTO minMessageDTO = msgMap.get(message.getMessageName());
            BeanUtils.copyProperties(message, minMessageDTO);

            return minMessageDTO;
        }).collect(Collectors.toList());
        }
       pageInfo.setList(collect);


        return pageInfo;
    }

    private List<Message> getUndeleteMessageListByDB(String email) {

        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(email).andRecStatusEqualTo(RecStatus.UNDELETE.getStatus());
        messageExample.setOrderByClause("last_updated desc");
        List<Message> messages = messageMapper.selectByExample(messageExample);
        if (null == messages || 0 == messages.size()) {
            return messages;
        }
        return messages;
    }

    private Map<String, MinMessageDTO> getFloderMSG(String username,String emailpassword)  {
        javaMailSenderImpl.setUsername(username);
        javaMailSenderImpl.setPassword(emailpassword);
        Session session = javaMailSenderImpl.getSession();
        POP3Folder folder = null;
        Store pop3 = null;
        try {
            pop3 = session.getStore("pop3");
            pop3.connect(host, username, emailpassword);
            folder = (POP3Folder) pop3.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            javax.mail.Message[] messages = folder.getMessages();
            POP3Folder finalFolder = folder;

            Map<String, MinMessageDTO> collect = Arrays.stream(messages).collect(Collectors.toMap(message -> {
                String uid = "";
                try {
                    uid = finalFolder.getUID(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                return uid;
            }, message -> {
                MinMessageDTO minMessageDTO = new MinMessageDTO();
                boolean status = false;

                try {
                    status = isContainAttachment(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (status) {
                    minMessageDTO.setIsFileStatus(IsFileStatus.IS_FILE.getStatus());
                } else {
                    minMessageDTO.setIsFileStatus(IsFileStatus.NO_FILE.getStatus());
                }

                try {
                    minMessageDTO.setSubject(message.getSubject());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                try {
                    minMessageDTO.setSize(message.getSize());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return minMessageDTO;
            }));


            return collect;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.out.println("获取Store失败");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("连接邮件服务器邮箱失败");
        } finally {
            try {
                if (null != folder)
                    folder.close(true);
                if (null != pop3)
                    pop3.close();
            } catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("关闭邮箱链接失败！");
            }

        }
        return new HashMap<>();
    }

    private boolean isContainAttachment(Part part) throws MessagingException, IOException {
        boolean flag = false;
        if (part.isMimeType("multipart/*")) {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*")) {
                    flag = isContainAttachment(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("application") != -1) {
                        flag = true;
                    }

                    if (contentType.indexOf("name") != -1) {
                        flag = true;
                    }
                }

                if (flag) break;
            }
        } else if (part.isMimeType("message/rfc822")) {
            flag = isContainAttachment((Part)part.getContent());
        }
        return flag;
    }


    public void deleteMsgByMsgID(List<String> msgIdList,LoginUser loginUser) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andMessageNameIn(msgIdList).andRecipientsEqualTo(loginUser.getEmail());
        Message message=new Message();
        message.setRecStatus(RecStatus.DELETED.getStatus());
        Date date=new Date(System.currentTimeMillis());
        message.setDeleteTime(date);
        messageMapper.updateByExampleSelective(message,messageExample);

    }
    public void deletedMsgByMsgID(List<String> msgIdList,LoginUser loginUser) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andMessageNameIn(msgIdList).andRecipientsEqualTo(loginUser.getEmail());
        Message message=new Message();
        message.setRecStatus(RecStatus.DELETE_COMPLETELY.getStatus());
        Date date=new Date(System.currentTimeMillis());
        message.setDeleteTime(date);
        messageMapper.updateByExampleSelective(message,messageExample);

    }

    public void readedMsg(LoginUser user, List<String> msgIdList) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andMessageNameIn(msgIdList).andRecipientsEqualTo(user.getEmail());
        Message message=new Message();
       message.setNewMsg(NewMsgStatus.OLD_MSG.getStatus());
       message.setReaded(ReadStatus.READED.getStatus());
        messageMapper.updateByExampleSelective(message,messageExample);
    }

    public void readedAllMsg(LoginUser user) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andRecipientsEqualTo(user.getEmail());
        Message message=new Message();
        message.setNewMsg(NewMsgStatus.OLD_MSG.getStatus());
        message.setReaded(ReadStatus.READED.getStatus());
        messageMapper.updateByExampleSelective(message,messageExample);
    }

    public PageInfo<MinMessageDTO> getdeletedMsgList(int indexPage, int size, LoginUser loginUser) {
        PageHelper.startPage(indexPage, size);
        List<Message> messages = getdeletedMessageListByDB(loginUser.getEmail());
        PageInfo pageInfo = new PageInfo<>(messages,5);
        Map<String, MinMessageDTO> msgMap = getFloderMSG(loginUser.getUserName(),loginUser.getEmailPassword());
        List<MinMessageDTO> collect=new ArrayList<>();
        if (null!=messages){

            collect = messages.stream().map(message -> {
                MinMessageDTO minMessageDTO = msgMap.get(message.getMessageName());
                BeanUtils.copyProperties(message, minMessageDTO);

                return minMessageDTO;
            }).collect(Collectors.toList());
        }
        pageInfo.setList(collect);


        return pageInfo;

    }
    private List<Message> getdeletedMessageListByDB(String email) {

        MessageExample messageExample = new MessageExample();
        messageExample.or().andRecipientsEqualTo(email).andRecStatusEqualTo(RecStatus.DELETED.getStatus());
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }

    public void reductionMsg(LoginUser user, List<String> msgIdList) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andMessageNameIn(msgIdList).andRecipientsEqualTo(user.getEmail());
        Message message=new Message();
        message.setRecStatus(RecStatus.UNDELETE.getStatus());
        messageMapper.updateByExampleSelective(message,messageExample);
    }
    public boolean isDeleteMSGPageNull(LoginUser user, int indexPage,int size){
        PageHelper.startPage(indexPage, size);
        List<Message> messages = getdeletedMessageListByDB(user.getEmail());
        if (0==messages.size()){
            return true;
        }
        return false;
    }
    public boolean isUndeleteMSGPageNull(LoginUser user, int indexPage,int size){
        PageHelper.startPage(indexPage, size);
        List<Message> messages = getUndeleteMessageListByDB(user.getEmail());
        if (0==messages.size()){
            return true;
        }
        return false;
    }

    public PageInfo<MinMessageDTO> recordSenderMsg(int indexPage, int size, LoginUser loginUser) {
        PageHelper.startPage(indexPage, size);
        List<Message> messages = getSenderRecordMsgListByDB(loginUser.getEmail());
        PageInfo pageInfo = new PageInfo<>(messages,5);
        Set<String> recList = messages.stream().map(message -> {
                    String recipients = message.getRecipients();
                    String username=recipients.split("@")[0];
                    return username;
                }
                ).collect(Collectors.toSet());

        Map<String, MinMessageDTO> msgMap = getFloderMSG(recList);
        List<MinMessageDTO> collect=new ArrayList<>();
        if (null!=messages){

            collect = messages.stream().map(message -> {
                MinMessageDTO minMessageDTO = msgMap.get(message.getMessageName());
                BeanUtils.copyProperties(message, minMessageDTO);

                return minMessageDTO;
            }).collect(Collectors.toList());
        }
        pageInfo.setList(collect);


        return pageInfo;
    }
    private List<Message> getSenderRecordMsgListByDB(String email) {

        MessageExample messageExample = new MessageExample();
        messageExample.or().andSenderEqualTo(email).andSenderStatusEqualTo(SenderStatus.UNCLEAN.getStatus());
        messageExample.setOrderByClause("last_updated desc");


        List<Message> messages = messageMapper.selectByExample(messageExample);
        if (null == messages || 0 == messages.size()) {
            return messages;
        }
        return messages;
    }

    private Map<String, MinMessageDTO> getFloderMSG(Set<String> list)  {
        Map<String, MinMessageDTO> minMessageDTOMap=new HashMap<>();
        for (String username:list){
            String eamilPassword = getEamilPassword(username);
            Map<String, MinMessageDTO> floderMSG = getFloderMSG(username, eamilPassword);
            minMessageDTOMap.putAll(floderMSG);

        }
        return minMessageDTOMap;

    }

    private String getEamilPassword(String username){
        StaffExample staffExample=new StaffExample();
        staffExample.or().andUserNameEqualTo(username);
        List<Staff> staff = staffMapper.selectByExample(staffExample);
        if (0==staff.size()){
            return "";
        }
        return staff.get(0).getEmailPassword();
    }

    public void cleanSenderMSgRecord(List<String> msgIdList, LoginUser user) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andMessageNameIn(msgIdList).andSenderEqualTo(user.getEmail());
        Message message=new Message();
        message.setSenderStatus(SenderStatus.CLEAN.getStatus());
        messageMapper.updateByExampleSelective(message,messageExample);
    }

    public boolean isSenderMSgRecordNull(LoginUser user, int indexPage, int size) {
        PageHelper.startPage(indexPage, size);
        List<Message> messages = getSenderRecordMsgListByDB(user.getEmail());
        if (0==messages.size()){
            return true;
        }else
        {
            return false;
        }
    }

    public void cleanAllSenderMSgRecord(List<String> msgIdList, LoginUser user) {
        MessageExample messageExample=new MessageExample();
        messageExample.or().andSenderEqualTo(user.getEmail());
        Message message=new Message();
        message.setSenderStatus(SenderStatus.CLEAN.getStatus());
        messageMapper.updateByExampleSelective(message,messageExample);
    }
}
