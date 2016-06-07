<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
	<h1>Acceso a usuarios</h1>
	<c:if test="${param.error != null}">
		<span style="color:red;">Error en credenciales!</span>
	</c:if>
	<form name='f' action="j_spring_security_check" method='POST'>
		<table>	
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>	
			<tr>		
				<td>Contraseña:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

	<%--   	<span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span> --%>



</body>
</html>