package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTorneoProbabilistico {

	public static ArrayList<Individuo<Character>> seleccion(ArrayList<Individuo<Character>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Character>> nuevaPobl) {
		
		Individuo<Character> aux;
		double fitnessAct=0;
		double mejorFitness=Double.MAX_VALUE;
		double peorFitness=Double.NEGATIVE_INFINITY;
		int pos_mejor=0;
		int pos_peor=0;
		
		for(int i=0;i<tamPobl;i++) {
			for(int j=0;j<3;j++) {  
				int rand=(int) (Math.random()*tamPobl);
				aux=poblacion.get(rand);
				fitnessAct=aux.getFitness();
				if (fitnessAct<=mejorFitness) {
					mejorFitness=fitnessAct;
					pos_mejor=rand;
				}
				if (fitnessAct>peorFitness) {
					peorFitness=fitnessAct;
					pos_peor=rand;
				}
			}	
		    double p = Math.random();
		    if (p >= 0.5) {
		    	nuevaPobl.get(i).setCromosoma(poblacion.get(pos_mejor).getCromosoma()); //añadimos el mejor si es 0.5 o mayor
		    } else {
		    	nuevaPobl.get(i).setCromosoma(poblacion.get(pos_peor).getCromosoma());//añadimos el peor si el random es menos que 0.5
		    }
		    mejorFitness=Double.MAX_VALUE;
			peorFitness=Double.NEGATIVE_INFINITY;
			
		}
		return nuevaPobl;
	}

}
