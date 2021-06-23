package com.koreait.facebookclone1.security;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserPrincipal;

@Component
public class AuthenticationFacade implements  IAuthenticationFacade{

    @Override
    public UserEntity getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userDetails = (UserPrincipal) auth.getPrincipal();

        return userDetails.getUser();
    }


    @Override
    public int getLoginUserPk() {
        return getLoginUserPk().getIuser();
    }
}
