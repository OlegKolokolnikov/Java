<%-- 
    Document   : rapport
    Created on : 1-okt-2014, 14:20:43
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Rapport</title>
    </head>
    <body>
        <a href="index.htm">Genres</a>
        <h1>Rapport</h1>
        <c:if test="${empty fouten}">
            <h3>De reservatie is OK</h3>
        </c:if>
        <c:if test="${not empty fouten}">
            Volgende films zijn niet gereserveerd:   
                <ul>
                    <c:forEach items="${fouten}" var="item">
                        <li> 
                            ${item}
                        </li>
                    </c:forEach>
                </ul>
        </c:if>
    </body>
</html>
