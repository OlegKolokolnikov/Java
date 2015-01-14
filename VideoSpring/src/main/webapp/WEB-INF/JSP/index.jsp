<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beginpagina</title>
    </head>
    <body>
        <a href="<c:url value='mandje'/>">Mandje</a>
        <h1>Reservaties</h1>
        <c:import url="widgets/GenreMenu.jsp"/>  
    </body>
</html>
