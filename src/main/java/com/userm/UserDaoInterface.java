package com.userm;

import org.jvnet.hk2.annotations.Contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;


public interface UserDaoInterface {
    List<User> getAllUsers();

    User getUser(int id);

    int addUser(User pUser);

    int updateUser(User pUser);

    int deleteUser(int id);
}
