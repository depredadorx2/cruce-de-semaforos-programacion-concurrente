package model;

import java.util.concurrent.Semaphore;


public class AutoCruceSimple extends Auto {
	/*Lock l = new ReentrantLock();
	Condition puedoCruzar = new
	*/
	

	public AutoCruceSimple(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula, String tipoDeCruce, Semaphore estoyPrimero,
			Semaforo semaforoDeMiCalle,  String direccion) {
		super(velocidad,  calle, semaforoCubito,  modelo, matricula, tipoDeCruce, estoyPrimero, semaforoDeMiCalle,   direccion);
		
	}
	
	@Override
	public synchronized void start(){
		try {
		this.unirmeAlTransito();
		
		
		this.estoyPrimero.acquireUninterruptibly();
		
		System.out.println(this.id +" " +this.modeloAuto+" " +"  estoy en transito, espero semaforo verde " + " calle " + this.calle.nombre+" "+this.direccion);
		
		if (! (this.semaforoDeMiCalle.getEstaEnVerde())) {
			this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
		}
		
		
			
			
			System.out.println(this.id +" " +this.modeloAuto+" "+"  cruce semaforo "+ " calle " + this.calle.nombre+" "+this.direccion);
			
			this.semaforoPaso1.acquireUninterruptibly();
			
			//this.semaforoDeMiCalle.getEsVerde().release();
			
			System.out.println(this.id +" " +this.modeloAuto+" "+"  ocupe " + this.tipoDeCruce+" "+this.direccion);
			Thread.sleep(this.velocidad);
			this.estoyPrimero.release();

			System.out.println(this.id +" " +this.modeloAuto+" "+"  desocupe " + this.tipoDeCruce+" "+this.direccion);
			
			this.semaforoPaso1.release();
			
			
			System.out.println(this.id +" " +this.modeloAuto+" "+"  abandone el cruce ");
			
			
			
		} catch (Exception e) {}
	}

	/*public synchronized void curzar(){
		//notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
		this.esperoVerde.release();
	}
	*/
	public synchronized void unirmeAlTransito(){
		//this.calle.agregarAuto(this); //esta bien esto, porque no se si se agrega auto o se agregua el auto que lo invoca
		System.out.println(this.id +" " +this.modeloAuto+" "+"  estoy en transito " + " calle " + this.calle.nombre+" "+this.direccion);
		
	}
	
	public synchronized void soyPrimero(){
		
	}
	
}
