package com.example.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author L.F.Q
 * @date 2019/5/19 17:28
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
