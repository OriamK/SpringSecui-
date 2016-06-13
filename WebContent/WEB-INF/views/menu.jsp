<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	
	<h1>Menu</h1>
	<sec:authorize access="!isAuthenticated()">
		Porfavor inicie sesion
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		Usuario a iniciado sesion como:
		<sec:authentication property="principal" var="principal"/>
		<c:set var="username" value="${principal}"/>
		<c:out value="${username}"></c:out>
		<br/>
		<a href="<c:url value='/logout' />">Cerrar sesion</a>
		
	</sec:authorize>


