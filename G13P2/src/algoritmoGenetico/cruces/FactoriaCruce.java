package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	public static ArrayList<Individuo<Character>> getTipoCruce (int cruce, ArrayList<Individuo<Character>> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo<Character>> nuevaPobl) {
		switch (cruce) {
			case 1:
				return PMX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 2:
				return OX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				
			case 3:
				return CX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 4:
				//return ERX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 5:
				//return CO.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 6:
				return OxPp.cruce(cruce, poblacion, probCruce, tamPobl, nuevaPobl);
				
			default:
				return PMX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				
		}
	}
}
