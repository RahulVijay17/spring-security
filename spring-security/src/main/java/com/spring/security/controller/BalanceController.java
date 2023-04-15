package com.spring.security.controller;

import com.spring.security.model.AccountTransactions;
import com.spring.security.repository.AccountTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceController {

    private AccountTransactionRepository accountTransactionRepository;

   /* @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "Here are the balance details from the DB";
    }*/

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam Integer id){
        List<AccountTransactions> accountTransactionsList =
                accountTransactionRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactionsList!=null){
            return accountTransactionsList;
        }else {
            return null;
        }
    }

}
