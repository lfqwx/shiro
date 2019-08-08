package com.example;

import com.example.model.Permission;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author L.F.Q
 * @date 2019/5/20 6:07
 */
public class AuthRealm extends AuthorizingRealm {
    //自己写的接口
    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从session获取用户
        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if (!CollectionUtils.isEmpty(roleSet)) {
            for (Role role : roleSet) {
                Set<Permission> permissionSet = role.getPermissions();
                roleNameList.add(role.getRname());
                if (!CollectionUtils.isEmpty(permissionSet)) {
                    for (Permission permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }

    //认证登陆：Object principal, Object credentials, String realmName
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
