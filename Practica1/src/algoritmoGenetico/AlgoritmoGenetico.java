package algoritmoGenetico;

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
	private double valorError;
	private String algoritmoSeleccion;
	

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,double valorError,String algoritmoSeleccion/*, int tamTorneo*/) {
		this.tipoFuncion = tipoFuncion;
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.valorError=valorError;
		this.algoritmoSeleccion=algoritmoSeleccion;
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion,this.tipoFuncion,7,this.valorError); //el 7 es por si es la funcion4
		while(this.genActual < this.maxGeneraciones) {	
			gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
			/* hay que guardar la media, el mejor de la generacion, el ,mejor absoluto, el peor de la generacion*/
			
			// seleccion
			gen.seleccion(this.algoritmoSeleccion);
			
			// cruce
			
			// mutacion
			
			evaluar();
			generarGrafica();
			
			this.genActual++;
		}
	}
	
	public void inicializar() {
		this.genActual = 1;
	}
	
	public void evaluar() {
		
	}
	
	public void generarGrafica() {
		
	}
	
}
