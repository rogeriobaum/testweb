package testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import testweb.entidades.Senha;
import testweb.jdbc.SenhaDAO;


@WebServlet("/clientecontroller.do")
public class clienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

    public clienteController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		
		SenhaDAO senDAO = new SenhaDAO();	
		
		if(opcao.equals("telagerarsenhas")){			
		
			RequestDispatcher saida = request.getRequestDispatcher("gerarsenhas.jsp");		
			saida.forward(request, response);
			
		}else if(opcao.equals("gerarsenha")){			
				
				String prioridade = request.getParameter("prioridade");
				Integer nova_senha = null;
				String senha_criada = null;
				
				nova_senha = senDAO.GerarSenha(prioridade);
				
				senha_criada = prioridade+String.format("%04d", nova_senha);
				
				request.setAttribute("nova_senha", senha_criada);
				
				RequestDispatcher saida = request.getRequestDispatcher("gerarsenhas.jsp");		
				saida.forward(request, response);
			
		}else if(opcao.equals("painel")){		
				
			List<Senha> lista = senDAO.UltimaSenha();
		
			request.setAttribute("lista", lista);
		
			RequestDispatcher saida = request.getRequestDispatcher("painelsenhas.jsp");		
			saida.forward(request, response);
			
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post		
		
	}

}
