CREATE TABLE t_user(
   iuser INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
   email VARCHAR(50) UNIQUE NOT NULL,
   pw VARCHAR(100) NOT NULL,
   nm VARCHAR(5) NOT NULL,
   tel CHAR(13) COMMENT '연락처',
   authCd CHAR(5) COMMENT '회원가입 인증코드, null이면 인증받은 상태, 값이 있으면 인증해야 되는 상태',
   regdt DATETIME DEFAULT NOW(),
   INDEX idx_auth_cd (`authCd`)
);


/* pk값은 있어줘야한다. 레코드의 대표값이다. */
/* Pk는 테이블의 identity */
CREATE TABLE t_user_profile(
    iprofile INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    iuser INT UNSIGNED,
    img VARCHAR(50),
    regdt datetime DEFAULT NOW(),
    FOREIGN KEY(iuser) REFERENCES t_user(iuser)
);



