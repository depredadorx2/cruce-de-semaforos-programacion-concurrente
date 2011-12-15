package model;

import java.util.concurrent.Semaphore;


public class AutoFactory {
	
	
	private Semaphore semaforoNO = new Semaphore(1);
	private Semaphore semaforoNE = new Semaphore(1);
	private Semaphore semaforoSO = new Semaphore(1);
	private Semaphore semaforoSE = new Semaphore(1);
	
	
	public AutoCruceDoble makeAutoEO(int velocidad,String  modelo, int matricula, Avenida calleEste ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleEste, this.semaforoNE, modelo, matricula, "cruce fraccion NorEste " , this.semaforoNO, "cruzando fraccion NorOeste " );
		return auto;}
	
	public AutoCruceDoble makeAutoEOHaciaSur(int velocidad,String  modelo, int matricula, Avenida calleEste){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleEste, this.semaforoNE, modelo, matricula, "cruce fraccion NorEste " , this.semaforoSO, "cruzando fraccion SurOeste " );
		return auto;}
	
	public AutoCruceDoble makeAutoOE(int velocidad,String  modelo, int matricula, Avenida calleOeste){
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleOeste, this.semaforoSO, modelo, matricula, "cruce fraccion SurOeste " , this.semaforoSE, "cruzando fraccion SurEste " );
		return auto;}
	
	public AutoCruceDoble makeAutoSurHaciaIzquierda(int velocidad,String  modelo, int matricula,  Avenida calleSur ){
		
		AutoCruceDoble auto = new AutoCruceDoble(velocidad, calleSur, this.semaforoSE, modelo, matricula, "cruce fraccion SurEste " , this.semaforoNO, "cruzando fraccion NorOeste " );
		return auto;}
	
	public AutoCruceSimple makeAutoOEHaciaSur(int velocidad,String  modelo, int matricula, Avenida calleOeste){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, calleOeste, this.semaforoSO, modelo, matricula, "cruce fraccion SurOeste");
		return auto;}
	
	public AutoCruceSimple makeAutoSurHaciaDerecha(int velocidad,String  modelo, int matricula, Avenida calleSur){
		
		AutoCruceSimple auto = new AutoCruceSimple(velocidad, calleSur, this.semaforoSE, modelo, matricula, "cruce fraccion SurEste");
		return auto;}
	

}
