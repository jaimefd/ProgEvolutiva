package algoritmoGenetico.individuos;

import java.util.ArrayList;


public class Generacion {
	private ArrayList<Individuo> poblacion;  //Array con los individuos de la generacion
	private ArrayList<Double> puntuaciones;  //Array con las puntuaciones de cada individuo
	private int tamPobl;

	private double media;  //media de la generacion
	private Individuo elMejor;  //el mejor individuo de la generacion
	private Individuo elPeor;  //el peor individuo de la generacion
	
	
	public Generacion(int tamaņoPobl,int funcion,int numVariables4) {

		poblacion = new ArrayList<Individuo>();
		this.tamPobl = tamaņoPobl;
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
