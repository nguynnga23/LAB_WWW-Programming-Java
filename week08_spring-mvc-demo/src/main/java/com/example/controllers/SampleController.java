package com.example.controllers;

import com.example.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;
    @RequestMapping(value = {"", "/index", "/default", "/home"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("myObj", "Sample line of words");
        return mav;
    }

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String foo(Model model) {
        model.addAttribute("myFoo", sampleService.getFoo());
        return "foo";
    }

    @RequestMapping(value = "/math")
    public ModelAndView sum() {
        ModelAndView mav = new ModelAndView("math");
        return mav;
    }

    @PostMapping(value = "/math")
    public ModelAndView sum(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        ModelAndView mav = new ModelAndView("math");
        mav.addObject("result", sampleService.sum(a, b));
        return mav;
    }
}
