package com.example.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BlogErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    @RequestMapping(value = ERROR_PATH)
    public ModelAndView error(){
        return new ModelAndView(ERROR_PATH);
    }

    @GetMapping("/403")
    public ModelAndView error403(){
        return new ModelAndView("/403");
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}
