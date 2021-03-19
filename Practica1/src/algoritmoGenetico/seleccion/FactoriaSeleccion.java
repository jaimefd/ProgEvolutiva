package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaSeleccion {

	public static ArrayList<Individuo<Boolean>> getAlgoritmoSeleccion (int algoritmo, ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, ArrayList<Double> punt,int tamPobl,ArrayList<Individuo<Boolean>> nuevaPobl) {
		switch (algoritmo) {
			case 1:
				return SeleccionEstocasticoUniversal.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
			case 2:
				return SeleccionRestos.seleccion(poblacion, puntAcu, tamPobl,punt,nuevaPobl);
			case 3:
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
			case 4:
				return SeleccionTorneoDeterministico.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
			case 5:
				return SeleccionTorneoProbabilistico.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
			case 6:
				return SeleccionTruncamiento.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
			default:
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl,nuevaPobl);
		}
	}
	
}
