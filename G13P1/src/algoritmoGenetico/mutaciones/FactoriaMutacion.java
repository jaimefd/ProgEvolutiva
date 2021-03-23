package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;


public class FactoriaMutacion {
	public static ArrayList<Individuo> getTipoMutacion (int tipo, ArrayList<Individuo> poblacion,
			double probMutacion,int tamPobl,boolean real) {
		switch (tipo) {
			case 1:
				if(!real) {
					return MutacionBasica.mutar(tipo, poblacion, probMutacion,tamPobl);
				}
				else {
					return MutacionBasica.mutarReal(tipo,poblacion,probMutacion,tamPobl);
				}
				
			case 2:
				if(real) {
					return MutacionUniforme.mutar(tipo, poblacion, probMutacion,tamPobl);
				}
			default:
				if(!real) {
					return MutacionBasica.mutar(tipo, poblacion, probMutacion,tamPobl);
				}
				else {
					return MutacionBasica.mutarReal(tipo,poblacion,probMutacion,tamPobl);
				}
		}
	}

}
