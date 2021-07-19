package com.cos.security.auth;
/*
    1. 시큐리티가 /login 주소요청이 오면 낚아채서 로그인을 진행시킨다.
    2. session에다가 저장을 해야하는데 키값 security contextHolder에 user정보를 저장시킨다.
    정리
    Security Session에다가 값을 저장해야한다.
    이때 저장할 수 있는 타입은 Authentication 타입이고
    user는 UserDetails타입 객체로 저장을 해야 입력이 들어간다.
    이거는 시큐리티 고유 틀같다고 생각하면 편할듯

    Security Session => Authentication => UserDetails(PricipalDetails)
*/


import com.cos.security.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PricipalDetails implements UserDetails, OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    //생성자만들기 일반로그인할때사용하는 생성자
    public PricipalDetails(User user) {
        this.user = user;
    }

    //OAuth로그인 할때 사용하는 생성자
    public PricipalDetails(User user,Map<String, Object>attributes) {
        this.user = user;
        this.attributes = attributes;
    }


    //해당 User의 권한을 리턴하는곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return user.getRole();
            }

        });
        return collect;
    }



    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        //계정이 만료되었습니까?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정이 잠겼습니까
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //계정의 비밀번호가 너무 오래동안 사용된건가
        return true; //아니요
    }

    @Override
    public boolean isEnabled() {
        //계정이 활성화 되어있니 아니요

        //우리사이트 1년동안 회원이 로그인안하면 휴면계정을 하기로함
        //현재시간 - 로그인시간 => 1년을 초과하면 return false

        return true;
    }


    //Oauth2User overriding

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }


    @Override
    public String getName() {
        return null;
    }

}
