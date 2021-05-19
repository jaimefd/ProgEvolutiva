package algoritmoGenetico.individuos;

public abstract class Individuo<T> implements Comparable<Individuo<T>> {
	
	Arbol cromosoma;
	boolean cruce;
	boolean elite;
	
	
	public abstract int getValor();
	public abstract int getFitness();
	
	
	
	
	public int compareTo(Individuo<T> comparingTo) {
		double compareFitness=((Individuo<T>)comparingTo).getFitness() - this.getFitness();
		if (compareFitness < 0) {
			return 1;
		} else if (compareFitness > 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	
	public Arbol getCromosoma() {
		return cromosoma;
	}
	public void setCromosoma(Arbol cromosoma) {
		this.cromosoma = (Arbol) cromosoma.clone();
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
