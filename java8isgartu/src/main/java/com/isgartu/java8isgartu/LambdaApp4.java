package com.isgartu.java8isgartu;

/**
 * Scope (ambito o alcance) en las lambdas
 * 
 * https://www.youtube.com/watch?v=EWN2Ry4ZUxo&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=4
 *
 */
public class LambdaApp4 {
	
	private static double atributo1;
	private double atributo2;

	public double probarLocalVariable() {
		
		final double n3 = 3;
		Operacion operacion = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				return n1 + n2 + n3;
			}
		};
		
		// Esto es lo mismo que lo de arriba pero la variable n3 no tendria porque ser final en una lambda
		Operacion op = (x, y) -> {
			return x + y + n3;
		};
		
		return op.calcular(1, 1);
	}
	
	// Se comportan igual que en un objeto anonimo que se instancia a traves de una interfaz.
	// Esto quiere decir que en Java 8 se comporta igual que en versiones anteriores
	public double probarAtributosStaticVariables() {
		
		Operacion operacion = (x, y) -> {
			atributo1 = x + y;
			atributo2 = atributo1;
			return atributo1;
		};
		return operacion.calcular(3, 2);
	}

	public static void main(String[] args) {
		LambdaApp4 app = new LambdaApp4();
		System.out.println(app.probarLocalVariable());
		System.out.println(app.probarAtributosStaticVariables());
	}
}
