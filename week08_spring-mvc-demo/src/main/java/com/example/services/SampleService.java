package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String getFoo(){
        return "Waterfall everybody!!!!";
    }

    public int sum(int a, int b){
        return a+b;
    }
}
