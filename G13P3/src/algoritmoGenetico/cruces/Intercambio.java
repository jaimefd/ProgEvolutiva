package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Arbol.Hijo;
import algoritmoGenetico.individuos.Individuo;

public class Intercambio {
	
	static void cruce(int cruce, ArrayList<Individuo<Arbol>> poblacion,
			double probCruce,int tamPobl,int[] totCruces) {

		for(int i=0;i<tamPobl;i++) { //ponemos cruce a true para los individuos que cumplen rand < ProbCruce
			double rand = Math.random();
			if(rand<probCruce) {
				poblacion.get(i).setCruce(true);
			} else {
				poblacion.get(i).setCruce(false);
			}
		}
		
		int x=1;
		boolean encontrado=false;
		
		for(int j=0;j<tamPobl;j++) {
			if(poblacion.get(j).isCruce()) { //encontramos el primero para cruzar
				while(encontrado==false && x<tamPobl) { //buscamos el segundo
					if(poblacion.get(x).isCruce()) { //lo encontramos
						encontrado=true;
						totCruces[0]++;
						Arbol aux1 = poblacion.get(j).getCromosoma();
						Arbol aux2 = poblacion.get(x).getCromosoma();
						int profMax = aux2.getProf() - 1;
						
						int rand1 = (int) (Math.random()*(aux1.getNumElementos()-1)+1);
						Arbol hijo1 = aux1.getArbol(rand1);
						// nos aseguramos de que la profundidad de el hijo 1 no sea excesiva
						while(hijo1.getProf() > profMax) {
							rand1 = (int) (Math.random()*(aux1.getNumElementos()-1)+1);
							hijo1 = aux1.getArbol(rand1);
						}
						
						int rand2 = (int) (Math.random()*(aux2.getNumElementos()-1)+1);
						Arbol hijo2 = aux2.getArbol(rand2);
						// nos aseguramos de que ambos hijos tengan la misma profundidad para no aumentar la de los arboles
						while(hijo2.getProf() != hijo1.getProf()) {
							rand2 = (int) (Math.random()*(aux2.getNumElementos()-1)+1);
							hijo2 = aux2.getArbol(rand2);
						}
						
						Arbol padre1 = hijo1.getPadre();
						Arbol padre2 = hijo2.getPadre();
						
						Hijo auxTipo = hijo2.tipoHijo;
						//Cruce del primero
						switch (hijo1.tipoHijo) {
						case IZQUIERDO:
							padre1.setHijoIzq(hijo2);
							auxTipo = Hijo.IZQUIERDO;
							break;
						case CENTRAL:
							padre1.setHijoCen(hijo2);
							auxTipo = Hijo.CENTRAL;
							break;
						case DERECHO:
							padre1.setHijoDer(hijo2);
							auxTipo = Hijo.DERECHO;
							break;
						default:
							break;
						}

						//Cruce del segundo
						switch (hijo2.tipoHijo) {
						case IZQUIERDO:
							padre2.setHijoIzq(hijo1);
							hijo1.tipoHijo = Hijo.IZQUIERDO;
							break;
						case CENTRAL:
							padre2.setHijoCen(hijo1);
							hijo1.tipoHijo = Hijo.CENTRAL;
							break;
						case DERECHO:
							padre2.setHijoDer(hijo1);
							hijo1.tipoHijo = Hijo.DERECHO;
							break;
						default:
							break;
						}
						
						hijo2.tipoHijo = auxTipo;
						
						hijo1.setPadre(padre2);
						hijo2.setPadre(padre1);
						
						int elem1 = hijo1.getNumElementos();
						int elem2 = hijo2.getNumElementos();
						int elemAux = 0;
						Arbol padreAux = padre1;
						
						// actualizamos el numero de elementos de los nodos de aux1
						while (padreAux != null) {
							elemAux = padreAux.getNumElementos();
							padreAux.setNumElementos(elemAux - elem1 + elem2);
							padreAux = padreAux.getPadre();
						}
						
						// actualizamos el numero de elementos de los nodos de aux2
						padreAux = padre2;
						while (padreAux != null) {
							elemAux = padreAux.getNumElementos();
							padreAux.setNumElementos(elemAux - elem2 + elem1);
							padreAux = padreAux.getPadre();
						}
						
						//System.out.println(aux1.getAlgoritmo());
						//System.out.println(aux1.getNumElementos());
						
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						poblacion.get(x).setCruce(false); //ponemos cruce a false y cuando vuelva a salir se añadira a nuevaPobl en su posion
					} else {
						x++;
					}
				}
			}
			//reiniciamos variables
			x=j+2; //para que siempre este uno por encima de la j
			encontrado=false;
		}
	}
	
}
