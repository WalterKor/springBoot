package com.koreait.facebook.feed.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FeedCmtEntity {

    private int icmt;
    private int ifeed;
    private int iuser;
    private String cmt;
    private String regdt;
}
