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

<h1>All Products</h1>
<c:forEach var="p" items="${list }">
	<c:out value="${p.getName() }" /> -- <c:out value="${p.getPrice() }" /> <br>
	<a href="<%= request.getContextPath() %>/Show-Product?id=<c:out value="${p.getId() }" />">Description</a> <br>
</c:forEach>
</body>
</html>