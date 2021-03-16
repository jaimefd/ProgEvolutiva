package algoritmoGenetico.seleccion;

import java.util.ArrayList;
import java.util.Collections;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTruncamiento {
	
	public static ArrayList<Individuo<Boolean>> seleccion(ArrayList<Individuo<Boolean>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl) {
		double trunc = 0.5; // umbral de truncamiento, puede hacerse que le llegue como parámetro
		ArrayList<Individuo<Boolean>> nuevaPobl = new ArrayList<Individuo<Boolean>>();
		Collections.sort(poblacion);
		int tamElite = (int) (tamPobl*trunc); // cantidad de mejores elementos de la poblacion original que se van a repetir
		int x = 0, j = 0;
		
		while (x < tamPobl) {
			while (j < tamElite && x < tamPobl) {
				nuevaPobl.add(poblacion.get(j));
				x++;
				j++;
			}
			j = 0; // tras copiar los tamElite mejores elementos, si sigue habiendo hueco los volvemos a copiar
		}
		
		return nuevaPobl;
	}

}
