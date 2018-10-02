package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream paralelo
 * 
 * Hay que tener en cuenta que afecta el rendimiento de los hilos, no es tan optimo como quieren decir
 * 
 * https://www.youtube.com/watch?v=9hGb9k5I6fA&index=11&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp11 {

	private List<Integer> numeros;

	public void llenar() {

		numeros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numeros.add(i);
		}
	}

	public void probarStream() {
		numeros.stream().forEach(System.out::println);
	}

	public void probarParalelo() {
		numeros.parallelStream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		LambdaApp11 app = new LambdaApp11();
		app.llenar();
		
		//app.probarStream();
		
		app.probarParalelo();
		
	}

}
