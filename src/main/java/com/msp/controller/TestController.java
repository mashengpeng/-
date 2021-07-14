package com.msp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","msp");
        return "test";
    }
}
