package model;

import java.util.concurrent.Semaphore;




public abstract class Auto extends Thread{
	
	public int velocidad;
	public Semaphore semaforoPaso1;
	public String modeloAuto;
	public String tipoDeCruce;
	public Semaphore estoyPrimero;
	public Semaforo semaforoDeMiCalle;
	public String direccion;
	public String calle;
	
	public Auto(int velocidad,  Semaphore semaforoCubito, String modelo, String tipoDeCruce, Semaphore estoyPrimero, Semaforo semaforoDeMiCalle,
			 String direccion, String calle) {
		
		this.velocidad = velocidad;
		this.semaforoPaso1 =  semaforoCubito;
		this.modeloAuto = modelo;
		this.tipoDeCruce = tipoDeCruce;
		this.estoyPrimero = estoyPrimero;
		this.semaforoDeMiCalle = semaforoDeMiCalle;
		this.direccion = direccion;
		this.calle = calle;
	}
	
	
	public void run(){}
	
	public void unirmeAlTransito(){
		System.out.println(this.modeloAuto+" " +"  estoy en transito " + " calle " + this.calle);
		
	}
}
