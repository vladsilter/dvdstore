<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"/>
<title>Login account</title>
</head>
<body>
<h1><strong>  DVD STORE </strong> </h1>
<a class="a1" href="homepage.jsp"> Homepage </a>
<hr>
<form action="../SessionController" method="post" class="form1">
  <fieldset>
    <legend><b> Login: </b> </legend>
   	Email: <input type="text" required="true" name="email"><br>
    Password: <input type="password" maxlength="10" name="password">
    <input name="btnAccedi" type="submit" value="Accedi">
    </fieldset>
</form>
<form action="../MainControllerRegistra" method="post" class="form2">
  <fieldset>
    <legend><b> Sign in: </b> </legend>
    Nome: <input type="text" name="nome"><br>
   	Email: <input type="text" required="true" name="email"><br>
   	Password: <input type="password" maxlength="10" name="password">
    <input type="submit" value="Registrati">
    </fieldset>
</form>
</body>
</html>