package algoritmoGenetico.individuos;

import java.util.ArrayList;

import algoritmoGenetico.cruces.FactoriaCruce;
import algoritmoGenetico.mutaciones.FactoriaMutacion;
import algoritmoGenetico.seleccion.FactoriaSeleccion;


public class Generacion {
	private ArrayList<Individuo<Boolean>> poblacion;  //Array con los individuos de la generacion
	private ArrayList<Double> puntuaciones;  //Array con las puntuaciones de cada individuo
	private ArrayList<Double> puntAcu;  //Array con la puntuacion acumulada de cada individuo
	private int tamPobl;
	private int funcion;

	private double media;  //media de la generacio para la grafica!
	private Individuo elMejor;  //el mejor individuo de la generacion para la grafica!
	private Individuo elPeor;  //el peor individuo de la generacion para la grafica!
	private int pos_mejor_fitness;
	private int pos_peor_fitness;
	
	
	public Generacion(int tamañoPobl,int funcion,int numVariables4,double valorError) {

		poblacion = new ArrayList<Individuo<Boolean>>();
		this.tamPobl = tamañoPobl;
		this.puntuaciones = new ArrayList<Double>();
		this.funcion=funcion;
	
		
		if(funcion==1) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion1(valorError);
				poblacion.add(indiv);	
			}
		}
		else if(funcion==2) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion2(valorError);
				poblacion.add(indiv);	
			}
		}
		else if(funcion==3) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion3(valorError);
				poblacion.add(indiv);	
			}
		}
		else if(funcion==4) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion4(numVariables4,valorError);
				poblacion.add(indiv);	
			}
		}
		
		
	}
	
	
	public void evaluarPoblacion() {
		//¡¡¡No se si habria que vaciar los arrays de puntuaciones y reiniciar las variables!!!
		puntuaciones.clear();
		puntAcu.clear();
		double puntAcum=0; //puntuacion acumulada
		double fitnessTotal=0; //fitness total
		double fitnessActual=0; //fitness del individuo actual
		
		if(funcion==1) {  //hay que diferenciar la funcion 1 de las demas
			double mejorFitness=Double.MIN_VALUE; //mejor fitness de la generacion
			double peorFitness=Double.MAX_VALUE;
			
			for(int i=0;i<this.tamPobl;i++) {
				fitnessActual=this.poblacion.get(i).getFitness();
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
		}
		else {
			double mejorFitness=Double.MAX_VALUE;
			double peorFitness=Double.MIN_VALUE;
			
			for(int i=0;i<this.tamPobl;i++) {
				fitnessActual=this.poblacion.get(i).getFitness();
				fitnessTotal+=fitnessActual;
				if(fitnessActual<mejorFitness) {
					mejorFitness=fitnessActual;
					pos_mejor_fitness=i;
					elMejor=this.poblacion.get(pos_mejor_fitness);
				}
				
				if(fitnessActual>peorFitness) {
					peorFitness=fitnessActual;
					pos_peor_fitness=i;
					elPeor=this.poblacion.get(pos_peor_fitness);
				}
			}
	
		}
		
		for(int i=0;i<this.tamPobl;i++) {
			this.puntuaciones.add(this.poblacion.get(i).getFitness()/fitnessTotal); //añado al array de puntuaciones la puntuacion del individuo
			this.puntAcu.add(this.puntuaciones.get(i) + puntAcum); //añado al array de puntAcu la puntuacion acumulada del individuo
			puntAcum+=this.puntuaciones.get(i); //sumo a la puntuacion acumulada la del indiv actual
		}
		
		this.media=fitnessTotal/this.tamPobl;
		
		if(this.funcion==1) {
			desplazamiento_maximizar();
		}
		else {
			desplazamiento_minimizar();
		}
		
	}
	
	public void seleccion(String algoritmo) {
		this.poblacion = FactoriaSeleccion.getAlgoritmoSeleccion(algoritmo, this.poblacion, this.puntAcu, this.tamPobl);
		//evaluarPoblacion(); ???? No se si hay que evaluar la pobl. despues de hacer la seleccion
	}
	
	public void cruce(int tipoCruce,double probCruce) {
		this.poblacion= FactoriaCruce.getTipoCruce(tipoCruce, this.poblacion, probCruce, this.tamPobl);
	}
	
	public void mutar(int tipoMutacion,double probMutacion) {
		this.poblacion=FactoriaMutacion.getTipoMutacion(tipoMutacion, poblacion, probMutacion, this.tamPobl);
	}
	
	public void desplazamiento_minimizar() {}  //Falta por hacer porque tengo dudas
	
	public void desplazamiento_maximizar() {}  //Falta por hacer porque tengo dudas
	
	public void generarElite() {}  //FALTA
	public void introducirElite() {}  //FALTA


	public ArrayList<Individuo<Boolean>> getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(ArrayList<Individuo<Boolean>> poblacion) {
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


	public int getFuncion() {
		return funcion;
	}


	public void setFuncion(int funcion) {
		this.funcion = funcion;
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
