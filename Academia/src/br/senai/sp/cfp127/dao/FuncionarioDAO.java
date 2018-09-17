package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import br.senai.sp.cfp127.dbutil.Conexao;
import br.senai.sp.cfp127.modelo.Funcionario;
import br.senai.sp.cfp127.view.FrmFuncionario;

public class FuncionarioDAO {
	
	//atributo
	private Funcionario funcionario;
	// construtor↓ que pede um parametro↓
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	//construtor vazio
	public FuncionarioDAO() {
		
	}
	
	public Funcionario getFuncionario(int codigo) {
		
		try {
			//função em SQL
			String consulta = "SELECT * FROM funcionario WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que a primeira"?" na função SQL é o conteúdo da caixa de txt codigo
			stm.setInt(1, codigo);
			//o statement leva a função SQL ao banco de dados
			ResultSet rs = stm.executeQuery();
									// ↑ query é só no 'SELECT' 
			if(rs.next()) {
				funcionario = new Funcionario();
				this.funcionario.setNome(rs.getString("nome"));                	
				this.funcionario.setEmail(rs.getString("email"));
				this.funcionario.setCidade(rs.getString("cidade"));
				this.funcionario.setPeso(rs.getInt("peso"));
				this.funcionario.setCodigo(rs.getInt("codigo"));
			}else {
				JOptionPane.showMessageDialog(null, "Registro " + codigo + " não encontrado");
			}
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		return funcionario;
	}
	
public ArrayList<Funcionario> getFuncionarios() {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
		try {
			//função em SQL
			String consulta = "SELECT * FROM funcionario ORDER BY nome";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que a primeira"?" na função SQL é o conteúdo da caixa de txt codigo
			//o statement leva a função SQL ao banco de dados
			ResultSet rs = stm.executeQuery();
									// ↑ query é só no 'SELECT' 
				// ↓ resultado do select em SQL
			while(rs.next()) {
				funcionario = new Funcionario();
				this.funcionario.setNome(rs.getString("nome"));                	
				this.funcionario.setEmail(rs.getString("email"));
				this.funcionario.setCidade(rs.getString("cidade"));
				this.funcionario.setPeso(rs.getInt("peso"));
				this.funcionario.setCodigo(rs.getInt("codigo"));
				funcionarios.add(funcionario);
			}
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		return funcionarios;
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
			String consulta = "UPDATE funcionario "
					+ "SET nome = ?, email = ?, cidade = ?, peso = ? "
					+ "WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, funcionario.getNome());
						//    objeto↑ onde on nome, email, cidade etc estão
			stm.setString(2, funcionario.getEmail());
			stm.setString(3, funcionario.getCidade());
			stm.setInt(4, funcionario.getPeso());
			stm.setInt(5, funcionario.getCodigo());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
			}else {
				JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso.");
			}
			
			} catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
			}
		
	}
	
	public void excluir() {
		
		try {		
			//função em SQL
			String consulta = "DELETE FROM funcionario WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setInt(1, funcionario.getCodigo());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão.");
			}else {
				JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso.");
			}
		}	
		catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão.");
		}
	}
	
	
	
}
	

