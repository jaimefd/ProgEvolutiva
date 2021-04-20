package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoPerm;

public class heuristica {
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
				int posIni=(int)(Math.random()*aux.getTamTotal());
				int posFin=(int)(Math.random()*aux.getTamTotal());
				while(posIni==posFin) {
					posFin=(int)(Math.random()*aux.getTamTotal());
				}
				if(posIni>posFin) {
					int auxs=posIni;
					posIni=posFin;
					posFin=auxs;
				}
				
				Character aux1,aux2;
				aux1=aux.getCromosoma().get(posIni);		
				aux2=aux.getCromosoma().get(posFin);
				aux.getCromosoma().set(posIni, aux2);
				aux.getCromosoma().set(posFin, aux1);
				fitness2=aux.getFitness();
				if(fitness2<fitness1) {
					poblacion.get(i).setCromosoma(aux.getCromosoma());
				}
			}
		}
		
		return poblacion;
	}
}
