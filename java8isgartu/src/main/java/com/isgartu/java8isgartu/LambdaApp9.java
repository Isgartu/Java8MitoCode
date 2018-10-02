package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Stream
 * 
 * https://www.youtube.com/watch?v=hz6hlaU5o58&index=9&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp9 {
	
	private List<String> lista;
	private List<String> numeros;
	
	
	public LambdaApp9() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("Jaime");
		lista.add("MitoCode");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		
	}
	
	public void filtrar() {
		lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);
	}

	public void ordenar() {
		lista.stream().sorted().forEach(System.out::println);
		
		//Si la queremos ordenar en orden inverso
//		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
	}

	public void transformar() {
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//Para sumar una unidad a los numeros del array numeros
		/*for(String x : numeros) {
			int num = Integer.parseInt(x) + 1;
			System.out.println(num);
		}*/
		
		//Para hacer lo mismo que en el caso anterior
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
	}

	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
	}

	public void contar() {
		long x = lista.stream().count();
		System.out.println(x);
	}

	public static void main(String[] args) {
		LambdaApp9 app = new LambdaApp9();
		//app.filtrar();
		//app.ordenar();
		//app.transformar();
		//app.limitar();
		app.contar();
	}

}
