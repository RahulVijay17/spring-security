package com.spring.security.controller;

import com.spring.security.model.Cards;
import com.spring.security.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CartController {

    private CardsRepository cardsRepository;

   /* @GetMapping("/myCards")
    public String getCardDetails() {
        return "Here are the card details from the DB";
    }*/

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(Integer id){
        List<Cards> cardsList = cardsRepository.findByCustomerId(id);
        if (cardsList!=null){
            return cardsList;
        }else {
            return null;
        }
    }
}
