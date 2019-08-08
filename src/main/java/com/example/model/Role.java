package com.example.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author L.F.Q
 * @date 2019/5/19 17:28
 */
@Data
public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>();
}
