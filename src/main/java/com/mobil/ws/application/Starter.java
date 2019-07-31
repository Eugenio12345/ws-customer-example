package com.mobil.ws.application;

import java.io.File;

public class Starter {

	public static void main(String[] args) {
		File archivo = new File("C://input/altamiraAlta_20190729_162926.csv");
		byte[] bytes = new byte[(int)archivo.length()];
		System.out.println("leyendo archivo....."+bytes);
		
	}
}
