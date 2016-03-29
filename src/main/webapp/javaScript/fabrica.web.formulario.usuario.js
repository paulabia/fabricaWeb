// Função para confirmar a exclusão
function confirmarExclusao(id) {
	if (window.confirm("Deseja realmente excluir?")) {
		location.href = "usuController?acao=excluir&id=" + id;
	}
}