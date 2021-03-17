package algoritmoGenetico;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Generacion;
import algoritmoGenetico.individuos.Individuo;

public class AlgoritmoGenetico {
	
	private int tipoFuncion;
	private int tamPoblacion;
	private Individuo[] poblacion;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	//private int tamTorneo;  he puesto directamente 3
	private Individuo elMejor;
	private int posMejor;
	private int genActual;
	private double valorError; //precision
	private int algoritmoSeleccion; // Es mejor int
	private int tipoCruce; 
	private int tipoMutacion;
	

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,double valorError,int algoritmoSeleccion,int tipoCruce,int tipoMutacion/*, int tamTorneo*/) {
		this.tipoFuncion = tipoFuncion;
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.valorError=valorError;
		this.algoritmoSeleccion=algoritmoSeleccion;
		this.tipoCruce=tipoCruce;
		this.tipoMutacion=tipoMutacion;
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion,this.tipoFuncion,7,this.valorError); //el 7 es por si es la funcion4
		gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
		ArrayList<Individuo<Boolean>> elite = new ArrayList<Individuo<Boolean>>();
		ArrayList<Double> puntuacionElite = new ArrayList<Double>();
		ArrayList<Double> puntuacionAcElite = new ArrayList<Double>(); //luego hay que vaciar tras introducir elite
		while(this.genActual < this.maxGeneraciones) {	
			/* hay que guardar la media, el mejor de la generacion, el ,mejor absoluto, el peor de la generacion*/
			
			// seleccion
			gen.seleccion(this.algoritmoSeleccion);
			
			// cruce
			gen.cruce(tipoCruce, probCruce);
			
			// mutacion
			gen.mutar(tipoMutacion, probMutacion);
			
			//evaluar
			gen.evaluarPoblacion();
			
			//obtener datos y pasarselos a grafica
			
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
