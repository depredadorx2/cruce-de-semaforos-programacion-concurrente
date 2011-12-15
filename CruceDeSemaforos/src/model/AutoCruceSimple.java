package model;

import java.util.concurrent.Semaphore;


public class AutoCruceSimple extends Auto {
	/*Lock l = new ReentrantLock();
	Condition puedoCruzar = new
	*/
	public Semaphore permiso = new Semaphore(1, true);

	public AutoCruceSimple(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula, String tipoDeCruce) {
		super(velocidad,  calle, semaforoCubito,  modelo, matricula, tipoDeCruce);
		
	}
	
	@Override
	public synchronized void start(){
		try {
		this.unirmeAlTransito();
		System.out.println(this.modeloAuto+" "+this.matricula +"  estoy en transito, espero semaforo verde " + " calle " + this.calle.nombre);
		
			//wait(); //espero que al semaforo
		this.permiso.acquireUninterruptibly();
			
			
			System.out.println(this.modeloAuto+" "+this.matricula +"  cruce semaforo "+ " calle " + this.calle.nombre);
			
			super.semaforoPaso1.acquireUninterruptibly();
			
			System.out.println(this.modeloAuto+" "+this.matricula +"  ocupe " + this.tipoDeCruce);
			Thread.sleep(this.velocidad);
			this.semaforoPaso1.release();
			
			System.out.println(this.modeloAuto+" "+this.matricula +"  desocupe " + this.tipoDeCruce);
			
			
			
			
			
		} catch (Exception e) {}
	}

	public synchronized void curzar(){
		//notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
		this.permiso.release();
	}
	
	public void unirmeAlTransito(){
		this.calle.agregarAuto(this); //esta bien esto, porque no se si se agrega auto o se agregua el auto que lo invoca
		
	}
	
}
