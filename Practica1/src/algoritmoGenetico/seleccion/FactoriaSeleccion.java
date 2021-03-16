package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaSeleccion {

	public static ArrayList<Individuo<Boolean>> getAlgoritmoSeleccion (int algoritmo, ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, ArrayList<Double> punt,int tamPobl) {
		switch (algoritmo) {
			case 1:
				return SeleccionEstocasticoUniversal.seleccion(poblacion, puntAcu, tamPobl);
			case 2:
				return SeleccionRestos.seleccion(poblacion, puntAcu, tamPobl,punt);
			case 3:
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl);
			case 4:
				return SeleccionTorneoDeterministico.seleccion(poblacion, puntAcu, tamPobl);
			case 5:
				return SeleccionTorneoProbabilistico.seleccion(poblacion, puntAcu, tamPobl);
			case 6:
				return SeleccionTruncamiento.seleccion(poblacion, puntAcu, tamPobl);
			default:
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl);
		}
	}
	
}
