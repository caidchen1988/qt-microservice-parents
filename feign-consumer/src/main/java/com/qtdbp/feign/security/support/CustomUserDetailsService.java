package com.qtdbp.feign.security.support;

import com.qtdbp.feign.mapper.SysUserMapper;
import com.qtdbp.feign.model.security.SysRole;
import com.qtdbp.feign.model.security.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义用户登录策略
 * Created by dell on 2017/4/11.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired  //业务服务类
    private SysUserMapper userService;

    /**
     * 参考地址: http://blog.csdn.net/u012373815/article/details/54633046
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        /*
          SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
          本例使用SysUser中的name作为用户名:
         */
        SysUser user = userService.findByName(userName); // testSysUser() ;
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }

        // SecurityUser实现UserDetails并将SysUser的name映射为username
        return new SecurityUser(user);
    }

    /**
     * 测试数据
     * @return
     */
    private static SysUser testSysUser() {
        SysUser user = new SysUser() ;
        user.setPassword("$2a$04$P6twfI8qKpBBlk3Tzq8KiOMuVmyYHbGYPduO3LSqxZpCQcn80OH/2"); //123456
        user.setUser_name("admin");
        Set<SysRole> sysRoles = new HashSet<SysRole>();
        SysRole sysRole = new SysRole() ;
        sysRole.setName("USER"); // ADMIN
        sysRole.setCode("USER"); // ADMIN
        sysRoles.add(sysRole) ;
        user.setSysRoles(sysRoles);

        return user ;
    }
}
