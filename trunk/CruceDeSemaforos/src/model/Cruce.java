package model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cruce {
	
	private Lock semaforoEsquinaNE = new ReentrantLock();
	private Lock semaforoEsquinaSE = new ReentrantLock();
	private Lock semaforoEsquinaSO = new ReentrantLock();
	private Avenida calleOeste = new Avenida();
	private Avenida calleSur = new Avenida();
	private Avenida calleEste = new Avenida();
	
	
	
	
	
	public void inicializarCruce(){}
	

}
