package com.example;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author L.F.Q
 * @date 2019/5/20 8:38
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String dbPassowrd = info.getCredentials().toString();//不确定能不能用toString
        return this.equals(password,dbPassowrd);
    }
}
