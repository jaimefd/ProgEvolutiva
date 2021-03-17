package algoritmoGenetico.individuos;

public abstract class Individuo<T> implements Comparable<Individuo<T>> {
	
	T[] cromosoma;
	int[] tamGenes;
	int tamTotal;
	double[] min;
	double[] max;
	double valorError;
	boolean cruce;
	boolean elite;
	
	public abstract double getValor();
	public abstract double getFitness();
	
	public int tamGen(double valorError , double min , double max) {
		return (int) (Math.log10(((max-min ) / valorError) + 1) / Math.log10(2));
	}
	
	public int compareTo(Individuo<T> comparingTo) {
		double compareFitness=((Individuo<T>)comparingTo).getFitness() - this.getFitness();
		if (compareFitness < 0) {
			return -1;
		} else if (compareFitness > 0) {
			return 1;
		} else {
			return 0;
		}
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
	public boolean isElite() {
		return elite;
	}
	public void setElite(boolean elite) {
		this.elite = elite;
	}
	
	public void copia(Individuo<T> indiv) {
		this.cromosoma=indiv.cromosoma;
		this.cruce=indiv.cruce;
		this.elite=false;
		this.max=indiv.max;
		this.min=indiv.min;
		this.tamGenes=indiv.tamGenes;
		this.tamTotal=indiv.tamTotal;
		this.valorError=indiv.valorError;
	}
	
	

}
