package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmoGenetico.individuos.Individuo;

public class PMX {

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
						int tama�oCromosoma=poblacion.get(j).getTamTotal();
						int tama�oCruce = (int) (Math.random()*(tama�oCromosoma-2)) + 1;
						int punto1 =(int) (Math.random()*(tama�oCromosoma-tama�oCruce+1));
						int punto2 = punto1 + tama�oCruce;
						
						ArrayList<Character> aux1 = new ArrayList<Character>();
						ArrayList<Character> aux2 = new ArrayList<Character>();
						ArrayList<Character> padre1 = (ArrayList<Character>) Arrays.asList(poblacion.get(j).getCromosoma());
						ArrayList<Character> padre2 = (ArrayList<Character>) Arrays.asList(poblacion.get(x).getCromosoma());
						
						for (int i = 0; i < tama�oCromosoma; i++) {
							aux1.add('-');
							aux2.add('-');
						}
						
						for (int i = punto1; i < punto2; i++) {
							aux1.set(i, padre2.get(i));
							aux2.set(i, padre1.get(i));
						}
						
						// Copiamos las partes derechas
						for (int i = punto2; i < tama�oCromosoma; i++) {
							//Cruce del primero
							char elem1 = padre1.get(i);
							while (aux1.contains(elem1)) {
								elem1 = padre1.get(padre2.indexOf(elem1));
							}
							aux1.set(i, elem1);
							//Cruce del segundo
							char elem2 = padre2.get(i);
							while (aux2.contains(elem2)) {
								elem2 = padre2.get(padre1.indexOf(elem2));
							}
							aux2.set(i, elem2);
						}
						
						// Copiamos las partes izquierdas
						for (int i = 0; i < punto1; i++) {
							//Cruce del primero
							char elem1 = padre1.get(i);
							while (aux1.contains(elem1)) {
								elem1 = padre1.get(padre2.indexOf(elem1));
							}
							aux1.set(i, elem1);
							//Cruce del segundo
							char elem2 = padre2.get(i);
							while (aux2.contains(elem2)) {
								elem2 = padre2.get(padre1.indexOf(elem2));
							}
							aux2.set(i, elem2);
						}
						
						poblacion.get(j).setCromosoma(aux1.toArray(new Character[tama�oCromosoma])); //cambiamos el cromosoma antiguo por el nuevo
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
						poblacion.get(x).setCromosoma(aux2.toArray(new Character[tama�oCromosoma]));
						poblacion.get(x).setCruce(false); //ponemos cruce a false y cuando vuelva a salir se a�adira a nuevaPobl en su posion
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