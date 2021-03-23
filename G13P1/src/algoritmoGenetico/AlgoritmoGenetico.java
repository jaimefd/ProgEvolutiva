package algoritmoGenetico;

import java.util.ArrayList;
import javax.swing.*;
import org.math.plot.*;
import org.math.plot.Plot2DPanel;

import algoritmoGenetico.individuos.Generacion;
import algoritmoGenetico.individuos.Individuo;

public class AlgoritmoGenetico {
	
	private int tipoFuncion;
	private int tamPoblacion;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private boolean min;
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
	private double[] mejorAbsoluto;
	private double[] gener;
	private int numVariables4;
	//EXTRA
	private double[] peorGeneracion;
	private double[] peorAbsoluto;
	
	private Plot2DPanel _plot;

	public AlgoritmoGenetico(int tipoFuncion, int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,double valorError,int algoritmoSeleccion,int tipoCruce,int tipoMutacion,boolean hayElite,double probElite,int numVariables4,Plot2DPanel plot/*, int tamTorneo*/) {
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
		this.mejorAbsoluto=new double[this.maxGeneraciones];
		this.peorAbsoluto=new double[this.maxGeneraciones];
		this.gener=new double[this.maxGeneraciones];
		this.min=(this.tipoFuncion==1)?false:true;
		_plot=plot;
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion,this.tipoFuncion,this.numVariables4,this.valorError); //numVariables4 es el numero de variables para la funcion4
		gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
		media[0]=gen.getMedia();
		mejorGeneracion[0]=gen.getElMejor().getFitness();
		mejorAbsoluto[0]=mejorGeneracion[0];
		
		gener[0]=1;
		
		peorGeneracion[0]=gen.getElPeor().getFitness();//EXTRA
		peorAbsoluto[0]=peorGeneracion[0]; //EXTRA
		
		
		ArrayList<Individuo> elite = new ArrayList<Individuo>(); //luego vaciar
		while(this.genActual < this.maxGeneraciones) {	
			
			if(hayElite) {
				gen.generarElite(tamElite, elite,min);
			}
			// seleccion
			gen.seleccion(this.algoritmoSeleccion); 
			
			// cruce
			gen.cruce(tipoCruce, probCruce);
			
			// mutacion
			gen.mutar(tipoMutacion, probMutacion);
			
			if(hayElite) {
				gen.introducirElite(tamElite, elite,min);
			}
			//evaluar
			gen.evaluarPoblacion();
			
			//obtener datos y pasarselos a grafica
			media[this.genActual]=gen.getMedia();
			mejorGeneracion[this.genActual]=gen.getElMejor().getFitness();
			
			peorGeneracion[this.genActual]=gen.getElPeor().getFitness();//EXTRA
			
			if(this.tipoFuncion==1) {
				if(mejorGeneracion[this.genActual]>mejorAbsoluto[(genActual-1)]) {
					this.mejorAbsoluto[this.genActual]=mejorGeneracion[this.genActual];
				}
				else {
					this.mejorAbsoluto[this.genActual]=this.mejorAbsoluto[genActual-1];
				}
				
				if(peorGeneracion[this.genActual]<peorAbsoluto[(genActual-1)]) { //EXTRA
					this.peorAbsoluto[this.genActual]=peorGeneracion[this.genActual];
				}
				else {
					this.peorAbsoluto[this.genActual]=this.peorAbsoluto[genActual-1];
				}
			}
			else {
				if(mejorGeneracion[this.genActual]<mejorAbsoluto[(genActual-1)]) {
					this.mejorAbsoluto[this.genActual]=mejorGeneracion[this.genActual];
				}
				else {
					this.mejorAbsoluto[this.genActual]=this.mejorAbsoluto[genActual-1];
				}
				
				if(peorGeneracion[this.genActual]>=peorAbsoluto[(genActual-1)]) { //EXTRA
					this.peorAbsoluto[this.genActual]=peorGeneracion[this.genActual];
				}
				else {
					this.peorAbsoluto[this.genActual]=this.peorAbsoluto[genActual-1];
				}
			}
			
			
			this.genActual++;
			gener[this.genActual-1]=this.genActual;
		}
		generarGrafica(this.media,this.mejorAbsoluto,this.mejorGeneracion,this.peorAbsoluto);
	}
	
	public void inicializar() {
		this.genActual = 1;
	}
	
	
	public void generarGrafica(double[]media,double[] mejorFitnessAbsoluto,double[]mejorGeneracion,double[] peorAbsoluto) {
		_plot.addLinePlot("Mejor Absoluto", this.gener, mejorFitnessAbsoluto);
		_plot.addLinePlot("Mejor Generacion", this.gener, mejorGeneracion);
		_plot.addLinePlot("Media", this.gener, media);
		_plot.addLinePlot("Peor Absoluto", this.gener, peorAbsoluto);
	}
	
}
