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
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controleur.ControleurNouvelleCourse;
import modele.Etat.Etat;
import vue.parametre.DateLabelFormatter;


public class FenetreNouvelleCourse extends JFrame {
	
	private int id_Course;
	private JButton btDateDebutCourse;
	private JTextField tfTitreCourse;
	private JTextField tfNomEvenement;
	private JTextField tfFormatCourse;
	private JTextField tfDateDebutCourse;
	private JFormattedTextField jtfDate = new JFormattedTextField(DateFormat.getDateInstance());
	private JTextField tfDateFinCourse;
	private JTextField tfBudget;
	private JFormattedTextField jtfBudget = new JFormattedTextField(NumberFormat.getCurrencyInstance());
	private JTextArea taCommentaireCourse;
	private SpinnerNumberModel spmNbParticipants;
	private JTable parcoursTab;
	private JCheckBox cbAgrement;
	private String villeNatation;
	private String villeCyclisme;
	private String villeCourseAPied;
	private String villeArrivee;
	private JLabel lbTitreCourse;
	private float distanceNatation;
	private float distanceCyclisme;
	private float distanceCourseAPied;
	private float distanceArrivee;
	private int cpNatation;
	private int cpCyclisme;
	private int cpCourseAPied;
	private int cpArrivee;
	private String type_epreuve;
	private JSpinner spNbParticipants;
	private JButton btValider;
	private JButton btAnnuler;


	public FenetreNouvelleCourse() throws Exception {
		ControleurNouvelleCourse controleur = new ControleurNouvelleCourse(this);
		
		this.setLayout(new BorderLayout());
				
		JPanel pNord = new JPanel();
		this.add(pNord, BorderLayout.NORTH);
		pNord.setBorder(new EmptyBorder(10,20,10,20));
		this.lbTitreCourse = new JLabel("Titre de la course * : ");
		this.lbTitreCourse.setForeground(Color.red);
		pNord.add(this.lbTitreCourse);		
		this.tfTitreCourse = new JTextField("nouveau");
		this.tfTitreCourse.addKeyListener(new CustomKeyListener());
		this.tfTitreCourse.setColumns(50);;
		pNord.add(tfTitreCourse);		
		
		JPanel pCentre = new JPanel();
		this.add(pCentre,BorderLayout.CENTER);
		JPanel spGauche = new JPanel();
		JPanel spDroite = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spGauche, spDroite);
		pCentre.add(sp);
		sp.setPreferredSize(new Dimension(830,370)); // édition de la dimension du JSplitPane
		sp.setOneTouchExpandable(true); //permet de faire glisser le séparateur avec la souris
		sp.setDividerLocation(400); //fixe la position du séprarateur
		
		//à Gauche du séparateur
		spGauche.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();

		JLabel lbDateDebutCourse = new JLabel("Date de D\u00E9but");
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 0;
		spGauche.add(lbDateDebutCourse, c1);
		
		//properties pour JDatePicker
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		c1.gridx = 1;
		c1.gridy = 0;
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		spGauche.add(datePicker1);
		
		JLabel lbDateFinCourse = new JLabel("Date de Fin");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 1;
		spGauche.add(lbDateFinCourse, c1);

		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		c1.insets = new Insets(5, 5, 5, 5);
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 1;
		c1.gridy = 1;
		spGauche.add(datePicker2, c1);

		JLabel lbBudget = new JLabel("Budget");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 2;
		spGauche.add(lbBudget, c1);
		
		tfBudget = new JTextField();
		c1.insets = new Insets(5, 5, 5, 5);
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 1;
		c1.gridy = 2;
		tfBudget.setColumns(8);
		tfBudget.setMinimumSize(new Dimension(70,20));
		spGauche.add(tfBudget, c1);
		
		JLabel lbDevise = new JLabel("€"); // ComboBox euro, livre sterling, couronne etc ?
		c1.gridx = 2;
		c1.gridy = 2;
		lbDevise.setPreferredSize(new Dimension(20,20));
		spGauche.add(lbDevise, c1);

		JLabel lbNbParticipants = new JLabel("Effectifs");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 3;
		spGauche.add(lbNbParticipants, c1);
		
		this.spmNbParticipants = new SpinnerNumberModel(5, 0, 50, 1);   
		JSpinner spNbParticipants = new JSpinner(spmNbParticipants);
		c1.insets = new Insets(5, 5, 5, 5);
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 1;
		c1.gridy = 3;
		spGauche.add(spNbParticipants, c1);
		
		JLabel lbCommentaireCourse = new JLabel("Notes");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 4;
		spGauche.add(lbCommentaireCourse, c1);
		
		this.taCommentaireCourse = new JTextArea();
		this.taCommentaireCourse.setColumns(7);
		this.taCommentaireCourse.setRows(5);
		JScrollPane spCommentaireCourse = new JScrollPane(this.taCommentaireCourse);
		spCommentaireCourse.setPreferredSize(new Dimension(10,60));
		c1.insets = new Insets(5, 5, 5, 5);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 0;
		c1.gridy = 5;
		c1.gridheight = 6;
		c1.gridwidth = 4;
		spGauche.add(spCommentaireCourse, c1);

		//à Droite du séparateur
		spDroite.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		
		JLabel lbAgrement = new JLabel("Agr\u00E9ment FFTri");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 0;
		spDroite.add(lbAgrement, c2);
		
		this.cbAgrement = new JCheckBox();
		c2.gridx = 1;
		c2.gridy = 0;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.anchor = GridBagConstraints.LINE_START;
		spDroite.add(cbAgrement, c2);
		
		JLabel lbNomEvenement = new JLabel("Nom de l'\u00E9v\u00E9nement");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 1;
		spDroite.add(lbNomEvenement, c2);
		
		this.tfNomEvenement = new JTextField();
		c2.insets = new Insets(5, 5, 5, 5);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 1;
		this.tfNomEvenement.setColumns(8);
		spDroite.add(this.tfNomEvenement, c2);
		
		JLabel lbFormatCourse = new JLabel("Format du Triathlon");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 2;
		spDroite.add(lbFormatCourse, c2);
		
		this.tfFormatCourse = new JTextField();
		c2.insets = new Insets(5, 5, 5, 5);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 2;
		this.tfFormatCourse.setColumns(8);
		spDroite.add(this.tfFormatCourse, c2);
		
		JLabel lbParcoursCourse = new JLabel("Parcours du Triathlon");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 3;
		spDroite.add(lbParcoursCourse, c2);
		
		String titresColonnes []  = {" ", "Distance","Ville","CP"};
		Object [][] donneesParcours = {
				{ "Natation",distanceNatation,villeNatation,cpNatation},
				{"Cyclisme",distanceCyclisme,villeCyclisme,cpCyclisme},
				{"Course à pied",distanceCourseAPied,villeCourseAPied,cpCourseAPied},
				{"Arriv\u00E9e",distanceArrivee,villeArrivee,cpArrivee}
		};
		this.parcoursTab = new JTable(donneesParcours, titresColonnes);
		JScrollPane tabSP = new JScrollPane(parcoursTab);
		tabSP.setMinimumSize(new Dimension(250,85)); 
		c2.gridx = 0;
		c2.gridy = 4;
		c2.gridheight = 3;
		c2.gridwidth = 2;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.anchor = GridBagConstraints.LINE_START;
		spDroite.add(tabSP, c2);
		
		//southPanel
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.SOUTH);
		pSud.setLayout(new GridLayout(1,2,150,0));
		pSud.setBorder(new EmptyBorder(30,100,30,100));
		this.btAnnuler = new JButton("annuler");
		this.btAnnuler.setPreferredSize(new Dimension(40,40));

		this.btValider = new JButton("valider");
		pSud.add(this.btAnnuler);
		pSud.add(this.btValider);
		
		this.btAnnuler.addActionListener(controleur);
		this.btValider.addActionListener(controleur);
		//this.btDateDebutCourse.addActionListener(controleur);


	}
	
	public void setActifComposants(boolean actif){
		this.tfDateDebutCourse.setEnabled(actif);
		this.tfDateFinCourse.setEnabled(actif);
		this.tfBudget.setEnabled(actif);
		this.tfNomEvenement.setEnabled(actif);
		this.tfFormatCourse.setEnabled(actif);
		this.taCommentaireCourse.setEnabled(actif);
		this.parcoursTab.setEnabled(actif);
		//this.spNbParticipants.setEnabled(actif); //lever un avertissement en cas d'écition du spinner en mode consultation
		this.cbAgrement.setEnabled(actif);
		this.btDateDebutCourse.setEnabled(actif);
	}
	

	public void titreFenetreSaisi(boolean b) {
		this.tfTitreCourse.setVisible(!b);
		this.lbTitreCourse.setVisible(!b);
		if (!b)
			this.setTitle(this.id_Course + " : " + this.tfTitreCourse.getText() + " - EDITION");
		else 
			this.setTitle(this.id_Course + " : " + this.tfTitreCourse.getText() + " - CONSULTATION");
	}

	  
	public void modifierTexteBoutonsPourEdition(boolean estEditable) {
		if (estEditable) {
			this.btValider.setText("valider");
			this.btAnnuler.setText("annuler");
		}else {
			this.btValider.setText("imprimer");
			this.btAnnuler.setText("retour");
		}
	}
	
	
	public HashMap<String, Object> getDonneesCourse() throws ParseException {
		System.out.println("données récupérées");
		HashMap<String,Object> donneesCourse = new HashMap<String, Object>();
		donneesCourse.put("id_Course", this.id_Course);
		donneesCourse.put("nom_courseVue", this.tfTitreCourse.getText());
		Date dateCourse = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateDebutCourse.getText());
		donneesCourse.put("date_debut_courseVue",dateCourse ); 
		Date dateFinCourse = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateFinCourse.getText());	
		donneesCourse.put("date_fin_courseVue",dateFinCourse ); 
		double budget = Double.parseDouble(this.tfBudget.getText());
		donneesCourse.put("budgetVue", budget);	
		int nbParticipantsInt = (Integer) this.spmNbParticipants.getValue();
		donneesCourse.put("nbParticipantsVue", nbParticipantsInt);		
		donneesCourse.put("agrementVue", cbAgrement.isSelected());		
		donneesCourse.put("type_epreuveVue", type_epreuve);
		donneesCourse.put("formatVue", tfFormatCourse.getText());		
		donneesCourse.put("distance_natVue", this.distanceNatation);		
		donneesCourse.put("distance_cycVue", distanceCyclisme);
		donneesCourse.put("distance_couVue", distanceCourseAPied);
		donneesCourse.put("distanceArrivee", distanceArrivee);
		donneesCourse.put("nom_ville_natVue", villeNatation);
		donneesCourse.put("nom_ville_cycVue", villeCyclisme);
		donneesCourse.put("nom_ville_couVue", villeCourseAPied);
		donneesCourse.put("nom_ville_arrVue", villeArrivee);
		donneesCourse.put("CP_ville_natVue", cpNatation);
		donneesCourse.put("CP_ville_cycVue", cpCyclisme);
		donneesCourse.put("CP_ville_arrVue", cpArrivee);
		donneesCourse.put("description_courseVue", taCommentaireCourse.getText());
		
		return donneesCourse ;
	}
	
	
	public void afficherDonnees(int id_Course, String nom_course, Date date_course, Date dateFin_course, double budget,  int nb_participants, String description_course, 
								boolean isAgrement, String type_epreuve, String format_course, 
								int distance_nat, int distance_cyc, int distance_cou, int distance_arr,
								String nom_ville_nat, String nom_ville_cyc, String nom_ville_cou, String nom_ville_arr, 
								String CP_ville_nat, String CP_ville_cyc, String CP_ville_cou, String CP_ville_arr  ) {
		this.tfTitreCourse.setText(nom_course);
		this.id_Course = id_Course;
		String date_courseStr = date_course.toString();
		this.tfDateDebutCourse.setText(date_courseStr); 
		String dateFin_courseStr = dateFin_course.toString();
		this.tfDateFinCourse.setText(dateFin_courseStr);
		String budgetStr = String.valueOf(budget);
		this.tfBudget.setText(budgetStr);
		this.spmNbParticipants.setValue(nb_participants);
		this.taCommentaireCourse.setText(description_course);
		this.cbAgrement.setSelected(isAgrement);
		this.tfNomEvenement.setText(type_epreuve);
		this.tfFormatCourse.setText(format_course);
		this.parcoursTab.setValueAt(distance_nat, 0, 1);
		this.parcoursTab.setValueAt(distance_cyc, 1, 1);
		this.parcoursTab.setValueAt(distance_cou, 2, 1);
		this.parcoursTab.setValueAt(distance_arr, 3, 1);
		this.parcoursTab.setValueAt(nom_ville_nat, 0, 2);
		this.parcoursTab.setValueAt(nom_ville_cyc, 1, 2);
		this.parcoursTab.setValueAt(nom_ville_cou, 2, 2);
		this.parcoursTab.setValueAt(nom_ville_arr, 3, 2);
		this.parcoursTab.setValueAt(CP_ville_nat, 0, 3);
		this.parcoursTab.setValueAt(CP_ville_cyc, 1, 3);
		this.parcoursTab.setValueAt(CP_ville_cou, 2, 3);
		this.parcoursTab.setValueAt(CP_ville_arr, 3, 3);
	}
	
	public JTextField getTfTitreCourse() {
		return tfTitreCourse;
	}

	public void setTfTitreCourse(JTextField tfTitreCourse) {
		this.tfTitreCourse = tfTitreCourse;
	}


	public class CustomKeyListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lbTitreCourse.setForeground(Color.BLACK);

			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lbTitreCourse.setForeground(Color.BLACK);
				btValider.setEnabled(true);
			}

		}
		public void keyReleased(KeyEvent arg0) {
			
		}
		
	
		
	}




	

	

}
