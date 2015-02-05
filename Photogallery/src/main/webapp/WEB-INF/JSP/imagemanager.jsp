<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
    <%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<html>
<head>
<title>Upload Multiple File Request Page</title>
</head>
<body>
 
     <c:url value='/kryaadm/image/add' var='url'/> 
	<form:form action="${url}" method="post" enctype="multipart/form-data"> 
        File1 to upload: <input type="file" name="image"><br /> <br /> 
        <input type="submit" value="Upload"> Press here to upload the file!
    </form:form>
     
</body>
</html>