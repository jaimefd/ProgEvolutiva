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
	private int numVariables4;
	//EXTRA
	private double[] peorGeneracion;
	private double peorAbsoluto;
	

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,double valorError,int algoritmoSeleccion,int tipoCruce,int tipoMutacion,boolean hayElite,double probElite,int numVariables4/*, int tamTorneo*/) {
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
		this.numVariables4=numVariables4;
		this.peorGeneracion=new double[this.maxGeneraciones];
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion,this.tipoFuncion,this.numVariables4,this.valorError); //numVariables4 es el numero de variables para la funcion4
		gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
		media[0]=gen.getMedia();
		mejorGeneracion[0]=gen.getElMejor().getFitness();
		mejorAbsoluto=mejorGeneracion[0];
		
		peorGeneracion[0]=gen.getElPeor().getFitness();//EXTRA
		peorAbsoluto=peorGeneracion[0]; //EXTRA
		
		
		ArrayList<Individuo> elite = new ArrayList<Individuo>(); //luego vaciar
		while(this.genActual < this.maxGeneraciones) {	
			
			if(hayElite) {
				gen.generarElite(tamElite, elite);
			}
			// seleccion
			gen.seleccion(this.algoritmoSeleccion); 
			
			// cruce
			gen.cruce(tipoCruce, probCruce);
			
			// mutacion
			gen.mutar(tipoMutacion, probMutacion);
			
			if(hayElite) {
				gen.introducirElite(tamElite, elite);
			}
			//evaluar
			gen.evaluarPoblacion();
			
			//obtener datos y pasarselos a grafica
			media[this.genActual]=gen.getMedia();
			mejorGeneracion[this.genActual]=gen.getElMejor().getFitness();
			
			peorGeneracion[this.genActual]=gen.getElPeor().getFitness();//EXTRA
			
			if(this.tipoFuncion==1) {
				if(mejorGeneracion[this.genActual]>mejorAbsoluto) {
					this.mejorAbsoluto=mejorGeneracion[this.genActual];
				}
				
				if(peorGeneracion[this.genActual]<peorAbsoluto) { //EXTRA
					this.peorAbsoluto=peorGeneracion[this.genActual];
				}
			}
			else {
				if(mejorGeneracion[this.genActual]<mejorAbsoluto) {
					this.mejorAbsoluto=mejorGeneracion[this.genActual];
				}
				
				if(peorGeneracion[this.genActual]>peorAbsoluto) { //EXTRA
					this.peorAbsoluto=peorGeneracion[this.genActual];
				}
			}
			

			generarGrafica(this.media,this.mejorAbsoluto,this.mejorGeneracion,this.peorAbsoluto);
			
			this.genActual++;
		}
	}
	
	public void inicializar() {
		this.genActual = 1;
	}
	
	
	public void generarGrafica(double[]media,double mejorFitnessAbsoluto,double[]mejorGeneracion,double peorAbsoluto) {
		
	}
	
}
