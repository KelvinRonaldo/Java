package br.senai.sp.cfp127.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.clientes.Cliente;
import br.senai.sp.cfp127.dao.ClienteDAO;

import javax.swing.table.DefaultTableModel;

//↓↓ a classe FrmCLiente herda tudo a classe JFrame tem
public class FrmCliente extends JFrame {

	// vairáveis de referência dos componente do frame(janela)
	private JPanel painelTitulo, painelDados, painelResultado;
	// declarar várias variáveis do mesmo tipo
	private JLabel lblTitulo, lblIcone, lblNome, lblSexo, lblPeso, lblKg, lblAltura, lblCm, lblIdade, lblAnos,
			lblNivelAtiv;
	private JLabel lblSexoResult, lblImcResult, lblTmbResult, lblFcmResult;
	private JLabel lblSexoR, lblImcR, lblTmbR, lblFcmR;
	private JTextField txtNome, txtPeso, txtAltura, txtIdade;
	// criar objeto cor
	private Color cinza = new Color(200, 200, 200);
	private Color azulEscuro = new Color(7, 71, 102);
	private Color verde = new Color(93, 191, 100);
	// criar objeto fonte
	private Font arialBlack = new Font("Arial Black", 1, 40);
	private Font arial = new Font("Arial", 0, 20);
	private Font arial18 = new Font("Arial", 0, 18);
	private Font arialBold = new Font("Arial", 1, 20);
	private Font arialNarrow = new Font("Arial Narrow", 0, 18);
	private Font verdana20 = new Font("Verdana", 0, 20);
	private ImageIcon iconeTitulo, iconeCalcular;
	private TitledBorder bordaPainelDados, bordaPainelResultado;
	private JRadioButton radioM, radioF;
	private JComboBox comboAtividades;
	private JButton btnCalcular;
	private JPanel panel_2;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JPanel panel_4;
	private JLabel lblLogradouro;
	private JTextField textLogradouro;
	private JLabel lblBairro;
	private JTextField textBairro;
	private JLabel lblCidade;
	private JTextField textCidade;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JLabel label;

	public FrmCliente() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gymIcon128.png")));

		// título do frame
		setTitle("Cadastro de Cliente");
		// tamanho do frame
		setSize(845, 720);
		// não usar layout pré-definido
		getContentPane().setLayout(null);
		// finalizar processo da janela ao fecha-la
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// **IMAGENS DO FORMULÁRIO
		iconeTitulo = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym64.png"));
		iconeCalcular = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/calculator48.png"));
		// **LABELS DO PAINEL TÍTULO
		lblIcone = new JLabel(iconeTitulo);
		// setBounds = definir posição e tamanho do objeto
		lblIcone.setBounds(20, 0, 70, 100);
		/*
		 * OU lblIcone = new JLabel(); lblIcone.setBounds(20, 0, 70, 100);
		 * lblIcone.setIcon(iconeTitulo);
		 */

		lblTitulo = new JLabel("Academia Boa Forma");
		lblTitulo.setBounds(100, 0, 516, 100);
		lblTitulo.setFont(arialBlack);
		// setar cor da donte
		lblTitulo.setForeground(azulEscuro);

		// **PAINEL TÍTULO
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 1280, 100);
		painelTitulo.setLayout(null);

		painelTitulo.add(lblIcone);
		painelTitulo.add(lblTitulo);

		// SELECIONAR SEXO
		ButtonGroup grupoRadio = new ButtonGroup();

		// COMBO DE ATIVIDADES
		String atividades[] = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		bordaPainelDados = new TitledBorder("Dados do Cliente:");

		bordaPainelResultado = new TitledBorder("Resultados:");

		// colocar labels e panels no painel de conteúdo do frame
		getContentPane().add(painelTitulo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 111, 819, 569);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Lista de Clientes", null, panel, "Listagem de Clientes Cadastrados");
		panel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Lista de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(10, 25, 794, 358);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 774, 323);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "ID", "NOME", "E-MAIL" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(246);
		table.getColumnModel().getColumn(2).setPreferredWidth(193);
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 416, 794, 102);
		panel.add(panel_3);
		panel_3.setLayout(null);

		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/add64.png")));
		btnNewButton.setBounds(32, 11, 147, 80);
		panel_3.add(btnNewButton);

		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/save-x64.png")));
		btnSair.setBounds(615, 11, 169, 80);
		panel_3.add(btnSair);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Dados dos Clientes", null, panel_1, "Dados registrados dos Clientes cadastrados");
		panel_1.setLayout(null);
		// ** PAINEL DADOS
		painelDados = new JPanel();
		painelDados.setBounds(10, 0, 794, 215);
		panel_1.add(painelDados);
		painelDados.setLayout(null);
		painelDados.setBorder(
				new TitledBorder(null, "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		radioM = new JRadioButton("Masculino");
		radioM.setBounds(17, 150, 120, 20);
		painelDados.add(radioM);
		radioM.setFont(arial);
		grupoRadio.add(radioM);
		// FIM PAINEL TITULO

		// **ELEMENTOS DO PAINEL DE DADOS
		// NOME
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(25, 39, 75, 30);
		painelDados.add(lblNome);
		lblNome.setFont(arialBold);

		// SEXO
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(25, 121, 75, 30);
		painelDados.add(lblSexo);
		lblSexo.setFont(arialBold);
		radioF = new JRadioButton("Feminino");
		radioF.setBounds(17, 179, 120, 20);
		painelDados.add(radioF);
		radioF.setFont(arial);
		grupoRadio.add(radioF);

		// PESO
		lblPeso = new JLabel("Peso: ");
		lblPeso.setBounds(602, 39, 75, 30);
		painelDados.add(lblPeso);
		lblPeso.setFont(arialBold);
		// DIGITAR PESO
		txtPeso = new JTextField();
		txtPeso.setBounds(602, 70, 100, 30);
		painelDados.add(txtPeso);
		txtPeso.setFont(arial18);
		comboAtividades = new JComboBox(atividades);
		comboAtividades.setBounds(188, 157, 334, 35);
		painelDados.add(comboAtividades);
		comboAtividades.setFont(verdana20);
		// Quilos
		lblKg = new JLabel("Quilos(Kg)");
		lblKg.setBounds(702, 72, 72, 25);
		painelDados.add(lblKg);
		lblKg.setFont(arialNarrow);

		// ALTURA
		lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(602, 121, 75, 30);
		painelDados.add(lblAltura);
		lblAltura.setFont(arialBold);
		// DIGITAR ALTURA
		txtAltura = new JTextField();
		txtAltura.setBounds(602, 154, 100, 30);
		painelDados.add(txtAltura);
		txtAltura.setFont(arial18);

		// IDADE
		lblIdade = new JLabel("Data de Nascimento");
		lblIdade.setBounds(386, 39, 196, 30);
		painelDados.add(lblIdade);
		lblIdade.setFont(arialBold);
		// DIGITAR IDADE
		txtIdade = new JTextField();
		txtIdade.setBounds(386, 70, 100, 30);
		painelDados.add(txtIdade);
		txtIdade.setFont(arial18);
		// Centimetros
		lblCm = new JLabel("Cm");
		lblCm.setBounds(712, 156, 31, 25);
		painelDados.add(lblCm);
		lblCm.setFont(arialNarrow);
		// Anos
		lblAnos = new JLabel("Anos");
		lblAnos.setBounds(494, 72, 50, 25);
		painelDados.add(lblAnos);
		lblAnos.setFont(arialNarrow);

		// NÍVEL ATIVIDADE
		lblNivelAtiv = new JLabel("Nível de Atividade");
		lblNivelAtiv.setBounds(189, 121, 178, 30);
		painelDados.add(lblNivelAtiv);
		lblNivelAtiv.setFont(arialBold);
		// DIGITAR NOME
		txtNome = new JTextField();
		txtNome.setBounds(25, 70, 341, 30);
		painelDados.add(txtNome);
		txtNome.setFont(arial18);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Endere\u00E7o do Cliente", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_4.setBounds(10, 221, 603, 215);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogradouro.setBounds(26, 38, 124, 30);
		panel_4.add(lblLogradouro);

		textLogradouro = new JTextField();
		textLogradouro.setBounds(26, 73, 309, 30);
		panel_4.add(textLogradouro);
		textLogradouro.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 20));
		lblBairro.setBounds(363, 38, 75, 30);
		panel_4.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(363, 73, 218, 30);
		panel_4.add(textBairro);
		textBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 20));
		lblCidade.setBounds(26, 135, 75, 30);
		panel_4.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(26, 167, 171, 30);
		panel_4.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 20));
		lblTelefone.setBounds(218, 135, 103, 30);
		panel_4.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(218, 167, 117, 30);
		panel_4.add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(363, 135, 75, 30);
		panel_4.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(363, 167, 218, 30);
		panel_4.add(textEmail);
		textEmail.setColumns(10);

		// **PAINEL RESULTADOS
		painelResultado = new JPanel();
		painelResultado.setBounds(623, 221, 181, 215);
		panel_1.add(painelResultado);
		painelResultado.setLayout(null);
		painelResultado.setBorder(
				new TitledBorder(null, "Resultados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));

		// IMC
		lblImcResult = new JLabel("IMC: ", SwingConstants.LEFT);
		lblImcResult.setBounds(10, 43, 57, 30);
		painelResultado.add(lblImcResult);
		lblImcResult.setFont(arialBold);

		// TMB
		lblTmbResult = new JLabel("TMB: ", SwingConstants.LEFT);
		lblTmbResult.setBounds(10, 100, 57, 30);
		painelResultado.add(lblTmbResult);
		lblTmbResult.setFont(arialBold);

		// FCM
		lblFcmResult = new JLabel("FCM: ", SwingConstants.LEFT);
		lblFcmResult.setBounds(10, 157, 57, 30);
		painelResultado.add(lblFcmResult);
		lblFcmResult.setFont(arialBold);
		// RESULTADO TMB
		lblTmbR = new JLabel("...");
		lblTmbR.setBounds(69, 99, 102, 30);
		painelResultado.add(lblTmbR);
		lblTmbR.setFont(verdana20);
		lblTmbR.setForeground(new Color(0, 100, 0));
		// RESULTADO FCM
		lblFcmR = new JLabel("...");
		lblFcmR.setBounds(69, 156, 102, 30);
		painelResultado.add(lblFcmR);
		lblFcmR.setFont(verdana20);

		lblImcR = new JLabel("...");
		lblImcR.setForeground(new Color(0, 100, 0));
		lblImcR.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblImcR.setBounds(69, 42, 102, 30);
		painelResultado.add(lblImcR);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 438, 794, 92);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		btnExcluir = new JButton("");
		btnExcluir.setBounds(236, 5, 169, 80);
		panel_5.add(btnExcluir);
		btnExcluir.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/delete64.png")));

		btnEditar = new JButton("");
		btnEditar.setBounds(10, 5, 169, 80);
		panel_5.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/edit2-64.png")));

		// BOTÃO CALCULAR
		btnCalcular = new JButton("");
		btnCalcular.setBounds(657, 5, 127, 80);
		panel_5.add(btnCalcular);
		btnCalcular.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/disquete64.png")));
		btnCalcular.setFont(arial);
		// cor de fundo do painel de conteúdo
		// getLayeredPane().add(lblTitulo);

		// ***LISTENER DO BOTÃO
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				criarCliente("gravar");
				
			}
		});
		
		// fazer o frame aparecer
		setVisible(true);
	}
	
	private void criarCliente(String operacao) {
		
		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		cliente.setPeso(Double.parseDouble(txtPeso.getText()));
		cliente.setNivelAtividade(comboAtividades.getSelectedIndex());
		cliente.setAltura(Double.parseDouble(txtAltura.getText()));
		cliente.setIdade(Integer.parseInt(txtIdade.getText()));
		cliente.setLogradouro(textLogradouro.getText());
		cliente.setBairro(textBairro.getText());
		cliente.setCidade(textCidade.getText());
		cliente.setTelefone(textTelefone.getText());
		cliente.setEmail(textEmail.getText());
		
		ClienteDAO dao = new ClienteDAO(cliente);
		
		if(operacao.equals("gravar")) {
			dao.gravar();
			if (radioM.isSelected()) {
				cliente.setSexo('m');
			} else if (radioF.isSelected()) {
				cliente.setSexo('f');
			} else {
				JOptionPane.showMessageDialog(null, "Selecione o sexo do cliente(Masculino ou Feminino)!");
			}

			cliente.setNivelAtividade(comboAtividades.getSelectedIndex() + 1);

			lblImcR.setText(String.valueOf(cliente.getImc()));
			lblTmbR.setText(String.valueOf(cliente.getTmb()));
			lblFcmR.setText(String.valueOf(cliente.getFcm()));
			System.out.println(cliente.getImc());
			// lblPesoR.setText(cliente.getPeso()+ "Kg");
		}else {
			
		}
		
		
		
	}

}
