package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AutoFactory {
	
	private Lock semaforoEsquinaNE = new ReentrantLock();
	private Lock semaforoEsquinaSE = new ReentrantLock();
	private Lock semaforoEsquinaSO = new ReentrantLock();
	private Semaphore semaforoNO = new Semaphore(1);
	private Semaphore semaforoNE = new Semaphore(1);
	private Semaphore semaforoSO = new Semaphore(1);
	private Semaphore semaforoSE = new Semaphore(1);
	private Avenida calleOeste = new Avenida();
	private Avenida calleSur = new Avenida();
	private Avenida calleEste = new Avenida();
	
	public AutoCruceDoble makeAutoEO(){
		return null;}
	
	public AutoCruceDoble makeAutoEOHaciaSur(){
		return null;}
	
	public AutoCruceDoble makeAutoOE(){
		return null;}
	
	public AutoCruceDoble makeAutoSurHaciaIzquierda(){
		return null;}
	
	public AutoCruceSimple makeAutoOEHaciaSur(){
		return null;}
	
	public AutoCruceSimple makeAutoSurHaciaDerecha(){
		return null;}
	

}
