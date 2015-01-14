<%-- 
    Document   : klant
    Created on : 1-okt-2014, 14:15:36
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klant</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
         <a href="index.htm">Genres</a>
        <a href="mandje.htm">Mandje</a>
        <h1>Klant</h1>
        <c:url value="klant.htm" var="url"/>
        <form method="get" action="${url}">
             <span class="fout">${fouten}</span><br />
            <label>Familienaam bevat: 
            <input name="naam" value="${familienaam}"/>
            </label>
            <input type="submit" value="Zoeken"/>
           
        </form>
        <c:if test="${not empty klant}">
            <table>
                <tr>
                    <th>Naam</th>
                    <th>Straat - Huisnummer</th>
                    <th>Postcode</th>
                    <th>Gemeente</th>
                </tr>
                <c:forEach var="klanten" items="${klant}">
                    <tr>
                        <c:url value="/bevestiging.htm" var="bevURL">
                            <c:param name="klantNr" value="${klanten.klantNr}"/>
                        </c:url>
                        <td><a href="<c:out value='${bevURL}'/>">${klanten.voornaam} ${klanten.familienaam}</a></td>
                        <td>${klanten.straatNummer}</td>
                        <td>${klanten.postCode}</td>
                        <td>${klanten.gemeente}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
       
            
    </body>
</html>
