package model;

import java.util.ArrayList;
import java.util.List;

public class Avenida {
	
	private List<Auto> calle = new ArrayList<Auto>();
	
	
	
	public Avenida() {
		super();
	}



	public void agregarAuto(Auto auto){
		this.calle.add(auto);
	}
	

}
