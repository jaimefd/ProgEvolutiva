package algoritmoGenetico;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Generacion;
import algoritmoGenetico.individuos.Individuo;

public class AlgoritmoGenetico {
	
	private int tipoFuncion;
	private int tamPoblacion;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	//private int tamTorneo;  he puesto directamente 3
	private int genActual;
	private double valorError; //precision
	//Tipos selecc. , cruce y mutacion
	private int algoritmoSeleccion; 
	private int tipoCruce; 
	private int tipoMutacion;
	private boolean hayElite; //si ha seleccionado elite
	private int tamElite; //tamaño elite
	//Grafica
	private double[] media;
	private double[] mejorGeneracion;
	private double mejorAbsoluto;
	

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,double valorError,int algoritmoSeleccion,int tipoCruce,int tipoMutacion,boolean hayElite,double probElite/*, int tamTorneo*/) {
		this.tipoFuncion = tipoFuncion;
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.valorError=valorError;
		this.algoritmoSeleccion=algoritmoSeleccion;
		this.tipoCruce=tipoCruce;
		this.tipoMutacion=tipoMutacion;
		this.hayElite=hayElite;
		this.tamElite=(int) (probElite*this.tamPoblacion*0.01);
		this.media=new double[this.maxGeneraciones];
		this.mejorGeneracion=new double[this.maxGeneraciones];
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion,this.tipoFuncion,7,this.valorError); //el 7 es por si es la funcion4
		gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
		media[0]=gen.getMedia();
		mejorGeneracion[0]=gen.getElMejor().getFitness();
		mejorAbsoluto=mejorGeneracion[0];
		
		
		ArrayList<Individuo<Boolean>> elite = new ArrayList<Individuo<Boolean>>(); //luego vaciar
		while(this.genActual < this.maxGeneraciones) {	
			
			if(hayElite) {
				gen.generarElite(tamElite, elite);
			}
			// seleccion
			gen.seleccion(this.algoritmoSeleccion); 
			/*hay que pasarle a la factoria un array nuevo inicializado y 
			luego solo cambiar cromosoma con set para que no salgan indiv con mismo id
			como en elite*/
			
			// cruce
			gen.cruce(tipoCruce, probCruce);
			/*hay que pasarle a la factoria un array nuevo inicializado y 
			luego solo cambiar cromosoma con set para que no salgan indiv con mismo id*/
			
			// mutacion
			gen.mutar(tipoMutacion, probMutacion);
			/*hay que pasarle a la factoria un array nuevo inicializado y 
			luego solo cambiar cromosoma con set para que no salgan indiv con mismo id*/
			
			if(hayElite) {
				gen.introducirElite(tamElite, elite);
			}
			//evaluar
			gen.evaluarPoblacion();
			
			//obtener datos y pasarselos a grafica
			media[this.genActual]=gen.getMedia();
			mejorGeneracion[this.genActual]=gen.getElMejor().getFitness();
			if(mejorGeneracion[this.genActual]>mejorAbsoluto) {
				this.mejorAbsoluto=mejorGeneracion[this.genActual];
			}
			

			generarGrafica();
			
			this.genActual++;
		}
	}
	
	public void inicializar() {
		this.genActual = 1;
	}
	
	
	public void generarGrafica() {
		
	}
	
}
