package algoritmoGenetico.individuos;

public abstract class Individuo<T> {
	
	T[] cromosoma;
	int[] tamGenes;
	int tamTotal;
	double[] min;
	double[] max;
	double valorError;
	boolean cruce;
	
	public abstract double getValor();
	public abstract double getFitness();
	
	public int tamGen(double valorError , double min , double max) {
		return (int) (Math.log10(((max-min ) / valorError) + 1) / Math.log10(2));
	}
	
	
	public T[] getCromosoma() {
		return cromosoma;
	}
	public void setCromosoma(T[] cromosoma) {
		this.cromosoma = cromosoma;
	}
	public int getTamTotal() {
		return tamTotal;
	}
	public boolean isCruce() {
		return cruce;
	}
	public void setCruce(boolean cruce) {
		this.cruce = cruce;
	}
	
	

}
