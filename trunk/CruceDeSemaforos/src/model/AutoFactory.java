package model;

import java.util.concurrent.Semaphore;


public class AutoFactory {
	
	
	private Semaphore sectorNO = new Semaphore(1);
	private Semaphore sectorNE = new Semaphore(1);
	private Semaphore sectorSO = new Semaphore(1);
	private Semaphore sectorSE = new Semaphore(1);
	public Semaphore esVerdeEste = new Semaphore(1, true);
	public Semaphore esVerdeOeste = new Semaphore(1, true);
	public Semaphore esVerdeSur = new Semaphore(1, true);
	
	
	public AutoCruceDoble makeAutoEO(int velocidad,String  modelo, int matricula, Avenida calleEste, Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleEste, this.sectorNE, modelo, matricula, "cruce fraccion NorEste " , this.sectorNO, "cruzando fraccion NorOeste " , esVerdeEste, semaSuCalle, "sigo derecho hacia el Oeste"  );
		return auto;}
	
	public AutoCruceDoble makeAutoEOHaciaSur(int velocidad,String  modelo, int matricula, Avenida calleEste, Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleEste, this.sectorNE, modelo, matricula, "cruce fraccion NorEste " , this.sectorSO, "cruzando fraccion SurOeste ", esVerdeEste, semaSuCalle,"giro a la izquierda"   );
		return auto;}
	
	public AutoCruceDoble makeAutoOE(int velocidad,String  modelo, int matricula, Avenida calleOeste, Semaforo semaSuCalle ){
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleOeste, this.sectorSO, modelo, matricula, "cruce fraccion SurOeste " , this.sectorSE, "cruzando fraccion SurEste ", esVerdeOeste, semaSuCalle,  "derecho hacia Este"  );
		return auto;}
	
	public AutoCruceDoble makeAutoSurHaciaIzquierda(int velocidad,String  modelo, int matricula,  Avenida calleSur, Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleSur, this.sectorSE, modelo, matricula, "cruce fraccion SurEste " , this.sectorNO, "cruzando fraccion NorOeste ", esVerdeSur, semaSuCalle,  "giro a la izquierda"  );
		return auto;}
	
	public AutoCruceSimple makeAutoOEHaciaSur(int velocidad,String  modelo, int matricula, Avenida calleOeste, Semaforo semaSuCalle ){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, calleOeste, this.sectorSO, modelo, matricula, "cruce fraccion SurOeste", esVerdeOeste, semaSuCalle, "giro derecha" );
		return auto;}
	
	public AutoCruceSimple makeAutoSurHaciaDerecha(int velocidad,String  modelo, int matricula, Avenida calleSur, Semaforo semaSuCalle){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, calleSur, this.sectorSE, modelo, matricula, "cruce fraccion SurEste", esVerdeSur, semaSuCalle,  "giro derecha" );
		return auto;}
	

}
