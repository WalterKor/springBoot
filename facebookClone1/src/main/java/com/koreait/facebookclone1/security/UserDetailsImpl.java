package com.koreait.facebookclone1.security;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {



    private UserEntity user;

    public UserDetailsImpl(UserEntity user){
        this.user = user;
    }



    @Override
    //권한 같은 사용자지만 등급처리
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }




    @Override
    //패스워드
    public String getPassword() {
        return user.getPw();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //계정을 잠궜는지 아닌지
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //권한쪽인데 ? 뭔말이야
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    //계정이 활성화되었는지
    public boolean isEnabled() {
        return false;
    }

}
