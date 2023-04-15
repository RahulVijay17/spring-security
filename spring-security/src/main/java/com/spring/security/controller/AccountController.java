package com.spring.security.controller;

import com.spring.security.model.Accounts;
import com.spring.security.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

   private AccountRepository accountRepository;

   /* @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "here are the account details from the db";
    }*/

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam Integer id){
        Accounts accounts = accountRepository.findByCustomerId(id);
        if (accounts!=null){
            return accounts;
        }else {
            return null;
        }
    }
}
