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


@WebServlet("/gerentecontroller.do")
public class gerenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

    public gerenteController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");		
		SenhaDAO senDAO = new SenhaDAO();	
		
		 if(opcao.equals("telachamarsenha")){						
				
				RequestDispatcher saida = request.getRequestDispatcher("chamarsenha.jsp");		
				saida.forward(request, response);		
				
		}else if(opcao.equals("atendido")){						
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			senDAO.AlterarStatus(id, 3);
			RequestDispatcher saida = request.getRequestDispatcher("chamarsenha.jsp");		
			saida.forward(request, response);		
			
		}else if(opcao.equals("naocompareceu")){
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			senDAO.AlterarStatus(id, 4);
			RequestDispatcher saida = request.getRequestDispatcher("chamarsenha.jsp");		
			saida.forward(request, response);
			
		}else if(opcao.equals("reiniciar")){			
			
			senDAO.ReiniciarSenhas();
			response.sendRedirect("gerentecontroller.do?opcao=gerente&reiniciar=ok");			
		
		}else if(opcao.equals("gerente")){			
			
			String reiniciar = request.getParameter("reiniciar");			
			request.setAttribute("reiniciar", reiniciar);
			
			RequestDispatcher saida = request.getRequestDispatcher("gerente.jsp");	
			saida.forward(request, response);
			
		}else if(opcao.equals("chamarsenha")){
			
			String senha_chamada = null;
			Integer id     = null;
			Integer numero = null;
			String letra   = null;			
			Integer vazio  = null;			
			
			List<Senha> lista1 = senDAO.ChamarSenha();				
			
			if(lista1.size() == 0){
				request.setAttribute("vazia", "1");
				
				RequestDispatcher saida = request.getRequestDispatcher("chamarsenha.jsp");		
				saida.forward(request, response);
			}else{
				for(Senha s: lista1){
					id     = s.getId();
					numero = s.getNumero_senha();
					letra  = s.getLetra_prioridade();				
					senha_chamada = letra+String.format("%04d", numero);
				}
				request.setAttribute("id", id);
				request.setAttribute("senha_chamada", senha_chamada);				
							
				RequestDispatcher saida = request.getRequestDispatcher("atendimento.jsp");		
				saida.forward(request, response);
			}						
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post		
		
	}

}
