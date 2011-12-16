package model;

import java.util.concurrent.Semaphore;

public class AutoCruceSimple extends Auto {

	/**
	 * Constructor, del cual hereda parte de la superclase Auto
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
	public AutoCruceSimple(int velocidad, Semaphore semaforoCubito,
			String modelo, String tipoDeCruce, Semaphore estoyPrimero,
			Semaforo semaforoDeMiCalle, String direccion, String calle, int id) {
		super(velocidad, semaforoCubito, modelo, tipoDeCruce, estoyPrimero,
				semaforoDeMiCalle, direccion, calle, id);

	}

	public void run() {
		super.run();
		this.irse();

	}

	/**
	 * Se retira del cruce, libreando la ultima grilla.
	 */
	public synchronized void irse() {
		this.imprimirInformacion("  desocupe ");
		this.semaforoPaso1.release();
		System.out.println(this.id + " " + this.modeloAuto + " "
				+ "  abandone el cruce ");
	}

}
