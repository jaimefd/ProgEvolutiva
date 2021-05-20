package algoritmoGenetico.individuos;



public class IndividuoArbol extends Individuo<Arbol> {
		
		public IndividuoArbol(int profMin,int profMax) {
			this.cruce=false;
			this.elite=false;
			this.fitness=0;
			Arbol arbol=new Arbol();
			
			//Inicializamos el arbol
			arbol.crearArbol(arbol, profMin, profMax);
			arbol.setProf(profMax);
			this.cromosoma=arbol;
		}

		@Override
		public int getValor() { 
			//this.fitness=resultado
			return 0;
		}


		@Override
		public int getFitness() {
			// TODO Auto-generated method stub
			return this.fitness;
		}
		

}
