package com.example;

import com.example.backend.models.Address;
import com.example.backend.models.Candidate;
import com.example.backend.repositories.AddressRepository;
import com.example.backend.repositories.CandidateRepository;
import com.example.backend.services.AddressService;
import com.example.backend.services.CandidateService;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Week08JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(Week08JobApplication.class, args);
    }

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            Random rand = new Random();
//            for (int i = 1; i <= 1000; i++) {
//                // Tạo đối tượng Address với ID tự động tăng
//                Address add = new Address(null, "Quang Trung", "HCM", CountryCode.VN,
//                        rand.nextInt(70000, 80000) + "", rand.nextInt(70000, 80000) + "");
//                addressService.save(add);
//
//                // Tạo đối tượng Candidate với ID tự động tăng và tham chiếu đến Address vừa tạo
//                Candidate candidate = new Candidate(null, LocalDate.of(1998, rand.nextInt(1,13), rand.nextInt(1,29)),
//                        "email_" + i + "@gmail.com", "Name #" + i,
//                        rand.nextLong(1111111111111L, 99999999999999L) + "", add);
//                candidateService.save(candidate);
//
//                System.out.println("Added candidate " + candidate);
//            }
//        };
//    }
}
