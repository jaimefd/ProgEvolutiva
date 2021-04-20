package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;


public class FactoriaMutacion {
	public static ArrayList<Individuo<Character>> getTipoMutacion (int tipo, ArrayList<Individuo<Character>> poblacion,
			double probMutacion,int tamPobl) {
		switch (tipo) {
			case 1:
				return insercion.mutar(tipo, poblacion, probMutacion,tamPobl);			
			case 2:
				return intercambio.mutar(tipo, poblacion, probMutacion,tamPobl);
			case 3:
				return inversion.mutar(tipo, poblacion, probMutacion,tamPobl);
			case 4:
				return heuristica.mutar(tipo, poblacion, probMutacion,tamPobl);
			default:
				return insercion.mutar(tipo, poblacion, probMutacion,tamPobl);
			
		}
	}

}
