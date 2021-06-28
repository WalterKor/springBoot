package com.koreait.facebook.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    //컨트롤러가 먼저 확인하고 그다음 물어보는게 리소스이다.
    @GetMapping("/css/common.css")
    public String common(){
        return "feed/home";
    }
}
