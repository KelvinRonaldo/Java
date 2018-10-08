package br.senai.sp.cfp127.clientes;

import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente {

	
	private String nome;
	private int idade;
	private char sexo;
	private double peso;
	private double altura;
	private int nivelAtividade;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String telefone;
	private String email;
	private int id;
	private int at;
	private double imc;
	private double tmb;
	private double fcm;
	private Date dtNascimento;

	// **MÉTODO CONSTRUTOR DA CLASSE(tem o mesmo nome da classe)


	

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome, double peso, double altura) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public Cliente() {

	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dt) {
		this.dtNascimento = dt;
	}
	
	public int getAt() {
		return at;
	}

	public void setAt(int at) {
		this.at = at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNivelAtividade() {
		return nivelAtividade;
	}

	public void setNivelAtividade(int nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getImc() {
		// ↓função matemática de potência
		this.imc = this.peso / Math.pow(this.altura / 100, 2);
		/*
		 * if (imc < 17) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta muito abaixo do peso.\n" +
		 * "Riscos: Queda de cabelo, infertilidade \n" + "ausência menstrual.";
		 * 
		 * }else if (imc < 18.5) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta abaixo do peso.\n" + "Riscos: Fadiga, stress, ansiedade"; }else if
		 * (imc < 25) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta com o peso normal.\n" + "Menor risco de doençascardíacas \n" +
		 * "e vasculares;"; }else if (imc < 30) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta acima do peso.\n" + "Riscos: Fadiga, má circulação, varizes";
		 * }else if (imc < 35) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta com Obesidade de Grau I.\n" +
		 * "Riscos: Diabetes, angina, infarto, \n" + "aterosclerose"; }else if (imc <
		 * 41) { this.imc = "Seu IMC é " + imc + "\n" +
		 * "Você esta com Obesidade de Grau II.\n" +
		 * "Riscos: Apneia do sono, falta de ar"; }else { this.imc = "Seu IMC é " + imc
		 * + "\n" + "Você esta com Obesidade de Grau III.\n" +
		 * "Riscos: Refluxo, dificuldade para se \n" +
		 * "mover, escaras, diabetes, infarto, AVC"; }
		 */
		return this.imc;
	}

	public double getTmb() {

		if (this.sexo == 'm') {
			this.tmb = 66 + (13.7 * this.peso) + (5 * (this.altura)) - (6.8 * this.idade);
		} else {
			this.tmb = 665 + (9.6 * this.peso) + (1.8 * (this.altura)) - (4.7 * this.idade);
		}

		if (this.nivelAtividade == 0) {
			JOptionPane.showMessageDialog(null, "Selecione seu Nível de Atividade");
		} else if (this.nivelAtividade == 1) {
			this.tmb = (tmb * 1.2);
		} else if (this.nivelAtividade == 2) {
			this.tmb = (tmb * 1.37);
		} else if (this.nivelAtividade == 3) {
			this.tmb = (tmb * 1.55);
		} else if (this.nivelAtividade == 4){
			this.tmb = (tmb * 1.72);
		}else {
			this.tmb = (tmb * 1.9);
		}

		return this.tmb;
	}

	public double getFcm() {

		double fcm = 0;

		if (this.sexo == 'm') {
			fcm = ((210 - (0.5 * this.idade)) - this.peso / 100) + 4;
			this.fcm = fcm;
		} else {
			fcm = ((210 - (0.5 * this.idade)) - this.peso / 100);
			this.fcm = fcm;
		}

		return this.fcm;
	}

}
