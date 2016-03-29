<%@page import="br.com.fabricadeprogramador.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div>
	<label>Olá, </label> <br>
		<%
			Usuario usuario = ((Usuario) request.getSession().getAttribute("usuController")); // CAST -> converter o objeto em usuario " O setAttribute cria um objeto"
			out.print(usuario.getNome());
		%>

	</div>


	<div id="menu">
		<a href="">Home</a>| <a href="usuController?acao=cadastrar">Cadastrar</a>|
		<a href="usuController?acao=listar">Lista</a>|
	</div>

</body>
</html>


