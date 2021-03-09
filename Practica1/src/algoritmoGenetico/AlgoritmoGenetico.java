package algoritmoGenetico;

import algoritmoGenetico.individuos.Individuo;

public class AlgoritmoGenetico {
	
	private int tipoFuncion;
	private int tamPoblacion;
	private Individuo[] poblacion;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor;
	private int posMejor;
	private int genActual;

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion, int tamTorneo) {
		this.tipoFuncion = tipoFuncion;
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		while(this.genActual < this.maxGeneraciones) {
			// seleccion
			
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
