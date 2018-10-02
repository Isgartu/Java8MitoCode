package com.isgartu.java8isgartu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Map
 * 
 * https://www.youtube.com/watch?v=n2plQQwJes0&index=12&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp12 {

	private Map<Integer, String> map;

	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Mito");
		map.put(2, "Code");
		map.put(3, "Suscribete");
	}

	public void imprimir_v7() {
		for(Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
		}
	}
	
	public void imprimir_v8() {
		// En Java 8 se puede hacer asi
		//map.forEach((k, v) -> System.out.println("Lave: " + k + " Valor: " + v));
		
		// Tambien se puede hacer asi
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void recolectar() {
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e -> e.getValue().contains("Sus"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		mapaRecolectado.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
	}
	
	public void insertarSiAusente() {
		//Asi lo que hace es insertar un valor mas
		map.putIfAbsent(4, "Jaime");
		
		//Asi, en el caso de que no tiviesemos el valor 2 del array,
		//si lo insertaria, pero como lo tenemos, no agrega el parametro
		map.putIfAbsent(2, "Jaime");
	}
	
	public void operarSiPresente() {
		map.computeIfPresent(3, (k,v) -> k + v);
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		// En el caso de que no existiese la posicion indicada,
		// mostrara el valor por defecto
		String valor = map.getOrDefault(5, "valor por defecto");
		System.out.println(valor);
	}
	
	public static void main(String[] args) {
		LambdaApp12 app = new LambdaApp12();
		app.poblar();
		
		//app.imprimir_v7();
		
		//app.imprimir_v8();
		
		//app.insertarSiAusente();
		//app.imprimir_v8();
		
		//app.operarSiPresente();
		//app.imprimir_v8();
		
		//app.obtenerOrPredeterminado();
		//app.imprimir_v8();
		
		app.recolectar();
	}

}
