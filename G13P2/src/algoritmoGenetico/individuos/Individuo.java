package algoritmoGenetico.individuos;


public abstract class Individuo<T> implements Comparable<Individuo<T>> {
	
	T[] cromosoma;
	int[] tamGenes;
	int tamTotal;
	boolean cruce;
	boolean elite;
	String textoTraducido;
	
	
	public abstract double getValor();
	public abstract double getFitness();
	
	
	
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
	public String getTextoTraducido() {
		return textoTraducido;
	}
	public void setTextoTraducido(String textoTraducido) {
		this.textoTraducido = textoTraducido;
	}
	
	
	

}
