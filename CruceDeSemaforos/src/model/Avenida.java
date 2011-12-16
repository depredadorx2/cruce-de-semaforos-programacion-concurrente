package model;

import java.util.ArrayList;
import java.util.List;

public class Avenida {
	
	private List<Auto> calle = new ArrayList<Auto>();
	public String nombre;
	
	
	
	public Avenida(String nombre) {
		this.nombre=nombre;
	}
	
	
	

	public List<Auto> getCalle() {
		return calle;
	}




	public void setCalle(List<Auto> calle) {
		this.calle = calle;
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
