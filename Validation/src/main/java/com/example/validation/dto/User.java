package com.example.validation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User {

    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Size(min = 6, max = 6) //글자가 아니면 안되는거
    private String reqYearMonth; //yyyymm

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰의 번호와 양식과 맞지않습니다. ")
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
