<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
    <%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/styles.css"/>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css"/>
<title>Insert title here</title>
</head>
<body>
<div id='cssmenu'>
<ul>
<li><span><a href="<c:url value='/kryaadm/categorymanager'/>">Категории</a></span></li>
<li><span><a href="<c:url value='/kryaadm/imagemanager'/>">Изображения</a></span></li>
<li><span><a href="<c:url value='/kryaadm/zloemanager'/>">Злое</a></span></li>
 </ul></div>
</body>
</html>