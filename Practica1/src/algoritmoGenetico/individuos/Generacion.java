package algoritmoGenetico.individuos;

import java.util.ArrayList;


public class Generacion {
	private ArrayList<Individuo> poblacion;
	private ArrayList<Double> puntuaciones;
	private int tamPobl;
	private int pos_mejor;
	private double media;
	private Individuo elMejor;
	private Individuo elPeor;
	
	
	public Generacion(int tamañoPobl,int funcion,int numVariables4) {

		poblacion = new ArrayList<Individuo>();
		this.tamPobl = tamañoPobl;
		this.puntuaciones = new ArrayList<Double>();
		
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
	
	
	public void evaluarPoblacion() {}
}
