package com.clive.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void name() {

        User user = new User();

        String s = user.name("welcome to clive", "!");

        assertTrue(s.equals("welcome to clive!"));
    }
}