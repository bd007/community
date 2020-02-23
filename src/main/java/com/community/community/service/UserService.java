package com.community.community.service;

import com.community.community.mapper.UserMapper;
import com.community.community.model.User;
import com.community.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void createOrUpdateUser(User user) {
        //插入
        user.setGmtModified(System.currentTimeMillis());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        if(userMapper.selectByExample(userExample).size()==0){
            user.setGmtCreate(System.currentTimeMillis());
            userMapper.insert(user);
        }else{//更新
            userMapper.updateByExampleSelective(user,userExample);
        }
    }
}
