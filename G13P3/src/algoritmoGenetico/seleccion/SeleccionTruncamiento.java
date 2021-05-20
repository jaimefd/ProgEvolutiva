package algoritmoGenetico.seleccion;

import java.util.ArrayList;
import java.util.Collections;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class SeleccionTruncamiento {
	
	public static ArrayList<Individuo<Arbol>> seleccion(ArrayList<Individuo<Arbol>> poblacion,
			ArrayList<Double> puntAcu, int tamPobl,ArrayList<Individuo<Arbol>> nuevaPobl) {
		double trunc = 0.2; // umbral de truncamiento, puede hacerse que le llegue como par�metro
		Collections.sort(poblacion);
		int tamElite = (int) (tamPobl*trunc); // cantidad de mejores elementos de la poblacion original que se van a repetir
		int x = 0, j = 0;
		
		while (x < tamPobl) {
			while (j < tamElite && x < tamPobl) {
				nuevaPobl.get(x).setCromosoma(poblacion.get(j).getCromosoma());
				x++;
				j++;
			}
			j = 0; // tras copiar los tamElite mejores elementos, si sigue habiendo hueco los volvemos a copiar
		}
		
		return nuevaPobl;
	}

}
