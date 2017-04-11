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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        /*
          SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
          本例使用SysUser中的name作为用户名:
         */
        SysUser user = testSysUser() ; // userService.findByName(userName);
        if (user != null) {
            /*
            参考地址: http://blog.csdn.net/u012373815/article/details/54633046

            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            */

            // SecurityUser实现UserDetails并将SysUser的name映射为username
            return new SecurityUser(user);
        } else {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
    }

    /**
     * 测试数据
     * @return
     */
    private static SysUser testSysUser() {
        SysUser user = new SysUser() ;
        user.setEmail("caidchen@126.com");
        user.setPassword("$2a$04$P6twfI8qKpBBlk3Tzq8KiOMuVmyYHbGYPduO3LSqxZpCQcn80OH/2"); //123456
        user.setName("admin");
        Set<SysRole> sysRoles = new HashSet<SysRole>();
        SysRole sysRole = new SysRole() ;
        sysRole.setName("USER"); // ADMIN
        sysRoles.add(sysRole) ;
        user.setSysRoles(sysRoles);

        return user ;
    }
}
