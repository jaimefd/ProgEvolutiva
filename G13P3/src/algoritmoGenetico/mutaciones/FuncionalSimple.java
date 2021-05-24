package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.Arbol.Dato;

public class FuncionalSimple {
	
	static ArrayList<Individuo<Arbol>> mutar(int tipo, ArrayList<Individuo<Arbol>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		
		for(int i=0;i<tamPobl;i++) {
			double rand= Math.random();
			if(rand<probMutacion) {
				Arbol arbol = poblacion.get(i).getCromosoma();
				int randIndice = (int) (Math.random() * arbol.getNumElementos());
				Arbol hijo = arbol.getArbol(randIndice);
				
				while (hijo.esTerminal() || hijo.getValor() == Dato.PROGN3) {
					randIndice = (int) (Math.random() * arbol.getNumElementos());
					hijo = arbol.getArbol(randIndice);
				}
				
				Dato nuevoDato = Dato.SIC;
				if (hijo.getValor() == Dato.SIC) nuevoDato = Dato.PROGN2;
				hijo.setValor(nuevoDato);
			}
		}
		
		return poblacion;
	}

}
