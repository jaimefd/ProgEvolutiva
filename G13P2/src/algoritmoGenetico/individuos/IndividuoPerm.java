package algoritmoGenetico.individuos;


import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import algoritmoGenetico.ficheros.Ngrams;


public class IndividuoPerm extends Individuo<Character> {
		
		public IndividuoPerm() {
			this.cruce=false;
			this.elite=false;
			this.tamGenes=new int[1];
			this.tamGenes[0]=26;  //Tenemos 1 gen con 26 posiciones
			this.tamTotal=tamGenes[0];
			this.cromosoma = new Character[tamTotal];
			this.dic=new ArrayList<Character>();
			
			//Inicializamos nuestro cromosoma de forma aleatoria
			ArrayList<Character> dicc = new ArrayList<Character>(); //arraylist para guardar todas las letras ordenadas
			int rand = 0;
			
			for (int i = 0; i < tamTotal; i++) {
				dicc.add((char) (i + 97)); //97 = a / 122 = z
				dic.add((char) (i+97));
			}
			
			for (int i = 0; i < tamTotal; i++) {  //llenamos nuestro cromosoma obteniendo las letras de forma aleatoria del arraylist ordenado
				rand = ((int) (Math.random() * (dicc.size())));
				
				this.cromosoma[i]=dicc.get(rand);
				
				dicc.remove(rand);
			}
		}

		@Override
		public double getValor() { 
			double bigrama = 0.0,trigrama=0.0,porc=0.0,ret,frec;
			
			for (Map.Entry<String, Integer> bi : TextoEntrada.getBigramastxt().entrySet()) {
				frec=TextoEntrada.getFrecBigramas();
				porc=(double)((bi.getValue())/frec); //calculamos frecuencia del bigrama en el texto
				bigrama += Math.abs(porc*(Math.log(Ngrams.getBigramas_ing().get(traducirNgram(bi))/Math.log(2)))); //multiplicamos la frec * log de fec del bigrama traducido
			}
			
			for (Map.Entry<String, Integer> tri : TextoEntrada.getTrigramastxt().entrySet()) {
				frec=TextoEntrada.getFrecTrigramas();
				porc=(double)((tri.getValue())/frec);
				trigrama += Math.abs(porc*(Math.log(Ngrams.getTrigramas_ing().get(traducirNgram(tri))/Math.log(2))));
			}
			
			ret = 0.3*bigrama + 0.7*trigrama;
			return ret;

		}

		private String traducirNgram(Entry<String, Integer> ngram) {
			int j;
			String ngramtxt="";
			for (int i = 0; i < ngram.getKey().length(); i++) {
				j = dic.indexOf(ngram.getKey().charAt(i));
				ngramtxt += this.cromosoma[j];
			}
			return ngramtxt;
		}

		@Override
		public double getFitness() {
			// TODO Auto-generated method stub
			return this.getValor();
		}
		
		//FUNCION PARA TRADUCIR TEXTO CIFRADO EN BASE A NUESTRO CROMOSOMA
		public String traducirTexto(String texto) {
			int pos;
			String txt="";
			for (int i = 0; i < texto.length(); i++) {
				if (((int) texto.charAt(i)) >= 97 && ((int) texto.charAt(i))<= 122 ) {
					pos = dic.indexOf(texto.charAt(i));
					txt += this.cromosoma[pos];
				}
				else {
					txt+=texto.charAt(i);
				}
			}
			return txt;
		}
		
		public String getCrom() {
			String crom=" ";
			for(int i=0;i<this.tamTotal;i++) {
				crom+=this.cromosoma[i]+" ";
			}
			return crom;
		}


}
