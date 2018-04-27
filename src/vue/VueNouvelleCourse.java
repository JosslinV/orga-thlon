package vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class VueNouvelleCourse extends JPanel {
	
	private JTextField tfTitreCourse;
	private JTextField tfDateDebutCourse;
	private JTextField tfDureeCourse;
	private JTextField tfBudget;
	private JTextField tfNomEvenement;
	private JTextField tfFormatCourse;
	private JTextArea taCommentaireCourse;
	private JCheckBox cbAgrement;
	private JSpinner spNbParticipants;
	private String distanceNatation;
	private String villeNatation;
	private String cpNatation;
	private String distanceCyclisme;
	private String villeCyclisme;
	private String cpCyclisme;
	private String distanceCourseAPied;
	private String villeCourseAPied;
	private String cpCourseAPied;
	private String distanceArrivee;
	private String villeArrivee;
	private String cpArrivee;
	

	public VueNouvelleCourse() {
		this.setLayout(new BorderLayout());
				
		JPanel pNord = new JPanel();
		this.add(pNord, BorderLayout.NORTH);
		pNord.setBorder(new EmptyBorder(10,20,10,20));
		JLabel lbTitreCourse = new JLabel("Titre de la course");
		pNord.add(lbTitreCourse);
		tfTitreCourse = new JTextField();
		tfTitreCourse.setPreferredSize(new Dimension(500,30));
		pNord.add(tfTitreCourse);
		
		JPanel pCentre = new JPanel();
		this.add(pCentre,BorderLayout.CENTER);
		JPanel spGauche = new JPanel();
		JPanel spDroite = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spGauche, spDroite);
		pCentre.add(sp);
		sp.setPreferredSize(new Dimension(650,370)); // édition de la dimension du JSplitPane
		sp.setOneTouchExpandable(true); //permet de faire glisser le séparateur avec la souris
		sp.setDividerLocation(270); //fixe la position du séprarateur
		sp.setBorder(new EmptyBorder(10,20,10,20));

		//à Gauche du séparateur
		spGauche.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		spGauche.setMinimumSize(new Dimension(400,400));

		JLabel lbDateDebutCourse = new JLabel("Date de D\u00E9but");
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 0;
		spGauche.add(lbDateDebutCourse, c1);
		
		tfDateDebutCourse = new JTextField();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		tfDateDebutCourse.setMinimumSize(new Dimension(70,20));
		tfDateDebutCourse.setColumns(8);
		spGauche.add(tfDateDebutCourse, c1);
		
		JButton btDateDebutCourse = new JButton();
		c1.gridx = 2;
		c1.gridy = 0;
		btDateDebutCourse.setPreferredSize(new Dimension(20,20));
		btDateDebutCourse.setIcon(new ImageIcon("./src/calendar.png"));
		spGauche.add(btDateDebutCourse, c1);

		JLabel lbDureeCourse = new JLabel("Dur\u00E9e");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 1;
		spGauche.add(lbDureeCourse, c1);
		
		tfDureeCourse = new JTextField();
		c1.insets = new Insets(5, 5, 5, 5);
		//c1.fill = GridBagConstraints.HORIZONTAL;
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 1;
		c1.gridy = 1;
		tfDureeCourse.setColumns(8);
		tfDureeCourse.setMinimumSize(new Dimension(70,20));
		spGauche.add(tfDureeCourse, c1);
		
		JButton btDureeCourse = new JButton();
		c1.gridx = 2;
		c1.gridy = 1;
		btDureeCourse.setPreferredSize(new Dimension(20,20));
		btDureeCourse.setIcon(new ImageIcon("./src/calendar.png"));
		spGauche.add(btDureeCourse, c1);


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


		JLabel lbNbParticipants = new JLabel("Effectifs");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 3;
		spGauche.add(lbNbParticipants, c1);
		
		SpinnerModel value = new SpinnerNumberModel(5, 0, 50, 1);   
		spNbParticipants = new JSpinner(value);
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
		
		taCommentaireCourse = new JTextArea();
		taCommentaireCourse.setColumns(7);
		taCommentaireCourse.setRows(5);
		JScrollPane spCommentaireCourse = new JScrollPane(taCommentaireCourse);
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
		
		cbAgrement = new JCheckBox();
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
		
		tfNomEvenement = new JTextField();
		c2.insets = new Insets(5, 5, 5, 5);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 1;
		tfNomEvenement.setColumns(8);
		spDroite.add(tfNomEvenement, c2);
		
		JLabel lbFormatCourse = new JLabel("Format du Triathlon");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 2;
		spDroite.add(lbFormatCourse, c2);
		
		tfFormatCourse = new JTextField();
		c2.insets = new Insets(5, 5, 5, 5);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 2;
		tfFormatCourse.setColumns(8);
		spDroite.add(tfFormatCourse, c2);
		
		JLabel lbParcoursCourse = new JLabel("Parcours du Triathlon");
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.gridx = 0;
		c2.gridy = 3;
		spDroite.add(lbParcoursCourse, c2);
		
		String titresColonnes []  = {" ", "Distance","Ville","CP"};
		String [][] donneesParcours = {
				{ "Natation",distanceNatation,villeNatation,cpNatation},
				{"Cyclisme",distanceCyclisme,villeCyclisme,cpCyclisme},
				{"Course à pied",distanceCourseAPied,villeCourseAPied,cpCourseAPied},
				{"Arriv\u00E9e",distanceArrivee,villeArrivee,cpArrivee}
		};
		JTable parcoursTab = new JTable(donneesParcours, titresColonnes);
		parcoursTab.setRowHeight(20);
		JScrollPane tabSP = new JScrollPane(parcoursTab);
		tabSP.setMinimumSize(new Dimension(250,100)); 
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
		JButton annuler = new JButton("annuler");
		annuler.setPreferredSize(new Dimension(40,40));
		pSud.add(annuler);
		JButton valider = new JButton("valider");
		pSud.add(valider);
		
	}
	
	public HashMap<String, Object> getDonneesCourse() throws ParseException{
		HashMap<String,Object> donneesCourses = new HashMap<String, Object>();
		
		donneesCourses.put("Nom", tfTitreCourse.getText());		
		Date dateCourse = new SimpleDateFormat("dd/MM/yyyy").parse(tfDateDebutCourse.getText());	
		donneesCourses.put("DateC",dateCourse ); 		
		Double Budget = Double.parseDouble(tfBudget.getText());
		donneesCourses.put("Budget",Budget);			
		int NbParticipants = (Integer)spNbParticipants.getValue();
		donneesCourses.put("NbParticipants", NbParticipants);		
		donneesCourses.put("isAgrement", cbAgrement.isSelected());		
		donneesCourses.put("Type_Epreuve", tfNomEvenement.getText());
		donneesCourses.put("Format", tfFormatCourse.getText());		
		float distanceNatationFloat = Float.parseFloat(distanceNatation);
		donneesCourses.put("distanceNatation", distanceNatationFloat);		
		float distanceCyclismeFloat = Float.parseFloat(distanceCyclisme);
		donneesCourses.put("distanceCyclisme", distanceCyclismeFloat);
		float distanceCourseAPiedFloat = Float.parseFloat(distanceCourseAPied);
		donneesCourses.put("distanceCourseAPied", distanceCourseAPiedFloat);
		float distanceArriveeFloat = Float.parseFloat(distanceArrivee);
		donneesCourses.put("distanceArrivee", distanceArriveeFloat);
		donneesCourses.put("villeNatation", villeNatation);
		donneesCourses.put("villeCyclisme", villeCyclisme);
		donneesCourses.put("villeCourseAPied", villeCourseAPied);
		donneesCourses.put("villeArrivee", villeArrivee);
		int cpNatationInt = Integer.parseInt(cpNatation);
		donneesCourses.put("cpNatation", cpNatationInt);
		int cpCyclismeInt = Integer.parseInt(cpCyclisme);
		donneesCourses.put("cpCyclisme", cpCyclismeInt);
		int cpCourseAPiedInt = Integer.parseInt(cpCourseAPied);
		donneesCourses.put("cpCourseAPied", cpCourseAPiedInt);
		int cpArriveeInt = Integer.parseInt(cpArrivee);
		donneesCourses.put("cpArrivee", cpArriveeInt);	
		donneesCourses.put("DescriptionCourse", taCommentaireCourse.getText());
		
		return donneesCourses ;
		
	}
	
	//public int augmenter effectif()
	
	//public Date calculerDuree()
	
	

}
