package com.koreait.facebook.feed;

import com.koreait.facebook.feed.model.FeedEntity;
import com.koreait.facebook.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FeedService {

    @Autowired
    FeedMapper mapper;

    @Autowired
    private IAuthenticationFacade auth;


    public int reg(MultipartFile[] imgArr, FeedEntity param){

        //t_feed ctnt가 null일경우 imgArr
        if(imgArr == null && param.getCtnt() == null){ return 0; }

        //user의 pk값을 얻어오는거
        param.setIuser(auth.getLoginUserPk());
        int result = mapper.insFeed(param);


        return 1;
    }

}
