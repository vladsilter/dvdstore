<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dvdstore.model.Actor" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"/>
<title> Tutti gli Attori </title>
</head>
<body>
<c:if test="${not empty user}">
	<a class="a1" href="profilo.jsp"> Carrello </a>
</c:if>
<c:if test="${empty user}">
	<a class="a1" href="login.jsp"> Login </a>
</c:if>
<h1>Lista completa degli attori:</h1>
<a class="a1" href="homepage.jsp"> Indietro </a>
<hr>
<table class="table1" border="1">
				
				<tr>
					<td><b>Cognome</b></td>
					<td><b>Nome</b></td>
				
				</tr>
				<c:forEach items="${requestScope.fullList}" var="x">
						
						<tr>
							<td>
								<c:out value="${x.getCognome()}"></c:out>
							</td>
							<td>
								<c:out value="${x.getNome()}"></c:out>
							</td>
						</tr>
				</c:forEach>
</table>
</body>
</html>