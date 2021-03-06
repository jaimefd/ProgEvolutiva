package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.math.plot.*;

import algoritmoGenetico.AlgoritmoGenetico;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;


public class Panel {

	private JFrame frmPractica;
	
	//Declaracion de variables
	
	public static Plot2DPanel _plot;
	private JSpinner generaciones;
	private JSpinner tamPobl;
	private JComboBox selecc;
	private JComboBox cruce;
	private JComboBox mutacion;
	private JCheckBox isElite;
	private JSpinner elite;
	private JSpinner probCruce;
	private JSpinner probMut;
	private JComboBox func;
	private JTextField valorError;
	private JSpinner nVariables4;
	
	private int gen;
	private int pobl;
	private int selec;
	private int cruc;
	private int mut;
	private boolean isElit;
	private double elit;
	private double probCruc;
	private double probMu;
	private int fun;
	private double err;
	private int nVar4;
	

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
		frmPractica.setTitle("Practica 1");
		frmPractica.setBounds(100, 100, 1028, 661);
		frmPractica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPractica.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Practica 1 PE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 353, 600);
		frmPractica.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		
		JLabel lblNewLabel_9 = new JLabel("Funcion");
		lblNewLabel_9.setBounds(10, 456, 107, 13);
		panel.add(lblNewLabel_9);
		
		JLabel error = new JLabel("Valor Error");
		error.setBounds(10, 402, 107, 13);
		panel.add(error);
		
		JLabel lblNewLabel_10 = new JLabel("Variables Funcion 4");
		lblNewLabel_10.setBounds(10, 507, 116, 13);
		panel.add(lblNewLabel_10);
		
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
		cruce.setModel(new DefaultComboBoxModel(new String[] {"Monopunto", "Uniforme", "Aritmetico"}));
		cruce.setBounds(128, 155, 107, 21);
		panel.add(cruce);
		
		mutacion = new JComboBox();
		mutacion.setModel(new DefaultComboBoxModel(new String[] {"Basica", "Uniforme"}));
		mutacion.setBounds(127, 191, 107, 21);
		panel.add(mutacion);
		
		isElite = new JCheckBox("");
		isElite.setBounds(123, 231, 93, 21);
		panel.add(isElite);
		
		elite = new JSpinner();
		elite.setModel(new SpinnerNumberModel(10.0, 5.0, 100.0, 1.0));
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
		
	    func = new JComboBox();
		func.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5"}));
		func.setBounds(127, 452, 107, 21);
		panel.add(func);
		
		valorError = new JTextField();
		valorError.setText("0.001");
		valorError.setBounds(127, 399, 108, 19);
		panel.add(valorError);
		valorError.setColumns(10);
		
		nVariables4 = new JSpinner();
		nVariables4.setModel(new SpinnerNumberModel(2, 1, 7, 1));
		nVariables4.setBounds(127, 504, 41, 20);
		panel.add(nVariables4);
		
		_plot.addLegend("SOUTH");
		_plot.setBounds(400, 10, 800, 600);
		frmPractica.getContentPane().add(_plot);
		
		JButton run = new JButton("Run");
		run.setBounds(238, 546, 85, 21);
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
				fun=func.getSelectedIndex()+1;
				err=Double.parseDouble(valorError.getText());
				nVar4=(int)nVariables4.getValue();
				_plot.removeAllPlots();
				
				//Cuando obtenemos todas las variables ejecutamos el AG
				AlgoritmoGenetico alg= new AlgoritmoGenetico(fun,pobl,gen,probCruc,probMu,err,selec,cruc,mut,isElit,elit,nVar4,_plot);
				alg.run();
			}
		});
		panel.add(run);
		
		
		
	
		
		frmPractica.setVisible(true);
		
		
	}
}
