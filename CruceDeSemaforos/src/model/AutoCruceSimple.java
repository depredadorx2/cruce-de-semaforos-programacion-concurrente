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

	public void run(){
		try{
		this.unirmeAlTransito();
		
		this.estoyPrimero.acquireUninterruptibly();

		this.imprimirInformacion("  estoy en transito, espero semaforo verde ");

		if (!(this.semaforoDeMiCalle.getEstaEnVerde())) {
			this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
		}

		this.imprimirInformacion("  cruce semaforo ");

		
		this.semaforoPaso1.acquireUninterruptibly();
		System.out.println(this.id + " " + this.modeloAuto + " "
				+ "  ocupe " + this.tipoDeCruce + " " + this.direccion);

		Thread.sleep(this.velocidad);
		this.estoyPrimero.release();
		
		
		this.imprimirInformacion("  desocupe ");
		this.semaforoPaso1.release();
		System.out.println(this.id + " " + this.modeloAuto + " "
				+ "  abandone el cruce ");
		}
		catch(Exception e){}
	}

	
	/**
	 * Se retira del cruce, libreando la ultima grilla.
	 */
	/*public synchronized void irse() {
		this.imprimirInformacion("  desocupe ");
		this.semaforoPaso1.release();
		System.out.println(this.id + " " + this.modeloAuto + " "
				+ "  abandone el cruce ");
	}
*/
}
