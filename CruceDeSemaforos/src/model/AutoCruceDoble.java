package model;

import java.util.concurrent.Semaphore;

public class AutoCruceDoble extends Auto {
	
	private Semaphore semaforoPaso2;

	public AutoCruceDoble(int velocidad, Avenida calle) {
		super(velocidad, calle);
		this.semaforoPaso2= new Semaphore(1);
		
	}
	
	@Override
	public void start(){}

}
