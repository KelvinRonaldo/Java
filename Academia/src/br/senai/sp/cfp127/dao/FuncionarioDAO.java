package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.cfp127.dbutil.Conexao;
import br.senai.sp.cfp127.modelo.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		
		try {		
			//função em SQL
			String consulta = "INSERT INTO funcionario(nome, email, cidade, peso) "
					+ "VALUES (?, ?, ?, ?)";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getEmail());
			stm.setString(3, funcionario.getCidade());
			stm.setInt(4, funcionario.getPeso());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
			}else {
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso.");
			}
			
			} catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
			}
		
	}
	
public void atualizar() {
		
		try {		
			//função em SQL
			String consulta = "UPDATE funcionario"
					+ "SET nome = ?, email = ?, cidade = ?, peso = ?)"
					+ "WHERE ";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getEmail());
			stm.setString(3, funcionario.getCidade());
			stm.setInt(4, funcionario.getPeso());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
			}else {
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso.");
			}
			
			} catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
			}
		
	}
	
}
