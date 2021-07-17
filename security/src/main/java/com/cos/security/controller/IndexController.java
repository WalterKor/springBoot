package com.cos.security.controller;

import com.cos.security.auth.PricipalDetails;
import com.cos.security.model.User;
import com.cos.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //view를 리턴한다.
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    @ResponseBody
    public String testLogin(Authentication authentication){

        System.out.println("/test/login==============================");
        PricipalDetails pricipalDetails = (PricipalDetails)authentication.getPrincipal();
        System.out.println("authentication : " +pricipalDetails.getUser());
        return "세션정보확인하기";
    }

    @GetMapping({"","/"})
    public String index(){
        //머스테치 기본폴더 src/main/resources/
        return "index";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    @ResponseBody
    public String manager(){
        return "manager";
    }

    //스프링시큐리티가 낚아첸다
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    //회원가입페이지
    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }


    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER"); //아마 이게 권한을 넣는거일거야
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user); //id랑 date는 왜 자동으로되는거지
        //비밀번호 1234 => 시큐리티로 로그인 할 수가 없다. 이유는 패스워드가 암호화가 되지 않음
        return "redirect:/loginForm"; //redirect을부치면 /loginForm로 호출해준다.
    }

    @Secured("ROLE_ADMIN") //권한이 필요할때 거는 어노테이션 존나편한데
    @GetMapping("/info")
    @ResponseBody
    public String info(){
        return "개인정보";
    }


//    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") //함수가 시작하기전에 권한체크
//    @PostAuthorize("") //함수가 끝나고 난뒤 권한체크
//    권한을 중복으로 주는걸로하면 에러터진다.
    @GetMapping("/data")
    @ResponseBody
    public String data(){
        return "개인정보";
    }





}
