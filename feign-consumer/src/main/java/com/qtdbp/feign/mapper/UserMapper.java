package com.qtdbp.feign.mapper;

import com.qtdbp.feign.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chenhao
 * Date: 2017/4/9
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM USER")
    List<User> findAll();

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM USER WHERE ID = #{id}")
    @Results({
            @Result(property="name",column="name"),
            @Result(property="age",column="age")
    })
    User findById(@Param("id") Long id);

    /**
     * 修改用户名
     * @param user
     * @return
     */
    @Update("update USER set NAME = #{user.name}, AGE = #{user.age} WHERE ID=#{user.id}")
    int updateById(@Param("user") User user) ;

    /**
     * 通过注解方式插入User
     * useGeneratedKeys 表示自增主键
     * @param user
     * @return
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{user.name}, #{user.age})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    int insert(@Param("user") User user);

    /**
     * 删除某条数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM USER WHERE ID = #{id}")
    boolean deleteById(@Param("id") Long id) ;
}
