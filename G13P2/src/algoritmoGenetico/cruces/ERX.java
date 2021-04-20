package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import algoritmoGenetico.individuos.Individuo;

public class ERX {
	
	public static ArrayList<Individuo<Character>> cruce(int cruce, ArrayList<Individuo<Character>> poblacion, double probCruce, int tamPobl,
			ArrayList<Individuo<Character>> nuevaPobl) {
		
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
						int tamañoCromosoma=poblacion.get(j).getTamTotal();
						
						ArrayList<Character> aux1 = new ArrayList<Character>();
						ArrayList<Character> aux2 = new ArrayList<Character>();
						ArrayList<Character> padre1 = new ArrayList<Character>(poblacion.get(j).getCromosoma());
						ArrayList<Character> padre2 = new ArrayList<Character>(poblacion.get(x).getCromosoma());
						
						Set<Integer>[] tablaRutas = new HashSet[tamañoCromosoma];
						for (int i = 0; i < tamañoCromosoma; i++) {
							tablaRutas[i] = new HashSet<Integer>();
				        }
						
						// Registramos en la tabla de rutas los primeros elementos de ambos cromosomas
						int indice = ((int) padre1.get(0)) - 97; // el caracter 'a' es 97, asi que los pasamos todos a base 0
						tablaRutas[indice].add(((int) padre1.get(1)) - 97);
						tablaRutas[indice].add(((int) padre1.get(tamañoCromosoma - 1)) - 97);
						
						indice = ((int) padre2.get(0)) - 97;
						tablaRutas[indice].add(((int) padre2.get(1)) - 97);
						tablaRutas[indice].add(((int) padre2.get(tamañoCromosoma - 1)) - 97);
						
						for (int i = 1; i < tamañoCromosoma - 1; i++) {
							indice = ((int) padre1.get(i)) - 97;
							tablaRutas[indice].add(((int) padre1.get(i-1)) - 97);
							tablaRutas[indice].add(((int) padre1.get(i+1)) - 97);
							
							indice = ((int) padre2.get(i)) - 97;
							tablaRutas[indice].add(((int) padre2.get(i-1)) - 97);
							tablaRutas[indice].add(((int) padre2.get(i+1)) - 97);
				        }
						
						// Registramos en la tabla de rutas los ultimos elementos de ambos cromosomas
						indice = ((int) padre1.get(tamañoCromosoma - 1)) - 97;
						tablaRutas[indice].add(((int) padre1.get(tamañoCromosoma - 2)) - 97);
						tablaRutas[indice].add(((int) padre1.get(0)) - 97);
						
						indice = ((int) padre2.get(tamañoCromosoma - 1)) - 97;
						tablaRutas[indice].add(((int) padre2.get(tamañoCromosoma - 2)) - 97);
						tablaRutas[indice].add(((int) padre2.get(0)) - 97);
						
						Set<Integer>[] tablaRutasCopia = new HashSet[tamañoCromosoma];
						for (int i = 0; i < tamañoCromosoma; i++) {
							tablaRutasCopia[i] = new HashSet<Integer>(tablaRutas[i]);
				        }
						
						aux1.add(padre2.get(0));
						for (int r = 0; r < tamañoCromosoma; r++) tablaRutas[r].remove(((int) padre2.get(0)) - 97);
						for (int i = 1; i < tamañoCromosoma; i++) {
							ArrayList<Integer> opciones = new ArrayList<Integer>(tablaRutas[((int) aux1.get(i-1)) - 97]);
							int mejor = opciones.get(0);
							for (int k = 1; k < opciones.size(); k++) {
								int candidato = opciones.get(1);
								if (tablaRutas[candidato].size() < tablaRutas[mejor].size()) mejor = candidato;
							}
							aux1.add((char) (mejor + 97));
							for (int r = 0; r < tamañoCromosoma; r++) tablaRutas[r].remove(mejor);
						}
						
						aux2.add(padre1.get(0));
						for (int r = 0; r < tamañoCromosoma; r++) tablaRutasCopia[r].remove(((int) padre1.get(0)) - 97);
						for (int i = 1; i < tamañoCromosoma; i++) {
							ArrayList<Integer> opciones = new ArrayList<Integer>(tablaRutasCopia[((int) aux2.get(i-1)) - 97]);
							int mejor = opciones.get(0);
							for (int k = 1; k < opciones.size(); k++) {
								int candidato = opciones.get(1);
								if (tablaRutasCopia[candidato].size() < tablaRutasCopia[mejor].size()) mejor = candidato;
							}
							aux2.add((char) (mejor + 97));
							for (int r = 0; r < tamañoCromosoma; r++) tablaRutasCopia[r].remove(mejor);
						}
						
						poblacion.get(j).setCromosoma(aux1); //cambiamos el cromosoma antiguo por el nuevo
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
						poblacion.get(x).setCromosoma(aux2);
						poblacion.get(x).setCruce(false); //ponemos cruce a false y cuando vuelva a salir se añadira a nuevaPobl en su posion
					} else {
						x++;
					}
				}
				if(encontrado==false) {
					nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
				}
			} else {
				nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma());  //Si no se cruzan los agregamos directamente en su posicion
			}
			//reiniciamos variables
			x=j+2; //para que siempre este uno por encima de la j
			encontrado=false;
		}
		
		return nuevaPobl;
	}

}
