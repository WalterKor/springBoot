package com.example.mooyaho.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    //연습입니다.
    @GetMapping("hi")
    public String hi(){
        return "hi.html";
    }



}
