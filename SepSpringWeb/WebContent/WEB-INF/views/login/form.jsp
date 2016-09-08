<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<form:form commandName="loginCommand">
		<form:errors element="div" /><!-- 글로벌 에러 (전체 에러 표시)-->
		아이디: <form:input path="userId" />
		<form:errors path="userId" />
		<br />
		암호: <form:password path="password" showPassword="false" />
		<form:errors path="password" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>

