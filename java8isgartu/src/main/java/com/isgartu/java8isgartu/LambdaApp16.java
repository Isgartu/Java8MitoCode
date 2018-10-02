package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * RxJava -> procedimiento asincrono de manera legible
 * 
 * https://www.youtube.com/watch?v=dD0vE3GGzDM&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=16
 *
 */
public class LambdaApp16 {
	
	private List<Integer> lista1;
	private List<Integer> lista2;

	public LambdaApp16() {
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llenarListas();
	}

	public void llenarListas() {
		for (int i = 0; i < 10; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}

	public void buscar() {
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		/*Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer numero) {
				if(numero == 1) {
					System.out.println(numero);
				}
				
			}
			
		});*/
		
		//Convertimos la interfaz funcional anterior a una funcion lambda para mejor legibilidad
		Observable.merge(obs1, obs2).filter(x -> x == 1).subscribe(System.out::println);
		
		//Si la logica fuese mas compleja, podriamos ampliar la funcion lambda de esta manera
		Observable.merge(obs1, obs2).filter(x -> x == 1).subscribe(x -> {
			if(x == 1) {
				System.out.println(x);
			}
		});
	}

	public static void main(String[] args) {
		/*List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");

		Observable<String> obs = Observable.from(lista);
		obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				System.out.println(elemento);
				
			}
		});*/
		
		LambdaApp16 app = new LambdaApp16();
		app.buscar();
	}

}
