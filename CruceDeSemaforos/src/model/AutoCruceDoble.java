package model;

import java.util.concurrent.Semaphore;

public class AutoCruceDoble extends Auto {
	
	public Semaphore semaforoPaso2;
	public String tipoDeCruce2;

	public AutoCruceDoble(int velocidad,  Semaphore semaforoCubito, String modelo, String tipoDeCruce , 
			Semaphore semaforoCubito2, String tipoDeCruce2, Semaphore esVerde, Semaforo semaforoDeMiCalle,  String direccion, String calle) {
		super(velocidad,  semaforoCubito,  modelo,  tipoDeCruce, esVerde, semaforoDeMiCalle,    direccion, calle);
		this.semaforoPaso2 = semaforoCubito2;
		this.tipoDeCruce2 = tipoDeCruce2;
		
		
	}
	
	@Override
	public void run(){
		try {
			this.unirmeAlTransito();
			
			
			
			this.estoyPrimero.acquireUninterruptibly();
			
			System.out.println(this.modeloAuto+" "+"  estoy en transito, espero semaforo verde " + " calle " + this.calle+" "+this.direccion);
			
			if (! (this.semaforoDeMiCalle.getEstaEnVerde())) {
				this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
			}
			
			
				
				
				System.out.println(this.modeloAuto+" "+"  cruce semaforo "+ " calle " + this.calle+" "+this.direccion);
				
				this.semaforoPaso1.acquireUninterruptibly();
				System.out.println(this.modeloAuto+" " +"  ocupe " + this.tipoDeCruce+" "+this.direccion);
				Thread.sleep(this.velocidad);

				this.estoyPrimero.release();
				
                System.out.println(this.modeloAuto+" " +"  desocupe " + this.tipoDeCruce+" "+this.direccion);
				this.semaforoPaso2.acquireUninterruptibly();
				this.semaforoPaso1.release();
				
				System.out.println(this.modeloAuto+" " +"  ocupe " + this.tipoDeCruce2+" "+this.direccion);
				Thread.sleep(this.velocidad);
				this.semaforoPaso2.release();
				System.out.println(this.modeloAuto+" " +"  desocupe " + this.tipoDeCruce2+" "+this.direccion);
				
				System.out.println(this.modeloAuto+" "+"  abandone el cruce ");
				
			} catch (Exception e) {}
		
	}
	
	
	

}
