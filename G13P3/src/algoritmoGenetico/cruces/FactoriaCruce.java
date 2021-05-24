package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	public static void getTipoCruce (int cruce, ArrayList<Individuo<Arbol>> poblacion,
			double probCruce,int tamPobl,int[] totCruces) {
		switch (cruce) {
			case 1:
				Intercambio.cruce(cruce, poblacion, probCruce,tamPobl,totCruces);
				break;
			default:
				Intercambio.cruce(cruce, poblacion, probCruce,tamPobl,totCruces);
				break;
				
		}
	}
}
