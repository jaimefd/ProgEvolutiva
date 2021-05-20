package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Component;

public class Panel {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(34, 35, 711, 416);
		frame.getContentPane().add(table);
		
		TableColumn columna = table.getColumnModel().getColumn(0);
		colorCelda TableCellRenderer = new colorCelda();
		TableCellRenderer.setColumns(0); //se le da por parametro la columna que se quiere modificar
		TableCellRenderer.setRow(0);//se le da por parametro la fila que se quiere modificar
		columna.setCellRenderer(TableCellRenderer);
		
		
	}
}
