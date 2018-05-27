package com.hzg.imoocshiro.test;

import com.hzg.imoocshiro.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 测试加密
 */
public class EncryptCustomRealmTest {

    CustomRealm customRealm = new CustomRealm();

    @Test
    public void testAuthentication(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置加密算法名称
        matcher.setHashAlgorithmName("md5");
        // 设置加密次数
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123");
        subject.login(token);

        subject.checkRole("admin");

        subject.checkPermission("user:delete");
//        subject.checkPermission("user:update");

    }
}
