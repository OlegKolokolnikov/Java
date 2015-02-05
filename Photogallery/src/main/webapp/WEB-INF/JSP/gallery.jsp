<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
    <%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css"/>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/bootstrap.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/lightbox/js/lightbox.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/bootstrap.min.js"></script>

<link href="${pageContext.servletContext.contextPath}/scripts/lightbox/css/lightbox.css" rel="stylesheet" />
</head>
<body>
<header><c:import url="/gallery/choosecategory"></c:import><br/></header>
<div class="container">
  <div class="jumbotron">
<c:forEach var="image" items="${images}">
<a title="${image.discription}" data-lightbox="${category.name}" href="<c:url value='/images/${category.name}/${image.name}.jpg'/>">
<img width="200" height="150" alt="" src="<c:url value='/images/${category.name}/${image.name}.jpg'/>">
</a>
</c:forEach>
</div></div>
<footer></footer>
</body>
</html>