package com.userm;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by developer on 15/06/16.
 */
public class Usmgr extends ResourceConfig {
    public Usmgr() {
        register(new MyApplicationBinder());
    }
}

