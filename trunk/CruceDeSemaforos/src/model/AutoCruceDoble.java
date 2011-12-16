package model;

import java.util.concurrent.Semaphore;

public class AutoCruceDoble extends Auto {
	
	public Semaphore semaforoPaso2;
	public String tipoDeCruce2;

	public AutoCruceDoble(int velocidad, Avenida calle, Semaphore semaforoCubito, String modelo, int matricula,String tipoDeCruce , 
			Semaphore semaforoCubito2, String tipoDeCruce2, Semaphore esVerde, Semaforo semaforoDeMiCalle,  String direccion) {
		super(velocidad,  calle,  semaforoCubito,  modelo,  matricula, tipoDeCruce, esVerde, semaforoDeMiCalle,    direccion);
		this.semaforoPaso2 = semaforoCubito2;
		this.tipoDeCruce2 = tipoDeCruce2;
		
		
	}
	
	@Override
	public void start(){
		try {
			this.unirmeAlTransito();
			
			
			
			this.estoyPrimero.acquireUninterruptibly();
			
			System.out.println(this.id +" " +this.modeloAuto+" "+"  estoy en transito, espero semaforo verde " + " calle " + this.calle.nombre+" "+this.direccion);
			
			if (! (this.semaforoDeMiCalle.getEstaEnVerde())) {
				this.semaforoDeMiCalle.getEsVerde().acquireUninterruptibly();
			}
			
			
				
				
				System.out.println(this.id +" " +this.modeloAuto+" "+"  cruce semaforo "+ " calle " + this.calle.nombre+" "+this.direccion);
				
				this.semaforoPaso1.acquireUninterruptibly();
				System.out.println(this.id +" " +this.modeloAuto+" " +"  ocupe " + this.tipoDeCruce+" "+this.direccion);
				Thread.sleep(this.velocidad);

				this.estoyPrimero.release();
				

				//this.semaforoDeMiCalle.getEsVerde().release();
				
				
				
				System.out.println(this.id +" " +this.modeloAuto+" " +"  desocupe " + this.tipoDeCruce+" "+this.direccion);
				this.semaforoPaso2.acquireUninterruptibly();
				this.semaforoPaso1.release();
				
				System.out.println(this.id +" " +this.modeloAuto+" " +"  ocupe " + this.tipoDeCruce2+" "+this.direccion);
				Thread.sleep(this.velocidad);
				this.semaforoPaso2.release();
				System.out.println(this.id +" " +this.modeloAuto+" " +"  desocupe " + this.tipoDeCruce2+" "+this.direccion);
				
				System.out.println(this.id +" " +this.modeloAuto+" "+"  abandone el cruce ");
				
			} catch (Exception e) {}
		
	}
	
	/*public synchronized void curzar(){
		notify(); // esto lo hace fair? o sea, libera al auto que realmente esta primero?
	}*/
	
	public void unirmeAlTransito(){
		System.out.println(this.id +" " +this.modeloAuto+" " +"  estoy en transito " + " calle " + this.calle.nombre);
		
	}

}
