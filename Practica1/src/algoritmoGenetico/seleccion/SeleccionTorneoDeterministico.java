package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTorneoDeterministico {

	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Boolean>> nuevaPobl) {
		
		Individuo<Boolean> aux;
		double fitnessAct=0;
		double mejorFitness= Double.NEGATIVE_INFINITY;
		int pos_mejor=0;
		
		for(int i=0;i<tamPobl;i++) {
			for(int j=0;j<3;j++) {  //Se pueden 2 o 3
				int rand=(int) (Math.random()*tamPobl);
				aux=poblacion.get(rand);
				fitnessAct=aux.getFitness();
				if(fitnessAct>mejorFitness) {
					mejorFitness=fitnessAct;
					pos_mejor=rand;
				}
			}
			nuevaPobl.get(i).setCromosoma(poblacion.get(pos_mejor).getCromosoma());  //añadimos a la nueva poblacion el mejor de los 3 elegidos aleatoriamente
			mejorFitness= Double.NEGATIVE_INFINITY;
			
		}
		return nuevaPobl;
	}

}
