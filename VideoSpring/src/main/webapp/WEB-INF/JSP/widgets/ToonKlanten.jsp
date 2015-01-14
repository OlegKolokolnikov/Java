<%-- 
    Document   : klant
    Created on : 1-okt-2014, 14:15:36
    Author     : Oleg.Kolokolnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klant</title>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css" />
    </head>
    <body>
         <a href="<c:url value='/'/>">Genres</a>
        <a href="<c:url value='/mandje'/>">Mandje</a>
        <h1>Klant</h1>
        <c:url value="/klanten" var="url"/>
        <form:form action="${url}" method="get" commandName="klantForm"> 
			<form:label path="naam">Familienaam bevat:</form:label> 
			<form:input path="naam" autofocus="autofocus" /> 
			
			<input type="submit" value="Zoeken"/> <br/>
			<form:errors path="naam" cssClass="fout"/>
			<form:errors cssClass="fout" element="div"/>
			 <span class="fout">${fouten}</span><br />
		</form:form>
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
                        <c:url value="klanten/bevestig/${klanten.klantNr}" var="bevURL">
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
