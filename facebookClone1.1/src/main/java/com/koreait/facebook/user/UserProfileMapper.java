package com.koreait.facebook.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper {

    int insUserProfile(UserProfileEntity param);

}
