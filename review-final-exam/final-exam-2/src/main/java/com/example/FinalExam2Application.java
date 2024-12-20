package com.example;

import com.example.enums.AccountStatus;
import com.example.models.Account;
import com.example.models.Customer;
import com.example.repositories.AccountRepository;
import com.example.repositories.CustomerRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalExam2Application {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    public static void main(String[] args) {
        SpringApplication.run(FinalExam2Application.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
//                Faker faker = new Faker();
//                Customer customer_1 = new Customer();
//                customer_1.setName(faker.name().fullName());
//                customer_1.setAddress(faker.address().fullAddress());
//                customer_1.setEmail(faker.internet().emailAddress());
//                customer_1.setDob(faker.timeAndDate().birthday());
//
//                Customer customer_2 = new Customer();
//                customer_2.setName(faker.name().fullName());
//                customer_2.setAddress(faker.address().fullAddress());
//                customer_2.setEmail(faker.internet().emailAddress());
//                customer_2.setDob(faker.timeAndDate().birthday());
//
//                Customer customer_3 = new Customer();
//                customer_3.setName(faker.name().fullName());
//                customer_3.setAddress(faker.address().fullAddress());
//                customer_3.setEmail(faker.internet().emailAddress());
//                customer_3.setDob(faker.timeAndDate().birthday());
//
//                customerRepository.save(customer_1);
//                customerRepository.save(customer_2);
//                customerRepository.save(customer_3);
//
//                Account account_1 = new Account();
//                account_1.setCustomer(customer_1);
//                account_1.setBalance(100000);
//                account_1.setStatus(AccountStatus.CHECKING);
//
//                Account account_2 = new Account();
//                account_2.setCustomer(customer_2);
//                account_2.setBalance(50000);
//                account_2.setStatus(AccountStatus.CHECKING);
//
//                Account account_3 = new Account();
//                account_3.setCustomer(customer_3);
//                account_3.setBalance(10000);
//                account_3.setStatus(AccountStatus.CHECKING);
//
//                accountRepository.save(account_1);
//                accountRepository.save(account_2);
//                accountRepository.save(account_3);
//                System.out.println("Done");
            };
        };
    }

}
