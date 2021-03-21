package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class MutacionUniforme {

	static ArrayList<Individuo> mutar(int tipo, ArrayList<Individuo> poblacion,
			double probMutacion,int tamPobl) {
		
		for(int i=0;i<tamPobl;i++) {
			int tamañoCromosoma =poblacion.get(i).getTamTotal();
			Double[] aux=new Double[tamañoCromosoma]; //creamos un array auxiliar
			aux=(Double[]) poblacion.get(i).getCromosoma(); //lo igualamos al cromosoma del individuo ¡puede que haya que usar .clone!
			
			for(int j=0;j<tamañoCromosoma;j++) {  
				double rand= Math.random();
				if(rand<probMutacion) {
					double auxiliar=poblacion.get(i).getMax(j) +poblacion.get(i).getMin(j); 
					rand*=auxiliar; //saca un numero aleatorio entre los valores permitidos
					aux[j] = auxiliar; 
				}
			}
			poblacion.get(i).setCromosoma(aux);
		}
		
		return poblacion;
	}
}
