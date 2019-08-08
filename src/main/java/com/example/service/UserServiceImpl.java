package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author L.F.Q
 * @date 2019/5/19 18:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
