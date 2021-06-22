package com.koreait.facebookclone1.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MySecurityUtils {

    //len 길이 만큼의 랜덤한 숫자
    public String getRandomValue(int len){

        UUID uuid = UUID.randomUUID();

        return uuid.toString().substring(0,len);

    }

    public String getRandomValue1(int len){
        return RandomStringUtils.randomAlphanumeric(len);
    }



}
