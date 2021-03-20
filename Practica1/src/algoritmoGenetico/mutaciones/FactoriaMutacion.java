package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;


public class FactoriaMutacion {
	public static ArrayList<Individuo> getTipoMutacion (int tipo, ArrayList<Individuo> poblacion,
			double probMutacion,int tamPobl) {
		switch (tipo) {
			case 1:
				return MutacionBasica.mutar(tipo, poblacion, probMutacion,tamPobl);
			case 2:
				return MutacionUniforme.mutar(tipo, poblacion, probMutacion,tamPobl);
			default:
				return MutacionBasica.mutar(tipo, poblacion, probMutacion,tamPobl);
		}
	}

}
