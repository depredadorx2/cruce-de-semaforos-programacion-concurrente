package model;

import java.util.concurrent.Semaphore;




public abstract class Auto extends Thread{
	
	public int velocidad;
	public Semaphore semaforoPaso1;
	public Avenida calle;
	public String modeloAuto;
	public int matricula;
	public String tipoDeCruce;
	public Semaphore estoyPrimero;
	public Semaforo semaforoDeMiCalle;
	public int id;
	public String direccion;
	
	public Auto(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula, String tipoDeCruce, Semaphore estoyPrimero, Semaforo semaforoDeMiCalle,
			 String direccion) {
		
		this.velocidad = velocidad;
		this.semaforoPaso1 =  semaforoCubito;
		this.calle = calle;
		this.modeloAuto = modelo;
		this.matricula = matricula;
		this.tipoDeCruce = tipoDeCruce;
		this.estoyPrimero = estoyPrimero;
		this.semaforoDeMiCalle = semaforoDeMiCalle;
		
		this.direccion = direccion;
	}
	
	public void setId(int numero){
		this.id = numero;
	}
	
	public void run(){}
	
	

	public void cruzar() {
		
		
	}
	
}
