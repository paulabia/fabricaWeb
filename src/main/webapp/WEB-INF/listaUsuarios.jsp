<%@page import="java.util.List"%>
<%@page import="br.com.fabricadeprogramador.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Usuarios</title>

<script type="text/javascript">
	function confirmar(id) {
		if (window.confirm("Deseja realmente excluir?")) {
			location.href = "usuController?acao=excluir&id=" + id;
		}
	}
</script>

</head>
<body>

	<div>
		<%@ include file="menu.jsp"%>
	</div>

	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("listaUsuarios"); // CAST -> converter o objeto em lista " O setAttribute cria um objeto"
	%>
	<br>
	<div style="width: 50%">
		<table style="width: 100%" border="1">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Login</td>
				<td colspan="3" style="text-align: center;">Ação</td>
			</tr>
			<%
				for (Usuario usu : lista) {
			%>
			<tr>
				<td><%=usu.getId()%></td>
				<td><%=usu.getNome()%></td>
				<td><%=usu.getLogin()%></td>
				<td><a href="usuController?acao=alterar&id=<%=usu.getId()%>">Alterar</a></td>
				<td><a href="javaScript:confirmar(<%=usu.getId()%>)">Excluir</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>
