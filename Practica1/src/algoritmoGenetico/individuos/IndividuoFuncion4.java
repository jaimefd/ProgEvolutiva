package algoritmoGenetico.individuos;

import java.util.Random;

public class IndividuoFuncion4 extends Individuo<Boolean> {
	
	int numVariables;
	
	public IndividuoFuncion4(int numVariables) {
		this.numVariables = numVariables;
		this.tamGenes = new int[numVariables];
		this.min = new double[numVariables];
		this.max = new double[numVariables];
		int tamTotal = 0;
		for(int i = 0; i < numVariables; i++) {
			this.min[i] = 0;
			this.max[i] = Math.PI;
			this.tamGenes[i] = this.tamGen(this.valorError, min[i], max[i]);
			tamTotal += this.tamGenes[i];
		}
		this.cromosoma = new Boolean[tamTotal];
		this.rand = new Random();
		for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
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

	@Override
	public double getFitness() {
		return this.getValor();
	}
	
	public double getFenotipo(int variable) {
		double min = this.min[variable], max = this.max[variable];
		return min + binToDecimal(variable)*((max-min)/(Math.pow(2, this.tamGenes[variable])-1)); 
	}

	private double binToDecimal(int variable) {
		double result = 0;
		int tamGen = this.tamGenes[variable];
		int startIndex = 0;
		for (int j = 0; j < variable; j++) startIndex += this.tamGenes[j];
		
		for (int k = 0; k < tamGen; k++) {
			if (this.cromosoma[k + startIndex]) {
				result += Math.pow(2, tamGen - k - 1);
			}
		}
		
		return result;
	}

}
