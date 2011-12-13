package model;

import java.util.concurrent.locks.Lock;

public class Semaforo extends Thread {
	
	private String color;
	private Lock turno;
	
	
	
	public Semaforo(String color, Lock turno) {
		
		this.color = color;
		this.turno = turno;
	}



	public void run(){}

}
