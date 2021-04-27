package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmoGenetico.individuos.Individuo;

public class CX {

	public static ArrayList<Individuo<Character>> cruce(int cruce, ArrayList<Individuo<Character>> poblacion, double probCruce, int tamPobl,
			ArrayList<Individuo<Character>> nuevaPobl,int[] totCruces) {
		
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
						totCruces[0]++;
						
						ArrayList<Character> aux1 = new ArrayList<Character>();
						ArrayList<Character> aux2 = new ArrayList<Character>();
						ArrayList<Character> padre1 = new ArrayList<Character>(poblacion.get(j).getCromosoma());
						ArrayList<Character> padre2 = new ArrayList<Character>(poblacion.get(x).getCromosoma());
						
						for (int i = 0; i < tamañoCromosoma; i++) {
							aux1.add('-');
							aux2.add('-');
						}
						
						int index = 0;
						char elem = padre1.get(index);
						aux1.set(index, elem);
						
						// realizamos ciclo 1
						while (!aux1.contains(padre2.get(index))) {
							index = padre1.indexOf(padre2.get(index));
							elem = padre1.get(index);
							aux1.set(index, elem);
						}
						
						index = 0;
						elem = padre2.get(index);
						aux2.set(index, elem);
						
						// realizamos ciclo 2
						while (!aux2.contains(padre1.get(index))) {
							index = padre2.indexOf(padre1.get(index));
							elem = padre2.get(index);
							aux2.set(index, elem);
						}
						
						// copiamos del padre inverso los que queden
						for (int i = 0; i < tamañoCromosoma; i++) {
							if (aux1.get(i) == '-') aux1.set(i, padre2.get(i));
							if (aux2.get(i) == '-') aux2.set(i, padre1.get(i));
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
