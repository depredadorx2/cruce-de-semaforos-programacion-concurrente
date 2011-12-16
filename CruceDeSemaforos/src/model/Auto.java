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
	 * Genera el id para cada auto.
	 * 
	 * @return
	 */
	public int generarId() {
		int numero = Auto.fabricaId;
		Auto.fabricaId++;
		return numero;
	}

	/**
	 * metodo run del thread, esta plasmado todo el comportamiento de un auto,
	 * desde que entra en circulacion hasta que sale de ella.
	 */
	public synchronized void run() {
		try {
			this.unirmeAlTransito();
			this.esperarVerde();
			this.avanzar();
			this.irse();

		} catch (Exception e) {
		}
	}

	/**
	 * Hace que el auto se inicie en el transito, solamente con una impresion.
	 */
	public void unirmeAlTransito() {
		this.imprimirInformacion("  estoy en transito ");

	}

	/**
	 * Toma un recurso del semaforo que simula la cola de espera, como es fair
	 * tiene que esperar su turno. Si pasa se fija si el semaforo esta en verde
	 * y si es asi avanza.
	 */
	public void esperarVerde() {
		this.estoyPrimero.acquireUninterruptibly();

		this.imprimirInformacion("  estoy en transito, espero semaforo verde ");

		if (!(this.semaforoDeMiCalle.getEstaEnVerde())) {
			this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
		}

		this.imprimirInformacion("  cruce semaforo ");

	}

	/**
	 * Entra en el cruce centrar, y consume la primera gruilla, simulada con un
	 * semaforo.
	 */
	public void avanzar() {
		try {
			this.semaforoPaso1.acquireUninterruptibly();
			System.out.println(this.id + " " + this.modeloAuto + " "
					+ "  ocupe " + this.tipoDeCruce + " " + this.direccion);

			Thread.sleep(this.velocidad);
			this.estoyPrimero.release();
		} catch (Exception e) {
		}

	}

	/**
	 * Lo redefinen las subclases
	 */
	private void irse() {
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
