<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<script>
<%
if (request.getAttribute("nova_senha") != null){
%>
alert('Gerada senha <%=request.getAttribute("nova_senha").toString()%>');
<%
}
%>
</script>
<title>Gerar Senhas</title>
</head>
<body>
<a href="index.html">In�cio</a>
<table>
	<tr>		
		<th width="50%" align="center"><a href="clientecontroller.do?opcao=gerarsenha&prioridade=P">Preferencial</a></th>		
		<th width="50%" align="center"><a href="clientecontroller.do?opcao=gerarsenha&prioridade=N">Normal</a></th>		
	</tr>
<table>	
</body>
</html>