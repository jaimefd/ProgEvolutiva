package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class MutacionBasica {
	
	static ArrayList<Individuo<Boolean>> mutar(int tipo, ArrayList<Individuo<Boolean>> poblacion,
			double probMutacion,int tamPobl) {
		
		for(int i=0;i<tamPobl;i++) {
			int tama�oCromosoma =poblacion.get(i).getTamTotal();
			Boolean[] aux=new Boolean[tama�oCromosoma]; //creamos un array auxiliar
			aux=poblacion.get(i).getCromosoma(); //lo igualamos al cromosoma del individuo
			
			for(int j=0;j<tama�oCromosoma;j++) {  
				double rand= Math.random();
				if(rand<probMutacion) {
					aux[j] = !aux[j];  //si tiene un 0 ponemos un 1 y viceversa
				}
			}
			poblacion.get(i).setCromosoma(aux);
		}
		
		return poblacion;
	}
}