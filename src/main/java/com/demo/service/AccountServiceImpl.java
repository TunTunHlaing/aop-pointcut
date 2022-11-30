package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService{


    @Override
    public void creat() {
        System.out.println("Account created.");
    }
}
