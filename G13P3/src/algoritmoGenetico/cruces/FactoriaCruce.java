package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	public static ArrayList<Individuo<Arbol>> getTipoCruce (int cruce, ArrayList<Individuo<Arbol>> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo<Arbol>> nuevaPobl,int[] totCruces) {
		switch (cruce) {
			case 1:
				return Intercambio.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
			default:
				return Intercambio.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
				
		}
	}
}
