package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class Aritmetico {
	static ArrayList<Individuo> cruce(int cruce, ArrayList<Individuo> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl,boolean real) {
		
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
						int rand =(int) (Math.random()*(tamañoCromosoma-1));
						Double[] aux1 = new Double[tamañoCromosoma];
						Double[] aux2 = new Double[tamañoCromosoma];
						Double[] aux3 = new Double[tamañoCromosoma];
						System.arraycopy(poblacion.get(j).getCromosoma(), 0, aux1, 0, tamañoCromosoma);
						System.arraycopy(poblacion.get(x).getCromosoma(), 0, aux2, 0, tamañoCromosoma);
						double resul=0;
						for(int k=0;k<tamañoCromosoma;k++) {
							resul=((aux1[k]+aux2[k])/2);
							aux3[k]=resul;
						}
					
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.get(j).setCromosoma(aux3); 
						poblacion.get(x).setCromosoma(aux3);
						poblacion.get(x).setCruce(false); //ponemos cruce a false y cuando vuelva a salir se añadira a nuevaPobl en su posion
					} else {
						x++;
					}
				}
				if(encontrado==false) {
					nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
				}
			} else {
				nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma());  //Si no se cruzan los agregamos directamente en su posicion
			}
			//reiniciamos variables
			x=j+2; //para que siempre este uno por encima de la j
			encontrado=false;
		}
		
		return nuevaPobl;
	}
}
