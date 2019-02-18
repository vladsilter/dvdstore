<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.dvdstore.model.Actor" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Tabella attori</h1>
<hr>
	<table border=5>
		<tr>
			<td><b>Cognome</b></td>
			<td><b>Nome</b></td>
		</tr>
		<% 
			ArrayList<Actor> list = (ArrayList<Actor>) request.getAttribute("full_list");
			
			for(int i=0;i<list.size();i++){
				out.println("<tr>");
					
					out.println("<td>");
						out.println(list.get(i).getCognome());
					out.println("</td>");
					
					out.println("<td>");
						out.println(list.get(i).getNome());
					out.println("</td>");
				
				out.println("</tr>");
			}
		%>
	
	
	</table>
</body>
</html>