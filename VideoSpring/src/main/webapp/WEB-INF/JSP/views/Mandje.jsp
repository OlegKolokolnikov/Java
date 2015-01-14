<%-- 
    Document   : mandje
    Created on : 1-okt-2014, 14:14:10
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mandje</title>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css" />
    </head>
    <body>
        <c:set var="totaal" value="0"/>
        <a href="<c:url value='/'/>">Genres</a>
        <a href="<c:url value='/klanten'/>">Klant</a>
        
        <h1>Mandje</h1>
        <c:url value="/mandje/verwijder" var="mandjeURL" />
                <form method="post" action="${mandjeURL}">
       <table>
           
            <tr>
                <th>Film</th>
                <th>Prijs</th>
                
                <th><input type="submit" value="Verwijderen" /></th>
            </tr>
            <c:forEach var="film" items="${filmInMandje}">
            <tr>
                <td>${film.titel}</td>
                <td>${film.prijs}</td>
                <td  class="midden"><input type="checkbox" name="verwijdernummer" value="${film.filmNr}"></td>
                <c:set var="totaal" value="${totaal+film.prijs}"/>
            </tr>
            </c:forEach>
            <tr>
	            <td class="totaal">Totaal: </td>
	            <td class="totaal">${totaal}</td>
	            <td class="totaal"> </td>
            <tr>
        </table>
        </form>
    </body>
</html>
