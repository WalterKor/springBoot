package com.koreait.facebook.user;

import com.koreait.facebook.common.MyConst;
import com.koreait.facebook.feed.model.FeedDTO;
import com.koreait.facebook.feed.model.FeedDomain2;
import com.koreait.facebook.security.UserDetailsImpl;
import com.koreait.facebook.user.model.UserDTO;
import com.koreait.facebook.user.model.UserEntity;
import com.koreait.facebook.user.model.UserFollowEntity;
import com.koreait.facebook.user.model.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;
    @Autowired private MyConst myConst;

    @GetMapping("/login")
    public void login(UserEntity userEntity) {
        userEntity.setEmail("pirbak@daum.net");
    }

    @GetMapping("/join")
    public void join(UserEntity userEntity) {}

    @PostMapping("/join")
    public String joinProc(UserEntity userEntity) {
        service.join(userEntity);
        return "redirect:login?needEmail=1";
    }

    @GetMapping("/auth")
    public String auth(UserEntity param) {
        int result = service.auth(param);
        return "redirect:login?auth=" + result;
    }

    @GetMapping("/profile")
    public void profile(Model model, UserEntity param, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println(param);

        UserDTO param2 = new UserDTO();
        param2.setYouIuser(param.getIuser());
        if(param2.getYouIuser() == 0) {
            param2.setYouIuser(userDetails.getUser().getIuser());
        }
        model.addAttribute(myConst.PROFILE, service.selUserProfile(param2));
        model.addAttribute(myConst.PROFILE_LIST, service.selUserProfileList(param));
    }

    @PostMapping("/profileImg")
    public String profileImg(MultipartFile[] imgArr) {
        service.profileImg(imgArr);
        return "redirect:profile";
    }

    @ResponseBody
    @GetMapping("/mainProfile")
    public Map<String, Object> mainProfile(UserProfileEntity param) {
        return service.updUserMainProfile(param);
    }

    @ResponseBody
    @GetMapping("/feedList")
    public List<FeedDomain2> selFeedList2(FeedDTO param) {
        return service.selFeedList2(param);
    }


    @ResponseBody
    @PostMapping("/follow")
    public Map<String, Object> doFollow(@RequestBody UserFollowEntity param) {

        return service.insUserFollow(param);
    }

    @ResponseBody
    @DeleteMapping("/follow")
    public Map<String, Object> cancleFollow(UserFollowEntity param) {

        return service.delUserFollow(param);
    }


}











