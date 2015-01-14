<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css"/>
<title>Maria-Krya</title>
</head>
<body>
<h1>Здесь будет фотогалерея</h1>
	<img src="${pageContext.servletContext.contextPath}/images/me/me.jpg" width="500" height="400"/>
	<a href="<c:url value='/gallery/choosecategory'/>">Галерея</a>
 <a href="<c:url value='/kryaadm'/>">Админка</a>
</body>
</html>