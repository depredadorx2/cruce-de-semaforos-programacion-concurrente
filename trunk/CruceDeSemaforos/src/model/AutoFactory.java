package model;

import java.util.concurrent.Semaphore;

public class AutoFactory {

	/**
	 * Estas son variables de instancia que necesita AutoFactory para instanciar
	 * los autos. Los primeras 4 varibles representan cada grilla despues del de
	 * cruzar el semaforo y las ultimas 3, son semaforos que representan la cola
	 * de espera frente al semaforo fisico.
	 */
	public Semaphore sectorNO = new Semaphore(1);
	public Semaphore sectorNE = new Semaphore(1);
	public Semaphore sectorSO = new Semaphore(1);
	public Semaphore sectorSE = new Semaphore(1);
	public Semaphore esVerdeEste = new Semaphore(1, true);
	public Semaphore esVerdeOeste = new Semaphore(1, true);
	public Semaphore esVerdeSur = new Semaphore(1, true);

	/**
	 * Crea autos que se ubicaran en la calle Este, y luego de curzar el
	 * semaforo, ocuparan las grillas NorEste y NorOeste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleEste
	 * @param semaSuCalle
	 * @return
	 */
	public AutoCruceDoble makeAutoEO(int velocidad, String modelo,
			 Semaforo semaSuCalle, int id) {

		AutoCruceDoble auto = new AutoCruceDoble(velocidad, 
				this.sectorNE, modelo, "cruce fraccion NorEste ",
				this.sectorNO, "cruzando fraccion NorOeste ", esVerdeEste,
				semaSuCalle, "sigo derecho hacia el Oeste", "Este", id);
		return auto;
	}

	/**
	 * Crea autos que se ubican en la calle Este, luego de cruzar el semaforo
	 * ocuparan las grillas NorEste y SurOeste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleEste
	 * @param semaSuCalle
	 * @return
	 */
	public AutoCruceDoble makeAutoEOHaciaSur(int velocidad, String modelo,
			 Semaforo semaSuCalle, int id) {

		AutoCruceDoble auto = new AutoCruceDoble(velocidad,
				this.sectorNE, modelo, "cruce fraccion NorEste ",
				this.sectorSO, "cruzando fraccion SurOeste ", esVerdeEste,
				semaSuCalle, "giro a la izquierda", "Este", id);
		return auto;
	}

	/**
	 * Crea autos que se ubican en la calle Oeste, luego de cruzar el semaforo
	 * ocuparan las grillas SurOeste y SurEste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleOeste
	 * @param semaSuCalle
	 * @return
	 */
	public AutoCruceDoble makeAutoOE(int velocidad, String modelo,
			 Semaforo semaSuCalle, int id) {
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, 
				this.sectorSO, modelo, "cruce fraccion SurOeste ",
				this.sectorSE, "cruzando fraccion SurEste ", esVerdeOeste,
				semaSuCalle, "derecho hacia Este", "Oeste", id);
		return auto;
	}

	/**
	 * Crea autos que se ubican en la calle Sur, luego de cruzar el semaforo
	 * ocuparan las grillas SurEste y NorOeste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleSur
	 * @param semaSuCalle
	 * @return
	 */
	public AutoCruceDoble makeAutoSurHaciaIzquierda(int velocidad,
			String modelo, Semaforo semaSuCalle, int id) {

		AutoCruceDoble auto = new AutoCruceDoble(velocidad, 
				this.sectorSE, modelo, "cruce fraccion SurEste ",
				this.sectorNO, "cruzando fraccion NorOeste ", esVerdeSur,
				semaSuCalle, "giro a la izquierda", "Sur", id);
		return auto;
	}

	/**
	 * Crea autos que se ubican en la calle Oeste, luego de cruzar el semaforo
	 * ocupará la grilla SurOeste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleOeste
	 * @param semaSuCalle
	 * @return
	 */
	public Auto makeAutoOEHaciaSur(int velocidad, String modelo,
			 Semaforo semaSuCalle, int id) {

		Auto auto = new Auto(velocidad,  this.sectorSO, modelo,
				"cruce fraccion SurOeste", esVerdeOeste, semaSuCalle,
				"giro derecha", "Oeste", id);
		return auto;
	}

	/**
	 * Crea autos que se ubican en la calle Sur, luego de cruzar el semaforo
	 * ocupará la grilla SurEste
	 * 
	 * @param velocidad
	 * @param modelo
	 * @param calleSur
	 * @param semaSuCalle
	 * @return
	 */
	public Auto makeAutoSurHaciaDerecha(int velocidad, String modelo,
			 Semaforo semaSuCalle, int id) {

		Auto auto = new Auto(velocidad, this.sectorSE, modelo,
				"cruce fraccion SurEste", esVerdeSur, semaSuCalle,
				"giro derecha", "Sur", id);
		return auto;
	}

}
