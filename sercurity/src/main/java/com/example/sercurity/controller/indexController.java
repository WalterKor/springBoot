package com.example.sercurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //view를 리턴한다.
public class indexController {

    @GetMapping({"","/"})
    public String index(){
        //머스테치 : src/main/resources/기본폴더로 잡힌다/
        //뷰리졸버 설정 : templates (prefix).mustache(suffix) 설정을 생략이 가능하다.
        return "index"; //src/main/resources/templates/index.mustache




    }


}
