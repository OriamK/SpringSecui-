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


</head>
<body>

	<h1>Direccion.jsp</h1>

	<form:form action="${pageContext.request.contextPath}/direccion/save"
		method="post" commandName="direccion">
		<table>

<%-- 			<c:if test="${admin.idAd ne 0}"> --%>
<%-- 				<form:input path="idAd" type="hidden" /> --%>
<%-- 				<form:input path="fechaCreacion" type="hidden" /> --%>
<%-- 			</c:if> --%>
			<tr>
				<td>Calle</td>
				<td><form:input path="calle" type="text" /></td>
			</tr>
			<tr>
				<td>Codigo</td>
				<td><form:input path="codigo" type="text" /></td>
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

	<c:forEach items="${direcciones}" var="direccion">

		<c:out value="${direccion}" />
		
		<br>
	</c:forEach>


</body>
</html>