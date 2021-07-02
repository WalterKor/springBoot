package dev.yhp.basic.controllers;

import dev.yhp.basic.vos.user.RegisterVo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user",
//        method 를 안쓰는 이유는 동일한 주소로 들어가면 안되기 떄문에
        produces = MediaType.TEXT_HTML_VALUE)
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    // 메소드 = GET
    public String loginGet() {
        // user/로그인
        return "user/login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    // 메소드 = GET
    public String registerGet() {
        // user/ 회원가입
        return "user/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    // 메소드 = Post
    public  String registerPost(RegisterVo registerVo){ //값을 받아서



        return "user/register";
    }
}

