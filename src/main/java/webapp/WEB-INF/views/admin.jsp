<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/resources/jquery-3.6.0.min.js"/>'></script>
<script>
 	  
$(document).on("click","#confirmar",function(){
    return confirm("Seguro de eliminar?");
  });
    	

</script>

</head>
<body>

	<h1>Admin.jsp</h1>

	<sf:form action="adminSave" method="post" modelAttribute="admin">


		<table>

			<c:if test="${admin.idAd != 0}">
				<sf:input path="idAd" type="hidden" />
				<sf:input path="fechaCreacion" type="hidden" />


			</c:if>

			

			<tr>
				<td>Nombre:</td>
				<td><sf:input path="nombre" type="text" /></td>

			</tr>

			<tr>
				<td>Cargo:</td>
				<td><sf:input path="cargo" type="text" /></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios"></td>

			</tr>

		</table>


	</sf:form>


	<c:forEach var="admins" items="${admins}">

		<c:out value="${admins}"></c:out>
		<a href='<c:url value="/${admins.idAd}"/>'>Actualizar</a>
		<br>
		<a id ="confirmar" href='<c:url value="/${admins.idAd}/delete"/>'>Borrar</a>
		<br>
		<br>
	</c:forEach>


	<br>

	<c:out value="${resp}"></c:out>
	<br>
	<c:out value="${prueba}" />

	<br>

	<%--SessionScope para obtener los datos desde HTTPSESSION --%>
	<c:out value="${sessionScope.resultado}"></c:out>


</body>
</html>