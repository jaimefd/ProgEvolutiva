package algoritmoGenetico.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Ngrams {

	private static HashMap<String, Double> monogramas_ing   = new HashMap<String, Double>();
	private static HashMap<String, Double> bigramas_ing   = new HashMap<String, Double>();
	private static HashMap<String, Double> trigramas_ing  = new HashMap<String, Double>();
	
	public Ngrams() throws IOException {
		
		String[] ngrams = {"monogramas.txt","bigramas.txt","trigramas.txt"};
		
		//Cargamos los ngrams de los txt en HashMaps
		for(int i=0;i<3;i++) {
			
			File archivo = new File ("algoritmoGenetico/ficheros/"+ngrams[i]);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);		
			String lr;
			
			while((lr=br.readLine())!=null) {
				String linea[] = lr.split(" "); // string[0]= ngrama y string[1]=frecuencia
				switch(i) {
					//Guardamos en los datos en los HasMaps
					case 0:
						monogramas_ing.put(linea[0], Double.parseDouble(linea[1]));
					case 1:
						bigramas_ing.put(linea[0], Double.parseDouble(linea[1]));
					case 2:
						trigramas_ing.put(linea[0], Double.parseDouble(linea[1]));	
				}
			}
			br.close();
		}
	}

	
	public static HashMap<String, Double> getMonogramas_ing() {
		return monogramas_ing;
	}
	public static HashMap<String, Double> getBigramas_ing() {
		return bigramas_ing;
	}

	public static HashMap<String, Double> getTrigramas_ing() {
		return trigramas_ing;
	}
	
	
}
