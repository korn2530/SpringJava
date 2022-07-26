<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       
       <h1>about.jsp</h1>

<a href="<c:url value="/admin"/>">Acerca de </a>

 <c:out value="${sessionScope.resultado}"></c:out>

</body>
</html>