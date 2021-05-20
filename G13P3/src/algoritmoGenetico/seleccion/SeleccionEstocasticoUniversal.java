package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class SeleccionEstocasticoUniversal {

	public static ArrayList<Individuo<Arbol>> seleccion(ArrayList<Individuo<Arbol>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Arbol>> nuevaPobl) {
		
		double tama�o=tamPobl;
		double prob = Math.random()/tama�o;
		int posi = 0;
		for (int i = 0; i < tamPobl; i++) {
			while (prob > puntAcu.get(posi) && posi < tamPobl - 1) {
				posi++;
			}
			nuevaPobl.get(i).setCromosoma(poblacion.get(posi).getCromosoma()); 
			prob+= 1/tama�o;
		}
		return nuevaPobl;
	}

}
