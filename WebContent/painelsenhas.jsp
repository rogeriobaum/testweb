<%@page import = "testweb.entidades.Senha"%>
<%@page import = "java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="3" /> 
<title>Painel Senhas</title>
</head>
<body>
<a href="index.html">Início</a>
<table border=1>	
	<tr>
		<th>Chamando Senha:</th>	
		
	</tr>
	<%
	List<Senha> lista = (List<Senha>) request.getAttribute("lista");
	for(Senha sU: lista){
	%>
	<tr>		
		<td><% out.print(sU.getLetra_prioridade()+String.format("%04d", sU.getNumero_senha()));%></td>				
	</tr>
	<%
	}
	%>
</table>
</body>
</html>