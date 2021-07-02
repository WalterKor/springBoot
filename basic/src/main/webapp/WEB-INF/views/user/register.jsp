<%@ page import="org.eclipse.jdt.internal.compiler.batch.Main" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입-소양</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preload" as="style"
          href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="/resources/stylesheets/common.css">

</head>
<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

<main>
    <form method="post">
        <div>
            <label>
                <input autofocus maxlength="50" name="email" placeholder="이메일" type="email">
            </label>
            <span>해당 이메일은 이미 사용 중입니다.</span>
        </div>
        <div>
            <label>
                <input maxlength="100" name="password" placeholder="비밀번호" type="password">
            </label>
        </div>
        <div>
            <label>
                <input maxlength="100" name="passwordCheck" placeholder="비밀번호 재입력" type="password">
            </label>
            <span>비밀번호가 서로 일치하지 않습니다.</span>
        </div>
        <div>
            <label>
                <input maxlength="10" name="nickname" placeholder="닉네임" type="text">
            </label>
            <span>해당 닉네임은 이미 사용 중입니다.</span>
        </div>
        <div>
            <label>
                <input maxlength="5" name="name" placeholder="실명" type="text">
            </label>
        </div>
        <div>
            <label>
                <select name="telecom">
                    <option value="SKT" selected>SKT</option>
                    <option value="KT">KT</option>
                    <option value="LGU">LGU+</option>
                </select>
            </label>
            <label>
                <select name="contactFirst">
                    <option value="010" selected>010</option>
                </select>
            </label>
            <span>-</span>
            <label>
                <input maxlength="4" name="contactSecond" style="width: 50px;" type="text">
            </label>
            <span>-</span>
            <label>
                <input maxlength="4" name="contactThird" style="width: 50px;" type="text">
            </label>
        </div>
        <div>
            <label>
                <textarea readonly style="width: 400px; height:100px; resize: none;"> 이용약관 및 개인정보처리방침</textarea>
            </label>
        </div>
        <div>
            <label>
                <input name="agree" type="checkbox">
                <span> 이용약관 및 개인정보처리방침을 모두 읽어보았으며 이해하고 동의합니다.</span>
            </label>
        </div>
        <div>
            <input type="reset" value="다시 작성">
            <input type="submit" value="회원가입">
        </div>
    </form>
</main>

<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>