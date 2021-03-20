package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	
	public static ArrayList<Individuo> getTipoCruce (int cruce, ArrayList<Individuo> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl) {
		switch (cruce) {
			case 1:
				return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 2:
				return Uniforme.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			case 3:
				return Aritmetico.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
			default:
				return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
		}
	}
}
