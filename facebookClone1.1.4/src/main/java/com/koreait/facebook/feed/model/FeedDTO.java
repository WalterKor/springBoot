package com.koreait.facebook.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedDTO {

    private int page;
    private int limit;
    private int iuserForMyFeed; //내 피드만 보고싶을때 쓰는 iuser;
    private int iuserForFav; //feed에 좋아요 했는지 알기위해 사용하는 iuser;
    public int getStartIdx() {
        return (page - 1) * limit;
    }

}
