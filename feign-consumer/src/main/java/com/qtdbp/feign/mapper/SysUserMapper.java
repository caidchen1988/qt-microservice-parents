package com.qtdbp.feign.mapper;

import com.qtdbp.feign.model.security.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 系统用户数据库操作
 *
 * Created by dell on 2017/4/11.
 */
@Mapper
public interface SysUserMapper {

    /**
     * 查询系统用户
     * @param name
     * @return
     */
    @Select("select * from s_user where name = #{name}")
    SysUser findByName(@Param("name") String name) ;
}
