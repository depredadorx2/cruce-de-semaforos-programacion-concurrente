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
			System.out.println(this.modeloAuto+" "+this.matricula +"  estoy en transito, espero semaforo verde "+ " calle " + this.calle.nombre);
			
				wait(); //espero que al semaforo
				
				System.out.println(this.modeloAuto+" "+this.matricula +"  cruce semaforo " + " calle " + this.calle.nombre);
				
				this.semaforoPaso1.acquireUninterruptibly();
				
				System.out.println(this.modeloAuto+" "+this.matricula +"  ocupe " + this.tipoDeCruce);
				Thread.sleep(this.velocidad);
				this.semaforoPaso1.release();
				
				System.out.println(this.modeloAuto+" "+this.matricula +"  desocupe " + this.tipoDeCruce);
				
				this.semaforoPaso2.acquireUninterruptibly();
				System.out.println(this.modeloAuto+" "+this.matricula +"  ocupe " + this.tipoDeCruce2);
				Thread.sleep(this.velocidad);
				this.semaforoPaso2.release();
				System.out.println(this.modeloAuto+" "+this.matricula +"  desocupe " + this.tipoDeCruce2);
				
				
				
			} catch (Exception e) {}
		
	}
	
	public synchronized void curzar(){
		notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
	}
	
	public void unirmeAlTransito(){
		this.calle.agregarAuto(this); //esta bien esto, porque no se si se agrega auto o se agregua el auto que lo invoca
		
	}

}
