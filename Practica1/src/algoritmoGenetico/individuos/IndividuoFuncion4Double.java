package algoritmoGenetico.individuos;

public class IndividuoFuncion4Double extends Individuo<Double> {
	int numVariables;
	
	public IndividuoFuncion4Double(int numVariables,double valorError) {
		this.valorError=valorError;
		this.cruce=false;
		this.elite=false;
		this.numVariables = numVariables;
		this.tamGenes = new int[numVariables];
		this.min = new double[numVariables];
		this.max = new double[numVariables];
		this.tamTotal = 0;
		for(int i = 0; i < numVariables; i++) {
			this.min[i] = 0;
			this.max[i] = Math.PI;
			this.tamGenes[i]=1;
			this.tamTotal += 1;
		}
		this.cromosoma = new Double[tamTotal];
		
		Double rand;
		for(int i = 0; i < tamTotal; i++) {
			rand=Math.random()*(this.max[i]-this.min[i]);
			rand+=this.min[i];
			this.cromosoma[i] = rand;
		}
	}

	@Override
	public double getValor() {
		double result = 0;
		
		for (int i = 0; i < this.numVariables; i++) {
			double xi = getFenotipo(i);
			result += Math.sin(xi)*Math.pow(Math.sin(((i + 2)*Math.pow(xi, 2))/Math.PI), 20);
		}
		
		return -result;
	}

	public double getFenotipo(int variable) {
		return this.cromosoma[variable];
	}
	
	@Override
	public double getFitness() {
		return this.getValor();
	}
}
