package model;

import java.util.concurrent.Semaphore;

public class AutoCruceDoble extends Auto {
	
	public Semaphore semaforoPaso2;
	public String tipoDeCruce2;

	public AutoCruceDoble(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula,String tipoDeCruce , Semaphore semaforoCubito2, String tipoDeCruce2) {
		super(velocidad,  calle,  semaforoCubito,  modelo,  matricula, tipoDeCruce);
		this.semaforoPaso2 = semaforoCubito2;
		this.tipoDeCruce2 = tipoDeCruce2;
		
		
	}
	
	@Override
	public void start(){
		try {
			this.unirmeAlTransito();
			System.out.println(super.modeloAuto+" "+super.matricula +"  estoy en transito, espero semaforo verde "+ " calle " + super.calle.nombre);
			
				wait(); //espero que al semaforo
				
				System.out.println(super.modeloAuto+" "+super.matricula +"  cruce semaforo " + " calle " + super.calle.nombre);
				
				super.semaforoPaso1.acquireUninterruptibly();
				
				System.out.println(super.modeloAuto+" "+super.matricula +"  ocupe " + super.tipoDeCruce);
				Thread.sleep(super.velocidad);
				super.semaforoPaso1.release();
				
				System.out.println(super.modeloAuto+" "+super.matricula +"  desocupe " + super.tipoDeCruce);
				
				this.semaforoPaso2.acquireUninterruptibly();
				System.out.println(super.modeloAuto+" "+super.matricula +"  ocupe " + this.tipoDeCruce2);
				Thread.sleep(super.velocidad);
				this.semaforoPaso2.release();
				System.out.println(super.modeloAuto+" "+super.matricula +"  desocupe " + this.tipoDeCruce2);
				
				
				
			} catch (Exception e) {}
		
	}
	
	public synchronized void curzar(){
		notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
	}
	

}
