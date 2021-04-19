package algoritmoGenetico.cruces;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class Monopunto {


	static ArrayList<Individuo> cruce(int cruce, ArrayList<Individuo> poblacion,
			double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl) {

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
						Boolean[] aux1 = new Boolean[tamañoCromosoma];
						Boolean[] aux2 = new Boolean[tamañoCromosoma];
						//Cruce del primero
						System.arraycopy(poblacion.get(j).getCromosoma(), 0, aux1, 0, rand); //copiamos la parte del primero
						System.arraycopy(poblacion.get(x).getCromosoma(), rand, aux1, rand, tamañoCromosoma - rand); //copiamos la parte del segundo
						//Cruce del segundo
						System.arraycopy(poblacion.get(x).getCromosoma(), 0, aux2, 0, rand);
						System.arraycopy(poblacion.get(j).getCromosoma(), rand, aux2, rand, tamañoCromosoma - rand);
						
						poblacion.get(j).setCromosoma(aux1); //cambiamos el cromosoma antiguo por el nuevo
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
						poblacion.get(x).setCromosoma(aux2);
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
	
	static ArrayList<Individuo>cruceReal(int cruce, ArrayList<Individuo> poblacion,
	double probCruce,int tamPobl,ArrayList<Individuo> nuevaPobl){
		
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
						//Cruce del primero
						System.arraycopy(poblacion.get(j).getCromosoma(), 0, aux1, 0, rand); //copiamos la parte del primero
						System.arraycopy(poblacion.get(x).getCromosoma(), rand, aux1, rand, tamañoCromosoma - rand); //copiamos la parte del segundo
						//Cruce del segundo
						System.arraycopy(poblacion.get(x).getCromosoma(), 0, aux2, 0, rand);
						System.arraycopy(poblacion.get(j).getCromosoma(), rand, aux2, rand, tamañoCromosoma - rand);
						
						poblacion.get(j).setCromosoma(aux1); //cambiamos el cromosoma antiguo por el nuevo
						poblacion.get(j).setCruce(false); //ponemos cruce a false para no volver a cruzarlo
						nuevaPobl.get(j).setCromosoma(poblacion.get(j).getCromosoma()); 
						poblacion.get(x).setCromosoma(aux2);
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
