package com.cos.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PricipalOauth2UserService extends DefaultOAuth2UserService {

    //구글로 부터 받은 userRequest 데이터에대한 후처리되는 함수
    @Override //userRequest 토큰이 이렇게 리턴된다.
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest :" +userRequest.getClientRegistration());//registrationId로 어떤 OAuth로 로그인했는지확인 가능
        System.out.println("userRequest :" +userRequest.getAccessToken());
        // 구글로그인버튼 클릭 => 로그인을 완료 => code를 리턴(OAuth-Client라이브러리가 받음)
        // 코드를토대로 AcessToken을 요청
        //userRequest 정보 => 회원프로필을 받아야한다.(loadUser함수)을통해서 회원 프로필을 받을 수 있다.

        OAuth2User oAuth2User = super.loadUser(userRequest);

        return super.loadUser(userRequest);
    }



}
