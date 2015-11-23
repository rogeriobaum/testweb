package testweb.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import testweb.entidades.Senha;

public class SenhaDAO {
	
	private Connection con = Conexao.getConnection();
  
	public Integer GerarSenha(String prioridade){
		
		Integer ultima_senha  = 0;
		Integer nova_senha  = null;
		String letra_prioridade  = prioridade;		
				 
		String sql_ultimasenha = "SELECT numero_senha FROM SENHA WHERE letra_prioridade = ? ORDER BY NUMERO_SENHA DESC LIMIT 1";
		
		 
		 try {
			PreparedStatement busca = con.prepareStatement(sql_ultimasenha);
			
			busca.setString(1, prioridade);
			
			ResultSet resultado = busca.executeQuery();			
		
			while (resultado.next()){
				
				ultima_senha = resultado.getInt("numero_senha");
			}			
			
			
			busca.close();
			
		 } catch (SQLException e) {
			 
			 e.printStackTrace();
		 }
		
		 nova_senha = ultima_senha+1;  
		
		 String sql_insere = "INSERT INTO SENHA ( numero_senha, letra_prioridade, status) VALUES (?,?,?)";
		
		  
		 try {
			PreparedStatement insere = con.prepareStatement(sql_insere);
			
			insere.setInt(1, nova_senha);
			insere.setString(2, prioridade);
			insere.setInt(3, 1);
			
			insere.execute();
			insere.close();
			
			//System.out.println("Ok");
			
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }
		 
		 return nova_senha;
		 
	}
	public List<Senha> UltimaSenha(){
		
		Integer id = null;
		List<Senha> lista = new ArrayList<Senha>();
		
		String sql_Senha = "SELECT * FROM SENHA WHERE status = 2 and letra_prioridade = ? ORDER BY numero_senha desc LIMIT 1 ";
		if (id == null){
			try {
				PreparedStatement buscaP = con.prepareStatement(sql_Senha);
				buscaP.setString(1, "P");
				ResultSet resultadoP = buscaP.executeQuery();			
				while (resultadoP.next()){
					Senha sen = new Senha();
					id = resultadoP.getInt("id");
					sen.setId(resultadoP.getInt("id"));
					sen.setNumero_senha(resultadoP.getInt("numero_senha"));
					sen.setLetra_prioridade(resultadoP.getString("letra_prioridade"));
					sen.setStatus(resultadoP.getInt("status"));
				
					lista.add(sen);
				}
				buscaP.close();			
			} catch (SQLException e) {			 
				e.printStackTrace();
			}
		}			
		 if (id == null){		 
			 try {
				 PreparedStatement buscaN = con.prepareStatement(sql_Senha);
				 buscaN.setString(1, "N");
				 ResultSet resultadoN = buscaN.executeQuery();			
				 while (resultadoN.next()){
					Senha sen = new Senha();		
					id = resultadoN.getInt("id");
					sen.setId(resultadoN.getInt("id"));
					sen.setNumero_senha(resultadoN.getInt("numero_senha"));
					sen.setLetra_prioridade(resultadoN.getString("letra_prioridade"));
					sen.setStatus(resultadoN.getInt("status"));
						
					lista.add(sen);
				 }
				 buscaN.close();			
			 } catch (SQLException e) {			 
				 e.printStackTrace();
			 }
		 }		
		 
		 return lista;		 
	}
	public void ReiniciarSenhas(){
		
		//Monta SQL
		 String sql = "DELETE FROM SENHA";
		 
		 //Constroi PreparedStatement 
		 try {
			PreparedStatement reiniciar = con.prepareStatement(sql);
			//busca.setInt(1, 1);
			
			reiniciar.execute();
			reiniciar.close();
			
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }
	}
	
	public void AlterarStatus(Integer id,Integer status){
		
		String sql_AltStatus = "UPDATE SENHA SET status = ? WHERE ID = ?";
		  
		 try {
			 PreparedStatement altStatus = con.prepareStatement(sql_AltStatus);			
			 altStatus.setInt(1, status);			
			 altStatus.setInt(2, id);			
			 altStatus.execute();
			 altStatus.close();
		
	 	} catch (SQLException e) {			 
	 		e.printStackTrace();
	 	}
	}
	public List<Senha> ChamarSenha(){
		
		Integer id = null;
		List<Senha> lista = new ArrayList<Senha>();
		
		String sql_Senha = "SELECT * FROM SENHA WHERE status = 1 and letra_prioridade = ? ORDER BY numero_senha LIMIT 1 ";
		if (id == null){
			try {
				PreparedStatement buscaP = con.prepareStatement(sql_Senha);
				buscaP.setString(1, "P");
				ResultSet resultadoP = buscaP.executeQuery();			
				while (resultadoP.next()){
					Senha sen = new Senha();
					id = resultadoP.getInt("id");
					sen.setId(resultadoP.getInt("id"));
					sen.setNumero_senha(resultadoP.getInt("numero_senha"));
					sen.setLetra_prioridade(resultadoP.getString("letra_prioridade"));
					sen.setStatus(resultadoP.getInt("status"));
				
					lista.add(sen);
				}
				buscaP.close();			
			} catch (SQLException e) {			 
				e.printStackTrace();
			}
		}			
		 if (id == null){		 
			 try {
				 PreparedStatement buscaN = con.prepareStatement(sql_Senha);
				 buscaN.setString(1, "N");
				 ResultSet resultadoN = buscaN.executeQuery();			
				 while (resultadoN.next()){
					Senha sen = new Senha();		
					id = resultadoN.getInt("id");
					sen.setId(resultadoN.getInt("id"));
					sen.setNumero_senha(resultadoN.getInt("numero_senha"));
					sen.setLetra_prioridade(resultadoN.getString("letra_prioridade"));
					sen.setStatus(resultadoN.getInt("status"));
						
					lista.add(sen);
				 }
				 buscaN.close();			
			 } catch (SQLException e) {			 
				 e.printStackTrace();
			 }
		 }			
		 if (id !=  null){	
				
			 this.AlterarStatus(id, 2);
			 
		 }		 
		 
		 return lista;
	}		
}
