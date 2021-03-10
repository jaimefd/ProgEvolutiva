package algoritmoGenetico.individuos;

import java.util.Random;

public class IndividuoFuncion2 extends Individuo<Boolean>{
	
	public IndividuoFuncion2() {
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -10.000;
		this.min[1] = -10.000;
		this.max[0] = 10.000;
		this.max[1] = 10.000;
		this.tamGenes = new int[2];
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		
		Random rd = new Random();
		for(int i = 0; i < tamTotal; i++) {
			this.cromosoma[i] = rd.nextBoolean();
		}
	}

	@Override
	public double getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

}
