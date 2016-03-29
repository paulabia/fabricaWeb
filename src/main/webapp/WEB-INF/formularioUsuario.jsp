<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.fabricadeprogramador.entidade.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<%@ include file="menu.jsp"%>
	</div>

	<%
		Usuario usu = (Usuario) request.getAttribute("usuario");
	%>
<br><br>
	<form action="usuController" method="post">
		<div>
			<input type="hidden" name="id" value="<%=usu.getId()%>" />
			 nome: <input type="text" name="nome" value="<%=usu.getNome()%>" /><br><br> 
			 login: <input type="text" name="login" value="<%=usu.getLogin()%>" /><br><br> 
			 senha: <input type="text" name="senha" value="<%=usu.getSenha()%>" /> <br><br>
			 <input type="submit" value="salvar" />

		</div>

	</form>

</body>
</html>