package com.spring.security.controller;

import com.spring.security.model.Loans;
import com.spring.security.repository.CustomerRepository;
import com.spring.security.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoansController {

   @Autowired
   private LoansRepository loansRepository;

   @GetMapping("/myLoans")
  // @PostAuthorize("hasRole('ROOT')")
   public List<Loans> getLoanDetails(@RequestParam Integer id){
      List<Loans> loans =loansRepository.findByCustomerIdOrderByStartDtDesc(id);
      if (loans!=null){
         return loans;
      }else {
         return null;
      }
   }

}
