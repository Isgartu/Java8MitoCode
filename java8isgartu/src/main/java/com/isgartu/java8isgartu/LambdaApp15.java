package com.isgartu.java8isgartu;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Funciones de alto orden
 * 
 * https://www.youtube.com/watch?v=hYEizawDADU&index=15&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp15 {

	//Function<dato entrada, dato salida> 
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function<String, String> function, String valor) {
		System.out.println(function.apply(valor));
	}
	
	public Function<String, String> mostrar(String mensaje) {
		return (String x) -> mensaje + x;
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud) {
		lista.stream().filter(establecerLogicaFiltro(longitud)).forEach(consumidor);
	}
	
	public void filtrarCadena(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
		lista.stream().filter(establecerLogicaFiltro(cadena)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud) {
		return texto -> texto.length() < longitud;
	}
	public Predicate<String> establecerLogicaFiltro(String cadena) {
		return texto -> texto.contains(cadena);
	}

	public static void main(String[] args) {
		LambdaApp15 app = new LambdaApp15();
		
		app.imprimir(app.convertirMayusculas, "mifrase convertirmayusculas");
		app.imprimir(app.convertirMinusculas, "MIFRASE CONVERTIRMINUSCULAS");
		
		String respuesta = app.mostrar("Hola ").apply("Pepe");
		System.out.println(respuesta);
		
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");
		app.filtrar(lista, System.out::println, 5);
		
		app.filtrarCadena(lista, System.out::println, 0, "Mito");
		
	}

}
