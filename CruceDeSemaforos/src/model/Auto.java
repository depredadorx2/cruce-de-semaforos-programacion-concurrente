package model;

import java.util.concurrent.Semaphore;




public abstract class Auto extends Thread{
	
	private int velocidad;
	private Semaphore semaforoPaso1;
	private Avenida calle;
	
	public Auto(int velocidad, Avenida calle) {
		super();
		this.velocidad = velocidad;
		this.semaforoPaso1 =  new Semaphore(1);
		this.calle = calle;
	}
	
	public void run(){}
	
	
}
