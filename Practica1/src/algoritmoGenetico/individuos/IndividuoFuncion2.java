package algoritmoGenetico.individuos;

import java.util.Random;

public class IndividuoFuncion2 extends Individuo<Boolean>{
	
	public IndividuoFuncion2(double valorError) {
		this.valorError=valorError;
		this.cruce=false;
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -10.000;
		this.min[1] = -10.000;
		this.max[0] = 10.000;
		this.max[1] = 10.000;
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
		double ret=0,p1=0,p2=0;
		for(int i=1; i<=5; i++)
		{
			p1 += i*Math.cos((i+1)*getFenotipo(0)+i);
			p2 += i*Math.cos((i+1)*getFenotipo(1)+i);
		}
		ret=p1*p2;
		return ret;
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
