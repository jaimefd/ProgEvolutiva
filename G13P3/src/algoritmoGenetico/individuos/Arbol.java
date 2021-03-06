package algoritmoGenetico.individuos;

public class Arbol implements Cloneable{

	private Dato valor;
	boolean prim;
	Arbol padre;
	Arbol hijoIzq;
	Arbol hijoDer;
	Arbol hijoCen; //para PROGN3
	int prof;
	int numElementos;
	public Hijo tipoHijo;
	
	public enum Dato{
		AVANZA, DERECHA, IZQUIERDA,SIC,PROGN2,PROGN3
	}
	
	public enum Hijo {
		IZQUIERDO, CENTRAL, DERECHO, RAIZ
	}
	
	public Arbol() {
		numElementos=1;
	}
	
	public void crearArbol(Arbol arbol,int profMin,int profMax) {
		if(profMin>0 ||prim) { //es funcion
			prim=false;
			Dato valorAct;
			valorAct=Dato.values()[(int) (Math.random()*3)+3];  //math.random()*3+3 da valores del 0 al 3, excluyendo el 3 y +3 para seleccionar SIC,PROGN2,PROGN3
			arbol.valor=valorAct;
			
			
			arbol.hijoIzq=new Arbol();
			crearArbol(arbol.hijoIzq,profMin-1,profMax-1);
			arbol.hijoIzq.setPadre(arbol);
			arbol.hijoIzq.tipoHijo = Hijo.IZQUIERDO;
			arbol.numElementos=arbol.numElementos+arbol.hijoIzq.numElementos;
			
			if(arbol.valor==Dato.values()[5]) {
				arbol.hijoCen=new Arbol();
				crearArbol(arbol.hijoCen,profMin-1,profMax-1);
				arbol.hijoCen.setPadre(arbol);
				arbol.hijoCen.tipoHijo = Hijo.CENTRAL;
				arbol.numElementos=arbol.numElementos+arbol.hijoCen.numElementos;
			}
			
			arbol.hijoDer=new Arbol();
			crearArbol(arbol.hijoDer,profMin-1,profMax-1);
			arbol.hijoDer.setPadre(arbol);
			arbol.hijoDer.tipoHijo = Hijo.DERECHO;
			arbol.numElementos=arbol.numElementos+arbol.hijoDer.numElementos;
		}
		else {
			if(profMax==0) {  //hoja: no tiene hijos porque ha llegado a la prof. maxima  solo puede ser terminal
				Dato valorAct;
				valorAct=Dato.values()[(int) (Math.random()*3)];
				arbol.valor=valorAct;
			}
			else {  //puede ser funcion o terminal
				double random=Math.random();
				
				if(random>0.5) { //terminal
					Dato valorAct;
					valorAct=Dato.values()[(int) (Math.random()*3)];
					arbol.valor=valorAct;
				}
				else {  //funcion
					Dato valorAct;
					valorAct=Dato.values()[(int) (Math.random()*3)+3];
					arbol.valor=valorAct;
					
					
					arbol.hijoIzq=new Arbol();
					crearArbol(arbol.hijoIzq,profMin,profMax-1);
					arbol.hijoIzq.setPadre(arbol);
					arbol.hijoIzq.tipoHijo = Hijo.IZQUIERDO;
					arbol.numElementos=arbol.numElementos+arbol.hijoIzq.numElementos;
					
					if(arbol.valor==Dato.values()[5]) {
						arbol.hijoCen=new Arbol();
						crearArbol(arbol.hijoCen,profMin,profMax-1);
						arbol.hijoCen.setPadre(arbol);
						arbol.hijoCen.tipoHijo = Hijo.CENTRAL;
						arbol.numElementos=arbol.numElementos+arbol.hijoCen.numElementos;
					}
					
					arbol.hijoDer=new Arbol();
					crearArbol(arbol.hijoDer,profMin,profMax-1);
					arbol.hijoDer.setPadre(arbol);
					arbol.hijoDer.tipoHijo = Hijo.DERECHO;
					arbol.numElementos=arbol.numElementos+arbol.hijoDer.numElementos;
				}
			}
		}
		this.updateArbol();
	}
	
	public String getAlgoritmo(){
		String ret="";
		ret = valor.toString();
		if (hijoIzq != null) {
			ret += "(" + hijoIzq.getAlgoritmo() + ",";
			if (hijoCen != null) { 
				ret += hijoCen.getAlgoritmo() + ",";
			}
			ret += hijoDer.getAlgoritmo() + ")";
		}
		return ret;
	}
	
	public Arbol getArbol(int indice) {
		int cont = indice;
		if (indice > 0 && indice < numElementos) {
			if (hijoIzq != null) {
				if (hijoIzq.getNumElementos() >= cont) return hijoIzq.getArbol(cont - 1);
				else cont -= hijoIzq.getNumElementos();
			}
			if (hijoCen != null) {
				if (hijoCen.getNumElementos() >= cont) return hijoCen.getArbol(cont - 1);
				else cont -= hijoCen.getNumElementos();
			}
			if (hijoDer != null) {
				if (hijoDer.getNumElementos() >= cont) return hijoDer.getArbol(cont - 1);
				else cont -= hijoDer.getNumElementos();
			}
		} 
		return this;
	}
	
	public int updateArbol() {
		if (hijoIzq == null && hijoCen == null && hijoDer == null) {
			this.prof = 0;
			return 0;
		};
		if (hijoIzq != null) {
			hijoIzq.padre = this;
			this.prof = hijoIzq.updateArbol() + 1;
		}
		if (hijoCen != null) {
			hijoCen.padre = this;
			this.prof = Math.max(this.prof, hijoCen.updateArbol() + 1);
		}
		if (hijoDer != null) {
			hijoDer.padre = this;
			this.prof = Math.max(this.prof, hijoDer.updateArbol() + 1);
		}
		return this.prof;
	}
	
	public boolean esTerminal() {
		if (hijoIzq == null && hijoCen == null && hijoDer == null) return true;
		else return false;
	}
	
	public int getNumElementos() {
		return numElementos;
	}
	
	public void setNumElementos(int elem) {
		this.numElementos = elem;
	}
	
	public Dato getValor() {
		return valor;
	}
	
	public void setValor(Dato valorNuevo) {
		this.valor = valorNuevo;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public void setPadre(Arbol padre) {
		this.padre = padre;
	}
	
	public Arbol getPadre() {
		return padre;
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
	
	public void setHijoIzq(Arbol nuevoHijo) {
		this.hijoIzq = nuevoHijo;
	}
	
	public void setHijoDer(Arbol nuevoHijo) {
		this.hijoDer = nuevoHijo;
	}
	
	public void setHijoCen(Arbol nuevoHijo) {
		this.hijoCen = nuevoHijo;
	}

	public void setPrim(boolean prim) {
		this.prim = prim;
	}

	public void copiaArbol(Arbol arbol) {
		this.valor = arbol.valor;
		if (arbol.hijoIzq != null) {
			this.hijoIzq = new Arbol();
			this.hijoIzq.copiaArbol(arbol.hijoIzq);
			if (arbol.hijoCen != null) {
				this.hijoCen = new Arbol();
				this.hijoCen.copiaArbol(arbol.hijoCen);
			} else this.hijoCen = null;
			this.hijoDer = new Arbol();
			this.hijoDer.copiaArbol(arbol.hijoDer);
		}
		else {
			this.hijoIzq = null;
			this.hijoCen = null;
			this.hijoDer = null;
		}
		this.numElementos = arbol.numElementos;
		this.padre = arbol.padre;
		this.prim = arbol.prim;
		this.prof = arbol.prof;
		this.tipoHijo=arbol.tipoHijo;
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
