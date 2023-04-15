/*
package com.spring.security.config;

import com.spring.security.model.Customer;
import com.spring.security.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BankUserService implements UserDetailsService {

    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password=null;
        List<GrantedAuthority> authorities=null;
        List<Customer> customerList = customerRepository.findByEmail(username);
        if (customerList.size()==0){
            throw new UsernameNotFoundException("user details not found for the user : "+username);
        }else {
            userName = customerList.get(0).getEmail();
            password= customerList.get(0).getPwd();
            authorities= new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
        }
        return new User(userName,password,authorities);
    }
}
*/
