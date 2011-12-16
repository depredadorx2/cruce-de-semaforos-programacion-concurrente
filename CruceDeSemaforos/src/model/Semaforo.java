package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaforo extends Thread {
	
	public String color;
	public String indentificacion;
	private Semaphore semaforoVerde;
	public Semaphore mutexBooleano = new Semaphore(1);
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
	public Semaforo(Semaphore semaforoVerde, String identificacion) {
		
		
		this.semaforoVerde = semaforoVerde;
		this.indentificacion = identificacion;
		
		
		
	}

/**
 * Primero pide turno para ser verde, luego libera al primer auto y espera para ser amarillo y despues rojo, para ser rojo tambien pide permiso 
 * para tomar uno de los semaforos
 */

	public void run(){
		
		
		try{
			while (true){
				this.semaforoVerde.acquireUninterruptibly();
				System.out.println("espero a ser verde "+ this.indentificacion);
		
		System.out.println("soy verde "+ this.indentificacion);
		mutexBooleano.acquireUninterruptibly(); 
		
		estaEnVerde=true;
		mutexBooleano.release(); 
		
		System.out.println(estaEnVerde +""+this.indentificacion);
		
		System.out.println("libero autos "+ this.indentificacion);
		
		getEsVerde().release();
		
	
		Thread.sleep(2000);
		
		this.color = "Amarillo";
		System.out.println("ojo, cambio a  amarillo "+ this.indentificacion);
		Thread.sleep(500);
		
		mutexBooleano.acquireUninterruptibly(); 
		estaEnVerde=false;
		mutexBooleano.release();
		
		System.out.println(estaEnVerde +""+this.indentificacion);

		
		this.semaforoVerde.release(); 
		System.out.println("soy rojo"+ this.indentificacion);
		
			}
		}
		catch(Exception e){}
		
		
	}
	

}
