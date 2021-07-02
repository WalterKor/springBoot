package dev.yhp.basic.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(
        value = "/",
        method = RequestMethod.GET,
        produces = MediaType.TEXT_HTML_VALUE)
public class RootController {
    @RequestMapping(value = "/")
    public String indexGet(Model model) {
        model.addAttribute("view", "root/index");
        return "root/index";
    }

}