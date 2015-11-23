package testweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		static Connection con = null;
		
		public static Connection getConnection(){
			
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testweb", "postgres", "123456");
				System.out.println("Conectado com sucesso.");
			} catch (SQLException e) {
				
				System.out.println("N�o pode conectar:" + e.getMessage());
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver n�o encontrado.");
			}
			
		return con;
			
			
		}

}
