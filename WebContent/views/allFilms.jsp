<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dvdstore.model.Film" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"/>
<title>Tutti i film </title>
</head>
<body>
<c:if test="${not empty utente}">
	<a class="a1" href="views/profilo.jsp"> Carrello </a>
	
</c:if>
<c:if test="${empty utente}">
	<a class="a1" href="login.jsp"> Login </a>
</c:if>
<h2>Lista completa dei film:</h2>
<a class="a1" href="homepage.jsp"> Indietro </a>
<hr>
<table class="table1" border="1">
	<tr> 
	<td> <b> Titolo </b> </td>
	<td> <b> Prezzo </b> </td>
	<td> <b> Durata </b> </td>
	<td> <b> Disponibilità </b> </td>
	<td> </td>
	</tr>

<c:forEach items="${requestScope.fullList}" var="x">
<tr>
<td>
<c:out value="${x.getTitle()}"></c:out>
</td>
<td>
<c:out value="${x.getPrice()}"></c:out>
</td>
<td>
<c:out value="${x.getLength()}"></c:out>
</td>
<td>
<%-- <c:out value="${x.getDisp()}"></c:out> --%>
</td>
<td>
<c:if test="${not empty utente}">
	<a class="a3" href="SessionController?idFilm=${x.getId()}&comm=add" >Aggiungi al carrello</a>
</c:if>
<c:if test="${empty utente}">
	<a class="a1" href="views/login.jsp"> Effettua il login per acquistare </a>
</c:if>

</td>
</tr>
</c:forEach>
</table>
</body>
</html>