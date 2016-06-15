package com.userm;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Created by developer on 15/06/16.
 */
public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(Send.class).to(SendInterface.class);
        bind(UserDao.class).to(UserDaoInterface.class);
    }
}
