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

	<h1>Spring web. Claro que si papa</h1>

   <!--<a href="<c:url value="/about"/>">Acerca de </a>
   
    <c:out value="${sessionScope.resultado}"></c:out>-->
    
    <a href="<c:url value ="/admin"/>">Gestionar administradores</a>
    
    
    <!-- Imprimiendo adminForm -->
     <c:out value="${eladmin}"></c:out>  
   
 </body>
</html>