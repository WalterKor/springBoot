package dev.yhp.basic.mappers;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {

    int selectUserCountByEmail(String email);


    int selectUserCountByNickName(String nickname);


}
