package com.demo;

import com.demo.ds.CurrencyId;
import com.demo.service.AccountService;
import com.demo.service.CurrencyService;
import com.demo.service.MyAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();

        AccountService accountService = context.getBean(AccountService.class);
        MyAccountService myAccountService = context.getBean(MyAccountService.class);
        CurrencyService service = context.getBean(CurrencyService.class);


        accountService.creat();
        myAccountService.creat(5000);
        service.changeCurrency(500);
        service.changeCurrency(500,50);
        service.getLongCurrencyName(CurrencyId.US);

        try {
            service.getLongCurrencyName(CurrencyId.EURO);

        }catch (IllegalArgumentException e){
            System.out.println("Exception has been caught.");
        }
        service.getLongCountryName(CurrencyId.US);
        service.getLongCountryName(CurrencyId.EURO);
    }
}
