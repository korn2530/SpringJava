
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Direccion.jsp</h1>
        
        <form:form action="/direccion/save" method="post" modelAttribute="direccion">
            
            Calle: <form:input path="calle" type="text"></form:input>
            
            Cp: <form:input path="cp" type="text"></form:input>
            
            <input type="submit" value="guardar">
            
        </form:form>
            
            <c:out value="${resultado}"></c:out> 
            
            <c:forEach var="dire" items="${dire}"> 
                
                <c:out value="${dire}"></c:out><br>
                
                
            </c:forEach>
        
    </body>
</html>
