package br.senai.sp.cfp127.modelo;

//para fazer uma classe herdeira coloca-se "extends" e o nome da classe que dara a herança
//            //↓herdeiro        //↓o que dara herança
public class Funcionario extends Pessoa {

	private int codigo;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
}
