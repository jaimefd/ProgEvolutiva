package algoritmoGenetico.individuos;


import java.util.ArrayList;


public class IndividuoPerm extends Individuo<Character> {
		
		public IndividuoPerm() {
			this.cruce=false;
			this.elite=false;
			this.tamGenes=new int[1];
			this.tamGenes[0]=26;  //Tenemos 1 gen con 26 posiciones
			this.tamTotal=tamGenes[0];
			this.cromosoma = new Character[tamTotal];
			this.textoTraducido="";
			
			//Inicializamos nuestro cromosoma de forma aleatoria
			ArrayList<Character> dic = new ArrayList<Character>(); //arraylist para guardar todas las letras ordenadas
			int rand = 0;
			
			for (int i = 0; i < tamTotal; i++) {
				dic.add((char) (i + 97)); //97 = a
			}
			
			for (int i = 0; i < tamTotal; i++) {  //llenamos nuestro cromosoma obteniendo las letras de forma aleatoria del arraylist ordenado
				rand = ((int) (Math.random() * (dic.size())));
				
				this.cromosoma[i]=dic.get(rand);
				
				dic.remove(rand);
			}
		}

		@Override
		public double getValor() { //FALTA HACER LA FUNCION DE FITNESS CON N-GRAMS ¡IMPORTANTE!
			return 0;
		}

		@Override
		public double getFitness() {
			// TODO Auto-generated method stub
			return this.getValor();
		}
		
		//FALTA FUNCION PARA TRADUCIR TEXTO CIFRADO EN BASE A NUESTRO CROMOSOMA
		
		// HACER TO STRING PARA QUE SE VEA EL CROMOSOMA EN UN CUADRADITO EN LA GUI

		


}
