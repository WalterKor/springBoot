package com.koreait.facebook.user;

import com.koreait.facebook.common.EmailService;
import com.koreait.facebook.common.MyFileUtils;
import com.koreait.facebook.common.MySecurityUtils;
import com.koreait.facebook.security.IAuthenticationFacade;
import com.koreait.facebook.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;

@Service
public class UserService {

    @Autowired
    private EmailService email;

    @Autowired
    private MySecurityUtils secUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserProfileMapper profileMapper;


    //인터페이스를
    @Autowired
    private IAuthenticationFacade auth;


    @Autowired
    private MyFileUtils myFileUtils;

    @Autowired
    private UserMapper mapper;

    public int join(UserEntity param) {
        String authCd = secUtils.getRandomDigit(5);

        //비밀번호 암호화
        String hashedPw = passwordEncoder.encode(param.getPw());
        param.setPw(hashedPw);
        param.setAuthCd(authCd);
        int result = mapper.join(param);

        if(result == 1) { //메일 쏘기!! (id, authcd값을 메일로 쏜다.)
            String subject = "[얼굴책] 인증메일입니다.";
            String txt = String.format("<a href=\"http://localhost:8090/user/auth?email=%s&authCd=%s\">인증하기</a>"
                    , param.getEmail(), authCd);
            email.sendMimeMessage(param.getEmail(), subject, txt);
        }
        return result;
    }

    //이메일 인증 처리
    public int auth(UserEntity param) {
        return mapper.auth(param);
    }

    public void profileImg(MultipartFile[] imgArr) {

        //로그인한 사람의 pk값을 얻기위해서

        UserEntity loginUser = auth.getLoginUser();
        int iuser = auth.getLoginUserPk();

        //저장루트
        UserProfileEntity param = new UserProfileEntity();
        param.setIuser(iuser);
        String target = "profile/" + iuser;


        for(MultipartFile img : imgArr) {
            String saveFileNm = myFileUtils.transferTo(img, target);
            //saveFileNm이 null이 아니라면 t_user_profile테이블에
            //insert해주세요
           if(saveFileNm != null){

               param.setImg(saveFileNm);

               if(profileMapper.insUserProfile(param) == 1 && loginUser.getMainProfile() == null){

                   UserEntity param2 = new UserEntity();
                   param2.setIuser(loginUser.getIuser());
                   param2.setMainProfile(saveFileNm);

                   if(mapper.updUser(param2) == 1){
                       //시큐리티 맞춰주기위해서
                       loginUser.setMainProfile(saveFileNm);
                   }



               }

           }

        }
    }







}
