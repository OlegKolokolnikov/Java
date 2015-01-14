<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservaties</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <a href="mandje.htm">Mandje</a>
        <h1>Reservaties</h1>
        <c:import url="/WEB-INF/JSP/widgets/GenreMenu.jsp"/><br />
        <table>
            <tr>
                <c:forEach var="film" items="${film}">
                <td>
                    <c:url value="/filmdetail.htm" var="detailURL">
                        <c:param name="filmNummer" value="${film.filmNr}"/>
                    </c:url>
                    <a href="<c:out value='${detailURL}'/>">
                        <img src="images/${film.filmNr}.jpg" title="${film.titel}: ${film.gereserveerd<film.voorraad ? 'reservatie mogelijk':'reservatie niet mogelijk'}"/>
                    </a>
                </td>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>
