package com.lengkai.dao;

import com.lengkai.domain.Queryvo;
import com.lengkai.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(Integer userId);

    int saveUser(User user);

    int update(User user);

    int delete(int id);

    List<User> findByName(String username);

    int findtol();

    List<User> findByUser(User user);

    List<User> findByIds(Queryvo queryvo);
}
