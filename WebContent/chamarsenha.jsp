<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function proximo(){		  
		location.href="gerentecontroller.do?opcao=chamarsenha";  	
}
<%
if (request.getAttribute("vazia") != null){
%>
alert('Não existe nenhuma senha na fila.');
<%
}
%>
</script>
<title>c</title>
</head>
<body>
<a href="index.html">Início</a>
<table width="100%" height="500">
	<tr>		
		<th width="100%" align="center"><input type=button value="PRÓXIMO" onclick="proximo();" /></th>
	</tr>
</table>

</body>
</html>