package com.koreait.facebookclone1.security;


import com.koreait.facebookclone1.user.UserMapper;
import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//실제로 작업이 이루어지는 공간
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper mapper;


    @Override
    //String s 아이디값
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity param = new UserEntity();
        param.setEmail(email);

        UserEntity loginUser = mapper.selUser(param);

        return new UserDetailsImpl(loginUser);


    }
}
