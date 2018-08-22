package br.senai.sp.cfp127.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


//↓↓ a classe FrmCLiente herda tudo a classe JFrame tem
public class FrmCliente extends JFrame{

	//vairáveis de referência dos componente do frame(janela)
	private JPanel painelTitulo, painelDados, painelResultado;
		//declarar várias variáveis do mesmo tipo
	private JLabel lblTitulo, lblIcone, lblNome, lblSexo;
	private JTextField txtNome;
	//criar objeto cor
	private Color cinza = new Color(200, 200, 200);
	private Color azulEscuro = new Color(7, 71, 102);
	//criar objeto fonte
	private Font arialB = new Font("Arial Black", 1, 30);
	private Font arial = new Font("Arial", 2, 12);
	private ImageIcon iconeTitulo;
	private TitledBorder bordaPainelDados, bordaPainelResultado;
	private JRadioButton radioM, radioF;
	private JComboBox comboAtividades;
	
	
	
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
		lblTitulo.setBounds(100, 0, 500, 100);
		lblTitulo.setFont(arialB);
		//setar cor da donte
		lblTitulo.setForeground(azulEscuro);
		
		//**PAINEL TÍTULO
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 1920, 100);
		painelTitulo.setLayout(null);
		
		painelTitulo.add(lblIcone);
		painelTitulo.add(lblTitulo);
		//FIM PAINEL TITULO
		
		
		//**ELEMENTOS DO PAINEL DE DADOS
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(15, 25, 50, 10);

		
		txtNome = new JTextField();
		txtNome.setBounds(58, 21, 544, 21);

		
		
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(15, 55, 50, 10);

		ButtonGroup grupoRadio = new ButtonGroup();
		radioM = new JRadioButton("Masculino");
		radioM.setBounds(75, 55, 150, 15);
		radioF = new JRadioButton("Feminino");
		radioF.setBounds(240, 55, 150, 15);
		grupoRadio.add(radioF);
		grupoRadio.add(radioM);
		
		
		String atividades[] = {"Sedentário", "Levemente Ativo","MOderadamente Ativo","Bastante Ativo","Muito Ativo"};
		comboAtividades = new JComboBox(atividades);
		comboAtividades.setBounds(15, 95, 200, 30);
				
		
		//** PAINEL DADOS
		painelDados = new JPanel();
		painelDados.setLayout(null);
		painelDados.setBounds(15, 115, 617, 560);

		
		
		painelDados.add(lblNome);
		painelDados.add(txtNome);
		painelDados.add(lblSexo);
		painelDados.add(radioM);
		painelDados.add(radioF);
		painelDados.add(comboAtividades);
		
		bordaPainelDados = new TitledBorder("Dados do Cliente:");
		painelDados.setBorder(bordaPainelDados);
		//**FIM PAINEL DE DADOS
		
		
		
		//**PAINEL RESULTADOS
		painelResultado = new JPanel();
		painelResultado.setLayout(null);
		painelResultado.setBounds(640, 115, 617, 560);
		bordaPainelResultado = new TitledBorder("Resultados:");
		painelResultado.setBorder(bordaPainelResultado);
		

		
		
		
		//colocar labels e panels no painel de conteúdo dpo frame
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		getContentPane().add(painelResultado);
		//cor de fundo do painel de conteúdo
		//getLayeredPane().add(lblTitulo);
		
		//fazer o frame aparecer
		setVisible(true);
	}
	
}
