package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import controleur.ControleurNouvelleCourse;
import modele.Etat.Etat;

public class FenetreNouvelleCourse extends JFrame {
	
	public FenetreNouvelleCourse() throws Exception {
		VueNouvelleCourse vue = new VueNouvelleCourse();
		
		this.setTitle( vue.getId_Course() +" : " + "création d'une nouvelle fiche COURSE");
		this.setLayout(new GridLayout(1,1));		
		this.pack();
		this.setSize(700, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(vue);
				
		}	
	}




	

	


