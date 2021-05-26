package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class SeleccionTorneoProbabilistico {

	public static ArrayList<Individuo<Arbol>> seleccion(ArrayList<Individuo<Arbol>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Arbol>> nuevaPobl) {
		
		Individuo<Arbol> aux;
		double fitnessAct=0;
		double mejorFitness=Double.MIN_VALUE;
		double peorFitness=Double.MAX_VALUE;
		int pos_mejor=0;
		int pos_peor=0;
		
		for(int i=0;i<tamPobl;i++) {
			for(int j=0;j<3;j++) {  
				int rand=(int) (Math.random()*tamPobl);
				aux=poblacion.get(rand);
				fitnessAct=aux.getFitness();
				if (fitnessAct>mejorFitness) {
					mejorFitness=fitnessAct;
					pos_mejor=rand;
				}
				if (fitnessAct<peorFitness) {
					peorFitness=fitnessAct;
					pos_peor=rand;
				}
			}	
		    double p = Math.random();
		    if (p >= 0.5) {
		    	nuevaPobl.get(i).setCromosoma(poblacion.get(pos_mejor).getCromosoma()); //añadimos el mejor si es 0.5 o mayor
		    	nuevaPobl.get(i).setFitness(poblacion.get(pos_mejor).getFitness());
		    } else {
		    	nuevaPobl.get(i).setCromosoma(poblacion.get(pos_peor).getCromosoma());//añadimos el peor si el random es menos que 0.5
		    	nuevaPobl.get(i).setFitness(poblacion.get(pos_mejor).getFitness());
		    }
		    mejorFitness=Double.MIN_VALUE;
			peorFitness=Double.MAX_VALUE;
			
		}
		return nuevaPobl;
	}

}
