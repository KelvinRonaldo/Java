package br.senai.sp.cfp127.view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.clientes.Cliente;
import br.senai.sp.cfp127.dao.ClienteDAO;
import br.senai.sp.cfp127.utils.Data;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//↓↓ a classe FrmCLiente herda tudo a classe JFrame tem
public class FrmCliente extends JFrame {

	// vairáveis de referência dos componente do frame(janela)
	private JPanel painelTitulo, painelDados, painelResultado;
	// declarar várias variáveis do mesmo tipo
	private JLabel lblTitulo, lblIcone, lblNome, lblSexo, lblPeso, lblKg, lblAltura, lblCm, lblDataNascimento,
			lblNivelAtiv;
	private JLabel lblSexoResult, lblImcResult, lblTmbResult, lblFcmResult, lblIdade, lblId;
	private JLabel lblSexoR, lblImcR, lblTmbR, lblFcmR;
	private JTextField txtNome, txtPeso, txtAltura, txtDataNascimento;
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
	private JButton btnNovoLista;
	private JButton btnExcluirLista;
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
	private JTable tableDadosCliente;
	private JButton btnNovoDados;
	private JScrollPane scrollPane;
	private int atualizar = 0, clickNovo = 0, clickEdit = 0;

	public boolean isCellEditable(int linhas, String[] colunas) {
		return false;
	}

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

		lblTitulo = new JLabel("Academia PokéForma");
		lblTitulo.setBounds(100, 0, 525, 100);
		lblTitulo.setFont(arialBlack);
		// setar cor da donte
		lblTitulo.setForeground(azulEscuro);

		// **PAINEL TÍTULO
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 839, 100);
		painelTitulo.setLayout(null);

		painelTitulo.add(lblIcone);
		painelTitulo.add(lblTitulo);

		// SELECIONAR SEXO
		ButtonGroup grupoRadio = new ButtonGroup();

		// COMBO DE ATIVIDADES
		String atividades[] = { "Selecionar:", "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		bordaPainelDados = new TitledBorder("Dados do Cliente:");

		bordaPainelResultado = new TitledBorder("Resultados:");

		// colocar labels e panels no painel de conteúdo do frame
		getContentPane().add(painelTitulo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 111, 819, 569);
		getContentPane().add(tabbedPane);

		JPanel panelLista = new JPanel();
		tabbedPane.addTab("Lista de Clientes", null, panelLista, "Listagem de Clientes Cadastrados");
		panelLista.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Lista de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(10, 25, 794, 358);
		panelLista.add(panel_2);
		panel_2.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 774, 323);
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 428, 794, 102);
		panelLista.add(panel_3);
		panel_3.setLayout(null);

		btnNovoLista = new JButton("");
		btnNovoLista.setToolTipText("Cadastrar um novo cliente");

		btnNovoLista.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/add64.png")));
		btnNovoLista.setBounds(10, 11, 146, 80);
		panel_3.add(btnNovoLista);

		btnSair = new JButton("");
		btnSair.setToolTipText("Fechar Aplicação");

		btnSair.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/save-x64.png")));
		btnSair.setBounds(615, 11, 169, 80);
		panel_3.add(btnSair);

		btnExcluirLista = new JButton("");
		btnExcluirLista.setToolTipText("Exlcuir dados do cliente selecionado");

		btnExcluirLista.setBounds(323, 11, 146, 80);
		panel_3.add(btnExcluirLista);
		btnExcluirLista
				.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/delete64.png")));

		JButton btnVisualizar = new JButton("");
		
		btnVisualizar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/view64.png")));
		btnVisualizar.setToolTipText("Cadastrar um novo cliente");
		btnVisualizar.setBounds(167, 11, 146, 80);
		panel_3.add(btnVisualizar);

		JPanel panelDados = new JPanel();
		tabbedPane.addTab("Dados do Cliente", null, panelDados, null);
		panelDados.setLayout(null);
		// ** PAINEL DADOS
		painelDados = new JPanel();
		painelDados.setBounds(10, 4, 794, 215);
		panelDados.add(painelDados);
		painelDados.setLayout(null);
		painelDados.setBorder(
				new TitledBorder(null, "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		radioM = new JRadioButton("Masculino");
		radioM.setEnabled(false);
		radioM.setToolTipText("Selecione o Sexo do Cliente");
		radioM.setBounds(17, 150, 120, 20);
		painelDados.add(radioM);
		radioM.setFont(arial);
		grupoRadio.add(radioM);
		// FIM PAINEL TITULO

		// **ELEMENTOS DO PAINEL DE DADOS
		// NOME
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(65, 39, 84, 30);
		painelDados.add(lblNome);
		lblNome.setFont(arialBold);

		// SEXO
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(25, 121, 75, 30);
		painelDados.add(lblSexo);
		lblSexo.setFont(arialBold);
		radioF = new JRadioButton("Feminino");
		radioF.setEnabled(false);
		radioF.setToolTipText("Selecione o Sexo do Cliente");
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
		txtPeso.setEditable(false);
		txtPeso.setToolTipText("Digite o Peso em quilos do Cliente");
		txtPeso.setBounds(602, 70, 100, 30);
		painelDados.add(txtPeso);
		txtPeso.setFont(arial18);
		comboAtividades = new JComboBox(atividades);
		comboAtividades.setEnabled(false);
		comboAtividades.setToolTipText("Selecione oNivel de Atividadedo Cliente");
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
		txtAltura.setEditable(false);
		txtAltura.setToolTipText("Digite a Altura do cliente em centímetros");
		txtAltura.setBounds(602, 154, 100, 30);
		painelDados.add(txtAltura);
		txtAltura.setFont(arial18);

		// IDADE
		lblDataNascimento = new JLabel("Data de Nasc.:");
		lblDataNascimento.setBounds(360, 39, 142, 30);
		painelDados.add(lblDataNascimento);
		lblDataNascimento.setFont(arialBold);
		// DIGITAR IDADE
		txtDataNascimento = new JTextField();
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setToolTipText("Digite a Data de Nascimento do Cliente(ex: 21-09-2018)");
		txtDataNascimento.setBounds(360, 70, 142, 30);
		painelDados.add(txtDataNascimento);
		txtDataNascimento.setFont(arial18);
		// Centimetros
		lblCm = new JLabel("Cm");
		lblCm.setBounds(712, 156, 31, 25);
		painelDados.add(lblCm);
		lblCm.setFont(arialNarrow);

		// NÍVEL ATIVIDADE
		lblNivelAtiv = new JLabel("Nível de Atividade");
		lblNivelAtiv.setBounds(189, 121, 178, 30);
		painelDados.add(lblNivelAtiv);
		lblNivelAtiv.setFont(arialBold);
		// DIGITAR NOME
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setToolTipText("Digite o Nome do Cliente");
		txtNome.setBounds(65, 70, 285, 30);
		painelDados.add(txtNome);
		txtNome.setFont(arial18);

		lblId = new JLabel();
		lblId.setToolTipText("ID do cliente");
		lblId.setFont(new Font("Arial", Font.PLAIN, 22));
		lblId.setBounds(17, 70, 38, 30);
		painelDados.add(lblId);

		lblIdade = new JLabel("");
		lblIdade.setToolTipText("Idade do cliente");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 18));
		lblIdade.setBounds(508, 70, 72, 30);
		painelDados.add(lblIdade);

		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblId_1.setBounds(17, 39, 31, 30);
		painelDados.add(lblId_1);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Endere\u00E7o do Cliente", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		panel_4.setBounds(10, 230, 603, 189);
		panelDados.add(panel_4);
		panel_4.setLayout(null);

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogradouro.setBounds(26, 38, 124, 30);
		panel_4.add(lblLogradouro);

		textLogradouro = new JTextField();
		textLogradouro.setEditable(false);
		textLogradouro.setToolTipText("Digite o Logradouro do Cliente(ex: Rua, Avenida, Estrada...)");
		textLogradouro.setBounds(26, 73, 309, 30);
		panel_4.add(textLogradouro);
		textLogradouro.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 20));
		lblBairro.setBounds(363, 38, 75, 30);
		panel_4.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setToolTipText("Digite o Bairro do Cliente");
		textBairro.setBounds(363, 73, 218, 30);
		panel_4.add(textBairro);
		textBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 20));
		lblCidade.setBounds(26, 114, 75, 30);
		panel_4.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setToolTipText("Digite a Cidade do Cliente");
		textCidade.setBounds(26, 146, 171, 30);
		panel_4.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 20));
		lblTelefone.setBounds(218, 114, 103, 30);
		panel_4.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setEditable(false);
		textTelefone.setToolTipText("Digite o Telefone do Cliente(ex:(11) 9658-7423");
		textTelefone.setBounds(218, 146, 117, 30);
		panel_4.add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(363, 114, 75, 30);
		panel_4.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setToolTipText("Digite o Email do Cliente(ex: exemplo@exemplo.com");
		textEmail.setBounds(363, 146, 218, 30);
		panel_4.add(textEmail);
		textEmail.setColumns(10);

		// **PAINEL RESULTADOS
		painelResultado = new JPanel();
		painelResultado.setBounds(623, 221, 181, 198);
		panelDados.add(painelResultado);
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
		lblTmbR = new JLabel("");
		lblTmbR.setToolTipText("TMB calculado");
		lblTmbR.setBounds(69, 99, 102, 30);
		painelResultado.add(lblTmbR);
		lblTmbR.setFont(verdana20);
		lblTmbR.setForeground(new Color(0, 100, 0));
		// RESULTADO FCM
		lblFcmR = new JLabel("");
		lblFcmR.setToolTipText("FCM calculado");
		lblFcmR.setBounds(69, 156, 102, 30);
		painelResultado.add(lblFcmR);
		lblFcmR.setFont(verdana20);

		lblImcR = new JLabel("");
		lblImcR.setToolTipText("IMC calculado");
		lblImcR.setForeground(new Color(0, 100, 0));
		lblImcR.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblImcR.setBounds(69, 42, 102, 30);
		painelResultado.add(lblImcR);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 428, 794, 102);
		panelDados.add(panel_5);
		panel_5.setLayout(null);

		// BOTÃO CALCULAR
		btnCalcular = new JButton("");
		btnCalcular.setEnabled(false);
		btnCalcular.setToolTipText("Salvar/Atualizar");
		btnCalcular.setBounds(657, 11, 127, 80);
		panel_5.add(btnCalcular);
		btnCalcular.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/disquete64.png")));
		btnCalcular.setFont(arial);

		JButton btnExcluirDados = new JButton("");
		btnExcluirDados.setEnabled(false);
		btnExcluirDados.setToolTipText("Exlcuir dados do cliente selecionado");

		btnExcluirDados
				.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/delete64.png")));
		btnExcluirDados.setBounds(167, 11, 146, 80);
		panel_5.add(btnExcluirDados);

		btnNovoDados = new JButton("");
		btnNovoDados.setToolTipText("Cadastrar um novo cliente");

		btnNovoDados.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/add64.png")));
		btnNovoDados.setBounds(10, 11, 146, 80);
		panel_5.add(btnNovoDados);

		JButton btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(323, 11, 146, 80);
		panel_5.add(btnEditar);
		btnEditar.setToolTipText("Editar dados do cliente selecionado");
		btnEditar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/edit2-64.png")));

		String[] colunas = { "ID", "Nome", "Telefone", "Email" };

		ClienteDAO dao = new ClienteDAO();

		int linhas = dao.getCliente().size();
		String dados[][] = new String[linhas][4];

		for (int i = 0; i < linhas; i++) {
			dados[i][0] = String.valueOf(dao.getCliente().get(i).getId());
			dados[i][1] = dao.getCliente().get(i).getNome();
			dados[i][2] = dao.getCliente().get(i).getTelefone();
			dados[i][3] = dao.getCliente().get(i).getEmail();
		}

		tableDadosCliente = new JTable(dados, colunas);
		tableDadosCliente.setDefaultEditor(Object.class, null);
		tableDadosCliente.setToolTipText("Selecionar Cliente para Editar/Excluir");
		tableDadosCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					atualizar = 1;
					clickNovo = 0;
					int linha = tableDadosCliente.getSelectedRow();
					String codigo = tableDadosCliente.getValueAt(linha, 0).toString();
					lblId.setText(codigo);
					btnEditar.setEnabled(true);
					btnExcluirDados.setEnabled(true);
					btnCalcular.setEnabled(true);
					criarCliente("consultar");
					habiDesabilCampos("desabilitar");
					tabbedPane.setSelectedIndex(1);
				}
			}
		});

		scrollPane.setViewportView(tableDadosCliente);
		
		// ***LISTENER DO BOTÃO
		btnNovoLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar = 0;
				limparCampos();
				btnNovoLista.setEnabled(false);
				btnVisualizar.setEnabled(false);
				btnExcluirDados.setEnabled(false);
				btnExcluirLista.setEnabled(false);
				btnEditar.setEnabled(false);
				btnCalcular.setEnabled(true);
				tableDadosCliente.setEnabled(false);
				btnNovoDados.setIcon(
						new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/cancelar40.png")));
				grupoRadio.clearSelection();
				tabbedPane.setSelectedIndex(1);
				habiDesabilCampos("habilitar");
				txtNome.requestFocus();
				clickNovo = 1;
			}
		});
		
		btnNovoDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar = 0;
				if (clickNovo == 0) {
					limparCampos();
					btnNovoLista.setEnabled(false);
					btnVisualizar.setEnabled(false);
					btnExcluirDados.setEnabled(false);
					btnExcluirLista.setEnabled(false);
					btnEditar.setEnabled(false);
					btnCalcular.setEnabled(true);
					tableDadosCliente.setEnabled(false);
					btnNovoDados.setIcon(
							new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/cancelar40.png")));
					grupoRadio.clearSelection();
					habiDesabilCampos("habilitar");
					txtNome.requestFocus();
					clickNovo = 1;
				} else if (clickNovo == 1) {
					limparCampos();
					btnExcluirDados.setEnabled(false);
					btnEditar.setEnabled(false);
					btnExcluirLista.setEnabled(true);
					btnNovoDados.setEnabled(true);
					btnNovoLista.setEnabled(true);
					btnVisualizar.setEnabled(true);
					btnCalcular.setEnabled(false);
					tableDadosCliente.setEnabled(true);
					btnNovoDados.setIcon(
							new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/add64.png")));
					grupoRadio.clearSelection();
					habiDesabilCampos("desabilitar");
					tabbedPane.setSelectedIndex(0);
					clickNovo = 0;
				} else {

				}
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(clickEdit == 0) {
					btnNovoLista.setEnabled(false);
					btnNovoDados.setEnabled(false);
					btnVisualizar.setEnabled(false);
					btnExcluirDados.setEnabled(false);
					btnExcluirLista.setEnabled(false);
					tableDadosCliente.setEnabled(false);
					habiDesabilCampos("habilitar");
					btnEditar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/cancelar40.png")));
					clickEdit = 1;
				}else if(clickEdit == 1) {
					btnNovoLista.setEnabled(true);
					btnNovoDados.setEnabled(true);
					btnVisualizar.setEnabled(true);
					btnExcluirLista.setEnabled(true);
					btnExcluirDados.setEnabled(false);
					btnEditar.setEnabled(false);
					btnCalcular.setEnabled(false);
					tableDadosCliente.setEnabled(true);
					habiDesabilCampos("desabilitar");
					limparCampos();
					tabbedPane.setSelectedIndex(0);
					btnEditar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/edit2-64.png")));
					clickEdit = 0;
				}
			}
		});

		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar = 1;
				clickNovo = 0;
				int linha = tableDadosCliente.getSelectedRow();
				String codigo = tableDadosCliente.getValueAt(linha, 0).toString();
				lblId.setText(codigo);
				criarCliente("consultar");
				habiDesabilCampos("desabilitar");
				btnEditar.setEnabled(true);
				btnExcluirDados.setEnabled(true);
				btnVisualizar.setEnabled(true);
				btnCalcular.setEnabled(true);
				btnExcluirLista.setEnabled(true);
				btnNovoDados.setEnabled(true);
				btnNovoLista.setEnabled(true);
				btnSair.setEnabled(true);
				tabbedPane.setSelectedIndex(1);
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atualizar == 0) {
					criarCliente("gravar");
				} else if (atualizar == 1) {
					criarCliente("atualizar");
				}
				btnNovoDados.setIcon(
						new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/add64.png")));
				btnEditar.setIcon(
						new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/edit2-64.png")));
				habiDesabilCampos("desabilitar");
				atualizarTabela();
				limparCampos();
				btnCalcular.setEnabled(false);
				btnVisualizar.setEnabled(true);
				btnNovoLista.setEnabled(true);
				btnNovoDados.setEnabled(true);
				btnExcluirLista.setEnabled(true);
				btnExcluirDados.setEnabled(false);
				btnEditar.setEnabled(false);
				grupoRadio.clearSelection();
				tabbedPane.setSelectedIndex(0);
				atualizar = 0; clickNovo = 0; clickEdit = 0;
			}
		});

		

		btnExcluirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickNovo = 0;
				int resposta = JOptionPane.showConfirmDialog(null, "Confirmar Exclusão de \n" + txtNome.getText() + "?",
						"Exclui Cliente", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					criarCliente("excluir");
					limparCampos();
					habiDesabilCampos("desabilitar");
					btnExcluirDados.setEnabled(false);
					btnCalcular.setEnabled(false);
					btnEditar.setEnabled(false);
					tabbedPane.setSelectedIndex(0);
					atualizarTabela();
				} else {

				}
			}
		});

		btnExcluirLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickNovo = 0;
				int resposta = JOptionPane.showConfirmDialog(
						null, "Confirmar Exclusão de \n"
								+ tableDadosCliente.getValueAt(tableDadosCliente.getSelectedRow(), 1) + "?",
						"Exclui Cliente", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					int linha = tableDadosCliente.getSelectedRow();
					String codigo = tableDadosCliente.getValueAt(linha, 0).toString();
					lblId.setText(codigo);
					criarCliente("excluir");
					limparCampos();
					habiDesabilCampos("desabilitar");
					btnExcluirDados.setEnabled(false);
					btnCalcular.setEnabled(false);
					btnEditar.setEnabled(false);
					atualizarTabela();
				} else {

				}

			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// fazer o frame aparecer
		setVisible(true);
	}

	private void criarCliente(String operacao) {

		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		cliente.setLogradouro(textLogradouro.getText());
		cliente.setBairro(textBairro.getText());
		cliente.setCidade(textCidade.getText());
		cliente.setTelefone(textTelefone.getText());
		cliente.setEmail(textEmail.getText());

		ClienteDAO dao = new ClienteDAO(cliente);

		if (operacao.equals("gravar")) {
			cliente.setPeso(Double.parseDouble(txtPeso.getText()));
			cliente.setNivelAtividade(comboAtividades.getSelectedIndex());
			cliente.setAltura(Double.parseDouble(txtAltura.getText()));
			cliente.setDtNascimento(txtDataNascimento.getText());

			if (radioM.isSelected()) {
				cliente.setSexo('m');
			} else if (radioF.isSelected()) {
				cliente.setSexo('f');
			} else {
				JOptionPane.showMessageDialog(null, "Selecione o sexo do cliente(Masculino ou Feminino)!");
			}

			cliente.setNivelAtividade(comboAtividades.getSelectedIndex());
			dao.gravar();

		} else if (operacao.equals("consultar")) {
			cliente = dao.getCliente(Integer.parseInt(lblId.getText()));
			lblId.setText(String.valueOf(cliente.getId()));
			lblIdade.setText(String.valueOf(cliente.getIdade() + " anos"));
			txtNome.setText(cliente.getNome());
			txtPeso.setText(String.valueOf(cliente.getPeso()));
			comboAtividades.setSelectedIndex(cliente.getNivelAtividade());
			txtAltura.setText(String.valueOf(cliente.getAltura()));
			textLogradouro.setText(cliente.getLogradouro());
			textBairro.setText(cliente.getBairro());
			textTelefone.setText(cliente.getTelefone());
			textEmail.setText(cliente.getEmail());
			textCidade.setText(cliente.getCidade());
			txtDataNascimento.setText(cliente.getDtNascimento());
			lblImcR.setText(String.valueOf(cliente.getImc()));
			lblFcmR.setText(String.valueOf(cliente.getFcm()));
			lblTmbR.setText(String.valueOf(cliente.getTmb()));

			if (String.valueOf(cliente.getSexo()).equals("m")) {
				radioM.setSelected(true);
			} else if (String.valueOf(cliente.getSexo()).equals("f")) {
				radioF.setSelected(true);
			}

		} else if (operacao.equals("excluir")) {
			cliente.setId(Integer.parseInt(lblId.getText()));
			dao.excluir();
		} else if (operacao.equals("atualizar")) {
			cliente.setPeso(Double.parseDouble(txtPeso.getText()));
			cliente.setNivelAtividade(comboAtividades.getSelectedIndex());
			cliente.setAltura(Double.parseDouble(txtAltura.getText()));
			cliente.setDtNascimento(txtDataNascimento.getText());
			cliente.setId(Integer.parseInt(lblId.getText()));
			if (radioM.isSelected()) {
				cliente.setSexo('m');
			} else if (radioF.isSelected()) {
				cliente.setSexo('f');
			} else {

			}
			dao.atualizar();
		} else {

		}
	}

	private void atualizarTabela() {
		String[] colunas = { "ID", "Nome", "Telefone", "Email" };

		ClienteDAO dao = new ClienteDAO();

		int linhas = dao.getCliente().size();
		String dados[][] = new String[linhas][4];

		for (int i = 0; i < linhas; i++) {
			dados[i][0] = String.valueOf(dao.getCliente().get(i).getId());
			dados[i][1] = dao.getCliente().get(i).getNome();
			dados[i][2] = dao.getCliente().get(i).getTelefone();
			dados[i][3] = dao.getCliente().get(i).getEmail();
		}

		tableDadosCliente = new JTable(dados, colunas);
		tableDadosCliente.setDefaultEditor(Object.class, null);
		tableDadosCliente.setToolTipText("Selecionar Cliente para Editar/Excluir");
		tableDadosCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {

					atualizar = 1;
					// isCellEditable(linhas, colunas);
					int linha = tableDadosCliente.getSelectedRow();
					String codigo = tableDadosCliente.getValueAt(linha, 0).toString();
					lblId.setText(codigo);
					criarCliente("consultar");
					atualizar = 1;
					clickNovo = 0;
					txtNome.setEditable(false);
					txtPeso.setEditable(false);
					txtAltura.setEditable(true);
					comboAtividades.setEnabled(false);
					txtAltura.setEditable(false);
					textLogradouro.setEditable(false);
					textBairro.setEditable(false);
					textTelefone.setEditable(false);
					textEmail.setEditable(false);
					textCidade.setEditable(false);
					txtDataNascimento.setEditable(false);
					radioM.setEnabled(false);
					radioF.setEnabled(false);
				}
			}
		});

		scrollPane.setViewportView(tableDadosCliente);
	}

	private void habiDesabilCampos(String se) {
		if (se.equals("desabilitar")) {
			txtNome.setEditable(false);
			txtPeso.setEditable(false);
			comboAtividades.setEnabled(false);
			txtAltura.setEditable(false);
			txtDataNascimento.setEditable(false);
			textLogradouro.setEditable(false);
			textBairro.setEditable(false);
			textTelefone.setEditable(false);
			textEmail.setEditable(false);
			textCidade.setEditable(false);
			txtDataNascimento.setEditable(false);
			radioM.setEnabled(false);
			radioF.setEnabled(false);
		} else if (se.equals("habilitar")) {
			txtNome.setEditable(true);
			txtPeso.setEditable(true);
			comboAtividades.setEnabled(true);
			txtAltura.setEditable(true);
			txtDataNascimento.setEditable(true);
			textLogradouro.setEditable(true);
			textBairro.setEditable(true);
			textTelefone.setEditable(true);
			textEmail.setEditable(true);
			textCidade.setEditable(true);
			txtDataNascimento.setEditable(true);
			radioM.setEnabled(true);
			radioF.setEnabled(true);
		}

	}

	private void limparCampos() {
		lblId.setText("");
		txtNome.setText("");
		txtPeso.setText("");
		comboAtividades.setSelectedIndex(0);
		txtAltura.setText("");
		lblIdade.setText("");
		txtDataNascimento.setText("");
		textLogradouro.setText("");
		textBairro.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		textCidade.setText("");
		lblImcR.setText("");
		lblTmbR.setText("");
		lblFcmR.setText("");
	}
}
