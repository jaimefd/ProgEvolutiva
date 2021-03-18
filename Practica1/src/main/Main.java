package main;

import algoritmoGenetico.AlgoritmoGenetico;

public class Main {

	public static void main(String[] args) {
		AlgoritmoGenetico alg= new AlgoritmoGenetico(1,10,10,0.2,0.2,0.001,1,1,1,false,0);
		alg.run();

	}

}
