<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<c:forEach var="category" items="${categories}">
<spring:url var='url' value='/gallery/{id}'> 
<spring:param name='id' value='${category.categoryId}'/> 
</spring:url>
<li><span><a href='${url}'>${category.name}</a></span></li>
</c:forEach> </ul></div>
</body>
</html>