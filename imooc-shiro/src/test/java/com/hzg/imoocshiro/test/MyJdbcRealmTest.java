package com.hzg.imoocshiro.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class MyJdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro_test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }
    @Test
    public void testAuthentication(){
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from sys_users where number = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select rolename from sys_user_roles where number = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String permissionSql = "select permission from sys_role_permissions where rolename = ?";
        jdbcRealm.setPermissionsQuery(permissionSql);

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("1151401107", "123");
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());
        subject.checkRole("admin");
        subject.checkPermission("user:select");
    }
}
