package dev.yhp.basic.vos.user;

import dev.yhp.basic.utils.CryptoUtil;

public class RegisterVo {
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String telecom;
    private String contactFirst;
    private String contactSecond;
    private String getContactThird;


    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    public RegisterVo() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.hashedPassword = CryptoUtil.Sha512.hash(password);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelecom() {
        return telecom;
    }

    public void setTelecom(String telecom) {
        this.telecom = telecom;
    }

    public String getContactFirst() {
        return contactFirst;
    }

    public void setContactFirst(String contactFirst) {
        this.contactFirst = contactFirst;
    }

    public String getContactSecond() {
        return contactSecond;
    }

    public void setContactSecond(String contactSecond) {
        this.contactSecond = contactSecond;
    }

    public String getGetContactThird() {
        return getContactThird;
    }

    public void setGetContactThird(String getContactThird) {
        this.getContactThird = getContactThird;
    }

    public RegisterVo(String email, String password, String nickname, String name, String telecom, String contactFirst, String contactSecond, String getContactThird) {
        this.email = email;
        this.password = password;
        this.setPassword(password);
        this.nickname = nickname;
        this.name = name;
        this.telecom = telecom;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.getContactThird = getContactThird;

    }
}
