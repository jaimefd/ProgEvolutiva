package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionEstocasticoUniversal {

	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Boolean>> nuevaPobl) {
		
		double tamaño=tamPobl;
		double prob = Math.random()/tamaño;
		int posi = 0;
		for (int i = 0; i < tamPobl; i++) {
			while (prob > puntAcu.get(posi) && posi < tamPobl - 1) {
				posi++;
			}
			nuevaPobl.get(i).setCromosoma(poblacion.get(posi).getCromosoma()); 
			prob+= 1/tamaño;
		}
		return nuevaPobl;
	}

}
