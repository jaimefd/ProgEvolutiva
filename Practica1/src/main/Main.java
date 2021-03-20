package main;

import algoritmoGenetico.AlgoritmoGenetico;

public class Main {

	public static void main(String[] args) {
	
		//Definir Algoritmo Genetico y Grafica
		AlgoritmoGenetico alg= new AlgoritmoGenetico(5,10,1000,0.8,0.15,0.001,5,3,1,true,20,2);
		
		//Paneles y pasarle grafica y Ag
		alg.run();
	}

}
