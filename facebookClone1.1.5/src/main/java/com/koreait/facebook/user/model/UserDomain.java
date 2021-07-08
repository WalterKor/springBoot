package com.koreait.facebook.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDomain {
    private int isYouFollowMe;
    private int isMeFollowYou;
}
