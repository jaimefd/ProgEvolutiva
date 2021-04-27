package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;


public class FactoriaMutacion {
	public static ArrayList<Individuo<Character>> getTipoMutacion (int tipo, ArrayList<Individuo<Character>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		switch (tipo) {
			case 1:
				return insercion.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);			
			case 2:
				return intercambio.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			case 3:
				return inversion.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			case 4:
				return heuristica.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			case 5:
				return mutacion13.mutar(tipo, poblacion, probMutacion, tamPobl,totMut);
			default:
				return insercion.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			
		}
	}

}
