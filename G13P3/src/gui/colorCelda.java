package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class colorCelda extends JLabel implements TableCellRenderer{
int Row,Columns;
public void setRow(int Row){
    this.Row=Row;
}
public void setColumns(int Columns){
    this.Columns=Columns;
}
public colorCelda() {
    setOpaque(true); // Permite que se vea el color en la celda del JLabel
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if((row == Row) && (column == Columns)){
    setBackground(Color.red); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
    setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda*/
}
if((row != Row)&& (column==Columns)){
    setBackground(Color.white); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
    setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda
}
     
    return this;
}

}