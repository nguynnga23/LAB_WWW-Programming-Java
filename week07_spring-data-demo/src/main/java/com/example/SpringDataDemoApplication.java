package com.example;

import com.example.models.Account;
import com.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import java.util.List;

import java.util.Random;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random rnd = new Random();
//        for (int i = 0; i < 100; i++) {
//            Account account = new Account();
//            account.setOwnerName("Owner " + i);
//            account.setBalance(rnd.nextDouble() * 1000);
//            accountRepository.save(account);
//        }

        PageRequest request = PageRequest.of(5, 6);
        List<Account> content = accountRepository.findByBalanceGreaterThan(500, request);
        content.forEach(System.out::println);
    }
}
