package model;

import java.util.concurrent.Semaphore;


public class AutoCruceSimple extends Auto {
	
	

	public AutoCruceSimple(int velocidad,  Semaphore semaforoCubito, String modelo, String tipoDeCruce, Semaphore estoyPrimero,
			Semaforo semaforoDeMiCalle,  String direccion, String calle) {
		super(velocidad,  semaforoCubito,  modelo, tipoDeCruce, estoyPrimero, semaforoDeMiCalle,   direccion, calle);
		
	}
	
	@Override
	public synchronized void run(){
		try {
		this.unirmeAlTransito();
		
		
		this.estoyPrimero.acquireUninterruptibly();
		
		System.out.println(this.modeloAuto+" " +"  estoy en transito, espero semaforo verde " + " calle " + this.calle+" "+this.direccion);
		
		if (! (this.semaforoDeMiCalle.getEstaEnVerde())) {
			this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
		}
		
		
			
			
			System.out.println(this.modeloAuto+" "+"  cruce semaforo "+ " calle " + this.calle+" "+this.direccion);
			
			this.semaforoPaso1.acquireUninterruptibly();
			
			
			
			System.out.println(this.modeloAuto+" "+"  ocupe " + this.tipoDeCruce+" "+this.direccion);
			Thread.sleep(this.velocidad);
			this.estoyPrimero.release();

			System.out.println(this.modeloAuto+" "+"  desocupe " + this.tipoDeCruce+" "+this.direccion);
			
			this.semaforoPaso1.release();
			
			
			System.out.println(this.modeloAuto+" "+"  abandone el cruce ");
			
			
			
		} catch (Exception e) {}
	}



	
}
