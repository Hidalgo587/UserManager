package com.userm;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import java.util.List;

public class UserDaoMDB extends BasicDAO<User, Integer> implements UserDaoInterface{

    public UserDaoMDB() {
            super(new MongoClient(),
                  new Morphia(),
                    "userMng");
    }

    @Override
    public List<User> getAllUsers() {
        return getDs().find(User.class).asList();
    }

    @Override
    public User getUser(int id) {
        return get(id);
    }

    @Override
    public int addUser(User pUser) {
        save(pUser);
        return 1;
    }

    @Override
    public int updateUser(User pUser) {
        getDs().merge(pUser);
        return 1;
    }

    @Override
    public int deleteUser(int id) {
        deleteById(id);
        return 1;
    }
}
