package com.example.test2.oauth;

import com.example.test2.auth.PricipalDetails;
import com.example.test2.user.model.User;
import com.example.test2.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.getClientRegistration() :" +userRequest.getClientRegistration());//registrationId로 어떤 OAuth로 로그인했는지확인 가능
        System.out.println("userRequest.getAccessToken() :" + userRequest.getAccessToken());
        OAuth2User oAuth2User = super.loadUser(userRequest);

        //소셜로그인 회원가입을 진행하겠다
        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode("쓸모없는 비밀번호");
        String email = oAuth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            System.out.println("구글최초로그인");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);

        }else {
            System.out.println("구글로그인을 이미했다");
        }

        return new PricipalDetails(userEntity, oAuth2User.getAttributes());
        //뭔가 세션에다가 저장하는 느낌?

    }
}
