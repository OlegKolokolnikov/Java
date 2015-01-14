<%-- 
    Document   : filmdetail
    Created on : 1-okt-2014, 13:28:21
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Film</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        
        <a href="index.htm">Genres</a>
        <c:if test="${not empty film}">
            <h1>${film.titel}</h1>
            <img src="images/${film.filmNr}.jpg">
            <h2>Prijs</h2>
            <h2>&euro; ${film.prijs}</h2>
            <h2>Voorraad</h2>
            <h2>${film.voorraad}</h2>
            <h2>Gereserveerd</h2>
            <h2>${film.gereserveerd}</h2>
            <h2>Beschikbaar</h2>
            <h2>${film.voorraad-film.gereserveerd}</h2>
            <c:if test="${film.voorraad-film.gereserveerd>0}">
                <c:url value="mandje.htm" var="mandjeURL" />
                <form method="post" action="${mandjeURL}">
                    <input type="hidden" name="nummer"  value="${film.filmNr}">
                    <input type="submit" value="In mandje" />
                </form>
        </c:if>
        </c:if>
        <c:if test="${not empty fout}">
            <div class="fout">${fout}</div>
        </c:if>
    </body>
</html>
