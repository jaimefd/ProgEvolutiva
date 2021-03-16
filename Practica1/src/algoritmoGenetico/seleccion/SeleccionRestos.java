package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRestos {

	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Double> puntuaciones) {
		
		ArrayList<Individuo<Boolean>> nuevaPobl = new ArrayList<Individuo<Boolean>>();
		
		for(int i=0;i<tamPobl && nuevaPobl.size()<tamPobl;i++) {
			double pik= puntuaciones.get(i)*tamPobl; //puntuacion * individuos a seleccionar
			if(pik>1) {
				pik=Math.round(pik);
				int j=0;
				while(j<pik && nuevaPobl.size()<tamPobl) {
					nuevaPobl.add(poblacion.get(i));
					j++;
				}
			}
		}
		
		
		while(nuevaPobl.size()!=tamPobl) { //por si faltan por añadir los introducimos aleatoriamente
			int rand = (int) Math.random()*(tamPobl-1);
			nuevaPobl.add(poblacion.get(rand));
		}
		
		return nuevaPobl;
	}

}
