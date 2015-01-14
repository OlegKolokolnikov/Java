<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl">
	<head>
		<link rel="stylesheet"
		href="${pageContext.servletContext.contextPath}/styles/default.css" />
		<title>Aanmelden</title>
	</head>
	<body>
		<h1>Aanmelden</h1>
		<form method='post' action='<c:url value="/j_spring_security_check"/>'> 
			<label>Gebruikersnaam:
			<input name="j_username" autofocus /></label> 
			<label>Paswoord:
			<input type="password" name="j_password"/></label> 
			<div class="rij"><label><input type="checkbox" /> 
Onthoud me op deze computer</label></div>
			<input type="submit" value="Aanmelden"/>
			<c:if test="${param.error}"> 
				<div class="fout">Verkeerde gebruikersnaam of paswoord.</div>
			</c:if>
		</form>
	</body>
</html>