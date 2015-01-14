<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">
    <head>
        <title>Video - pagina niet gevonden</title>
        <link rel="stylesheet" href="styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/widgets/GenreMenu.jsp"/>
        <h1>Pagina niet gevonden</h1>
        
        <p>De pagina die u zocht bestaat niet op onze website.</p>
    </body>
</html>