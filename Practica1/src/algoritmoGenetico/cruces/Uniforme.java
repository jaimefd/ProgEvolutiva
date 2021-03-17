package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class Uniforme {
	static ArrayList<Individuo<Boolean>> cruce(int cruce, ArrayList<Individuo<Boolean>> poblacion,
			double probCruce,int tamPobl) {
		ArrayList<Individuo<Boolean>> nuevaPobl =new ArrayList<Individuo<Boolean>>();
		
		for(int i=0;i<tamPobl;i++) { //ponemos cruce a true para los individuos que cumplen rand < ProbCruce
			double rand = Math.random();
			if(rand<probCruce) {
				poblacion.get(i).setCruce(true);
			} else {
				poblacion.get(i).setCruce(false);
			}
		}
		
		int x=1;
		boolean encontrado=false;
		
		for(int j=0;j<tamPobl;j++) {
			if(poblacion.get(j).isCruce()) { //encontramos el primero para cruzar
				while(encontrado==false && x<tamPobl) { //buscamos el segundo
					if(poblacion.get(x).isCruce()) { //lo encontramos
						encontrado=true;
						int tamañoCromosoma=poblacion.get(j).getTamTotal();
						Boolean[] viejo1 = poblacion.get(j).getCromosoma();
						Boolean[] viejo2 = poblacion.get(x).getCromosoma();
						Boolean[] nuevo1 = new Boolean[tamañoCromosoma];
						Boolean[] nuevo2 = new Boolean[tamañoCromosoma];
						
						for (int i = 0; i < tamañoCromosoma; i++) {
							double rand = Math.random();
							if(rand<0.5) {
								nuevo1[i] = viejo2[i];
								nuevo2[i] = viejo1[i];
							} else {
								nuevo1[i] = viejo1[i];
								nuevo2[i] = viejo2[i];
							}
						}
						
						poblacion.get(j).setCromosoma(nuevo1); //cambiamos el cromosoma antiguo por el nuevo
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.add(poblacion.get(j));
						poblacion.get(x).setCromosoma(nuevo2);
						poblacion.get(x).setCruce(false); //ponemos cruce a false y cuando vuelva a salir se añadira a nuevaPobl en su posion
					} else {
						x++;
					}
				}
			} else {
				nuevaPobl.add(poblacion.get(j)); //Si no se cruzan los agregamos directamente en su posicion
			}
			//reiniciamos variables
			x=j+2; //para que siempre este uno por encima de la j
			encontrado=false;
		}
		
		return nuevaPobl;
	}
}
