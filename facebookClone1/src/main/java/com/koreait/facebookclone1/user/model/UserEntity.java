package com.koreait.facebookclone1.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
//@Data는 위에서 설명드린 @Getter, @Setter, @RequiredArgsConstructor,
//@ToString, @EqualsAndHashCode을
//한꺼번에 설정해주는 매우 유용한 어노테이션입니다.
public class UserEntity {

    private int iuser;
    private String email;
    private String pw;
    private String nm;
    private String tel;
    private String authCd;
    private String regdt;

}
