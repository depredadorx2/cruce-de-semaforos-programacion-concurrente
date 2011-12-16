package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;



public class Cruce {
	
	
	private Avenida calleOeste = new Avenida("oeste");
	private Avenida calleSur = new Avenida("Sur");
	private Avenida calleEste = new Avenida("Este");
	private Semaphore semaforoVerde = new Semaphore(1, true);
	private Semaphore semaforoRojo = new Semaphore(2, true);
	
	
	
	
	
	
	
	public void inicializarCruce(){
		
		Semaforo semaforoEste = new Semaforo(semaforoVerde, semaforoRojo, calleEste, "semaforo Este");
		Semaforo semaforoOeste = new Semaforo(semaforoVerde, semaforoRojo, calleOeste, "semaforo Oeste");
		Semaforo semaforoSur = new Semaforo(semaforoVerde, semaforoRojo, calleSur, "semaforo Sur");
		
		AutoFactory factory= new AutoFactory();
		List<Avenida> calles = new ArrayList<Avenida>();
		calles.add(calleEste);
		calles.add(calleOeste);
		calles.add(calleSur);
		
		List<String> modelos = new ArrayList<String>();
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
		
		
		
		List<Auto> autos = new ArrayList<Auto>();
		autos.add(factory.makeAutoEO(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleEste, semaforoEste));
		autos.add(factory.makeAutoEOHaciaSur(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleEste, semaforoEste));
		autos.add(factory.makeAutoOE(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleOeste, semaforoOeste));
		autos.add(factory.makeAutoSurHaciaIzquierda(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleSur, semaforoSur));
		autos.add(factory.makeAutoOEHaciaSur(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleOeste, semaforoOeste));
		autos.add(factory.makeAutoSurHaciaDerecha(((int) Math.floor(Math.random()*(50-10+1)+10)), modelos.get(new Random().nextInt(7)), ((int) Math.floor(Math.random()*(9234-1000+1)+1000)), calleSur, semaforoSur));
		
		semaforoEste.start();
		semaforoOeste.start();
		semaforoSur.start();
		
		
		for (int i = 0; i < 1000; i++) {
			
			Auto auto = autos.get(new Random().nextInt(5));
			auto.setId(i);
			auto.start();
			
			
		}
		
	}
	
	public static void main(String[] args) {
		Cruce cruce = new Cruce();
		cruce.inicializarCruce();
		
	}
	

}
