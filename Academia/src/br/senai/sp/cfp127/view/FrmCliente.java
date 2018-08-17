package br.senai.sp.cfp127.view;

import java.awt.*;

import javax.swing.*;


//↓↓ a classe FrmCLiente herda tudo a classe JFrame tem
public class FrmCliente extends JFrame{

	//vairáveis de referência dos componente do frame(janela)
	private JPanel painelTitulo;
	private JLabel lblTitulo;
	private JLabel lblIcone;
	private Color cinza = new Color(200, 200, 200);
	private Font fonte = new Font("Courier New", 1, 40);
	
	
	public FrmCliente() {
		//título do frame
		setTitle("Cadastro de Cliente");
		//tamanho do frame
		setSize(1920, 1080);
		//não usar layout pré-definido
		setLayout(null);
		setResizable(true);
		
		lblTitulo = new JLabel("Boa Forma");
		lblTitulo.setBounds(100, 0, 255, 100);
		lblTitulo.setFont(fonte);
		
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 1920, 100);
		painelTitulo.setLayout(null);
		
		painelTitulo.add(lblTitulo);
		
		getContentPane().add(painelTitulo);
		//getLayeredPane().add(lblTitulo);
		
		//fazer o frame aparecer
		setVisible(true);
	
	}
	
}
