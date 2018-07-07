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
<h1>This is index</h1>
Hello <c:out value="${name }"></c:out>
<br>
<a href="<%= request.getContextPath()%>/Show-All-Products">Show All Products</a>
<a href="${pageContext.request.contextPath }/vendor-register">Vendor registration</a><br><br>
<a href="${pageContext.request.contextPath }/Add-Product">Add Product</a>
</body>
</html>