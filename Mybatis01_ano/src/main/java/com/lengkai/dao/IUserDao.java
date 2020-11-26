package com.lengkai.dao;

import com.lengkai.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findbyid(int id);
}
