<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<h1> Spring Security Login Form</h1>
	
	<c:if test="${not empty errorMessage}">
	<div style="color:red; font-weight: bold; margin:30px 0px;">
	${errorMessage}</div></c:if>
	
	<form name="login" action="${pageContext.request.contextPath}/login" method="post">
	<table>
		<tr>
			<td>UserName:</td>
			<td><input type="text" name="username" value=""></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan = "2"><input type="submit" name="submit" value="submit"/></td>
		</tr>
	</table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
	</form>
 	

</body>
</html>






