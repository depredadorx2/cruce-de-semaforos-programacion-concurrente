package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaforo extends Thread {
	
	public String color;
	public String indentificacion;
	private Semaphore semaforoVerde;
	private Semaphore semaforoRojo;
	public   Avenida calle;
	public Semaphore mutexBoleano = new Semaphore(1);
	public static Lock l = new ReentrantLock();
	public static Condition esperarVerde = l.newCondition();
	public Boolean estaEnVerde= false;
	public Semaphore esVerde = new Semaphore(0);
	
	
	public Boolean getEstaEnVerde() {
		return estaEnVerde;
	}

	
	
	
	/**
	 * Semaforo que deja pasar si es verde
	 * @return
	 */
	public Semaphore getEsVerde() {
		return esVerde;
	}

	/**
	 * Constructor de un semafror de esquina.
	 * @param semaforoVerde
	 * @param semaforoRojo
	 * @param calle
	 */
	public Semaforo(Semaphore semaforoVerde, Semaphore semaforoRojo, Avenida calle, String identificacion) {
		
		
		this.semaforoVerde = semaforoVerde;
		this.semaforoRojo=semaforoRojo;
		this.calle=calle;
		this.indentificacion = identificacion;
		
		
		
	}

/**
 * Primero pide turno para ser verde, luego libera al primer auto y espera para ser amarillo y despues rojo, para ser rojo tambien pide permiso 
 * para tomar uno de los semaforos
 */

	public void run(){
		//sema.start();
		
		try{
			while (true){
				this.semaforoVerde.acquireUninterruptibly(); //pido para ser verde
				System.out.println("espero a ser verde "+ this.indentificacion);
		
		System.out.println("soy verde "+ this.indentificacion);
		mutexBoleano.acquireUninterruptibly(); //protejo el boleano
		
		estaEnVerde=true;
		mutexBoleano.release(); 
		
		System.out.println(estaEnVerde +""+this.indentificacion);
		
		System.out.println("libero autos "+ this.indentificacion);
		
		getEsVerde().release();
		
		//esperarVerde.signal(); //libero mi thread liberador de autos
		//this.calle.puedenCruzar();
		
		//System.out.println("libere "+ this.indentificacion); 
		
		
		Thread.sleep(2000);
		
		this.color = "Amarillo";
		System.out.println("ojo, cambio a  amarillo "+ this.indentificacion);
		Thread.sleep(500);
		
		mutexBoleano.acquireUninterruptibly(); //cambio el booleano para que dejen de pasar autos
		estaEnVerde=false;
		mutexBoleano.release();
		
		System.out.println(estaEnVerde +""+this.indentificacion);

		
		this.semaforoVerde.release(); //libero el semaforo verde
		System.out.println("soy rojo"+ this.indentificacion);
		//this.semaforoRojo.acquireUninterruptibly(); //ahora soy rojo
			}
		}
		catch(Exception e){}
		
		
	}
	
	
	
	/*public static class SemaforoLiberadorDeAutos extends Thread{
		
		public void run(){
			
			l.lock();
			try{
			while(true){
				System.out.println("ayudante, esperando a liberar autos ");
				esperarVerde.await();
				while(estaEnVerde){
					System.out.println("libero  ");
					calle.puedenCruzar(); // este esta adefinido en calle, lo que hace es a su primer auto lo libera
				}
				
				
				
			}
			
		}
		
		catch(Exception e){}
	  finally{l.unlock();}
		} 
}
*/
}
