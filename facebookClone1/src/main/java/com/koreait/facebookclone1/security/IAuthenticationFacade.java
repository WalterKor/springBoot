package com.koreait.facebookclone1.security;

import com.koreait.facebookclone1.user.model.UserEntity;

public interface IAuthenticationFacade {
    UserEntity getLoginUser();
    int getLoginUserPk();

}
