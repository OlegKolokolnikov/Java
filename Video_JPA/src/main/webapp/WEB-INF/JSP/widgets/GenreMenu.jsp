<%-- 
    Document   : menu
    Created on : 1-okt-2014, 10:29:52
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
        <link rel="stylesheet" href="styles/menu.css" />
    </head>
    <body><ul>
         <c:forEach var="genre" items="${genres}">
        <c:url value="/genredetail.htm" var="detailURL">
        <c:param name="genreNummer" value="${genre.genreNr}"/>
        </c:url>
        <li>
        <a href="<c:out value='${detailURL}'/>">${genre.naam}</a>
        </li>
        </c:forEach></ul>
    </body>
</html>
