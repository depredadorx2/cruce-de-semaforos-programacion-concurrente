package model;

import java.util.concurrent.Semaphore;

public class Auto extends Thread {

	public int velocidad;
	public Semaphore semaforoPaso1;
	public String modeloAuto;
	public String tipoDeCruce;
	public Semaphore estoyPrimero;
	public Semaforo semaforoDeMiCalle;
	public int id;
	public String direccion;
	public static int fabricaId = 0;
	public String calle;

	/**
	 * Constructor
	 * 
	 * @param velocidad
	 * @param calle
	 * @param semaforoCubito
	 * @param modelo
	 * @param tipoDeCruce
	 * @param estoyPrimero
	 * @param semaforoDeMiCalle
	 * @param direccion
	 */
	public Auto(int velocidad, Semaphore semaforoCubito,
			String modelo, String tipoDeCruce, Semaphore estoyPrimero,
			Semaforo semaforoDeMiCalle, String direccion, String calle, int id) {

		this.velocidad = velocidad;
		this.semaforoPaso1 = semaforoCubito;
		this.modeloAuto = modelo;
		this.tipoDeCruce = tipoDeCruce;
		this.estoyPrimero = estoyPrimero;
		this.semaforoDeMiCalle = semaforoDeMiCalle;
        this.calle = calle;
		this.direccion = direccion;
		this.id = id;
	}


	/**
	 * metodo run del thread, esta plasmado todo el comportamiento de un auto,
	 * desde que entra en circulacion hasta que sale de ella.
	 */
	public void run() {
		
	}

	
	
	

	/**
	 * Hace que el auto se inicie en el transito, solamente con una impresion.
	 */
	public synchronized void unirmeAlTransito() {
		this.imprimirInformacion("  estoy en transito ");

	}

	

	/**
	 * Este metodo permite imporimer la informacion del auto, con alguna
	 * variante mas que es el String que se pasa como parametro
	 * 
	 * @param info
	 */
	public void imprimirInformacion(String info) {
		System.out.println(this.id + " " + this.modeloAuto + " " + info
				+ " calle " + this.calle+ " " + this.direccion);
	}
}
