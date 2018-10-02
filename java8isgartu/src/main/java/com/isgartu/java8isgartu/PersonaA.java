package com.isgartu.java8isgartu;

public interface PersonaA {

	public void caminar();
	
	/* Esto es util cuando se programa orientado a interfaces para tener el codigo desacoplado
	 * Si se nos pide como requerimiento que todas las clases que implementan una interface
	 * tengan que tener un comportamiento por defecto se puede hacer de dos formas:
	 * 1. Crear de forma tradicional haciendo mencion al metodo y sobrescribiendo en cada clase
	 * 2. Hacer un metodo por defecto, implementar la funcionalidad y que todas las clases que implementan
	 *    la interface, tengan acceso al metodo que tiene la logica por defecto */
	
	/* Tambien se puede utilizar un metodo "default public double" o cualquier
	 * otro que haga un return, no es necesario que sea un void */
	default public void hablar() {
		System.out.println("Saludos developers - PersonaA");
	}
}
