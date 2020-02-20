package com.community.community.service;

import com.community.community.mapper.UserMapper;
import com.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void createOrUpdateUser(User user) {
        //插入
        user.setGmtModified(user.getGmtCreate());
        if(userMapper.findByAccountId(user.getAccountId())==null){
            userMapper.insert(user);
        }else{//更新
            userMapper.update(user);
        }
    }
}
