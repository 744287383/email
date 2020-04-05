package com.example.email.Service;

import com.example.email.Enum.FriendGroupStatus;
import com.example.email.ModelDTO.FriendGroupListDTO;
import com.example.email.entity.*;
import com.example.email.mapper.AddressBookMapper;
import com.example.email.mapper.FriendGroupMapper;
import com.example.email.mapper.StaffMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendGroupServiceIMP {
    @Autowired
    private FriendGroupMapper friendGroupMapper;
    @Autowired
    private AddressBookMapper addressBookMapper;
    @Autowired
    private StaffMapper staffMapper;

    public void addFriendGrop(FriendGroup friendGroup) {
        friendGroupMapper.insertSelective(friendGroup);
    }

    public List<FriendGroupListDTO> getAllFriendGroupList(String userName) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andUserNameEqualTo(userName);
        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(friendGroupExample);
        List<FriendGroupListDTO> collect = friendGroups.stream().map(friendGroup -> {
            FriendGroupListDTO friendGroupListDTO = new FriendGroupListDTO();
            BeanUtils.copyProperties(friendGroup, friendGroupListDTO);
            AddressBookExample addressBookExample = new AddressBookExample();
            addressBookExample.or().andFriendgroupIdEqualTo(friendGroup.getId());
            List<AddressBook> addressBooks = addressBookMapper.selectByExample(addressBookExample);
            List<String> usernameList = addressBooks.stream().map(addressBook -> addressBook.getUserName()).distinct().collect(Collectors.toList());
            if (null==usernameList||usernameList.size()==0){
                List<Staff> staffs=new ArrayList<>();
                friendGroupListDTO.setStaff(staffs);
                return friendGroupListDTO;
            }
            StaffExample staffExample = new StaffExample();
            staffExample.or().andUserNameIn(usernameList);
            List<Staff> staffs = staffMapper.selectByExample(staffExample);
            friendGroupListDTO.setStaff(staffs);
            return friendGroupListDTO;
        }).collect(Collectors.toList());

return collect;
    }


    public List<FriendGroup> getFriendGroups(String userName) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andUserNameEqualTo(userName);
        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(friendGroupExample);
        return friendGroups;
    }

    public FriendGroup getFriendGroup(String userName, String groupname) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andUserNameEqualTo(userName).andGroupNameEqualTo(groupname);
        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(friendGroupExample);
        if (null==friendGroups||friendGroups.size()==0){
            return null;
        }
        return friendGroups.get(0);
    }
    public FriendGroup getFriendGroup(String userName, long groupId) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andUserNameEqualTo(userName).andIdEqualTo(groupId);
        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(friendGroupExample);
        if (null==friendGroups||friendGroups.size()==0){
            return null;
        }
        return friendGroups.get(0);
    }
    public FriendGroup getFriendGroup1(String userName, long groupId) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andUserNameEqualTo(userName).andIdEqualTo(groupId).andDefaultGroupEqualTo(FriendGroupStatus.DEFAULT.getStatus());
        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(friendGroupExample);
        if (null==friendGroups||friendGroups.size()==0){
            return null;
        }
        return friendGroups.get(0);
    }

    public List<AddressBook> getAdressBook(long groupid) {
        AddressBookExample addressBookExample=new AddressBookExample();
        addressBookExample.or().andFriendgroupIdEqualTo(groupid);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(addressBookExample);
        return addressBooks;
    }

    public void deleteFriendGroup(long groupid) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andIdEqualTo(groupid);
        friendGroupMapper.deleteByExample(friendGroupExample);
    }

    public void updateFriendGrop(FriendGroup friendGroup) {
        FriendGroupExample friendGroupExample=new FriendGroupExample();
        friendGroupExample.or().andIdEqualTo(friendGroup.getId());
        friendGroupMapper.updateByExampleSelective(friendGroup,friendGroupExample);
    }

    public List<AddressBook> getAddressBooks(List<Long> collect, String username) {
        AddressBookExample addressBookExample=new AddressBookExample();
        addressBookExample.or().andFriendgroupIdIn(collect).andUserNameEqualTo(username);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(addressBookExample);
        return addressBooks;
    }

    public void addAddressBook(AddressBook addressBook) {
        addressBookMapper.insertSelective(addressBook);
    }

    public void deleteAddressBook(long groupid, String username) {
        AddressBookExample addressBookExample=new AddressBookExample();
        addressBookExample.or().andFriendgroupIdEqualTo(groupid).andUserNameEqualTo(username);
        addressBookMapper.deleteByExample(addressBookExample);

    }
}
