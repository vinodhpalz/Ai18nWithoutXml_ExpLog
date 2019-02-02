<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h2>${welcomeMsg}</h2>
	<hr/>
	<a id="en" href="${pageContext.request.contextPath}/?lang=en">English</a> | <a id="fr" href="${pageContext.request.contextPath}/?lang=fr">French</a> | <a id="zh" href="${pageContext.request.contextPath}/?lang=zh">Chinese</a> | <a href="${pageContext.request.contextPath}/logout">Logout</a>
	<div> </div>
	<div id="welcome_text">
		<h4><spring:message code="welcome.message"/></h4>
		<spring:message code="lbl.fname"/><input type="text" name="fname"/><br/>
		<spring:message code="lbl.lname"/><input type="text" name="lname"/><br/>
		<spring:message code="txt.country"/><input type="text" name="country"/><br/>
	</div> 
</body>
</html>