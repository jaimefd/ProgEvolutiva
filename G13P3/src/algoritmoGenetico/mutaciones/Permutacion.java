package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class Permutacion {

	static ArrayList<Individuo<Arbol>> mutar(int tipo, ArrayList<Individuo<Arbol>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		
		for(int i=0;i<tamPobl;i++) {
			double rand= Math.random();
			if(rand<probMutacion) {
				Arbol arbol = poblacion.get(i).getCromosoma();
				int randIndice = (int) (Math.random() * arbol.getNumElementos());
				Arbol hijo = arbol.getArbol(randIndice);
				
				while (hijo.esTerminal()) {
					randIndice = (int) (Math.random() * arbol.getNumElementos());
					hijo = arbol.getArbol(randIndice);
				}
				
				Arbol aux = hijo.getHijoIzq();
				hijo.setHijoIzq(hijo.getHijoDer());
				hijo.setHijoDer(aux);
			}
		}
		
		return poblacion;
	}
	
}
