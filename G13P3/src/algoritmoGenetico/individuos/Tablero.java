package algoritmoGenetico.individuos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import algoritmoGenetico.individuos.Arbol.Dato;



public class Tablero {

	private char tablero[][];
	private int comidas;
	private int pasos;
	
	//Hormiga: direccion y coordenadas
	private enum hormiga{NORTE,SUR,ESTE,OESTE}
	private hormiga dir; //direccion actual
	private int posX;
	private int posY;
	private int posYaux;
	private int posXaux;
	private boolean aux;
	
	public Tablero() throws IOException {
		tablero=new char[32][32];
		cargarTablero();
		this.comidas=0;
		this.pasos=400;
		dir=hormiga.ESTE;
		posX=0;
		posY=0;
		posYaux=0;
		posXaux=0;
		aux=false;
	}
	
	
	public void start(Arbol arbol) {
		if(pasos==0||comidas==89) {return;}
		//Vamos recorriendo el arbol
		Dato valor;
		valor=arbol.getValor();
		
		if(valor==Dato.AVANZA) {
			accion(valor);
			pasos--;
			if(tablero[posY][posX]=='#'||tablero[posY][posX]=='X') {
				if(tablero[posY][posX]=='#') {comidas++;}
				tablero[posY][posX]='X'; //PONDREMOS 'x' cuando la hormiga haya comido
			}
			else {
				tablero[posY][posX]='-'; //PONDREMOS '-' cuando la hormiga haya pasado
			}
		}
		else if(valor==Dato.DERECHA) {
			accion(valor);
			pasos--;
		}
		else if(valor==Dato.IZQUIERDA) {
			accion(valor);
			pasos--;
		}
		else if(valor==Dato.PROGN2) {
			start(arbol.getHijoIzq());
			start(arbol.getHijoDer());
		}
		else if(valor==Dato.PROGN3) {
			start(arbol.getHijoIzq());
			start(arbol.getHijoCen());
			start(arbol.getHijoDer());
		}
		else if(valor==Dato.SIC) {
			posYaux=posY+0;
			posXaux=posX+0;
			aux=true;
			accion(Dato.AVANZA);
			if(tablero[posYaux][posXaux]=='#') {
				start(arbol.getHijoIzq());
			}
			else {
				start(arbol.getHijoDer());
			}
		}
		
	}
	
	
	public void accion(Dato accion) {
		switch(accion) {
			case AVANZA:
				if(!aux) {
					switch(dir) {
					case ESTE:
						posX = (posX+1)%32;
						break;
					case NORTE:
						posY = (posY-1+32)%32; //+32 por si da negativo
						break;
					case OESTE:
						posX = (posX-1+32)%32;
						break;
					case SUR:
						posY = (posY+1)%32;
						break;
					}break;
				}
				else {
					aux=false;
					switch(dir) {
					case ESTE:
						posXaux = (posXaux+1)%32;
						break;
					case NORTE:
						posYaux = (posYaux-1+32)%32;
						break;
					case OESTE:
						posXaux = (posXaux-1+32)%32;
						break;
					case SUR:
						posYaux = (posYaux+1)%32;
						break;
					}break;
				}
			case DERECHA:
				dir = hormiga.values()[(dir.ordinal()+5)%4];  //sumamos 5 que es 1 mas de la actual y %4 para dentro de rango
				break;
			case IZQUIERDA:
				dir = hormiga.values()[(dir.ordinal()+3)%4]; //sumamos 3 para que sea el anterior y %4 para el rango
				break;
		}
	}
	
	public void cargarTablero() throws IOException {
		FileReader fr;
		char car;
		int fila=0,columna=0;
		fr = new FileReader("src/tablero.txt");
		car = (char) fr.read();
		while(fr.read() != -1) {
		    if(car=='@'||car=='0'||car=='#'){
		    	tablero[fila][columna]=car;
		        columna=(columna+1)%32; // %32 para que siempre este dentro de los limites
			    if(columna==0) {fila++;}
			}
		    car = (char) fr.read();	   
		}	
		fr.close();
	}


	
	public char[][] getTablero() {
		return tablero;
	}


	public int getComidas() {
		return comidas;
	}


	public int getPasos() {
		return pasos;
	}


	public int getPosX() {
		return posX;
	}


	public int getPosY() {
		return posY;
	}
	
	
	
	
}
