<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sv" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Vendor Registration</h1>
<sv:form action="${pageContext.request.contextPath }/vendor-register" method="POST" modelAttribute="vendor">
Name : <sv:input type="text" name="name" path="name" /> <sv:errors path="name"/><br>
City : <sv:input type="text" name="city" path="city" /> <sv:errors path="city"/><br>
Email : <sv:input type="text" name="email" path="email" /> <sv:errors path="email"/><br>
Password : <sv:input type="password" name="password" path="password" /> <sv:errors path="password"/><br>
Password : <input type="password" name="repassword" path="repassword" /><br>
<input type="submit" value="Register" /><br>
</sv:form>
</body>
</html>