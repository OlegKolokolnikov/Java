<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
    <%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:url value='/kryaadm/choosecategory' var='url'/> 
<form:form action="${url}" method="post" commandName="category"> 
 <form:errors path="name"/> <br/>
 <form:label path="name">Name:</form:label> <br/>
 <form:input path="name" autofocus='autofocus'  /> <br/>
 <form:errors path="discription"/> <br/>
 <form:label path="discription">Discription:</form:label> <br/>
 <form:input path="discription" /> <br/>
 <input type='submit' value='Create'> 
 </form:form> 
 <ul>
<c:forEach var="category" items="${categories}">
<spring:url var='url' value='/kryaadm/category/{id}'> 
<spring:param name='id' value='${category.categoryId}'/> 
</spring:url>
<li><span><a href='${url}'>${category.name}</a></span></li>
</c:forEach> </ul>
</body>
</html>