package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Arbol.Hijo;
import algoritmoGenetico.individuos.Individuo;

public class DeArbol {

	static ArrayList<Individuo<Arbol>> mutar(int tipo, ArrayList<Individuo<Arbol>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		
		for(int i=0;i<tamPobl;i++) {
			double rand= Math.random();
			if(rand<probMutacion) {
				totMut[0]++;
				Arbol arbol = poblacion.get(i).getCromosoma();
				int randIndice = (int) (Math.random() * (arbol.getNumElementos()-1));
				randIndice++;
				Arbol hijo = arbol.getArbol(randIndice);
				
				Arbol padre = hijo.getPadre();
				int profHijo = hijo.getProf();
				int elemHijo = hijo.getNumElementos();
				
				Arbol nuevoHijo = new Arbol();
				nuevoHijo.crearArbol(nuevoHijo, 0, profHijo);
				int elemNuevo = nuevoHijo.getNumElementos();
				
				switch(hijo.tipoHijo) {
				case IZQUIERDO:
					padre.setHijoIzq(nuevoHijo);
					nuevoHijo.tipoHijo = Hijo.IZQUIERDO;
					break;
				case CENTRAL:
					padre.setHijoCen(nuevoHijo);
					nuevoHijo.tipoHijo = Hijo.CENTRAL;
					break;
				case DERECHO:
					padre.setHijoDer(nuevoHijo);
					nuevoHijo.tipoHijo = Hijo.DERECHO;
					break;
				default:
					break;
				}
				
				nuevoHijo.setPadre(padre);
				
				int elemAux = 0;
				Arbol padreAux = padre;
				
				// actualizamos el numero de elementos de los nodos
				while (padreAux != null) {
					elemAux = padreAux.getNumElementos();
					padreAux.setNumElementos(elemAux - elemHijo + elemNuevo);
					padreAux = padreAux.getPadre();
				}
				
				arbol.updateProf();
			}
		}
		
		return poblacion;
	}
	
}
