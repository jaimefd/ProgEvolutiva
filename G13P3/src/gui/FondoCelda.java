package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class FondoCelda extends JLabel implements TableCellRenderer{
//int fila,columna;

/*public void setFila(int fila) {
	fila = fila;
}

public void setColumna(int columna) {
	columna = columna;
}*/

public FondoCelda() {
    setOpaque(true); // Permite que se vea el color en la celda del JLabel
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
  /*  if(((row == fila) && (column == columna))){
    setBackground(Color.red); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
    setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda*/
	//}
/*if((row != fila)&& (column==columna)){
    setBackground(Color.white); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
    setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda
}*/
	
	if(value.equals("@")) {   //HORMIGA
		this.setBackground(Color.red);
	}
	else if(value.equals("#")){ //COMIDA
		this.setBackground(Color.yellow);
	}
	else if(value.equals("x")){ //HABIA-COMIDA
		this.setBackground(Color.MAGENTA);
	}
	else if(value.equals("-")) {
		this.setBackground(Color.black);
	}
	else //NO HAY NADA
	{ 
		this.setBackground(Color.CYAN);
	}
	
	
     
    return this;
}


}