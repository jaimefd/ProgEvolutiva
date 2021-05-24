package algoritmoGenetico.individuos;

import java.io.IOException;
import java.util.ArrayList;

import algoritmoGenetico.cruces.FactoriaCruce;
import algoritmoGenetico.mutaciones.FactoriaMutacion;
import algoritmoGenetico.seleccion.FactoriaSeleccion;


public class Generacion {
	private ArrayList<Individuo<Arbol>> poblacion;  //Array con los individuos de la generacion
	private ArrayList<Double> puntuaciones;  //Array con las puntuaciones de cada individuo
	private ArrayList<Double> puntAcu;  //Array con la puntuacion acumulada de cada individuo
	private int tamPobl;
	private int profMax; //Profundidad maxima pasada por interfaz
	

	private double media;  //media de la generacio para la grafica!
	private Individuo elMejor;  //el mejor individuo de la generacion para la grafica!
	private Individuo elPeor;  //el peor individuo de la generacion para la grafica!
	private int pos_mejor_fitness;
	private int pos_peor_fitness;
	
	
	public Generacion(int tama�oPobl,int profMax) {

		poblacion = new ArrayList<Individuo<Arbol>>();
		this.tamPobl = tama�oPobl;
		this.puntuaciones = new ArrayList<Double>();
		this.puntAcu=new ArrayList<Double>();
		this.profMax=profMax;
		
		iniciarIndividuos(this.tamPobl,this.poblacion);
		
	}
	
	
	public void evaluarPoblacion() throws IOException{
		//Vaciamos Arrays para volver a calcular puntuaciones
		puntuaciones.clear();
		puntAcu.clear();
		double puntAcum=0; //puntuacion acumulada
		double fitnessTotal=0; //fitness total
		double fitnessActual=0; //fitness del individuo actual
		

		double mejorFitness=Double.MIN_VALUE; //mejor fitness de la generacion
		double peorFitness=Double.MAX_VALUE;
		
		for(int i=0;i<this.tamPobl;i++) {
			fitnessActual=this.poblacion.get(i).getValor();
			fitnessTotal+=fitnessActual;
			if(fitnessActual>mejorFitness) {
				mejorFitness=fitnessActual;
				pos_mejor_fitness=i;
				elMejor=this.poblacion.get(pos_mejor_fitness);
			}
			
			if(fitnessActual<peorFitness) {
				peorFitness=fitnessActual;
				pos_peor_fitness=i;
				elPeor=this.poblacion.get(pos_peor_fitness);
			}
		}
		
		
		for(int i=0;i<this.tamPobl;i++) {
			this.puntuaciones.add(this.poblacion.get(i).getFitness()/fitnessTotal); //a�ado al array de puntuaciones la puntuacion del individuo
			this.puntAcu.add(this.puntuaciones.get(i) + puntAcum); //a�ado al array de puntAcu la puntuacion acumulada del individuo
			puntAcum+=this.puntuaciones.get(i); //sumo a la puntuacion acumulada la del indiv actual
		}
		
		this.media= (fitnessTotal/this.tamPobl);
		
		//desplazamiento_minimizar(); //por si hay valores negativos para seleccion
	}
	
	public void seleccion(int algoritmo) {
		ArrayList<Individuo<Arbol>> nueva= new ArrayList<Individuo<Arbol>>();
		iniciarIndividuos(this.tamPobl,nueva);
		FactoriaSeleccion.getAlgoritmoSeleccion(algoritmo, this.poblacion, this.puntAcu, this.puntuaciones, this.tamPobl,nueva);
		this.poblacion=nueva;
	}
	
	public void cruce(int tipoCruce,double probCruce,int[] totalCruces) {
		ArrayList<Individuo<Arbol>> nueva= new ArrayList<Individuo<Arbol>>();
		iniciarIndividuos(this.tamPobl,nueva);
		FactoriaCruce.getTipoCruce(tipoCruce, this.poblacion, probCruce, this.tamPobl,nueva,totalCruces);
		this.poblacion=nueva;
	}
	
	/*public void mutar(int tipoMutacion,double probMutacion,int[] totalMutaciones) {
		this.poblacion=new ArrayList<Individuo<Character>>(FactoriaMutacion.getTipoMutacion(tipoMutacion, poblacion, probMutacion, this.tamPobl,totalMutaciones));
	}*/
	
	
	/*public void desplazamiento_minimizar() {
		double Fmax = elPeor.getFitness() * 1.05; //en este caso el mejor es el mas grande
		double puntAcumu=0;
		double nuevoFitnessTotal=0;
		for(int i=0; i<this.puntuaciones.size(); i++)
		{
			puntuaciones.set(i,Math.abs(Fmax-poblacion.get(i).getFitness()));
			nuevoFitnessTotal+=(puntuaciones.get(i));
		}
		
		for(int i=0;i<this.puntuaciones.size(); i++) {
			puntuaciones.set(i, (puntuaciones.get(i)/nuevoFitnessTotal));
		}
		
		for(int j=0;j<this.puntAcu.size();j++) {
			puntAcumu+=puntuaciones.get(j);
			puntAcu.set(j, puntAcumu);
		}
	}*/
	
	public void generarElite(int tamElite,ArrayList<Individuo<Arbol>> elite) { 
		iniciarIndividuos(tamElite,elite);
		
		for(int i=0;i<tamElite;i++) {
			double mejorFitness=this.poblacion.get(0).getFitness();
			int pos=0;
			for(int j=1;j<this.tamPobl;j++) {
				if((this.poblacion.get(j).getFitness()>mejorFitness) && (this.poblacion.get(j).isElite()==false)){
					mejorFitness=this.poblacion.get(j).getFitness();
					pos=j;
				}
			}
			
			elite.get(i).setCromosoma(this.poblacion.get(pos).getCromosoma());
			this.poblacion.get(pos).setElite(true);
		}
	}  
	
	public void introducirElite(int tamElite,ArrayList<Individuo<Arbol>> elite) {
		for(int i=0;i<tamElite;i++) {
			double peorFitness=this.poblacion.get(0).getFitness();
			int pos=0;
			this.poblacion.get(0).setElite(false);
			for(int j=1;j<this.tamPobl;j++) {
				this.poblacion.get(0).setElite(false); //volvemos a poner todos a false
				if((this.poblacion.get(j).getFitness()<peorFitness)){
					peorFitness=this.poblacion.get(j).getFitness(); //sustituimos elite por los que peor fitness tengan
					pos=j;
				}
				
			}
			this.poblacion.get(pos).setCromosoma(elite.get(i).getCromosoma());
		}
		elite.clear(); //dejamos vacio array elite
		
	}

	public void iniciarIndividuos(int tamPobl,ArrayList<Individuo<Arbol>> poblacion) {
		//Iniciamos los individuos aplicando Ramped and Half que combina metodo completo+creciente
		int grupos=profMax-1;
		int integrantes=tamPobl/grupos;
		
		for(int i=0;i<grupos;i++) {
			for(int j=0;j< Math.ceil(integrantes/2);j++) { //metodo creciente
				Individuo<Arbol> indiv =new IndividuoArbol(0,i+2);
				poblacion.add(indiv);
			}
			
			for(int x = (int) Math.ceil(integrantes/2); x < integrantes; x++) { //metodo completo
				Individuo<Arbol> indiv =new IndividuoArbol(i+2,i+2);
				poblacion.add(indiv);
			}
		}
		
		for(int z=integrantes*grupos;z<tamPobl;z++) {  //por si falta alguno. EJ: 100/3=33 y sobra 1
			Individuo<Arbol> indiv =new IndividuoArbol(0,grupos);
			poblacion.add(indiv);
		}
		
	}

	public ArrayList<Individuo<Arbol>> getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(ArrayList<Individuo<Arbol>> poblacion) {
		this.poblacion = poblacion;
	}


	public ArrayList<Double> getPuntuaciones() {
		return puntuaciones;
	}


	public void setPuntuaciones(ArrayList<Double> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}


	public ArrayList<Double> getPuntAcu() {
		return puntAcu;
	}


	public void setPuntAcu(ArrayList<Double> puntAcu) {
		this.puntAcu = puntAcu;
	}


	public int getTamPobl() {
		return tamPobl;
	}


	public void setTamPobl(int tamPobl) {
		this.tamPobl = tamPobl;
	}

	public double getMedia() {
		return media;
	}


	public void setMedia(double media) {
		this.media = media;
	}


	public Individuo getElMejor() {
		return elMejor;
	}


	public void setElMejor(Individuo elMejor) {
		this.elMejor = elMejor;
	}


	public Individuo getElPeor() {
		return elPeor;
	}


	public void setElPeor(Individuo elPeor) {
		this.elPeor = elPeor;
	}


	public int getPos_mejor_fitness() {
		return pos_mejor_fitness;
	}


	public void setPos_mejor_fitness(int pos_mejor_fitness) {
		this.pos_mejor_fitness = pos_mejor_fitness;
	}


	public int getPos_peor_fitness() {
		return pos_peor_fitness;
	}


	public void setPos_peor_fitness(int pos_peor_fitness) {
		this.pos_peor_fitness = pos_peor_fitness;
	}
	

}
