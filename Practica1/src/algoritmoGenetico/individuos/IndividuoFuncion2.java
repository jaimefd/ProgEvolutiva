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
		double result = Math.abs(Math.sin(getFenotipo(0)) * Math.cos(getFenotipo(1)) * 
				Math.exp(Math.abs(1 - (Math.sqrt(Math.pow(getFenotipo(0),2) + Math.pow(getFenotipo(1), 2))/Math.PI))));
		return result * (-1);
	}

	public double getFenotipo(int i) {
		double min = this.min[i];
		double max = this.max[i];
	
		return min + genToDecimal(i)*((max-min)/(Math.pow(2, this.tamGenes[i])-1)); 
	}
	
	public int genToDecimal(int i) {  
		int acum = 0;
		int b = getIndexCrom(i);
		int exp = this.tamGenes[i]-1; //el valor mayor esta a la izquierda
		
		for(int x=0; x<this.tamGenes[i];x++) {
			acum+=((this.cromosoma[b] ? 1 : 0)*(int)(Math.pow(2, exp)));  // 1o0 * la potencia de 2 correspondiente
			exp--;
			b++;
		}
		return acum;
	}
	
	public int getIndexCrom(int gen) {  //para saber donde empieza un gen en un cromosoma
		int index=0;
		
		for(int i=0;i<gen;i++) {
			index+=this.tamGenes[i];
		}
		
		return index;
	}
	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

}
