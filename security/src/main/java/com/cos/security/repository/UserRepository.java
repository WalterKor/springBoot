package com.cos.security.repository;

import com.cos.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CRUD 함수를 JpaRepository가 들고있다.
//@Repository라는 어노테이션이 없어도 IOC가된다 이유는 JpaRepository를 상속했기때문에

public interface UserRepository extends JpaRepository<User,Integer> {

    //findBy규칙 => Usename문법
    //select * from user where username = ? query method
    public User findByUsername(String username);

}
