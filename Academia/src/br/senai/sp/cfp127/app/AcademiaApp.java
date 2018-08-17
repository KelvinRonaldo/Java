package br.senai.sp.cfp127.app;

import br.senai.sp.cfp127.clientes.Cliente;

public class AcademiaApp {

	public static void main(String[] args) {
		
		Cliente kelvin = new Cliente();
			
			kelvin.setAltura(1.7);
			kelvin.setPeso(84);
			kelvin.setSexo('f');
			kelvin.setIdade(43);
			
			
			System.out.println(kelvin.getImc());
			System.out.println(kelvin.getTmb());
			System.out.println(kelvin.getFcm());
			
		

	}

}