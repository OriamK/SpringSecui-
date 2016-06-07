<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src='<c:url value="res/js/jquery.js"/>'></script>
<title>Insert title here</title>

<script type="text/javascript">
	$(document).ready(function() {
		
		$(".confirm").on("click",function() {
			return confirm("Eliminar");
		});
		
		
	});
</script>

</head>
<body>
	<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	<h1>Admin.jsp</h1>

	<form:form action="${pageContext.request.contextPath}/admin/save"
		method="post" commandName="admin" >
		<table>

			<c:if test="${admin.idAd ne 0}">
				<form:input path="idAd" type="hidden" />
				<form:input path="fechaCreacion" type="hidden" />
			</c:if>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><form:input path="cargo" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar Cambios"></td>
			</tr>

		</table>
	</form:form>

	<br>
	<c:out value="${resultado}"></c:out>
	<br>

	<c:forEach items="${administradores}" var="admin">

		<c:out value="${admin}" />
			<a href='<c:url value="/direccion/${admin.idAd}"/>'>Direcciones</a>
			<a href='<c:url value="/admin/${admin.idAd}/update"/>'>Actualizar</a>
			<a class="confirm" href='<c:url value="/admin/${admin.idAd}/delete"/>'>Eliminar</a>
		<br>

	</c:forEach>


</body>
</html>