package br.senai.sp.cfp127.modelo;

//para fazer uma classe herdeira coloca-se "extends" e o nome da classe que dara a herança
//            //↓herdeiro        //↓o que dara herança
public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
