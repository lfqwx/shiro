package com.example.service;

import com.example.model.User;

/**
 * @author L.F.Q
 * @date 2019/5/19 17:53
 */
public interface UserService {
    User findByUsername(String username);
}
