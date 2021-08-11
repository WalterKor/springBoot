package com.cos.security.oauth;

import com.cos.security.auth.PricipalDetails;
import com.cos.security.model.User;
import com.cos.security.oauth.provider.FacebookUserInfo;
import com.cos.security.oauth.provider.GoogleUserInfo;
import com.cos.security.oauth.provider.OAuth2UserInfo;
import com.cos.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PricipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


    //구글로 부터 받은 userRequest 데이터에대한 후처리되는 함수
    @Override //userRequest 토큰이 이렇게 리턴된다.
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.getClientRegistration() :" +userRequest.getClientRegistration());//registrationId로 어떤 OAuth로 로그인했는지확인 가능
        System.out.println("userRequest.getAccessToken() :" + userRequest.getAccessToken());


        OAuth2User oAuth2User = super.loadUser(userRequest); //회원정보가 들어가있는것
        // 구글로그인버튼 클릭 => 로그인을 완료 => code를 리턴(OAuth-Client라이브러리가 받음)
        // 코드를토대로 AcessToken을 요청
        //userRequest 정보 => 회원프로필을 받아야한다.(loadUser함수)을통해서 회원 프로필을 받을 수 있다.

        System.out.println("getAttributes:" +oAuth2User.getAttributes());

        //회원가입을 강제로 진행해볼 예정
        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("페이스북로그인요청");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }else {

        }




        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider+"_"+providerId; //google_12348412345341;
        String password = bCryptPasswordEncoder.encode("겟인데어"); //쓸모없는 비밀번호
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity =  userRepository.findByUsername(username);
        if(userEntity == null){
            System.out.println("구글로그인이 최초입니다.");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }else{
            System.out.println("구글로그인을 이미 한적이 있다.");
        }

        return new PricipalDetails(userEntity, oAuth2User.getAttributes());
        //일반적으론 userEntity만있고 oAuth2로 로그인하면 userEntity랑 토큰에서주는값이랑 둘다있다.
    }



}
