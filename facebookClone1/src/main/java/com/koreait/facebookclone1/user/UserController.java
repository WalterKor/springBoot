package com.koreait.facebookclone1.user;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(){ }

    @GetMapping("/join")
    public void join(UserEntity userEntity){ }

    @PostMapping("/join")
    public String joinPost(UserEntity userEntity){
        userService.join(userEntity);
        return "redirect:/feed/home";
    }



}
