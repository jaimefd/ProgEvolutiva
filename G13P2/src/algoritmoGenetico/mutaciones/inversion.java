package algoritmoGenetico.mutaciones;

import java.util.ArrayList;

import algoritmoGenetico.individuos.Individuo;

public class inversion {
	static ArrayList<Individuo<Character>> mutar(int tipo, ArrayList<Individuo<Character>> poblacion,
			double probMutacion,int tamPobl,int[] totMut) {
		
		double prob;
		ArrayList<Character> nueva=new ArrayList<Character>();
		for(int i=0;i<tamPobl;i++) {
			prob=Math.random();
			if(prob<probMutacion) {
				totMut[0]++;
				int posIni=(int)(Math.random()*poblacion.get(i).getTamTotal());
				int posFin=(int)(Math.random()*poblacion.get(i).getTamTotal());
				while(posIni==posFin) {
					posFin=(int)(Math.random()*poblacion.get(i).getTamTotal());
				}
				if(posIni>posFin) {
					int aux=posIni;
					posIni=posFin;
					posFin=aux;
				}
				for(int j=0;j<posIni;j++) {
					nueva.add(poblacion.get(i).getCromosoma().get(j));
				}
				for(int x=posFin;x>=posIni;x--) {
					nueva.add(poblacion.get(i).getCromosoma().get(x));
				}
				for(int z=posFin+1;z<26;z++) {
					nueva.add(poblacion.get(i).getCromosoma().get(z));
				}
				poblacion.get(i).setCromosoma(nueva);
			}
		}
		
		return poblacion;
	}
}
