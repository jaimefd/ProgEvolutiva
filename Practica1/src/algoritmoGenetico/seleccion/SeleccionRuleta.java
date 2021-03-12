package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRuleta {

	static ArrayList<Individuo<Boolean>> seleccion (ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl) {
		ArrayList<Individuo<Boolean>> nuevaPobl = new ArrayList<Individuo<Boolean>>();
		double prob;
		int posi;
		for (int i = 0; i < tamPobl; i++) {
			prob = Math.random();
			posi = 0;
			while (prob > puntAcu.get(posi) && posi < tamPobl - 1) posi++;
			nuevaPobl.add(poblacion.get(posi));
		}
		return nuevaPobl;
	}
	
}
