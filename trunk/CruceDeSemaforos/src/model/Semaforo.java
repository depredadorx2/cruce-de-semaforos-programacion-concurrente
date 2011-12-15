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
	public static  Avenida calle;
	public Semaphore mutexBoleano = new Semaphore(1);
	public static Lock l = new ReentrantLock();
	public static Condition esperarVerde = l.newCondition();
	public static Boolean estaEnVerde = true;
	public SemaforoLiberadorDeAutos sema = new SemaforoLiberadorDeAutos();
	
	/**
	 * Constructor de un semafror de esquina.
	 * @param semaforoVerde
	 * @param semaforoRojo
	 * @param calle
	 */
	public Semaforo(Semaphore semaforoVerde, Semaphore semaforoRojo, Avenida calle, String identificacion) {
		
		
		this.semaforoVerde = semaforoVerde;
		this.semaforoRojo=semaforoRojo;
		Semaforo.calle=calle;
		this.indentificacion = identificacion;
		
		
		
	}

/**
 * Primero pide turno para ser verde, luego libera al primer auto y espera para ser amarillo y despues rojo, para ser rojo tambien pide permiso 
 * para tomar uno de los semaforos
 */

	public void run(){
		sema.start();
		
		try{
			while (true){
				System.out.println("espero a ser verde "+ this.indentificacion);
		this.semaforoVerde.acquireUninterruptibly(); //pido para ser verde
		
		System.out.println("soy verde "+ this.indentificacion);
		mutexBoleano.acquireUninterruptibly(); //protejo el boleano
		
		estaEnVerde=true;
		
		esperarVerde.signal(); //libero mi thread liberador de autos
		mutexBoleano.release();  
		
		
		Thread.sleep(2000);
		
		this.color = "Amarillo";
		
		Thread.sleep(400);
		
		mutexBoleano.acquireUninterruptibly(); //cambio el booleano para que dejen de pasar autos
		estaEnVerde=false;
		mutexBoleano.release();
		
		this.semaforoVerde.release(); //libero el semaforo verde
		this.semaforoRojo.acquireUninterruptibly(); //ahora soy rojo
			}
		}
		catch(Exception e){}
		
		
	}
	
	public static class SemaforoLiberadorDeAutos extends Thread{
		
		public void run(){
			
			l.lock();
			try{
			while(true){
				while(estaEnVerde){
					calle.puedenCruzar(); // este esta adefinido en calle, lo que hace es a su primer auto lo libera
				}
				
				esperarVerde.await();
				
			}
			
		}
		
		catch(Exception e){}
	  l.unlock();
		} 
}
}
