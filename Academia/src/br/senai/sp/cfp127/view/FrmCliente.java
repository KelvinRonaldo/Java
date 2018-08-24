package br.senai.sp.cfp127.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.clientes.Cliente;


//↓↓ a classe FrmCLiente herda tudo a classe JFrame tem
public class FrmCliente extends JFrame{

	//vairáveis de referência dos componente do frame(janela)
	private JPanel painelTitulo, painelDados, painelResultado;
		//declarar várias variáveis do mesmo tipo
	private JLabel lblTitulo, lblIcone, lblNome, lblSexo, lblPeso, lblKg, lblAltura, lblCm, lblIdade, lblAnos, lblNivelAtiv, lblIconeCalcular;
	private JLabel lblNomeResult, lblSexoResult, lblPesoResult, lblAlturaResult, lblIdadeResult, lblNivelAtivResult, lblImcResult, lblTmbResult, lblFcmResult;
	private JLabel lblNomeR, lblSexoR, lblPesoR, lblAlturaR, lblIdadeR, lblNivelAtivR, lblTmbR, lblFcmR;
	private JTextField txtNome, txtPeso, txtAltura, txtIdade;
	//criar objeto cor
	private Color cinza = new Color(200, 200, 200);
	private Color azulEscuro = new Color(7, 71, 102);
	private Color verde = new Color(93, 191, 100);
	//criar objeto fonte
	private Font arialBlack = new Font("Arial Black", 1, 40);
	private Font arial = new Font("Arial", 0, 20);
	private Font arial18 = new Font("Arial", 0, 18);
	private Font arialBold = new Font("Arial", 1, 20);
	private Font arialNarrow = new Font("Arial Narrow", 0, 18);
	private Font verdana = new Font("Verdana", 0, 20);
	private ImageIcon iconeTitulo, iconeCalcular;
	private TitledBorder bordaPainelDados, bordaPainelResultado;
	private JRadioButton radioM, radioF;
	private JComboBox comboAtividades;
	private JButton btnCalcular;
	private JTextArea txtImcResult;
	private JScrollPane ImcScroll; 
	
	
	
	public FrmCliente() {
		
		//título do frame
		setTitle("Cadastro de Cliente");
		//tamanho do frame
		setSize(1280, 720);
		//não usar layout pré-definido
		setLayout(null);
		//permitir ou não que o usuário mude o tamanho da janela
		setResizable(false);
		//finalizar processo da janela ao fecha-la
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
				
		//**IMAGENS DO FORMULÁRIO
		iconeTitulo = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym64.png"));
		iconeCalcular = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/calculadora.png"));
		//**LABELS DO PAINEL TÍTULO
		lblIcone = new JLabel(iconeTitulo);
		//setBounds = definir posição e tamanho do objeto
		lblIcone.setBounds(20, 0, 70, 100);
		/*
		OU
		lblIcone = new JLabel();
		lblIcone.setBounds(20, 0, 70, 100);
		lblIcone.setIcon(iconeTitulo);
		 */
		
		lblTitulo = new JLabel("Academia Boa Forma");
		lblTitulo.setBounds(100, 0, 700, 100);
		lblTitulo.setFont(arialBlack);
		//setar cor da donte
		lblTitulo.setForeground(azulEscuro);
		
		//**PAINEL TÍTULO
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 1280, 100);
		painelTitulo.setLayout(null);
		
		painelTitulo.add(lblIcone);
		painelTitulo.add(lblTitulo);
		//FIM PAINEL TITULO
		
		
		//**ELEMENTOS DO PAINEL DE DADOS
		//NOME 
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(35, 20, 80, 50);
		lblNome.setFont(arialBold);
		//DIGITAR NOME
		txtNome = new JTextField();
		txtNome.setBounds(120, 30, 444, 30);
		txtNome.setFont(arial18);

		
		//SEXO
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(35, 75, 80, 30);
		lblSexo.setFont(arialBold);
		
		//SELECIONAR SEXO
		ButtonGroup grupoRadio = new ButtonGroup();
		radioM = new JRadioButton("Masculino");
		radioM.setBounds(120, 80, 150, 20);
		radioM.setFont(arial);
		radioF = new JRadioButton("Feminino");
		radioF.setBounds(340, 80, 150, 20);
		radioF.setFont(arial);
		grupoRadio.add(radioF);
		grupoRadio.add(radioM);
		
		
		//PESO
		lblPeso = new JLabel("Peso: ");
		lblPeso.setBounds(35, 130, 80, 20);
		lblPeso.setFont(arialBold);
		//DIGITAR PESO
		txtPeso = new JTextField();
		txtPeso.setBounds(120, 126, 100, 30);
		txtPeso.setFont(arial18);
		//Quilos
		lblKg = new JLabel("Quilos(Kg)");
		lblKg.setBounds(230, 133, 100, 25);
		lblKg.setFont(arialNarrow);
		
		//ALTURA
		lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(35, 185, 80, 20);
		lblAltura.setFont(arialBold);
		//DIGITAR ALTURA
		txtAltura = new JTextField();
		txtAltura.setBounds(120, 181, 100, 30);
		txtAltura.setFont(arial18);
		//Centimetros
		lblCm = new JLabel("Centímetros(Cm)");
		lblCm.setBounds(230, 188, 130, 25);
		lblCm.setFont(arialNarrow);
		
		//IDADE
		lblIdade = new JLabel("Idade: ");
		lblIdade.setBounds(35, 240, 80, 20);
		lblIdade.setFont(arialBold);
		//DIGITAR IDADE
		txtIdade = new JTextField();
		txtIdade.setBounds(120, 236, 100, 30);
		txtIdade.setFont(arial18);
		//Anos
		lblAnos = new JLabel("Anos");
		lblAnos.setBounds(230, 243, 50, 25);
		lblAnos.setFont(arialNarrow);
		
		//NÍVEL ATIVIDADE
		lblNivelAtiv = new JLabel("Nível de Atividade");
		lblNivelAtiv.setBounds(35, 310, 230, 20);	
		lblNivelAtiv.setFont(arialBold);
		
		//COMBO DE ATIVIDADES
		String atividades[] = {"Sedentário", "Levemente Ativo","Moderadamente Ativo","Bastante Ativo","Muito Ativo"};
		comboAtividades = new JComboBox(atividades);
		comboAtividades.setBounds(35, 340, 300, 35);
		comboAtividades.setFont(verdana);
		
		//BOTÃO CALCULAR
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(159, 430, 300, 60);
		btnCalcular.setFont(arial);
		
		lblIconeCalcular = new JLabel(iconeCalcular);
		lblIconeCalcular.setBounds(159, 430, 300, 60);
		btnCalcular.add(lblIconeCalcular);
		
		//** PAINEL DADOS
		painelDados = new JPanel();
		painelDados.setLayout(null);
		painelDados.setBounds(15, 115, 617, 560);
		
		painelDados.add(lblNome);
		painelDados.add(txtNome);
		painelDados.add(lblSexo);
		painelDados.add(radioM);
		painelDados.add(radioF);
		painelDados.add(lblPeso);
		painelDados.add(txtPeso);
		painelDados.add(lblKg);
		painelDados.add(lblAltura);
		painelDados.add(txtAltura);
		painelDados.add(lblCm);
		painelDados.add(lblIdade);
		painelDados.add(txtIdade);
		painelDados.add(lblAnos);
		painelDados.add(lblNivelAtiv);
		painelDados.add(comboAtividades);
		painelDados.add(btnCalcular);
		
		bordaPainelDados = new TitledBorder("Dados do Cliente:");
		painelDados.setBorder(bordaPainelDados);
		//**FIM PAINEL DE DADOS
		
		//NOME
		lblNomeResult = new JLabel("Nome: ", JLabel.RIGHT);
		lblNomeResult.setBounds(35, 20, 80, 50);
		lblNomeResult.setFont(arialBold);
		//RESULTADO NOME
		lblNomeR = new JLabel("RESULTADO");
		lblNomeR.setBounds(120, 20, 150, 50);
		lblNomeR.setFont(verdana);
		lblNomeR.setForeground(verde);
		
		//PESO
		lblPesoResult = new JLabel("Peso: ", JLabel.RIGHT);
		lblPesoResult.setBounds(35, 75, 80, 30);
		lblPesoResult.setFont(arialBold);
		//RESULTADO PESO
		lblPesoR = new JLabel("RESULTADO");
		lblPesoR.setBounds(120, 75, 150, 30);
		lblPesoR.setFont(verdana);
		lblPesoR.setForeground(verde);
		
		//ALTURA
		lblAlturaResult = new JLabel("Altura: ", JLabel.RIGHT);
		lblAlturaResult.setBounds(35, 130, 80, 30);
		lblAlturaResult.setFont(arialBold);
		//RESULTADO ALTURA
		lblAlturaR = new JLabel("RESULTADO");
		lblAlturaR.setBounds(120, 130, 150, 30);
		lblAlturaR.setFont(verdana);
		lblAlturaR.setForeground(verde);
		
		//IDADE
		lblIdadeResult = new JLabel("Idade: ", JLabel.RIGHT);
		lblIdadeResult.setBounds(35, 185, 80, 30);
		lblIdadeResult.setFont(arialBold);
		//RESULTADO IDADE
		lblIdadeR = new JLabel("RESULTADO");
		lblIdadeR.setBounds(120, 185, 150, 30);
		lblIdadeR.setFont(verdana);
		lblIdadeR.setForeground(verde);
		
		
		//NIVEL DE ATIVIDADE
		lblNivelAtivResult = new JLabel("Nível de Atividade: ", JLabel.RIGHT);
		lblNivelAtivResult.setBounds(35, 240, 190, 30);
		lblNivelAtivResult.setFont(arialBold);
		//RESULTADO NIVEL DE ATIVIDADE
		lblNivelAtivR = new JLabel("RESULTADO");
		lblNivelAtivR.setBounds(230, 240, 150, 30);
		lblNivelAtivR.setFont(verdana);
		
		
		//IMC
		lblImcResult = new JLabel("IMC: ", JLabel.RIGHT);
		lblImcResult.setBounds(35, 310, 80, 20);
		lblImcResult.setFont(arialBold);	
		
		txtImcResult = new JTextArea();
		//CRIAR PAINEL COM BARRA DE ROLAGEM COM TEXTAREA DENTRO
		ImcScroll = new JScrollPane(txtImcResult);
		//QUEBRA A LINHA DO TEXTAREA
		txtImcResult.setLineWrap(true);
		//QUEBRA A LINHA MAS NÃO AS PALAVRAS
		txtImcResult.setWrapStyleWord(true);
		ImcScroll.setBounds(120, 310, 400, 100);
		
		
		//TMB
		lblTmbResult = new JLabel("TMB: ", JLabel.RIGHT);
		lblTmbResult.setBounds(35, 415, 80, 30);
		lblTmbResult.setFont(arialBold);
		//RESULTADO TMB
		lblTmbR = new JLabel("RESULTADO");
		lblTmbR.setBounds(120, 415, 150, 30);
		lblTmbR.setFont(verdana);
		lblTmbR.setForeground(verde);
		
		
		//FCM
		lblFcmResult = new JLabel("FCM: ", JLabel.RIGHT);
		lblFcmResult.setBounds(35, 465, 80, 30);
		lblFcmResult.setFont(arialBold);
		//RESULTADO FCM
		lblFcmR = new JLabel("RESULTADO");
		lblFcmR.setBounds(120, 465, 150, 30);
		lblFcmR.setFont(verdana);
		

		//**PAINEL RESULTADOS
		painelResultado = new JPanel();
		painelResultado.setLayout(null);
		painelResultado.setBounds(640, 115, 617, 560);
		
		painelResultado.add(lblNomeResult);
		painelResultado.add(lblNomeR);
		painelResultado.add(lblPesoResult);
		painelResultado.add(lblPesoR);
		painelResultado.add(lblAlturaResult);
		painelResultado.add(lblAlturaR);
		painelResultado.add(lblIdadeResult);
		painelResultado.add(lblIdadeR);
		painelResultado.add(lblNivelAtivResult);
		painelResultado.add(lblNivelAtivR);
		painelResultado.add(lblImcResult);
		painelResultado.add(ImcScroll);
		painelResultado.add(lblTmbResult);
		painelResultado.add(lblTmbR);
		painelResultado.add(lblFcmResult);
		painelResultado.add(lblFcmR);
		
		bordaPainelResultado = new TitledBorder("Resultados:");
		painelResultado.setBorder(bordaPainelResultado);
		
		
		//colocar labels e panels no painel de conteúdo do frame
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		getContentPane().add(painelResultado);
		//cor de fundo do painel de conteúdo
		//getLayeredPane().add(lblTitulo);
		
		//***LISTENER DO BOTÃO
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));

				if(radioM.isSelected()){
					cliente.setSexo('M');
				}else if(radioM.isSelected()) {
					cliente.setSexo('F');
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o sexo do cliente(Masculino ou Feminino)!");
				}
				
				cliente.setNivelAtividade(comboAtividades.getSelectedIndex()+1);
				
				lblNomeR.setText(cliente.getNome());
				lblPesoR.setText(String.valueOf(cliente.getPeso()+"kg"));
				lblAlturaR.setText(String.valueOf(cliente.getAltura()+"Cm"));
				lblIdadeR.setText(String.valueOf(cliente.getIdade()+" Anos"));
				txtImcResult.setText(cliente.getImc());
				lblTmbR.setText(String.valueOf(cliente.getTmb()));
				lblFcmR.setText(String.valueOf(cliente.getFcm()));
				
				//lblPesoR.setText(cliente.getPeso()+ "Kg");
			}
		});
		
		
		//fazer o frame aparecer
		setVisible(true);
	}
	
}
