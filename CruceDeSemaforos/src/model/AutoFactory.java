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
	
	
	public AutoCruceDoble makeAutoEO(int velocidad,String  modelo, Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, this.sectorNE, modelo, "cruce fraccion NorEste " , this.sectorNO, "cruzando fraccion NorOeste " , esVerdeEste, semaSuCalle, "sigo derecho hacia el Oeste", "Este"  );
		return auto;}
	
	public AutoCruceDoble makeAutoEOHaciaSur(int velocidad,String  modelo,  Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, this.sectorNE, modelo, "cruce fraccion NorEste " , this.sectorSO, "cruzando fraccion SurOeste ", esVerdeEste, semaSuCalle,"giro a la izquierda", "Este"   );
		return auto;}
	
	public AutoCruceDoble makeAutoOE(int velocidad,String  modelo, Semaforo semaSuCalle ){
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, this.sectorSO, modelo, "cruce fraccion SurOeste " , this.sectorSE, "cruzando fraccion SurEste ", esVerdeOeste, semaSuCalle,  "derecho hacia Este", "Oeste"  );
		return auto;}
	
	public AutoCruceDoble makeAutoSurHaciaIzquierda(int velocidad,String  modelo,   Semaforo semaSuCalle ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad,  this.sectorSE, modelo, "cruce fraccion SurEste " , this.sectorNO, "cruzando fraccion NorOeste ", esVerdeSur, semaSuCalle,  "giro a la izquierda", "Sur"  );
		return auto;}
	
	public AutoCruceSimple makeAutoOEHaciaSur(int velocidad,String  modelo, Semaforo semaSuCalle ){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, this.sectorSO, modelo, "cruce fraccion SurOeste", esVerdeOeste, semaSuCalle, "giro derecha", "Oeste" );
		return auto;}
	
	public AutoCruceSimple makeAutoSurHaciaDerecha(int velocidad,String  modelo,Semaforo semaSuCalle){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, this.sectorSE, modelo, "cruce fraccion SurEste", esVerdeSur, semaSuCalle,  "giro derecha", "Sur" );
		return auto;}
	

}
