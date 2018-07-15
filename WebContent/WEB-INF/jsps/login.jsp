<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Custom Login</h3><form name='f' action='${pageContext.request.contextPath }/login' method='POST'>
<c:if test="${param.status != incorrect }">
	<font color="red">Invalid Username or Password</font>
</c:if>
<c:if test="${param.action != logout }">
	<font color="blue">You have been successfully logged out</font>
</c:if>
<table>
	<tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
	<tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
	<tr><td>Remember Me:</td><td><input type='checkbox' name='_spring_security_remember_me' checked="checked"/></td></tr>
	<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
</table>
</form>
</body>
</html>