<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<script>

function reiniciar(){	
	var r=confirm("Tem certeza que deseja reiniciar as senhas!");
	if (r==true)	{  
		location.href="gerentecontroller.do?opcao=reiniciar";
  	}
}
<%
if (request.getAttribute("reiniciar") != null){
%>
alert('Senhas reiniciadas com sucesso.')
<%
}
%>
</script>

<title>Opções</title>
</head>
<body>
<a href="index.html">Início</a>
<table width="100%" height="500" border="1">
	<tr>		
		<th width="50%" align="center"><a href="gerentecontroller.do?opcao=telachamarsenha">CHAMAR SENHAS</a></th>		
		<th width="50%" align="center"><input type=button value="REINICIAR SENHAS" onclick="reiniciar();" /></th>		
	</tr>
</table>

</body>
</html>