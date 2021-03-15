package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class FactoriaSeleccion {

	public static ArrayList<Individuo<Boolean>> getAlgoritmoSeleccion (String algoritmo, ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl) {
		switch (algoritmo) {
			case "EstocasticaUniversal":
				return SeleccionEstocasticoUniversal.seleccion(poblacion, puntAcu, tamPobl);
			case "Restos":
				return SeleccionRestos.seleccion(poblacion, puntAcu, tamPobl);
			case "Ruleta":
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl);
			case "TorneoDeterministico":
				return SeleccionTorneoDeterministico.seleccion(poblacion, puntAcu, tamPobl);
			case "TorneoProbabilistico":
				return SeleccionTorneoProbabilistico.seleccion(poblacion, puntAcu, tamPobl);
			case "Truncamiento":
				return SeleccionTruncamiento.seleccion(poblacion, puntAcu, tamPobl);
			default:
				return SeleccionRuleta.seleccion(poblacion, puntAcu, tamPobl);
		}
	}
	
}
