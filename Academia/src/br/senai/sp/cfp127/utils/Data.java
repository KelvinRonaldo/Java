package br.senai.sp.cfp127.utils;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.tree.DefaultMutableTreeNode;

public class Data {
	public static String converterParaPortugues(Date dt) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(dt);
	}

	public static Date converteParaDate(String data) {
		SimpleDateFormat stringParaDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		
		try {
			dt = stringParaDate.parse(data);
		} catch (ParseException e) {
			System.out.println("Erro na conversão de string para Date");
			e.printStackTrace();
		}
		return dt;
	}

	public static String converterParaPortugues(Date dt, String formato) {
		SimpleDateFormat df = new SimpleDateFormat(formato);
		return df.format(dt);
	}

	public static int calcularIdade(Date dtMaior, Date dtMenor) {
		long tempo = (dtMaior.getTime() - dtMenor.getTime()) / 1000 / 60 / 60 / 24 / 30 / 12;
		return Math.toIntExact(tempo);
	}

	public static String converterParaAccess(String data) {
		SimpleDateFormat stringParaDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateParaString = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000000");
		Date dt = null;

		try {
			dt = stringParaDate.parse(data);
			data = dateParaString.format(dt);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
}
