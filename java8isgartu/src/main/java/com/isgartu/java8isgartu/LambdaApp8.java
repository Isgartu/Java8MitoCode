package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * ForEach, RemoveIf, Sort
 * 
 * https://www.youtube.com/watch?v=1zC4Sqipzng&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=8
 *
 */
public class LambdaApp8 {
	
	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		
		lista.add("MitoCode");
		lista.add("Mito");
		lista.add("Code");
	}
	
	public void usarForEach() {
		/*for(String elemento : lista) {
			System.out.println(elemento);
		}*/
		
		// Lo mismo que lo anterior pero con Lambda
		/*lista.forEach(x -> System.out.println(x));*/
		
		// Con la referencia a metodos, quedaria asi
		lista.forEach(System.out::println);
	}
	
	public void usarRemoveIf() {
		//Esto da un error de concurrencia, no se puede 
		//eliminar el elemento del array dentro del for
		/*for(String elemento : lista) {
			if(elemento.equalsIgnoreCase("Code")) {
				lista.remove(elemento);
			}
		}*/
		
		//Para solucionar lo anterior usabamos un iterator
		/*Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			if(it.next().equalsIgnoreCase("Code")) {
				it.remove();
			}
		}*/
		
		//El iterator se puede sustituir por
		lista.removeIf(x -> x.equalsIgnoreCase("Code"));
	}
	
	public void usarSort() {
		lista.sort((x,y) -> x.compareTo(y));
	}
	
	public static void main(String[] args) {
		LambdaApp8 app = new LambdaApp8();
		app.llenarLista();
		
		//app.usarRemoveIf();
		app.usarSort();
		
		app.usarForEach();
	}

}
