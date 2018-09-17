package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.senai.sp.cfp127.clientes.Cliente;
import br.senai.sp.cfp127.dbutil.Conexao;

public class ClienteDAO {
	
	private Cliente cliente;
	
	public ClienteDAO(Cliente cliente) {
		this.cliente = cliente;
	}


	public void gravar() {
	
		try {		
			//função em SQL
			String consulta = "INSERT INTO cliente(nome, peso, altura, nivelAtividade, "
					+ "logradouro, bairro, cidade, telefone, email) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//statement - leva a função SQl ao banco de dados
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			//especificar ao statement que qual "?"  na função SQL é o conteúdo de cada campo
			stm.setString(1, cliente.getNome());
			stm.setDouble(2, cliente.getPeso());
			stm.setDouble(3, cliente.getAltura());
			stm.setLong(4, cliente.getNivelAtividade());
			stm.setString(5, cliente.getLogradouro());
			stm.setString(6, cliente.getBairro());
			stm.setString(7, cliente.getCidade());
			stm.setString(8, cliente.getTelefone());
			stm.setString(9, cliente.getEmail());
			
			
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
