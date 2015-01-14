<%-- 
    Document   : bevestigingen
    Created on : 1-okt-2014, 14:18:22
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bevestigingen</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <a href="index.htm">Genres</a>
        <a href="klant.htm">Klant</a>
        <h1>Bevestigingen</h1>
        <c:if test="${not empty klant}">
            
            <c:if test="${teReserveren > 0}">
                ${teReserveren} film(s) voor ${klant.voornaam} ${klant.familienaam}
                <c:url value="rapport.htm" var="rapportURL" />
                <form method="get" action="${rapportURL}">
                    <input type="hidden" name="klnummer"  value="${klant.klantNr}">
                    <input type="submit" value="Bevestigen" />
                </form>
                </c:if>
                <c:if test="${teReserveren == 0}">
                    Niets te reserveren voor ${klant.voornaam} ${klant.familienaam}
                </c:if>
        </c:if>
        <c:if test="${not empty fout}">
            <div class="fout">${fout}</div>
        </c:if>
    </body>
</html>
