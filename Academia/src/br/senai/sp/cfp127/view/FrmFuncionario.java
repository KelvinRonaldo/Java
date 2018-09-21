package br.senai.sp.cfp127.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.cfp127.dao.FuncionarioDAO;
import br.senai.sp.cfp127.dbutil.Conexao;
import br.senai.sp.cfp127.modelo.Funcionario;

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
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JPanel panelTabela;
	private JTable tableFuncionario;

	public FrmFuncionario() {
		setResizable(false);
		setTitle("Cadastro de Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// vetor↓
		String colunas[] = { "Código", "Nome do Funcionário" }; // CABEÇALHO DAS COLUNAS

		FuncionarioDAO dao = new FuncionarioDAO();
		int linhas = dao.getFuncionarios().size();
		// matriz↓ = vetor de vetores
		String dados[][] = new String[linhas][2];

		for (int i = 0; i < linhas; i++) {
			dados[i][0] = String.valueOf(dao.getFuncionarios().get(i).getCodigo());
			dados[i][1] = dao.getFuncionarios().get(i).getNome();
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 585, 429);
		contentPane.add(tabbedPane);

		panelTabela = new JPanel();
		tabbedPane.addTab("Lista de Funcionários", null, panelTabela, null);
		panelTabela.setBorder(new TitledBorder(null, "Tabela de Funcion\u00E1rios", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panelTabela.add(scrollPane);

		tableFuncionario = new JTable(dados, colunas);
		tableFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tableFuncionario.getSelectedRow();
				String codigo = tableFuncionario.getValueAt(linha, 0).toString();
				txtCodigo.setText(codigo);
				criarFuncionario("consultar");
				tabbedPane.setSelectedIndex(1);

			}
		});

		scrollPane.setViewportView(tableFuncionario);

		JPanel panelDetalhes = new JPanel();
		tabbedPane.addTab("Dados do Funcionário", null, panelDetalhes, null);
		panelDetalhes.setBorder(
				new TitledBorder(null, "Dados do Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetalhes.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(28, 31, 77, 24);
		panelDetalhes.add(lblCodigo);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));

		txtCodigo = new JTextField();
		txtCodigo.setBounds(108, 28, 63, 30);
		panelDetalhes.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(181, 27, 141, 33);
		panelDetalhes.add(btnConsultar);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(28, 79, 77, 25);
		panelDetalhes.add(lblNome);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));

		txtNome = new JTextField();
		txtNome.setBounds(108, 76, 307, 30);
		panelDetalhes.add(txtNome);
		txtNome.setColumns(10);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(28, 134, 77, 25);
		panelDetalhes.add(lblEmail);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));

		txtEmail = new JTextField();
		txtEmail.setBounds(108, 131, 307, 30);
		panelDetalhes.add(txtEmail);
		txtEmail.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(28, 187, 77, 25);
		panelDetalhes.add(lblCidade);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 20));

		txtCidade = new JTextField();
		txtCidade.setBounds(108, 184, 307, 30);
		panelDetalhes.add(txtCidade);
		txtCidade.setColumns(10);

		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(28, 239, 77, 25);
		panelDetalhes.add(lblPeso);
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 20));

		txtPeso = new JTextField();
		txtPeso.setBounds(108, 236, 63, 30);
		panelDetalhes.add(txtPeso);
		txtPeso.setColumns(10);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setBounds(28, 297, 104, 78);
		panelDetalhes.add(btnNovo);

		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(165, 297, 104, 78);
		panelDetalhes.add(btnAtualizar);
		btnAtualizar.setEnabled(false);

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(302, 297, 104, 78);
		panelDetalhes.add(btnExcluir);
		btnExcluir.setEnabled(false);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(439, 297, 104, 78);
		panelDetalhes.add(btnSalvar);
		btnSalvar.setEnabled(false);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				criarFuncionario("gravar");
				limparCampos();
				txtCodigo.setEnabled(true);
				btnConsultar.setEnabled(true);
				btnNovo.setText("NOVO");
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resposta = JOptionPane.showConfirmDialog(null, "Confirmar Exclusão de \n" + txtNome.getText() + "?",
						"Exclui Funcionário", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					criarFuncionario("excluir");
					limparCampos();
					txtCodigo.requestFocus();
				} else {

				}
			}
		});

		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				criarFuncionario("atualizar");
				limparCampos();

			}
		});

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btnNovo.getText().equals("NOVO")) { // ←←←←←←
					// esse botão ↓ ficar ativado(true)/destivado(false) quando o botão↑ em questão
					// for clicado
					btnSalvar.setEnabled(true);
					btnConsultar.setEnabled(false);
					btnAtualizar.setEnabled(false);
					btnExcluir.setEnabled(false);
					txtCodigo.setEnabled(false);
					txtNome.requestFocus();
					btnNovo.setText("CANCELAR");
					limparCampos();
				} else {
					btnSalvar.setEnabled(false);
					btnConsultar.setEnabled(true);
					btnAtualizar.setEnabled(false);
					btnExcluir.setEnabled(false);
					txtCodigo.setEnabled(true);
					txtNome.requestFocus();
					btnNovo.setText("NOVO");
					txtCodigo.requestFocus();
					limparCampos();
				}

			}
		});

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btnConsultar.getText().equals("CONSULTAR")) {
					criarFuncionario("consultar");
					btnExcluir.setEnabled(true);
					btnAtualizar.setEnabled(true);
					btnSalvar.setEnabled(false);
				} else {

				}
			}
		});
	}

	private void criarFuncionario(String operacao) {

		Funcionario funcionario = new Funcionario();
		funcionario.setCidade(txtCidade.getText());
		funcionario.setNome(txtNome.getText());
		funcionario.setEmail(txtEmail.getText());
		// no ↓objeto ↓definir que peso

		// ↑ é o
		FuncionarioDAO dao = new FuncionarioDAO(funcionario);

		if (operacao.equals("gravar")) {
			dao.gravar();
		} else if (operacao.equals("atualizar")) {
			funcionario.setPeso(Integer.parseInt(txtPeso.getText()));
			funcionario.setCodigo(Integer.parseInt(txtCodigo.getText()));
			dao.atualizar();
		} else if (operacao.equals("excluir")) {
			funcionario.setPeso(Integer.parseInt(txtPeso.getText()));
			funcionario.setCodigo(Integer.parseInt(txtCodigo.getText()));
			dao.excluir();
		} else if (operacao.equals("consultar")) {
			funcionario = dao.getFuncionario(Integer.parseInt(txtCodigo.getText()));
			txtCodigo.setText(String.valueOf(funcionario.getCodigo()));
			txtNome.setText(String.valueOf(funcionario.getNome()));
			txtEmail.setText(String.valueOf(funcionario.getEmail()));
			txtCidade.setText(String.valueOf(funcionario.getCidade()));
			txtPeso.setText(String.valueOf(funcionario.getPeso()));
		}

	}

	private void limparCampos() {
		txtNome.setText("");
		txtEmail.setText("");
		txtCidade.setText("");
		txtPeso.setText("");
		txtCodigo.setText("");
	}
}
