package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	
	public static ArrayList<Individuo> getTipoCruce (int cruce, ArrayList<Individuo> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl) {
		switch (cruce) {
			case 1:
				return pmx.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 2:
				return ox.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				
			case 3:
				return cx.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 4:
				return erx.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 5:
				return co.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				
			default:
				return pmx.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				
		}
	}
}
