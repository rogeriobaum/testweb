<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<script>
<%
String senha = null;
String id = null;
if (request.getAttribute("id") != null){
	id = request.getAttribute("id").toString();
}
if (request.getAttribute("senha_chamada") != null){
	senha = request.getAttribute("senha_chamada").toString();
	//String id = request.getAttribute("senha_chamada").toString();
	
	if (senha != null){
%>
	alert('Chamando Senha <%=senha%>');
<%
	}
}
%>
</script>
<title>Atendimento Senhas</title>
</head>
<body>
<a href="index.html">Início</a>
<table width="100%">
	<tr>
		<th colspan=3>
		 <%=senha%> 
		</th>
	</tr>
	<tr>		
		<th width="33%" align="center"><a href="gerentecontroller.do?opcao=naocompareceu&id=<%=id%>">Não Compareceu</a></th>		
		<th width="33%" align="center"><a href="gerentecontroller.do?opcao=atendido&id=<%=id%>">Finalizar Atendimento</a></th>	
		
	</tr>
<table>	
</body>
</html>