package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmoGenetico.individuos.Individuo;

public class CO {
	
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
						int punto1 =(int) (Math.random()*(tamañoCromosoma-1)) + 1;
						
						ArrayList<Character> letras = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
								'n', 'o', 'p', 'q', 'r' ,'s', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
						
						int[] indices1 = new int[tamañoCromosoma];
						int[] indices2 = new int[tamañoCromosoma];
						ArrayList<Character> padre1 = new ArrayList<Character>(poblacion.get(j).getCromosoma());
						ArrayList<Character> padre2 = new ArrayList<Character>(poblacion.get(x).getCromosoma());
						
						ArrayList<Character> lista1 = new ArrayList<Character>(letras);
						ArrayList<Character> lista2 = new ArrayList<Character>(letras);
						
						for (int i = 0; i < tamañoCromosoma; i++) {
							// primer elemento
							int indice = lista1.indexOf(padre1.get(i));
							indices1[i] = indice;
							lista1.remove(indice);
							// segundo elemento
							indice = lista2.indexOf(padre2.get(i));
							indices2[i] = indice;
							lista2.remove(indice);
						}
						
						// cruce monopunto
						int[] nuevosIndices1 = new int[tamañoCromosoma];
						int[] nuevosIndices2 = new int[tamañoCromosoma];
						
						for (int i = 0; i < punto1; i++) {
							nuevosIndices1[i] = indices1[i];
							nuevosIndices2[i] = indices2[i];
						}
						
						for (int i = punto1; i < tamañoCromosoma; i++) {
							nuevosIndices1[i] = indices2[i];
							nuevosIndices2[i] = indices1[i];
						}
						
						// traducción final
						ArrayList<Character> aux1 = new ArrayList<Character>();
						ArrayList<Character> aux2 = new ArrayList<Character>();
						lista1 = new ArrayList<Character>(letras);
						lista2 = new ArrayList<Character>(letras);
						
						
						for (int i = 0; i < tamañoCromosoma; i++) {
							// primer elemento
							aux1.add(lista1.remove(nuevosIndices1[i]));
							// segundo elemento
							aux2.add(lista2.remove(nuevosIndices2[i]));
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
