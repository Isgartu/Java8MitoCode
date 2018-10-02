package com.isgartu.java8isgartu;

/*
 * Una interface funcional es aquella que solo define un metodo, en caso de
 * que existan mas, como el metodo comentado, dara error en LambdaApp6
 * Java ha decidido formalizar que las interfaces funcionales sean anotadas con la
 * expresion @FunctionalInterface -> si tengo esta anotacion, la interface
 * no me dejara anotar mas metodos
 */
@FunctionalInterface
public interface Operacion {

	double calcular(double n1, double n2);
	
//	int calcular2();
}
