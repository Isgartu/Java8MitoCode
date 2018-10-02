package com.isgartu.java8isgartu;

/**
 * Default Methods en interfaces
 * 
 * https://www.youtube.com/watch?v=Ixn8Ypri90w&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=5
 *
 */
public class LambdaApp5 implements PersonaA, PersonaB{
	
	@Override
	public void caminar() {
		System.out.println("Hola que tal");
		
	}

	/* Como se estan implementando las dos interfaces, hay que hacer una sobrescritura
	 * marcando cual de las dos interfaces quiero utilizar para el metodo hablar() que
	 * tienen las dos interfaces */
	@Override
	public void hablar() {
		PersonaA.super.hablar();
		//Tambien podia retornar otra cosa:
//		System.out.println("Saludos desde aqui");
	}

	public static void main(String[] args) {
		LambdaApp5 app = new LambdaApp5();
		app.caminar();
		app.hablar();
	}

}
