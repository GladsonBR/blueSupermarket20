package factory;

import java.sql.*;

public class Factory {
	public static Connection c;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			String URL = "jdbc:postgresql://ec2-54-161-255-125.compute-1.amazonaws.com:5432/d1ql725gv00ejn?sslmode=require";
			c = DriverManager.getConnection(URL,"lipbopbyczzyem","19cf26a0f644f6f827370a12fcf7301cf918bedc4f51b59b26a59208e091bda9");

		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("ERRO NO CONSTRUTOR DA CLASSE FACTORY!");
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		System.out.println("Fechando conexao com o banco de dados");
		try {
			this.c.close();
		}catch (SQLException e) {
			System.out.println("ERRO AO FECHAR CONEXAO COM BANCO DE DADOS (method closeConnection())");
			System.out.println(e.getMessage());
		}
		
	}
}
