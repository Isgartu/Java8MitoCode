package com.isgartu.java8isgartu;

/**
 * Las lambdas se pueden escribir de distintas formas
 * 
 * https://www.youtube.com/watch?v=2yBTVVZK7JQ&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=3
 *
 */
public class LambdaApp3 {

	public double probarSintaxis() {
		
		// Una forma de hacerlo
//		 Operacion operacion = (double x, double y) -> (x + y) / 2;

		/* Otra forma de hacer lo anterior, por si hay que anadir mas operaciones ->
		   Operacion operacion = (double x, double y) -> { double a = 2.0;
		   System.out.println(a); return (x, y)/2 + a;} */
//		Operacion operacion = (double x, double y) -> {	return (x + y) / 2;	};
		
		// Podemos obviar el tipo de parametro
		// Tip: lambda:  parametros + operador + expresion
		Operacion operacion = (x, y) -> {	return (x + y) / 2;	};

		return operacion.calcular(2, 3);
	}

	public static void main(String[] args) {
		LambdaApp3 app = new LambdaApp3();
		System.out.println(app.probarSintaxis());
	}
}
