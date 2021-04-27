package algoritmoGenetico.mutaciones;

import java.util.ArrayList;
import algoritmoGenetico.individuos.Individuo;

public class intercambio {
		
		static ArrayList<Individuo<Character>> mutar(int tipo, ArrayList<Individuo<Character>> poblacion,
				double probMutacion,int tamPobl,int[] totMut) {
			
			double prob;
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
					
					Character aux1,aux2;
					aux1=poblacion.get(i).getCromosoma().get(posIni);		
					aux2=poblacion.get(i).getCromosoma().get(posFin);
					poblacion.get(i).getCromosoma().set(posIni, aux2);
					poblacion.get(i).getCromosoma().set(posFin, aux1);
			
				}
			}
			
			return poblacion;
		}
		
}