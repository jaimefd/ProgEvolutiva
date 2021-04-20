package algoritmoGenetico;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import org.math.plot.*;
import org.math.plot.Plot2DPanel;

import algoritmoGenetico.ficheros.Ngrams;
import algoritmoGenetico.individuos.Generacion;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.TextoEntrada;

public class AlgoritmoGenetico {
	
	
	private int tamPoblacion;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	//private int tamTorneo;  he puesto directamente 3
	private int genActual;
	//Tipos selecc. , cruce y mutacion
	private int algoritmoSeleccion; 
	private int tipoCruce; 
	private int tipoMutacion;
	private boolean hayElite; //si ha seleccionado elite
	private int tamElite; //tamaño elite
	private String mejorTraduccion;
	private String textoEntrada;
	private String mejorTexto;
	//Grafica
	private double[] media;
	private double[] mejorGeneracion;
	private double[] mejorAbsoluto;
	private double[] gener;
	//EXTRA
	private double[] peorGeneracion;
	private double[] peorAbsoluto;
	
	//PANEL MEJOR INDIVIDUO
	JTextField mejorFitnessPanel;
	JTextField mejorCromosomaPanel;
	JTextArea textoSalida;
	private Plot2DPanel _plot;

	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, 
			double probMutacion,int algoritmoSeleccion,int tipoCruce,int tipoMutacion,boolean hayElite,double probElite,Plot2DPanel plot/*, int tamTorneo*/
			, JTextField mejorFitnessPanel, JTextField mejorCromosomaPanel,String textoIntr,JTextArea textoSalida) throws IOException {

		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.algoritmoSeleccion=algoritmoSeleccion;
		this.tipoCruce=tipoCruce;
		this.tipoMutacion=tipoMutacion;
		this.hayElite=hayElite;
		this.tamElite=(int) (probElite*this.tamPoblacion*0.01);
		this.media=new double[this.maxGeneraciones];
		this.mejorGeneracion=new double[this.maxGeneraciones];
		this.peorGeneracion=new double[this.maxGeneraciones];
		this.mejorAbsoluto=new double[this.maxGeneraciones];
		this.peorAbsoluto=new double[this.maxGeneraciones];
		this.gener=new double[this.maxGeneraciones];
		_plot=plot;
		this.mejorCromosomaPanel=mejorCromosomaPanel;
		this.mejorFitnessPanel=mejorFitnessPanel;
		this.mejorTraduccion="";
		this.textoEntrada=textoIntr;
		new TextoEntrada(this.textoEntrada);
		new Ngrams();
		this.textoSalida=textoSalida;
		this.mejorTexto="";
		
		//this.tamTorneo = tamTorneo;
	}

	public void run() {
		inicializar();
		Generacion gen= new Generacion(this.tamPoblacion); //numVariables4 es el numero de variables para la funcion4
		gen.evaluarPoblacion(); //evaluamos la poblacion para obtener la media, el mejor, peor de esa generacion...
		media[0]=gen.getMedia();
		mejorGeneracion[0]=gen.getElMejor().getFitness();
		mejorAbsoluto[0]=mejorGeneracion[0];
		this.mejorTraduccion=gen.getElMejor().getCrom();
		this.mejorTexto=gen.getElMejor().traducirTexto(this.textoEntrada);
		gener[0]=1;
		
		peorGeneracion[0]=gen.getElPeor().getFitness();//EXTRA
		peorAbsoluto[0]=peorGeneracion[0]; //EXTRA
		
		
		ArrayList<Individuo<Character>> elite = new ArrayList<Individuo<Character>>(); //luego vaciar
		while(this.genActual < this.maxGeneraciones) {	
			
			if(hayElite) {
				gen.generarElite(tamElite, elite);
			}
			// seleccion
			gen.seleccion(this.algoritmoSeleccion); 
			
			// cruce
		//	gen.cruce(tipoCruce, probCruce);
			
			// mutacion
		//	gen.mutar(tipoMutacion, probMutacion);
			
			if(hayElite) {
				gen.introducirElite(tamElite, elite);
			}
			//evaluar
			gen.evaluarPoblacion();
			
			//obtener datos y pasarselos a grafica
			media[this.genActual]=gen.getMedia();
			mejorGeneracion[this.genActual]=gen.getElMejor().getFitness();
			
			peorGeneracion[this.genActual]=gen.getElPeor().getFitness();//EXTRA
			
			
			if(mejorGeneracion[this.genActual]>mejorAbsoluto[(genActual-1)]) {
				this.mejorAbsoluto[this.genActual]=mejorGeneracion[this.genActual];
				this.mejorTraduccion=gen.getElMejor().getCrom();
				this.mejorTexto=gen.getElMejor().traducirTexto(this.textoEntrada);
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
		//Actualizamos panel mejor individuo
		mejorFitnessPanel.setText(String.valueOf(this.mejorAbsoluto[this.genActual-1]));
		mejorCromosomaPanel.setText(this.mejorTraduccion);
		textoSalida.setText(mejorTexto);
	}
	
}
