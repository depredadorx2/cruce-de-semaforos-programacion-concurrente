package model;

import java.util.ArrayList;
import java.util.List;

public class Avenida {
	
	private List<Auto> calle = new ArrayList<Auto>();
	public String nombre;
	
	
	
	public Avenida(String nombre) {
		this.nombre=nombre;
	}

/**
 * Inicia los autos en el trancito
 * @param auto
 */

	public void agregarAuto(Auto auto){
		this.calle.add(auto);
	}
	
	/**
	 * Lo que hace es permitir que los autos curcen el semaforo
	 */
	public void puedenCruzar(){
		 this.calle.get(0).cruzar();
		
	}

}
