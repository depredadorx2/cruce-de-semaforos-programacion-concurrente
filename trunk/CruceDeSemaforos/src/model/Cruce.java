package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;



public class Cruce {
	
	
	Semaphore semaforoVerde = new Semaphore(1, true);
	List<String> modelos = new ArrayList<String>();
	AutoFactory factory= new AutoFactory();
	Semaforo semaforoEste = new Semaforo(semaforoVerde, "semaforo Este");
	Semaforo semaforoOeste = new Semaforo(semaforoVerde, "semaforo Oeste");
	Semaforo semaforoSur = new Semaforo(semaforoVerde, "semaforo Sur");
	
	
	public void inicializarCruce(){
		
		semaforoEste.start();
		semaforoOeste.start();
		semaforoSur.start();
		
		inicializarModelos();

		iniciarAutoEO();
		iniciarAutoEOHaciaSur();
		iniciarAutoOE();
		iniciarAutoOEHaciaSur();
		iniciarAutoSurHaciaDerecha();
		iniciarAutoSurHaciaIzquierda();
			
	}
	
	
	
	
	public void inicializarModelos(){
		
		String modelo1= "Kia Sorento";
		String modelo2= "Chevrolet Corsa";
		String modelo3= "Subaru Impresa";
		String modelo4= "Fiat Punto";
		String modelo5= "VW Vento";
		String modelo6= "BMW Serie 3";
		String modelo7= "Audi TT";
		String modelo8= "Mitsubishi Lancer Evolution";
		
		modelos.add(modelo8);
		modelos.add(modelo7);
		modelos.add(modelo6);
		modelos.add(modelo5);
		modelos.add(modelo4);
		modelos.add(modelo3);
		modelos.add(modelo2);
		modelos.add(modelo1);
		
	}
	
	public synchronized void iniciarAutoEO(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoEO(velocidad, modelo, semaforoEste, i);
			auto.start();
			}
		}
	
	public synchronized void iniciarAutoEOHaciaSur(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoEOHaciaSur(velocidad, modelo, semaforoEste, i + 1001);
			auto.start();
			}
		}
	
	public synchronized void iniciarAutoOE(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoOE(velocidad, modelo, semaforoOeste, i + 2001);
			auto.start();
			}
		}
	
	public synchronized void iniciarAutoSurHaciaIzquierda(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoSurHaciaIzquierda(velocidad, modelo, semaforoSur, i + 3001);
			auto.start();
			}
		}
	
	public synchronized void iniciarAutoOEHaciaSur(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoOEHaciaSur(velocidad, modelo, semaforoOeste, i + 4001);
			auto.start();
			}
		}
	
	public synchronized void iniciarAutoSurHaciaDerecha(){
		for (int i = 0; i < 1000; i++) {
			
			int velocidad = ((int) Math.floor(Math.random()*(50-10+1)+10));
			String modelo = modelos.get(new Random().nextInt(7));
			
			Auto auto = factory.makeAutoSurHaciaDerecha(velocidad, modelo, semaforoSur, i + 5001);
			auto.start();
			}
		}
	
	
	
	public static void main(String[] args) {
		Cruce cruce = new Cruce();
		cruce.inicializarCruce();
		
	}
	

}
