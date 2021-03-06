package com.koreait.facebook.feed;

import com.koreait.facebook.common.MyConst;
import com.koreait.facebook.feed.model.FeedDomain;
import com.koreait.facebook.feed.model.FeedEntity;
import com.koreait.facebook.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService service;
    @Autowired
    private IAuthenticationFacade auth;
    @Autowired
    private MyConst myConst;


    @GetMapping("/home")
    public void home() {}

    @GetMapping("/reg")
    public void reg(FeedEntity obj) {}

    @ResponseBody
    @PostMapping("/reg")
    public Map<String, Integer> reg(MultipartFile[] imgArr, FeedEntity param){

        Map<String, Integer> res = new HashMap<>();
        res.put(myConst.RESULT, service.reg(imgArr, param));
        return res;

    }

    @ResponseBody
    @GetMapping("/list")
    public List<FeedDomain> selFeedList(){ return service.selFeedList(); }


}
