<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto"/>
<title>Home Page</title>
</head>
<body>
<c:if test="${not empty utente}">
<a class="a1" href="profilo.jsp"> Carrello </a>
</c:if>
<c:if test="${empty utente}">
<% String url=request.getRequestURL().toString(); %>
<a class="a1" href="login.jsp?param=<%= url %>"> Login </a>
</c:if>
<h1><strong>  DVD STORE </strong> </h1>
<h2> Benvenuto nella home page del DVD STORE! </h2>
<hr>
<div class="dim1">
<form action="../MainController" method="post">
<input type="text" size="80%" placeholder="Cerca qui..." name="ricerca"><br>
<input class="btnHP" type="submit" value="Titolo" name="srcT">
<input class="btnHP" type="submit" value="Attore" name="srcA">
<select name="category">
<option value="1"> Action</option>
  <option value="2">Animation</option>
  <option value="3">Children</option>
  <option value="4">Classics</option>
  <option value="5">Comedy</option>
  <option value="6">Documentary</option>
  <option value="7">Drama</option>
  <option value="8">Family</option>
  <option value="9">Foreign</option>
  <option value="10">Games</option>
  <option value="11">Horror</option>
  <option value="12">Music</option>
  <option value="13">New</option>
  <option value="14">Sci-fi</option>
  <option value="15">Sports</option>
  <option value="16">Travel</option>
</select>
 <button class="btnHP" type="submit" name="srcCat" value="cat">Genere</button> 
</form>
</div>
<p class="dim2">
<a href="../MainController?param=2">Tutti i film</a>
<a href="../MainController?param=1">Tutti gli attori</a>
</p>
</body>
</html>