package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyAccountService {

    public  void creat(int amount){
        System.out.println("creat with :: " + amount);
    }
}
