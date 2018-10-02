package com.isgartu.java8isgartu;

/**
 * Interfaces funcionales
 * 
 * https://www.youtube.com/watch?v=PYbzuxET7lo&index=6&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp6 {
	
	public double calcularPromedio(double x, double y) {
		Operacion op = (n1, n2) -> n1 + n2;
		return op.calcular(x, y);
	}
	
	public static void main(String[] args) {
		LambdaApp6 app = new LambdaApp6();
		double rpta = app.calcularPromedio(2, 3);
		System.out.println(rpta);
	}

}
