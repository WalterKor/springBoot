package com.koreait.facebookclone1.user;

import com.koreait.facebookclone1.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int join(UserEntity userEntity) {
        String hashPw = BCrypt.hashpw(userEntity.getPw(), BCrypt.gensalt());
        userEntity.setPw(hashPw);
        return userMapper.join(userEntity);
    }
}
