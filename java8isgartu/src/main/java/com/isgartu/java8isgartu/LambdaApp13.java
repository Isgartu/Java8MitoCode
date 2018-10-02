package com.isgartu.java8isgartu;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Anotaciones de repeticion
 * 
 * https://www.youtube.com/watch?v=6RF-mdZpRSk&index=13&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp13 {

	// El scope por defecto es de class, para que pueda visualizarse las anotaciones
	// hay que poner la anotacion @Retention(RetentionPolicy.RUNTIME)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {
		Lenguaje[] value() default {};
	}

	// Hay que anotar que lea las anotaciones repetidas, porque sino seguira sin
	// entender
	// las que son repetidas de @Lenguaje
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje {
		String value();
	}

	// 1.7 o <
	/*@Lenguajes({ @Lenguaje("Java"), @Lenguaje("Python") })
	public interface LenguajeProgramacion {

	}*/

	// 1.8
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LenguajeProgramacion {

	}

	public static void main(String[] args) {
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tiene " + lenguajeArray.length + " anotaciones en lenguaje");

		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		for(Lenguaje elemento : len.value()) {
			System.out.println(elemento.value());
		}
	}

}
