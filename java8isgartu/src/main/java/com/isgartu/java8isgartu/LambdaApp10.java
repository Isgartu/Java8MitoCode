package com.isgartu.java8isgartu;

import java.util.Optional;

/**
 * Optional. Gestionar los NullPointerException
 * 
 * En algunas ocasiones no es recomendable utilizar Optional. El rendimiento se ve afectado
 * 
 * https://www.youtube.com/watch?v=ZqvbRCdZx8M&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=10
 *
 */
public class LambdaApp10 {
	
	public void probar(String valor) {
		//System.out.println(valor.contains("mito"));
		
		try {
			Optional op = Optional.empty();
			op.get();
		} catch (Exception e) {
			System.out.println("No hay elemento");
		}
		
	}

	public void orElse(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElse("predeterminado");
		System.out.println(x);
	}

	public void orElseThrow(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new);
	}

	public void isPresent(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
	}

	public static void main(String[] args) {
		LambdaApp10 app = new LambdaApp10();
		//app.probar("Mito"); // -> Terminal: No hay elemento. El error NullPointer se gestiona
		
		//app.orElse("Mito"); // -> Terminal: Mito
		//app.orElse(null); // -> Terminal: NullPointerException - Como tenemos el orElse se muestra el texto que hemos puesto (predeterminado)
		
		//app.orElseThrow(null); // -> Terminal: NumberFormatException - Hemos puesto que en caso de error lance la excepcion de formato
		
		//app.isPresent(null); // -> Terminal: false - Comprueba que hay valor
		//app.isPresent("Mito"); // -> Terminal: true
		
	}

}
