package model;

import java.util.concurrent.Semaphore;


public class AutoCruceSimple extends Auto {
	/*Lock l = new ReentrantLock();
	Condition puedoCruzar = new
	*/

	public AutoCruceSimple(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula, String tipoDeCruce) {
		super(velocidad,  calle, semaforoCubito,  modelo, matricula, tipoDeCruce);
		
	}
	
	@Override
	public synchronized void start(){
		try {
		this.unirmeAlTransito();
		System.out.println(super.modeloAuto+" "+super.matricula +"  estoy en transito, espero semaforo verde " + " calle " + super.calle.nombre);
		
			wait(); //espero que al semaforo
			
			
			System.out.println(super.modeloAuto+" "+super.matricula +"  cruce semaforo "+ " calle " + super.calle.nombre);
			
			super.semaforoPaso1.acquireUninterruptibly();
			
			System.out.println(super.modeloAuto+" "+super.matricula +"  ocupe " + super.tipoDeCruce);
			Thread.sleep(super.velocidad);
			super.semaforoPaso1.release();
			
			System.out.println(super.modeloAuto+" "+super.matricula +"  desocupe " + super.tipoDeCruce);
			
			
			
			
			
		} catch (Exception e) {}
	}

	public synchronized void curzar(){
		notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
	}
	
}
