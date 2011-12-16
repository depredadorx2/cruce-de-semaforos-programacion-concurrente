package model;

import java.util.concurrent.Semaphore;

public class AutoCruceDoble extends Auto {

	public Semaphore semaforoPaso2;
	public String tipoDeCruce2;

	/**
	 * Constructor del cual hereda parte de la superclase Auto
	 * 
	 * @param velocidad
	 * @param calle
	 * @param semaforoCubito
	 * @param modelo
	 * @param tipoDeCruce
	 * @param semaforoCubito2
	 * @param tipoDeCruce2
	 * @param esVerde
	 * @param semaforoDeMiCalle
	 * @param direccion
	 */
	public AutoCruceDoble(int velocidad,
			Semaphore semaforoCubito, String modelo, String tipoDeCruce,
			Semaphore semaforoCubito2, String tipoDeCruce2, Semaphore esVerde,
			Semaforo semaforoDeMiCalle, String direccion, String calle, int id) {
		super(velocidad, semaforoCubito, modelo, tipoDeCruce, esVerde,
				semaforoDeMiCalle, direccion, calle, id);
		this.semaforoPaso2 = semaforoCubito2;
		this.tipoDeCruce2 = tipoDeCruce2;

	}

	public void run(){
		try {
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
		

			this.semaforoPaso2.acquireUninterruptibly();
			this.semaforoPaso1.release();

			this.imprimirInformacion("  ocupe ");

			Thread.sleep(this.velocidad);
			this.semaforoPaso2.release();

			this.imprimirInformacion("  desocupe ");

			System.out.println(this.id + " " + this.modeloAuto + " "
					+ "  abandone el cruce ");
			

		} catch (Exception e) {
		}
	}

	/**
	 * Al irse, el auto libera las dos grillas que ocupo en su trayecto luego de
	 * haber avanzado al estar verde el semaforo.
	 */
	/*public synchronized void irse() {
		try {
			this.imprimirInformacion("  desocupe ");

			this.semaforoPaso2.acquireUninterruptibly();
			this.semaforoPaso1.release();

			this.imprimirInformacion("  ocupe ");

			Thread.sleep(this.velocidad);
			this.semaforoPaso2.release();

			this.imprimirInformacion("  desocupe ");

			System.out.println(this.id + " " + this.modeloAuto + " "
					+ "  abandone el cruce ");
		} catch (Exception e) {
		}
	}
*/
}
