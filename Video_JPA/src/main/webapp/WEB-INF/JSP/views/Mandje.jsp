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
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <c:set var="totaal" value="0"/>
        <a href="index.htm">Genres</a>
        <a href="klant.htm">Klant</a>
        
        <h1>Mandje</h1>
       <table>
           <c:url value="mandje.htm" var="mandjeURL" />
                <form method="post" action="${mandjeURL}">
                <input type="hidden" name="nummer"  value="${film.filmNr}">
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
            </form>
            <td class="totaal">Totaal: </td>
            <td class="totaal">${totaal}</td>
            <td class="totaal">&nbsp</td>
        </table>
    </body>
</html>
