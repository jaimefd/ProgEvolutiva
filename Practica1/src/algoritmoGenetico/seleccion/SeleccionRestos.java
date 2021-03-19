package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRestos {

	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Double> puntuaciones,ArrayList<Individuo<Boolean>> nuevaPobl) {
		
		/*
		for(int i=0;i<tamPobl && nuevaPobl.size()<tamPobl;i++) {
			double pik= puntuaciones.get(i)*tamPobl; //puntuacion * individuos a seleccionar
			if(pik>1) {
				pik=Math.round(pik);
				int j=0;
				while(j<pik && nuevaPobl.size()<tamPobl) {
					nuevaPobl.get(i).setCromosoma(poblacion.get(i).getCromosoma()); 
					j++;
				}
			}
		}
		
		
		while(nuevaPobl.size()!=tamPobl) { //por si faltan por añadir los introducimos aleatoriamente
			int rand = (int) Math.random()*(tamPobl-1);
			nuevaPobl.get(i).setCromosoma(poblacion.get(i).getCromosoma()); //MAL
		}
		*/ //esta mal, hay que volver a hacerlo
		return nuevaPobl;
	}

}
