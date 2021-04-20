package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRuleta {

	static ArrayList<Individuo<Character>> seleccion (ArrayList<Individuo<Character>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Character>> nuevaPobl) {
		double prob;
		int posi;
		for (int i = 0; i < tamPobl; i++) {
			prob = Math.random();
			posi = 0;
			while (prob > puntAcu.get(posi) && posi < tamPobl - 1) posi++;
			nuevaPobl.get(i).setCromosoma(poblacion.get(posi).getCromosoma()); 
		}
		return nuevaPobl;
	}
	
	static ArrayList<Individuo<Character>> seleccionRuletaRestos (ArrayList<Individuo<Character>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,int introducidos,ArrayList<Individuo<Character>> nuevaPobl) {
		double prob;
		int posi;
		for (int i = introducidos; i < tamPobl; i++) {
			prob = Math.random();
			posi = 0;
			while (prob > puntAcu.get(posi) && posi < tamPobl - 1) posi++;
			nuevaPobl.get(i).setCromosoma(poblacion.get(posi).getCromosoma()); 
		}
		return nuevaPobl;
	}
	
}
