package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

@WebServlet("/autenticar")
public class AutenticadorController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuAutenticado = usuarioDao.autenticar(login, senha);
		
		if(usuAutenticado != null){
			HttpSession session = req.getSession(); // crio uma sessão, o request os permite criar uma sessão
			// quando é criado uma sessão, cada usuario tem um ID de sessão, abaixo enviamo o sessãoId do Usuario
			session.setAttribute("usuario", usuAutenticado); // envia o usuario autenticado para a sessão criada
			
			session.setMaxInactiveInterval(60*5); // determinar o tempo de login do usuario
			
			//Redirecionando o usuario para a tela principal
			
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}else{
			
			resp.getWriter().print("<script> window.alert('Não encontrado'); location.href='login.html'</script>");
			
		}
	}

}
