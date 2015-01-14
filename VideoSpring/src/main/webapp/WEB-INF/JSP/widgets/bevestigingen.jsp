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
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css" />
    </head>
    <body>
        <a href="../../">Genres</a>
        <a href="../">Klant</a>
        <h1>Bevestigingen</h1>
        <c:if test="${not empty klant}">
            
            <c:if test="${teReserveren > 0}">
                ${teReserveren} film(s) voor ${klant.voornaam} ${klant.familienaam}
                <c:url value="/rapport/${klant.klantNr}" var="rapportURL" />
                <form method="post" action="<c:out value='${rapportURL}'/>">
                <input type="hidden" name="klantNummer" value="${klant.klantNr}" />
                    <input type="submit" value="Bevestigen" />
                </form>
                </c:if>
                <c:if test="${teReserveren == 0}">
                    Niets te reserveren voor ${klant.voornaam} ${klant.familienaam}
                </c:if>
        </c:if>
        <c:if test="${empty klant}">
            <div class="fout">Klant niet gevonden</div>
        </c:if>
    </body>
</html>
