package br.senai.sp.cfp127.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Connection conexao;
	
	public static Connection getConexao() {
		
		try {
			//driver do access
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//conexao até o banco de dados
			conexao = DriverManager.getConnection("jdbc:ucanaccess://Z:/POO/git2/Java/academia.accdb");
		}catch(Exception erro) {
			erro.printStackTrace();
		}
		return conexao;
	}
	
}
