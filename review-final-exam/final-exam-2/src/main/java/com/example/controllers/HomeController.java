package com.example.controllers;

import com.example.models.Account;
import com.example.models.Customer;
import com.example.services.AccountService;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final CustomerService customerService;
    private final AccountService accountService;

    @Autowired
    public HomeController(CustomerService customerService, AccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "/index";
    }

    @GetMapping("/report1")
    public String report1(Model model) {
        return "/report1";
    }

    @GetMapping("/find-accounts-balance")
    public String listAccountByXY(Model model, @RequestParam("from") String from, @RequestParam("to") String to) {
        double balanceFrom = Double.parseDouble(from);
        double balanceTo = Double.parseDouble(to);

        model.addAttribute("accounts", accountService.findAccountsByBalanceIsBetween(balanceFrom, balanceTo));
        return "report1";
    }

    @GetMapping("/report2")
    public String report2(Model model) {
        List<Customer> customers = customerService.findByYear(2000);
        model.addAttribute("customers", customers);
        return "/report2";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customers";
    }

    @GetMapping("/detail/{id}")
    public String cusDetail(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/cust_details";
    }
}
