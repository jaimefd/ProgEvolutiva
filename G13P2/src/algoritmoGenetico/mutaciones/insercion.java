package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;

public class insercion {
		
		static ArrayList<Individuo<Character>> mutar(int tipo, ArrayList<Individuo<Character>> poblacion,
				double probMutacion,int tamPobl) {
			
			double prob;
			for(int i=0;i<tamPobl;i++) {
				prob=Math.random();
				if(probMutacion<prob) {
					int posIni=(int)(Math.random()*poblacion.get(i).getTamTotal());
					int posFin=(int)(Math.random()*poblacion.get(i).getTamTotal());
					if(posIni>posFin) {
						Character aux1;
						aux1=poblacion.get(i).getCromosoma().get(posIni);		
						poblacion.get(i).getCromosoma().add(posFin, aux1);
						poblacion.get(i).getCromosoma().remove(posIni+1);
					}
					
				}
			}
			
			return poblacion;
		}
		
}
