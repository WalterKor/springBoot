package com.koreait.facebook.feed.model;

import lombok.Data;
import lombok.ToString;
import java.util.List;


@Data
@ToString
public class FeedDomain2  extends FeedEntity{
    private String writer;
    private String mainProfile;
    private List<FeedEntity> imgList;

}
