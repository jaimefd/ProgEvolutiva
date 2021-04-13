package algoritmoGenetico.seleccion;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRestos {

	public static ArrayList<Individuo> seleccion(ArrayList<Individuo> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Double> puntuaciones,ArrayList<Individuo> nuevaPobl) {
		
		int introducidos=0;
		for(int i=0;i<tamPobl && introducidos<tamPobl;i++) {
			double pik= ((puntuaciones.get(i)*tamPobl)/100); //puntuacion * individuos a seleccionar
			if(pik>1) {
				pik=Math.round(pik);
				int j=0;
				while(j<pik && introducidos<tamPobl) {
					nuevaPobl.get(introducidos).setCromosoma(poblacion.get(i).getCromosoma()); 
					introducidos++;
					j++;
				}
			}
		}
		
		if(introducidos<tamPobl) {
			SeleccionRuleta.seleccionRuletaRestos(poblacion, puntAcu, tamPobl,introducidos,nuevaPobl);
		}

		return nuevaPobl;
	}

}
