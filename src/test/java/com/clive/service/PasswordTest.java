package com.clive.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    @Test
    public void encrptPassword() {

        String password = "helloworld";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String p = bCryptPasswordEncoder.encode(password);

        System.out.println(p);
    }
}
