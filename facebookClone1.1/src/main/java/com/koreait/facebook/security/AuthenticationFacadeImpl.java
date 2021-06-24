package com.koreait.facebook.security;

import com.koreait.facebook.user.model.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacadeImpl implements IAuthenticationFacade {

    @Override
    public UserEntity getLoginUser() {
        //SecurityContextHolder : Security객체가 만들어지면 그냥 권한을 얻어 오는거같은데
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        return userDetails.getUser();
    }

    @Override
    public int getLoginUserPk() {

        /*
        UserEntity ue = getLoginUser();
        ue.getIuser();
         */

        return getLoginUser().getIuser();
    }
}
