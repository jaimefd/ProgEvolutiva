package algoritmoGenetico.individuos;

public abstract class Individuo<T> {
	
	T[] cromosoma;
	int[] tamGenes;
	double[] min;
	double[] max;
	
	public abstract double getValor();
	public abstract double getFitness();
	public abstract int tamGen();

}
