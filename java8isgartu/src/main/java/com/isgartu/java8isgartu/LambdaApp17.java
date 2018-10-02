package com.isgartu.java8isgartu;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Nashorn -> motor de javascript en java
 * 
 * https://www.youtube.com/watch?v=9Wvm4periZ4&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=17
 *
 */
public class LambdaApp17 {
	
	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;
	
	public LambdaApp17() {
		this.m = new ScriptEngineManager();
		this.e = m.getEngineByName("nashorn");
		this.invocador = (Invocable) e;
	}
	
	public void llamarFunciones() throws Exception {
		//e.eval("print('JS desde Java')"); //Asi podemos imprimer texto como en js pero hay que tener en cuenta que no podemos hacer la manipulacion del DOM
		e.eval(new FileReader("src/main/java/com/isgartu/java8isgartu/java.js")); //Asi podemos llamar a un archivo JS desde Java
		
		String respuesta = (String) invocador.invokeFunction("calcular", "2", "3");
		System.out.println(respuesta);
		
		double respuesta2 = (double) invocador.invokeFunction("calcular", 2, 3);
		System.out.println(respuesta2);
	} 
	
	public void implementarInterfaz() throws Exception {
		e.eval(new FileReader("src/main/java/com/isgartu/java8isgartu/java.js"));
		
		Object implementacion = e.get("hiloImpl");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
	}

	public static void main(String[] args) throws Exception {
		LambdaApp17 app = new LambdaApp17();
		
		//app.llamarFunciones();
		
		app.implementarInterfaz();
	}

}
