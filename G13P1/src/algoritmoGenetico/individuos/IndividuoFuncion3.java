package algoritmoGenetico.individuos;

import java.util.Random;

public class IndividuoFuncion3 extends Individuo<Boolean> {
	
	public IndividuoFuncion3(double valorError) {
		this.valorError=valorError;
		this.elite=false;
		this.cruce=false;
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -10.000;
		this.min[1] = -10.000;
		this.max[0] = 10.000;
		this.max[1] = 10.000;
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		this.tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		Random rd = new Random();
		for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = rd.nextBoolean();
	}

	@Override
	public double getValor() {
		double x = getFenotipo(0), y = getFenotipo(1);
		return -Math.abs(Math.sin(x)*Math.cos(y)*Math.exp(Math.abs(1 - (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))/Math.PI))));
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
