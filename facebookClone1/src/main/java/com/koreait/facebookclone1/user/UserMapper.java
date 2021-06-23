package com.koreait.facebookclone1.user;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int join(UserEntity userEntity);
    int upAuth(UserEntity param);
    UserEntity selUser(UserEntity param);
}
