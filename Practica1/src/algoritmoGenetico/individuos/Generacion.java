package algoritmoGenetico.individuos;

import java.util.ArrayList;


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
	
	
	public Generacion(int tama�oPobl,int funcion,int numVariables4) {

		poblacion = new ArrayList<Individuo<Boolean>>();
		this.tamPobl = tama�oPobl;
		this.puntuaciones = new ArrayList<Double>();
		this.funcion=funcion;
	
		
		if(funcion==1) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion1();
				poblacion.add(indiv);	
			}
		}
		else if(funcion==2) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion2();
				poblacion.add(indiv);	
			}
		}
		else if(funcion==3) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion3();
				poblacion.add(indiv);	
			}
		}
		else if(funcion==4) {
			for(int i = 0; i < tamPobl; i++)
			{
				Individuo<Boolean> indiv = new IndividuoFuncion4(numVariables4);
				poblacion.add(indiv);	
			}
		}
		
		
	}
	
	
	public void evaluarPoblacion() {
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
			this.puntuaciones.add(this.poblacion.get(i).getFitness()/fitnessTotal); //a�ado al array de puntuaciones la puntuacion del individuo
			this.puntAcu.add(this.puntuaciones.get(i) + puntAcum); //a�ado al array de puntAcu la puntuacion acumulada del individuo
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
	
	public void seleccion() {}
	
	public void desplazamiento_minimizar() {}
	
	public void desplazamiento_maximizar() {}
}
