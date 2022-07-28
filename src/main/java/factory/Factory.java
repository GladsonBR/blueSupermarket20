package factory;

import java.sql.*;

public class Factory {
	public static Connection c;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			String URL = "jdbc:postgresql://ec2-44-206-89-185.compute-1.amazonaws.com:5432/d1gmpl6spdejue?sslmode=require";
			c = DriverManager.getConnection(URL,"wwduvzviucxmjo","cb1a4199debb4c9013ceb76656b721e713b32123466d24edf8d69a2bc80abb2");

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
