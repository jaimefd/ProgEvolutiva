package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class MutacionBasica {
	
	static ArrayList<Individuo> mutar(int tipo, ArrayList<Individuo> poblacion,
			double probMutacion,int tamPobl) {
		
		for(int i=0;i<tamPobl;i++) {
			int tamañoCromosoma =poblacion.get(i).getTamTotal();
			Boolean[] aux=new Boolean[tamañoCromosoma]; //creamos un array auxiliar
			aux=(Boolean[]) poblacion.get(i).getCromosoma(); //lo igualamos al cromosoma del individuo ¡puede que haya que usar .clone!
			
			for(int j=0;j<tamañoCromosoma;j++) {  
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
