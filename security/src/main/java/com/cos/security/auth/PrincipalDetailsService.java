package com.cos.security.auth;

import com.cos.security.model.User;
import com.cos.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginProcessingUrl("/login");
//login 요청이 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수가 실행이된다.

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //security session = Authentication = UserDetails
    @Override
    //username 로그인 form에있는 이름과 동일해야한다.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);

        if(userEntity != null){
            return new PricipalDetails(userEntity);
            //리턴이되면 Authentication 내부에 UserDetails가 쏙들어간다.
            //security Session(Authentication(UserDetails));
        }
        return null;
    }

}
