package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	public static ArrayList<Individuo<Character>> getTipoCruce (int cruce, ArrayList<Individuo<Character>> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo<Character>> nuevaPobl,int[] totCruces) {
		switch (cruce) {
			case 1:
				return PMX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
			case 2:
				return OX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
				
			case 3:
				return CX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
			case 4:
				return ERX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
			case 5:
				return CO.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
			case 6:
				return OxPp.cruce(cruce, poblacion, probCruce, tamPobl, nuevaPobl,totCruces);
			case 7:
				return RVI.cruce(cruce, poblacion, probCruce, tamPobl, nuevaPobl,totCruces);
			default:
				return PMX.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,totCruces);
				
		}
	}
}
