package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class Cruce {
	
	
	public static ArrayList<Individuo<Boolean>> getAlgoritmoSeleccion (int cruce, ArrayList<Individuo<Boolean>> poblacion,
			double probCruce,int tamPobl) {
		switch (cruce) {
			case 1:
				return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl);
			case 2:
				return Uniforme.cruce(cruce, poblacion, probCruce,tamPobl);
			case 3:
				return Aritmetico.cruce(cruce, poblacion, probCruce,tamPobl);
			default:
				return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl);
		}
	}
}
