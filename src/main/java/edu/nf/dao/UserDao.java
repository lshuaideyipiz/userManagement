package edu.nf.dao;

import edu.nf.entity.User;

import java.util.List;

/**
 * @author LZ
 * @date 2020/11/25
 */
public interface UserDao {

    List<User> listUser();

    void addUser(User user);

    void delUserByName(String name);

    User selUserByName(String name);
}
