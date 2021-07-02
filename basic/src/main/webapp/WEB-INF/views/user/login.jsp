<%@ page import="org.eclipse.jdt.internal.compiler.batch.Main" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>소양</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preload" as="style"
          href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="/resources/stylesheets/common.css">

</head>
<body>

<%@ include file="/WEB-INF/views/header.jsp"%>
<main>
    <form method="post" >
        <div>
        <label>
            <input maxlength="50" name="email" placeholder="이메일" type="email">
        </label>
        </div>

        <div>
            <label>
                <input maxlength="50" name="password" placeholder="비밀번호" type="password">
            </label>
        </div>
        <div>
            <input type="submit" value="로그인">
        </div>
        <div>
            <a>아직 계정이 없으신가요?</a>
            <a href="register" target="_self">회원가입</a>
        </div>
        <div>
            <a>비밀번호를 분실하셨나요</a>
            <a href="recover" target="_self">비밀번호 찾기</a>
        </div>
    </form>
</main>

<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>