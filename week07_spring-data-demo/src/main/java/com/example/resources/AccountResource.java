package com.example.resources;


import com.example.models.Account;
import com.example.services.AccountService;
import com.example.services.impl.AccountServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.List;
@RestController
public class AccountResource {
   @Autowired
    AccountServiceImpl accountServiceImpl;

   @GetMapping("findbyid/{id}")
    public Account findById(Long id){
        return accountServiceImpl.findById(id);
    }

    @GetMapping("/findadd")
    public Array addAccount(){
        return null;
    }

}
