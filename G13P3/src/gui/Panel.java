package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.math.plot.*;

import algoritmoGenetico.AlgoritmoGenetico;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;


public class Panel {

	private JFrame frmPractica;
	
	//Declaracion de variables
	
	public static Plot2DPanel _plot;
	private JSpinner generaciones;
	private JSpinner tamPobl;
	private JSpinner profundidad;
	private JComboBox selecc;
	private JComboBox cruce;
	private JComboBox mutacion;
	private JCheckBox isElite;
	private JSpinner elite;
	private JSpinner probCruce;
	private JSpinner probMut;
	private JTextField fitnessMejor;
	private JTextArea mejorCromosoma;
	
	private int gen;
	private int pobl;
	private int selec;
	private int cruc;
	private int mut;
	private int prof;
	private boolean isElit;
	private double elit;
	private double probCruc;
	private double probMu;
	private JTextField totMut;
	private JTextField totCruc;
	
	private JTable table;
	private JTextField txtRastroDeFante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frmPractica.setVisible(true);
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
		_plot = new Plot2DPanel();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPractica = new JFrame();
		frmPractica.setFont(new Font("Dialog", Font.BOLD, 12));
		frmPractica.setTitle("Practica 3");
		frmPractica.setBounds(100, 100, 1401, 783);
		frmPractica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPractica.getContentPane().setLayout(null);
		frmPractica.setLocationRelativeTo(null); //para centrarlo en pantalla
		
		//PANEL
		
		table = new JTable();
		table.setBounds(562, 48, 613, 419);
		frmPractica.getContentPane().add(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
	//	TableColumn columna = table.getColumnModel().getColumn(5);
	//	TableCellRenderer.setColumna(5); //se le da por parametro la columna que se quiere modificar
		//TableCellRenderer.setFila(5);//se le da por parametro la fila que se quiere modificar
		//columna.setCellRenderer(TableCellRenderer);
		FondoCelda TableCellRenderer = new FondoCelda();
		table.setDefaultRenderer(Object.class, TableCellRenderer);
		table.setEnabled(false);
		
		/*for(int i=0;i<32;i++) {
			for(int j=0;j<32;j++) {                      AQUI HACER EL SETVALUE PARA INICIALIZAR EL TABLERO
				table.setValueAt("-", i, j);
			}
		}*/
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Practica 2 PE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(104, 10, 353, 457);
		frmPractica.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Mejor Individuo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(104, 477, 353, 259);
		frmPractica.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		fitnessMejor = new JTextField();
		fitnessMejor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fitnessMejor.setHorizontalAlignment(JTextField.CENTER);
		fitnessMejor.setEditable(false);
		fitnessMejor.setSelectedTextColor(Color.BLACK);
		fitnessMejor.setBounds(129, 178, 37, 19);
		panel_2.add(fitnessMejor);
		fitnessMejor.setColumns(10);
		
		
		
		//LABELS
		
		JLabel lblNewLabel = new JLabel("N\u00BAGeneraciones");
		lblNewLabel.setBounds(10, 44, 107, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tama\u00F1o Poblacion");
		lblNewLabel_1.setBounds(10, 89, 107, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Metodo Seleccion");
		lblNewLabel_2.setBounds(10, 126, 107, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Metodo Cruce");
		lblNewLabel_3.setBounds(10, 159, 107, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Metodo Mutacion");
		lblNewLabel_4.setBounds(10, 195, 107, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Elitismo");
		lblNewLabel_5.setBounds(10, 239, 107, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Porc. Elitismo");
		lblNewLabel_6.setBounds(10, 274, 107, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Probabilidad Cruce");
		lblNewLabel_7.setBounds(10, 311, 107, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Probabilidad Mutacion");
		lblNewLabel_8.setBounds(10, 356, 107, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblMejorCromosoma = new JLabel("Mejor cromosoma");
		lblMejorCromosoma.setBounds(108, 37, 104, 13);
		panel_2.add(lblMejorCromosoma);
		
		JLabel lblNewLabel_11 = new JLabel("Mejor Fitness");
		lblNewLabel_11.setBounds(120, 155, 104, 13);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Cruces:");
		lblNewLabel_12.setBounds(25, 221, 53, 13);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Mutaciones:");
		lblNewLabel_13.setBounds(167, 221, 72, 13);
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_8_1 = new JLabel("Profundidad Arbol");
		lblNewLabel_8_1.setBounds(10, 393, 107, 13);
		panel.add(lblNewLabel_8_1);
		
		
		totCruc = new JTextField();
		totCruc.setEditable(false);
		totCruc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totCruc.setBounds(88, 218, 37, 19);
		panel_2.add(totCruc);
		totCruc.setColumns(10);
		
		totMut = new JTextField();
		totMut.setEditable(false);
		totMut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totMut.setBounds(249, 218, 37, 19);
		panel_2.add(totMut);
		totMut.setColumns(10);
		
		txtRastroDeFante = new JTextField();
		txtRastroDeFante.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtRastroDeFante.setText("Rastro de Fante FE");
		txtRastroDeFante.setBounds(810, 19, 109, 19);
		frmPractica.getContentPane().add(txtRastroDeFante);
		txtRastroDeFante.setColumns(10);
		
		
		//Variables
		
		generaciones = new JSpinner();
		generaciones.setModel(new SpinnerNumberModel(new Integer(100), new Integer(50), null, new Integer(1)));
		generaciones.setBounds(127, 41, 41, 20);
		panel.add(generaciones);
		
		tamPobl = new JSpinner();
		tamPobl.setModel(new SpinnerNumberModel(new Integer(100), new Integer(20), null, new Integer(1)));
		tamPobl.setBounds(127, 86, 41, 20);
		panel.add(tamPobl);
		
		selecc = new JComboBox();
		selecc.setToolTipText("");
		selecc.setModel(new DefaultComboBoxModel(new String[] {"Estocastico Univ.", "Restos", "Ruleta", "Torneo Det.", "Torneo prob.", "Truncamiento"}));
		selecc.setBounds(128, 122, 107, 21);
		panel.add(selecc);
		
		cruce = new JComboBox();
		cruce.setModel(new DefaultComboBoxModel(new String[] {"PMX", "OX", "CX","ERX","CO","OX-PP","RVI"}));
		cruce.setBounds(128, 155, 107, 21);
		panel.add(cruce);
		
		mutacion = new JComboBox();
		mutacion.setModel(new DefaultComboBoxModel(new String[] {"Insercion", "Intercambio","Inversion","Heuristica","Mutacion13"}));
		mutacion.setBounds(127, 191, 107, 21);
		panel.add(mutacion);
		
		isElite = new JCheckBox("");
		isElite.setBounds(123, 231, 93, 21);
		panel.add(isElite);
		
		elite = new JSpinner();
		elite.setModel(new SpinnerNumberModel(10.0, 1.0, 100.0, 1.0));
		elite.setBounds(127, 271, 41, 20);
		panel.add(elite);
		
	    probCruce = new JSpinner();
		probCruce.setModel(new SpinnerNumberModel(60.0, 0.0, 100.0, 1.0));
		probCruce.setBounds(127, 308, 41, 20);
		panel.add(probCruce);
		
		probMut= new JSpinner();
		probMut.setToolTipText("");
		probMut.setBounds(127, 353, 41, 20);
		probMut.setModel(new SpinnerNumberModel(5.0, 0.0, 100.0, 1.0));
		panel.add(probMut);
		
		profundidad = new JSpinner();
		profundidad.setModel(new SpinnerNumberModel(4, 3, 9, 1));
		profundidad.setToolTipText("");
		profundidad.setBounds(127, 390, 41, 20);
		panel.add(profundidad);
		
		mejorCromosoma = new JTextArea();
		mejorCromosoma.setEditable(false);
		mejorCromosoma.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane scroll = new JScrollPane (mejorCromosoma); 
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setLocation(25, 60);
		scroll.setSize( 282, 86 );
		panel_2.add(scroll);
		
		_plot.addLegend("SOUTH");
		_plot.setBounds(562, 477, 613, 286);
		frmPractica.getContentPane().add(_plot);
		
		JButton run = new JButton("Run");
		run.setBounds(127, 426, 85, 21);
		run.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				gen= (int) generaciones.getValue();
				pobl= (int) tamPobl.getValue();
				selec= selecc.getSelectedIndex()+1;
				cruc=cruce.getSelectedIndex()+1;
				mut=mutacion.getSelectedIndex()+1;
				isElit=isElite.isSelected();
				elit=(double)elite.getValue();
				probCruc=((double)probCruce.getValue())/100;
				probMu=((double)probMut.getValue())/100;
				prof=(int)profundidad.getValue();
				_plot.removeAllPlots();
				
				
				
				//Cuando obtenemos todas las variables ejecutamos el AG
				AlgoritmoGenetico alg = null;
				try {
					alg = new AlgoritmoGenetico(pobl,gen,probCruc,probMu,selec,cruc,mut,isElit,elit,_plot,fitnessMejor,mejorCromosoma,totCruc,totMut,prof);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				alg.run();
			}
		});
		panel.add(run);
		
		
		
		
		
		
	
		
		frmPractica.setVisible(true);
		
		
	}
}
