package com.userm;

import org.jvnet.hk2.annotations.Contract;

import java.io.IOException;

/**
 * Created by developer on 15/06/16.
 */


public interface SendInterface {
    void message(String s) throws IOException;
}
