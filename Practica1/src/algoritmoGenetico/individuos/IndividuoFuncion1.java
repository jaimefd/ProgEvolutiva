package algoritmoGenetico.individuos;

import java.util.Random;

public class IndividuoFuncion1 extends Individuo<Boolean> {	
	
	public IndividuoFuncion1(double valorError) {
		this.valorError=valorError;
		this.cruce=false;
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.tamGenes = new int[2];
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		this.tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		
		Random rd = new Random();
		for(int i = 0; i < tamTotal; i++) {
			this.cromosoma[i] = rd.nextBoolean();
		}
		
	}

	@Override
	public double getValor() {
		// TODO Auto-generated method stub
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
	}

	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return this.getValor();
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
}

