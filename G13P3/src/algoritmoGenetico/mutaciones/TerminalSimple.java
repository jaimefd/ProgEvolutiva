package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Arbol.Dato;
import algoritmoGenetico.individuos.Individuo;

public class TerminalSimple {

	static ArrayList<Individuo<Arbol>> mutar(int tipo, ArrayList<Individuo<Arbol>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		
		for(int i=0;i<tamPobl;i++) {
			double rand= Math.random();
			if(rand<probMutacion) {
				Arbol arbol = poblacion.get(i).getCromosoma();
				int randIndice = (int) (Math.random() * (arbol.getNumElementos()-1));
				randIndice++;
				Arbol hijo = arbol.getArbol(randIndice);
				
				while (!hijo.esTerminal()) {
					randIndice = (int) (Math.random() * (arbol.getNumElementos()-1));
					randIndice++;
					hijo = arbol.getArbol(randIndice);
				}
				
				int randTipo = (int) (Math.random() * 3);
				Dato randato = Dato.values()[randTipo];
				hijo.setValor(randato);
			}
		}
		
		return poblacion;
	}
	
}
