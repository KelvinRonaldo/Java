package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.cfp127.clientes.Cliente;
import br.senai.sp.cfp127.dbutil.Conexao;


public class ClienteDAO {
	
	private Cliente cliente;
	
	public ClienteDAO(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ClienteDAO() {
		
	}

public Cliente getCliente(int id) {
		
		try {
			//função em SQL
			String consulta = "SELECT * FROM cliente WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que a primeira"?" na função SQL é o conteúdo da caixa de txt codigo
			stm.setInt(1, id);
			//o statement leva a função SQL ao banco de dados
			ResultSet rs = stm.executeQuery();
									// ↑ query é só no 'SELECT' 
			if(rs.next()) {
				
				cliente = new Cliente();
				this.cliente.setNome(rs.getString("nome"));                	
				this.cliente.setEmail(rs.getString("email"));
				this.cliente.setCidade(rs.getString("cidade"));
				this.cliente.setPeso(rs.getInt("peso"));
				this.cliente.setNivelAtividade(rs.getInt("nivelAtividade"));
				this.cliente.setAltura(rs.getInt("altura"));
				this.cliente.setLogradouro(rs.getString("logradouro"));
				this.cliente.setBairro(rs.getString("bairro"));
				this.cliente.setTelefone(rs.getString("telefone"));
				this.cliente.setSexo(rs.getString("sexo").charAt(0));
				this.cliente.setId(rs.getInt("codigo"));
			}else {
				JOptionPane.showMessageDialog(null, "Registro " + id + " não encontrado");
			}
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		return cliente;
	}
	
public ArrayList<Cliente> getCliente() {
	
	ArrayList<Cliente> clientes = new ArrayList<>();

	try {
		//função em SQL
		String consulta = "SELECT * FROM cliente ORDER BY nome";
		//statement - leva a função SQl ao banco de dados
		PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
		//especificar ao statement que a primeira"?" na função SQL é o conteúdo da caixa de txt codigo
		//o statement leva a função SQL ao banco de dados
		ResultSet rs = stm.executeQuery();
								// ↑ query é só no 'SELECT' 
			// ↓ resultado do select em SQL
		while(rs.next()) {
			cliente = new Cliente();
			this.cliente.setNome(rs.getString("nome"));                	
			this.cliente.setEmail(rs.getString("email"));
			this.cliente.setCidade(rs.getString("cidade"));
			this.cliente.setPeso(rs.getInt("peso"));
			this.cliente.setNivelAtividade(rs.getInt("nivelAtividade"));
			this.cliente.setAltura(rs.getInt("altura"));
			this.cliente.setLogradouro(rs.getString("logradouro"));
			this.cliente.setBairro(rs.getString("bairro"));
			this.cliente.setTelefone(rs.getString("telefone"));
			this.cliente.setSexo(rs.getString("sexo").charAt(0));
			this.cliente.setId(rs.getInt("codigo"));
			clientes.add(cliente);
		}
		
	} catch (Exception erro) {
		erro.printStackTrace();
	}
	
	return clientes;
}

	public void gravar() {
	
		try {		
			//função em SQL
			String consulta = "INSERT INTO cliente(nome, peso, altura, sexo, nivelAtividade, "
					+ "logradouro, bairro, cidade, telefone, email) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, cliente.getNome());
			stm.setDouble(2, cliente.getPeso());
			stm.setDouble(3, cliente.getAltura());
			stm.setString(4, String.valueOf(cliente.getSexo()));
			stm.setLong(5, cliente.getNivelAtividade());
			stm.setString(6, cliente.getLogradouro());
			stm.setString(7, cliente.getBairro());
			stm.setString(8, cliente.getCidade());
			stm.setString(9, cliente.getTelefone());
			stm.setString(10, cliente.getEmail());
			
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
			}else {
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
			}
			
		} catch (Exception erro) {
			erro.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
		}
	
	}
	
public void atualizar() {
		
		try {		
			//função em SQL
			String consulta = "UPDATE cliente "
					+ "SET nome = ?, peso = ?, altura = ?, sexo = ?,"
					+ " nivelAtividade = ?, logradouro = ?, bairro = ?,"
					+ " cidade = ?, telefone = ?, email = ?"
					+ "WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, cliente.getNome());
			stm.setDouble(2, cliente.getPeso());
			stm.setDouble(3, cliente.getAltura());
			stm.setString(4, String.valueOf(cliente.getSexo()));
			stm.setLong(5, cliente.getNivelAtividade());
			stm.setString(6, cliente.getLogradouro());
			stm.setString(7, cliente.getBairro());
			stm.setString(8, cliente.getCidade());
			stm.setString(9, cliente.getTelefone());
			stm.setString(10, cliente.getEmail());
			stm.setInt(11, cliente.getId());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
			}else {
				JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
			}
			
			} catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
			}
		
	}
	
	
public void excluir() {
		
		try {		
			//função em SQL
			String consulta = "DELETE FROM cliente WHERE codigo = ?";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setInt(1, cliente.getId());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão.");
			}else {
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
			}
		}	
		catch (Exception erro) {
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão.");
		}
	}
}
	

