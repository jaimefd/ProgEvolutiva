package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTorneoProbabilistico {

	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl) {
		
		ArrayList<Individuo<Boolean>> nuevaPobl = new ArrayList<Individuo<Boolean>>();
		Individuo aux;
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
				if(fitnessAct>mejorFitness) {
					mejorFitness=fitnessAct;
					pos_mejor=rand;
				}
				if(fitnessAct<peorFitness) {
					peorFitness=fitnessAct;
					pos_peor=rand;
				}
			}	
		    double p = Math.random();
		    if(p>=0.5) {
			nuevaPobl.add(poblacion.get(pos_mejor)); //añadimos el mejor si es 0.5 o mayor
		    }
		    else {
		    nuevaPobl.add(poblacion.get(pos_peor));//añadimos el peor si el random es menos que 0.5
		    }
			mejorFitness=0;
			
		}
		return nuevaPobl;
	}

}
