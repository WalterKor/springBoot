package com.koreait.facebookclone1.user;

import com.koreait.facebookclone1.common.EmailService;
import com.koreait.facebookclone1.common.MySecurityUtils;
import com.koreait.facebookclone1.security.IAuthenticationFacade;
import com.koreait.facebookclone1.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MySecurityUtils mySecurityUtils;
    @Autowired
    private EmailService emailService;

    @Autowired
    private IAuthenticationFacade

    public int join(UserEntity userEntity) {

        String rVal = mySecurityUtils.getRandomValue1(5);
        System.out.println("Random Num : " + rVal);
        //String hashPw = BCrypt.hashpw(userEntity.getPw(), BCrypt.gensalt());
        String hashedPw = passwordEncoder.encode(userEntity.getPw());
        userEntity.setPw(hashedPw);
        userEntity.setAuthCd(rVal);

        int result = userMapper.join(userEntity);
        if(result == 1){
            String subject = "[얼굴책] 인증메일입니다.";
            String txt = String.format("<a href=\"http://localhost:8090/user/auth?email=%s&authCd=%s\">인증하기</a>"
                    , userEntity.getEmail(), rVal);

            emailService.sendMimeMessage(userEntity.getEmail(), subject, txt);
        }
        return result;
    }

    public int auth(UserEntity param) {
        return userMapper.upAuth(param);
    }

    public void profileImg(MultipartFile[] imgArr){

    }


}
