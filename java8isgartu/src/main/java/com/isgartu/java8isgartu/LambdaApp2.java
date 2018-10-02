package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Con Java 8, el codigo se simplifica bastante
 * 
 * https://www.youtube.com/watch?v=RdujMhuzg1o&index=2&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp2 {
	
	public void ordenar() {
		List<String>  lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");
		
		/*Collections.sort(lista, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});*/
		
		//Todo lo anterior, se puede simplificar asi
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		for(String elemento : lista) {
			System.out.println(elemento);
		}
	}

	//Antes de Java 8 teniamos que hacerlo asi cuando invocabamos una interfaz funcional
	public void calcular() {
		/*Operacion operacion = new Operacion() {
			@Override
			public double calcular(double n1, double n2) {
				return (n1+n2)/2;
			}
		};
		System.out.println(operacion.calcular(2, 3));*/
		
		//Con Java 8 queda asi de sencillo
		Operacion operacion = (double x, double y) -> (x+y)/2;
		System.out.println(operacion.calcular(2, 3));
	}
	
	public static void main(String[] args) {
		LambdaApp2 app = new LambdaApp2();
		app.ordenar();
		app.calcular();
	}
}
