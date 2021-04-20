package algoritmoGenetico.individuos;

import java.util.ArrayList;

public abstract class Individuo<T> implements Comparable<Individuo<T>> {
	
	T[] cromosoma;
	int[] tamGenes;
	int tamTotal;
	boolean cruce;
	boolean elite;
	ArrayList<Character> dic;
	
	
	public abstract double getValor();
	public abstract double getFitness();
	public abstract String traducirTexto(String texto);
	public abstract String getCrom();
	
	
	
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
	public int[] getTamGenes() {
		return tamGenes;
	}
	public void setTamGenes(int[] tamGenes) {
		this.tamGenes = tamGenes;
	}
	public int getTamTotal() {
		return tamTotal;
	}
	public void setTamTotal(int tamTotal) {
		this.tamTotal = tamTotal;
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
	
	
	

}
