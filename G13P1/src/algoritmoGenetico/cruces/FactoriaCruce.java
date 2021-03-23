package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaCruce {
	
	
	public static ArrayList<Individuo> getTipoCruce (int cruce, ArrayList<Individuo> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl,boolean real) {
		switch (cruce) {
			case 1:
				if(!real) {
				return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
				else {
					return Monopunto.cruceReal(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
			case 2:
				if(!real) {
					return Uniforme.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
				else {
					return Uniforme.cruceReal(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
			case 3:
				if(real) {
					return Aritmetico.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl,real);
				}
			default:
				if(!real) {
					return Monopunto.cruce(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
				else {
					return Monopunto.cruceReal(cruce, poblacion, probCruce,tamPobl,nuevaPobl);
				}
		}
	}
}
