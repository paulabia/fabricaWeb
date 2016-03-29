package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

@WebServlet("/usuController")//Mapeamento para acessar o usuario controller EX: http://localhost:8181/fabricaWeb/usuController
public class UsuarioController extends HttpServlet{

	//busca os dados
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UsuarioDao usuarioDao = new UsuarioDao();
		String acao = req.getParameter("acao");
		
		if(acao.equals("excluir") ){
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(req.getParameter("id")));
			
			usuarioDao.exclui(usu);	
			//resp.getWriter().print("Excluído com Sucesso!!");
			
			resp.sendRedirect("usuController?acao=listar"); // redirecionando para a listar após excluir o usuario, FAZ UMA NOVA REQUISIÇÃO na URL determinada
			
		}else if(acao.equals("listar")){
			List<Usuario> listUsuarios = new ArrayList<Usuario>();
			
			listUsuarios.addAll(usuarioDao.buscaTodos());
			
			//resp.getWriter().print(listUsuarios); -> serve para imprimir os dados no browser, sem formtação nenhum, apenas com o toStrig() retornado.
			
			req.setAttribute("listaUsuarios", listUsuarios ); // adicionando a lista de usuários no request, para enviar para o .jsp
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/listaUsuarios.jsp"); // cria um estancia do RequestDispatcher que realiza o encaminhamento da lista
			
			requestDispatcher.forward(req, resp);// envia o resquest e o response para o .jsp "O RESQUEST ESTÁ CONTENDO A LISTA DE USUARIOS"
			
		}else if(acao.equals("alterar")){
			Usuario usu = usuarioDao.buscaPorId(Integer.parseInt(req.getParameter("id")));
			
			req.setAttribute("usuario", usu);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/formularioUsuario.jsp"); 
			
			requestDispatcher.forward(req, resp);
			
		}else if(acao.equals("cadastrar")){
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setLogin("");
			usu.setSenha("");
			usu.setNome("");
			
			req.setAttribute("usuario", usu);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/formularioUsuario.jsp"); 
			
			requestDispatcher.forward(req, resp);
			
		}
	}
	
	//envia dados
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    
		Usuario usu = new Usuario();
		String id = req.getParameter("id");
		
		if(id != "null"){
			usu.setId(Integer.parseInt(id));
		}
		
		usu.setLogin(req.getParameter("login"));
		usu.setSenha(req.getParameter("senha"));
		usu.setNome(req.getParameter("nome"));
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salva(usu);
		resp.sendRedirect("usuController?acao=listar");
	}
	
}
