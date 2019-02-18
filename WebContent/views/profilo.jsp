<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dvdstore.model.Film" %>
<%@ page import="com.dvdstore.model.CartImpl" %>    
<%@ page import="com.dvdstore.model.Cart" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"/>
<title>Il tuo carrello</title>
</head>
<body>
<c:if test="${empty utente}">
<c:redirect url="login.jsp"/>
</c:if>
<h2> Riepilogo ordini:</h2>
<a class="a1" href="../SessionController?comm=logout""> Logout </a>
<a class="a2" href="homepage.jsp"> Home </a>
<hr>
<table class="table2" border=1>
<tr> 
	<td> <b> Titolo </b> </td>
	<td> <b> Prezzo </b> </td>
	<td> </td>
</tr>
<c:forEach items="${sessionScope.carrello.listaFilm}" var="x">
<tr>
	<td>
		<c:out value="${x.getTitle()}"></c:out>
	</td>
	<td>
		<c:out value="${x.getPrice()}"></c:out>
	</td>
	<td>
		<a class="a2" href="../SessionController?idFilm=${x.getId()}&comm=remove">Rimuovi</a>
	</td>
</tr>
</c:forEach>
</table>
<div class="dim3">
<form>
  <fieldset>
    <legend>Informazioni account:</legend>
    Email: <br>
    Nome:<br>
  </fieldset>
</form>
</div>
<p class="tot">TOTALE: €
<input action="../SessionController&comm=buy" class="btnA" type="submit" value="Acquista ora">
</p>
</body>
</html>