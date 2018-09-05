package br.senai.sp.cfp127.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FrmFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCidade;
	private JTextField txtPeso;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblCidade;
	private JLabel lblPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFuncionario frame = new FrmFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmFuncionario() {
		setTitle("Cadastro de Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(41, 56, 77, 24);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(121, 56, 63, 25);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(121, 104, 307, 25);
		contentPane.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(121, 159, 307, 25);
		contentPane.add(txtEmail);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(121, 212, 307, 25);
		contentPane.add(txtCidade);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(121, 269, 63, 25);
		contentPane.add(txtPeso);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(41, 104, 77, 25);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(41, 159, 77, 25);
		contentPane.add(lblEmail);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCidade.setBounds(41, 212, 77, 25);
		contentPane.add(lblCidade);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPeso.setBounds(41, 269, 77, 25);
		contentPane.add(lblPeso);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		
		btnConsultar.setBounds(194, 56, 141, 25);
		contentPane.add(btnConsultar);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.setBounds(41, 337, 104, 78);
		contentPane.add(btnNovo);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(186, 337, 104, 78);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(331, 337, 104, 78);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(476, 337, 104, 78);
		contentPane.add(btnSalvar);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//driver do access
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					//conexao até o banco
					Connection conexao = DriverManager.getConnection("jdbc:ucanaccess://Z:/POO/git/academia.accdb");
					//função em SQL
					String consulta = "SELECT * FROM funcionario WHERE codigo = ?";
					//statement - leva a função SQl ao banco de dados
					PreparedStatement stm = conexao.prepareStatement(consulta);
					//especificar ao statement que a primeira"?" na função SQL é o conteúdo da caixa de txt codigo
					stm.setInt(1, Integer.parseInt(txtCodigo.getText()));
					//o statement leva a função SQL ao banco de dados
					ResultSet rs = stm.executeQuery();
					
					if(rs.next()) {
						txtNome.setText(rs.getString("nome"));
						txtEmail.setText(rs.getString("email"));
						txtCidade.setText(rs.getString("cidade"));
						txtPeso.setText(String.valueOf(rs.getInt("peso")));
					}else {
						txtNome.setText("");
						txtEmail.setText("");
						txtCidade.setText("");
						txtPeso.setText("");
						JOptionPane.showMessageDialog(null, "Registro não encontrado");
					}
					
				} catch (Exception erro) {
					System.out.println(erro.getMessage());
				}
			}
		});
	}
}
