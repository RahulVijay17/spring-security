package com.spring.security.controller;

import com.spring.security.model.Contact;
import com.spring.security.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
public class ContactController {

    private ContactRepository contactRepository;

   /* @GetMapping("/contact")
    public String saveContactInquiryDetails() {
        return "Inquiry details are saved to the DB";
    }*/

    @PostMapping("/contact")
   // @PreFilter("filterObject.contactName != 'Test'")
    @PostFilter("filterObject.contactName != 'Test'")
    public List<Contact> saveCustomerInquiryDetails(@RequestBody List<Contact> contacts){
    Contact contact = contacts.get(0);
    contact.setContactId(getServiceRequestNumber());
    contact.setCreateDt(new Date(System.currentTimeMillis()));
    contact=contactRepository.save(contact);
    List<Contact> returnContacts=new ArrayList<>();
    returnContacts.add(contact);
    return contacts;
    }

    private String getServiceRequestNumber() {
        Random random = new Random();
        Integer ranNUm= random.nextInt(999999999-9999)+9999;
        return "SR"+ranNUm;
    }
}
