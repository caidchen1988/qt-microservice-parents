package com.qtdbp.feign.security.support;

import com.qtdbp.feign.model.security.SysUser;
import com.qtdbp.feign.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 可以在这里将用户登录信息存入数据库
 *
 * Created by dell on 2017/4/11.
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SysUser userDetails = (SysUser)authentication.getPrincipal();
       /* Set<SysRole> roles = userDetails.getSysRoles();*/
        //输出登录提示信息
        logger.info("user: " + userDetails.getUser_name() + " acess sucess!");

        logger.info("IP :"+ CommonUtil.getIpAddress(request));

        logger.error("测试日志级别ERROR");

        super.onAuthenticationSuccess(request, response, authentication);
    }


}
