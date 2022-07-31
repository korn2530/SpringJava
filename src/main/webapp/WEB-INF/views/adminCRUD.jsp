<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <script type="text/javascript" src="<c:url value="/resources/jquery-3.6.0.min.js"></c:url>"></script>
        
        <script>
           
          $(document).on("click","#eliminar",function (){
             
              return confirm("Seguro desea Eliminar?");
              
          });
           
           
        </script>
        
        <title>Insert title here</title>
    </head>
    <body>

        <h1>SPRING CRUD</h1>
 

        
        
        <form:form action="saveOrUpdate" method="post" modelAttribute="admin">

            <!--Ocultar input cuando se actualiza los datos-->

            <c:if test="${admin.idAd!=0}">
                <form:input path="idAd" type="hidden"/>
                <form:input path="fechaCreacion" type="hidden"/>

            </c:if>

            Nombre : <form:input path="nombre" type="text"/><br>
            <br>
            Cargo : <form:input path="cargo" type="text"/><br>
            <br>

            <input type="submit" value="Procesar">

        </form:form>

        <c:forEach var="listar" items="${listar}">

            <c:out value="${listar}"></c:out>
            <a href="<c:url value="/${listar.idAd}"></c:url>">Actualizar</a>
            <a id="eliminar" href="<c:url value="/delete/${listar.idAd}"></c:url>">Borrar</a>
            <a href="<c:url value="/direccion/${listar.idAd}"></c:url>">Direccion</a>
            <br>

        </c:forEach>

    </body>
</html>