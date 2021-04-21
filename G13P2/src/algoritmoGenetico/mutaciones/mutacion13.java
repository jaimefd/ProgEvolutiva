package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import java.util.Collections;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoPerm;

public class mutacion13 {
	static ArrayList<Individuo<Character>> mutar(int tipo, ArrayList<Individuo<Character>> poblacion,
			double probMutacion,int tamPobl) {
		
		double prob;
		for(int i=0;i<tamPobl;i++) {
			prob=Math.random();
			if(prob<probMutacion) {
				double fitness1,fitness2;
				fitness1=poblacion.get(i).getFitness();
				Individuo<Character> aux=new IndividuoPerm();
				aux.setCromosoma(poblacion.get(i).getCromosoma());
				Collections.reverse(aux.getCromosoma());
				fitness2=aux.getFitness();
				if(fitness2<fitness1) {
					poblacion.get(i).setCromosoma(aux.getCromosoma());
				}
			}
		}
		
		return poblacion;
	}
}
