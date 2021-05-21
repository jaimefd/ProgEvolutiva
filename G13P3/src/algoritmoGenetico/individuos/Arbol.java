package algoritmoGenetico.individuos;

public class Arbol implements Cloneable{

	private Dato valor;
	Arbol hijoIzq;
	Arbol hijoDer;
	Arbol hijoCen; //para PROGN3
	int prof;
	int numElementos;
	enum Dato{
		AVANZA, DERECHA, IZQUIERDA,SIC,PROGN2,PROGN3
	}
	
	
	
	public Arbol() {
		numElementos=0;
	}
	
	public void crearArbol(Arbol arbol,int profMin,int profMax) {
		if(profMin>0 ) { //es funcion
			Dato valorAct;
			valorAct=Dato.values()[(int) (Math.random()*3)+3];  //math.random()*3+3 da valores del 0 al 3, excluyendo el 3 y +3 para seleccionar SIC,PROGN2,PROGN3
			arbol.valor=valorAct;
			numElementos++;
			
			arbol.hijoIzq=new Arbol();
			crearArbol(arbol.hijoIzq,profMin-1,profMax-1);
			
			if(arbol.valor==Dato.values()[5]) {
				arbol.hijoCen=new Arbol();
				crearArbol(arbol.hijoCen,profMin-1,profMax-1);
			}
			
			arbol.hijoDer=new Arbol();
			crearArbol(arbol.hijoDer,profMin-1,profMax-1);
		}
		else {
			if(profMax==0) {  //hoja: no tiene hijos porque ha llegado a la prof. maxima  solo puede ser terminal
				Dato valorAct;
				valorAct=Dato.values()[(int) (Math.random()*3)];
				arbol.valor=valorAct;
				numElementos++;
			}
			else {  //puede ser funcion o terminal
				double random=Math.random();
				
				if(random>0.5) { //terminal
					Dato valorAct;
					valorAct=Dato.values()[(int) (Math.random()*3)];
					arbol.valor=valorAct;
					numElementos++;
				}
				else {  //funcion
					Dato valorAct;
					valorAct=Dato.values()[(int) (Math.random()*3)+3];
					arbol.valor=valorAct;
					numElementos++;
					
					arbol.hijoIzq=new Arbol();
					crearArbol(arbol.hijoIzq,profMin,profMax-1);
					
					if(arbol.valor==Dato.values()[5]) {
						arbol.hijoCen=new Arbol();
						crearArbol(arbol.hijoCen,profMin,profMax-1);
					}
					
					arbol.hijoDer=new Arbol();
					crearArbol(arbol.hijoDer,profMin,profMax-1);
				}
			}
		}
	}
	
	
	
	public Dato getValor() {
		return valor;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	
	public Arbol getHijoIzq() {
		return hijoIzq;
	}

	public Arbol getHijoDer() {
		return hijoDer;
	}

	public Arbol getHijoCen() {
		return hijoCen;
	}

	public Object clone()
	{
	    Object clone = null;
	    try
	    {
	        clone = super.clone();
	    } 
	    catch(CloneNotSupportedException e)
	    {
	        // No deberia suceder
	    }
	    return clone;
	}
}
