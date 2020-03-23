package com.example.email.Service;

import com.example.email.Enum.DraftType;
import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import com.example.email.entity.Draft;
import com.example.email.entity.DraftExample;
import com.example.email.mapper.DraftMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DraftServiceImp {
        @Autowired
        private DraftMapper draftMapper;
    public void saveDraft(LoginUser loginUser, MassageDTO massageDTO) {
        Draft draft=new Draft();
        draft.setRecipients(massageDTO.getTo());
        draft.setSender(loginUser.getEmail());
        draft.setType(DraftType.ONE.getType());
        draft.setSubjects(massageDTO.getSubject());
        draft.setContent(massageDTO.getText());
        draft.setCreateTime(new Date(System.currentTimeMillis()));
        draftMapper.insertSelective(draft);
    }

    public PageInfo<DraftDTO> getDraftList(int indexPage, int size, LoginUser loginUser) {
        PageHelper.startPage(indexPage,size);
        DraftExample draftExample=new DraftExample();
        draftExample.or().andSenderEqualTo(loginUser.getEmail());
        draftExample.setOrderByClause("create_time desc");
        List<Draft> drafts = draftMapper.selectByExample(draftExample);
        PageInfo pageInfo=new PageInfo<>(drafts,5);
        List<DraftDTO> collect = drafts.stream().map(draft -> {
            DraftDTO draftDTO = new DraftDTO();
            BeanUtils.copyProperties(draft, draftDTO);
            return draftDTO;
        }).collect(Collectors.toList());
        pageInfo.setList(collect);
        return pageInfo;
    }


    public void deleteDraftByid(LoginUser loginUser, int id) {
        DraftExample draftExample=new DraftExample();
        draftExample.or().andSenderEqualTo(loginUser.getEmail()).andIdEqualTo((long) id);
        draftMapper.deleteByExample(draftExample);
    }
}
