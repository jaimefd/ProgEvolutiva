package algoritmoGenetico.individuos;

import java.util.Random;

public abstract class Individuo<T> {
	
	T[] cromosoma;
	int[] tamGenes;
	double[] min;
	double[] max;
	double valorError;
	Random rand;
	
	public abstract double getValor();
	public abstract double getFitness();
	
	public int tamGen(double valorError , double min , double max) {
		return (int) (Math.log10(((max-min ) / valorError) + 1) / Math.log10(2));
	}

}
