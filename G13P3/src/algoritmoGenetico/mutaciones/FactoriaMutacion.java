package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class FactoriaMutacion {

	public static ArrayList<Individuo<Arbol>> getTipoMutacion (int tipo, ArrayList<Individuo<Arbol>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		switch (tipo) {
			case 1:
				return TerminalSimple.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);			
			case 2:
				return FuncionalSimple.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			case 3:
				return DeArbol.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			case 4:
				return Permutacion.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			default:
				return TerminalSimple.mutar(tipo, poblacion, probMutacion,tamPobl,totMut);
			
		}
	}
	
}
