package algoritmoGenetico.individuos;

import java.util.HashMap;
import java.util.Map;

public class TextoEntrada {

	String texto;
	private static HashMap<String, Integer> monogramastxt   = new HashMap<String, Integer>();
	private static HashMap<String, Integer> bigramastxt   = new HashMap<String, Integer>();
	private static HashMap<String, Integer> trigramastxt = new HashMap<String, Integer>();
	private static int frecBigramas;
	private static int frecTrigramas;
	private static int frecMonogramas;
	
	public TextoEntrada(String texto) {
		
		this.texto=texto;
		frecBigramas=0;
		frecTrigramas=0;
		frecMonogramas=0;
		String monograma="";
		String bigrama="";
		String trigrama="";
		
		
		
		for(int i=0;i<this.texto.length();i++) {
			if(((int) this.texto.charAt(i)) <= 122 && ((int) this.texto.charAt(i)) >= 97){ //si el char es una letra de la a - z la evaluamos
				bigrama+=this.texto.charAt(i);
				trigrama+=this.texto.charAt(i);
				monograma+=this.texto.charAt(i);
				
				if(monograma.length()==1) {
					if(monogramastxt.containsKey(monograma)) { //si contiene bigrama sumamos 1 al valor, sino lo introducimos y ponemos 1
						monogramastxt.put(monograma, monogramastxt.get(monograma)+1);
					}
					else {
						monogramastxt.put(monograma, 1);
					}
					monograma=""; //reiniciamos
				}
				if(bigrama.length()==2) {
					if(bigramastxt.containsKey(bigrama)) { //si contiene bigrama sumamos 1 al valor, sino lo introducimos y ponemos 1
						bigramastxt.put(bigrama, bigramastxt.get(bigrama)+1);
					}
					else {
						bigramastxt.put(bigrama, 1);
					}
					bigrama=""; //reiniciamos
				}
				
				if(trigrama.length()==3) {
					if(trigramastxt.containsKey(trigrama)) { //si contiene bigrama sumamos 1 al valor, sino lo introducimos y ponemos 1
						trigramastxt.put(trigrama, trigramastxt.get(trigrama)+1);
					}
					else {
						trigramastxt.put(trigrama, 1);
					}
					trigrama="";
				}
			}
			else {
				bigrama="";
				trigrama="";
				monograma="";
			}
			
		}
		
		//Guardamos el total de frecuencias para el fitness
		for (Map.Entry<String, Integer> entry : bigramastxt.entrySet()) {
			frecBigramas=frecBigramas+entry.getValue();
		}
		
		for (Map.Entry<String, Integer> entry : trigramastxt.entrySet()) {
			frecTrigramas=frecTrigramas+entry.getValue();
		}
		
		for (Map.Entry<String, Integer> entry : monogramastxt.entrySet()) {
			frecMonogramas=frecMonogramas+entry.getValue();
		}
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static HashMap<String, Integer> getBigramastxt() {
		return bigramastxt;
	}

	public static void setBigramastxt(HashMap<String, Integer> bigramastxt) {
		TextoEntrada.bigramastxt = bigramastxt;
	}

	public static HashMap<String, Integer> getTrigramastxt() {
		return trigramastxt;
	}

	public static void setTrigramastxt(HashMap<String, Integer> trigramastxt) {
		TextoEntrada.trigramastxt = trigramastxt;
	}

	public static int getFrecBigramas() {
		return frecBigramas;
	}

	public void setFrecBigramas(int frecBigramas) {
		TextoEntrada.frecBigramas = frecBigramas;
	}

	public static int getFrecTrigramas() {
		return frecTrigramas;
	}

	public void setFrecTrigramas(int frecTrigramas) {
		TextoEntrada.frecTrigramas = frecTrigramas;
	}

	public static HashMap<String, Integer> getMonogramastxt() {
		return monogramastxt;
	}

	public static void setMonogramastxt(HashMap<String, Integer> monogramastxt) {
		TextoEntrada.monogramastxt = monogramastxt;
	}

	public static int getFrecMonogramas() {
		return frecMonogramas;
	}

	public static void setFrecMonogramas(int frecMonogramas) {
		TextoEntrada.frecMonogramas = frecMonogramas;
	}

	
	
	
	
	
	
}
