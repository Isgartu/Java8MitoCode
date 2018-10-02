package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Referencias a Metodos
 * 
 * https://www.youtube.com/watch?v=FkW4B6pOA1s&index=7&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp7 {
	
	public static void referenciarMetodoStatic() {
		System.out.println("Metodo Referido static");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String [] nombres = {"Mito", "Code", "Jaime" };
		
		/*Arrays.sort(nombres, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
			
		});*/
		
		// Todo lo anterior se reduce a esta linea con lambda
		//Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
		
		// La lambda se puede reducir con la referencia a metodos
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Metodo Referido Instancia de Clase");
	}
	
	public void referenciarConstructor() {
		/*IPersona iper = new IPersona() {
			
			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id, nombre);
			}
		};
		Persona per = iper.crear(1, "UnCode");*/
		
		// Todo lo anterior se sustituye por esto
		/*IPersona iper2 = (x,y)->(new Persona(x,y));
		Persona per = iper2.crear(1, "UnCode");*/
		
		// La lambda anterior se puede sustituir/reducir con la referencia a metodos
		IPersona iper3 = Persona::new;
		Persona per = iper3.crear(1, "UnCode");
		
		System.out.println(per.getId()+" - "+per.getNombre());
	}
	
	public void operar() {
		Operacion2 op = () -> LambdaApp7.referenciarMetodoStatic();
		op.saludar();
		
		// Igual que la anterior pero haciendo la referencia al metodo
		Operacion2 op2 = LambdaApp7::referenciarMetodoStatic;
		op2.saludar();
	}
	
	public static void main(String[] args) {
		LambdaApp7 app = new LambdaApp7();

		//app.operar();
		
		//app.referenciarMetodoInstanciaObjetoArbitrario();
		
		//Operacion2 op = app::referenciarMetodoInstanciaObjetoParticular;
		//op.saludar();
		
		app.referenciarConstructor();
	}

}
