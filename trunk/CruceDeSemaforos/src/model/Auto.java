package model;

import java.util.concurrent.Semaphore;




public abstract class Auto extends Thread{
	
	public int velocidad;
	public Semaphore semaforoPaso1;
	public Avenida calle;
	public String modeloAuto;
	public int matricula;
	public String tipoDeCruce;
	
	public Auto(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula, String tipoDeCruce) {
		
		this.velocidad = velocidad;
		this.semaforoPaso1 =  semaforoCubito;
		this.calle = calle;
		this.modeloAuto = modelo;
		this.matricula = matricula;
		this.tipoDeCruce = tipoDeCruce;
	}
	
	public void run(){}
	
	

	public void cruzar() {
		
		
	}
	
}
