package algoritmoGenetico.individuos;

import java.io.IOException;

import algoritmoGenetico.individuos.Arbol.Hijo;

public class IndividuoArbol extends Individuo<Arbol> {
		
		public IndividuoArbol(int profMin,int profMax) {
			this.cruce=false;
			this.elite=false;
			this.fitness=0;
			Arbol arbol=new Arbol();
			arbol.setPrim(true); //para que no ponga avanza o gira en el primer arbol
			//Inicializamos el arbol
			arbol.crearArbol(arbol, profMin, profMax);
			arbol.setPadre(null);
			arbol.tipoHijo = Hijo.RAIZ;
			this.cromosoma=arbol;
		}

		@Override
		public int getValor() throws IOException{ 
			//Creamos el tablero original
			Tablero tablero=new Tablero();
			//LLamamos a la funcion start donde la hormiga ira recorriendo el tablero y lo modificara
			while((tablero.getPasos()>0) && tablero.getComidas()<89){
				tablero.start(this.cromosoma);
			}
			//Guardamos los trozos de comida comidos y los pasos dados que compondran el fitness. Cuanto mayor sea la variable pasos -> - pasos ha dado
			this.fitness=tablero.getComidas() + tablero.getPasos();	
			
			return this.fitness;
		}


		@Override
		public int getFitness() {
			// TODO Auto-generated method stub
			return this.fitness;
		}
		

}
