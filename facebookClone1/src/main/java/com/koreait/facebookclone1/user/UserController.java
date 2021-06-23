package com.koreait.facebookclone1.user;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(UserEntity userEntity, Model model){ }

    @PostMapping("/login")
    public String loginporc(UserEntity param){

        return userService.login(param);

    }


    @GetMapping("/join")
    public void join(UserEntity userEntity){ }

    @PostMapping("/join")
    public String joinPost(UserEntity userEntity){
        userService.join(userEntity);
        return "redirect:login?needmail=1";
    }

    @GetMapping("/auth")
    public String auth(UserEntity param){
        int result = userService.auth(param);
        return "redirect:login?auth=" + result;
    }



}
