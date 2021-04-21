package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

// Cruce de Reordenación por Vector de Índices (creado por nosotros)
/*
 * La idea es, para cada hijo, reordenar los elementos de un padre usando los del otro padre como índices
 * Por ejemplo, para hijo1[3] tendríamos padre1[padre2[3]]
 * o realmente, padre1[((int) padre2[3]) - 97]
 * Es importante restar 97 ya que los caracteres empiezan desde ese valor (que sería el de a)
 * 
 * Este método respeta la permutación si los padres la respetan, ya que si no tienen elementos repetidos
 * la reordenación tampoco los tendrá (ya que los índices tampoco serán repetidos, y no tomamos el mismo
 * valor varias veces)
 * 
 * Ejemplo:
 * 
 * [a c d f e b] padre1
 * [f a d b c e] padre2
 * 
 * hijo1[0] sería el elemento de padre1 en la posición de padre2[0]. Es decir, la posición f = 5
 * por lo que hijo1[0] = padre1[padre2[0]] = padre1[5] = b
 * 
 * 
 */
public class RVI {
	
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
						
						int indice = 0;
						for (int i = 0; i < tamañoCromosoma; i++) {
							// Hijo 1
							indice = ((int) padre2.get(i)) - 97;
							aux1.add(padre1.get(indice));
							// Hijo 2
							indice = ((int) padre1.get(i)) - 97;
							aux2.add(padre2.get(indice));
						}
						
						// Sistema para evitar dos hijos iguales
						// Solo ocurre 2 hijos iguales (con padres distintos) cuando un padre es a,b,c,d...z
						// en cuyo caso ambos hijos serán idénticos al otro padre. Por tanto, hacemos que uno de los hijos
						// sea igual al padre que era a,b,c,d...z, haciendo como que el cruce nunca ha ocurrido
						// y esperamos a que la mutación cambie el padre a,b,c,d....z
						if (aux1.equals(padre1)) {
							aux1 = new ArrayList<Character>(padre2);
						} else if (aux1.equals(padre2)) {
							aux2 = new ArrayList<Character>(padre1);
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
