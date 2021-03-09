package algoritmoGenetico.individuos;
import java.util.*;

public class IndividuoFuncion1 extends Individuo<Boolean> {	
	
	public IndividuoFuncion1() {
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		this.tamGenes = new int[2];
				
		for(int i = 0; i < tamTotal; i++) {
			this.cromosoma[i] = this.rand.nextBoolean();  // falta
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
	
		return min + binToDecimal(i)*((max-min)/(Math.pow(2, this.tamGenes[i])-1));  //falta binToDecimal
	}
}

