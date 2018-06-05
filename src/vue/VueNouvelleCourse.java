package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JComponent;
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
import javax.swing.table.AbstractTableModel;

import controleur.ControleurNouvelleCourse;
import modele.Etat.Etat;

public class VueNouvelleCourse extends JPanel {
	
	private int id_Course;
	private LocalDate date_creation; 
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
	private JLabel lbTitreCourse;
	private JSpinner spNbParticipants;
	private JButton btValider;
	private JButton btAnnuler;
	private JTextField tfAuteurCourse;
	private JFrame fen;

	public VueNouvelleCourse() throws Exception {
		this.fen = new JFrame();
		
		this.fen.setTitle(" : " + "création d'une nouvelle fiche COURSE");
		this.fen.setLayout(new GridLayout(1,1));	
			
		ControleurNouvelleCourse controleur = new ControleurNouvelleCourse(this);
		
		this.setLayout(new BorderLayout());	
		JPanel pNord = new JPanel();
		this.add(pNord, BorderLayout.NORTH);
		pNord.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		pNord.setBorder(new EmptyBorder(10,20,10,20));
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.LINE_START;
		this.lbTitreCourse = new JLabel("Titre de la course *  ");
		this.lbTitreCourse.setForeground(Color.red);
		pNord.add(this.lbTitreCourse, c);
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		this.tfTitreCourse = new JTextField("nouveau");
		this.tfTitreCourse.setColumns(30);
		c.fill = GridBagConstraints.HORIZONTAL;
		//this.tfTitreCourse.addKeyListener(new CustomKeyListener());
		pNord.add(this.tfTitreCourse, c);
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		JLabel lbAuteurCourse = new JLabel("Auteur ");
		pNord.add(lbAuteurCourse, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		this.tfAuteurCourse = new JTextField();
		this.tfAuteurCourse.setColumns(15);
		//this.tfTitreCourse.addKeyListener(new CustomKeyListener());
		pNord.add(this.tfAuteurCourse, c);						
		
		JPanel pCentre = new JPanel();
		this.add(pCentre,BorderLayout.CENTER);
		JPanel spGauche = new JPanel();
		JPanel spDroite = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spGauche, spDroite);
		pCentre.add(sp);
		sp.setPreferredSize(new Dimension(650,370)); 
		sp.setOneTouchExpandable(true); 
		sp.setDividerLocation(270); 
		sp.setBorder(new EmptyBorder(10,20,10,20));

		//à Gauche du séparateur
		spGauche.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();

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
	
		this.btDateDebutCourse = new JButton();
		c1.gridx = 2;
		c1.gridy = 0;
		this.btDateDebutCourse.setPreferredSize(new Dimension(20,20));
		this.btDateDebutCourse.setIcon(new ImageIcon("./src/vue/calendar.png"));
		spGauche.add(this.btDateDebutCourse, c1);

		JLabel lbDateFinCourse = new JLabel("Date de Fin");
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(5, 5, 5, 5);
		c1.gridx = 0;
		c1.gridy = 1;
		spGauche.add(lbDateFinCourse, c1);
		
		tfDateFinCourse = new JTextField();
		c1.insets = new Insets(5, 5, 5, 5);
		c1.anchor = GridBagConstraints.LINE_START;
		c1.gridx = 1;
		c1.gridy = 1;
		tfDateFinCourse.setColumns(8);
		tfDateFinCourse.setMinimumSize(new Dimension(70,20));
		spGauche.add(tfDateFinCourse, c1);

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
		
		JLabel lbDevise = new JLabel("€"); 
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
		
		this.parcoursTab = new JTable(new TabModele());
		this.parcoursTab.setPreferredScrollableViewportSize(new Dimension(250,63)); 
		c2.gridx = 0;
		c2.gridy = 4;
		c2.gridheight = 3;
		c2.gridwidth = 2;
		c2.insets = new Insets(5, 5, 5, 5);
		c2.anchor = GridBagConstraints.LINE_START;
		spDroite.add(new JScrollPane(this.parcoursTab), c2);
		
		//southPanel
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.SOUTH);
		pSud.setLayout(new GridLayout(1,2,150,0));
		pSud.setBorder(new EmptyBorder(30,100,30,100));
		this.btAnnuler = new JButton("annuler");
		this.btAnnuler.setPreferredSize(new Dimension(80,40));
		this.btValider = new JButton("valider");
		pSud.add(this.btAnnuler);
		pSud.add(this.btValider);		
		this.btAnnuler.addActionListener(controleur);
		this.btValider.addActionListener(controleur);
		this.btDateDebutCourse.addActionListener(controleur);
		
		//génération fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(750, 600);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
	}
	
	public void rendreDisponible(boolean actif){
		this.tfDateDebutCourse.setEditable(actif);
		this.tfDateFinCourse.setEditable(actif);
		this.tfBudget.setEditable(actif);
		this.tfNomEvenement.setEditable(actif);
		this.tfFormatCourse.setEditable(actif);
		this.taCommentaireCourse.setEditable(actif);
		this.parcoursTab.setEnabled(actif);
		this.spNbParticipants.setEnabled(actif);
		this.cbAgrement.setEnabled(actif);
		this.btDateDebutCourse.setEnabled(actif);
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
		LocalDate dateCourse = LocalDate.parse(this.tfDateDebutCourse.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
		donneesCourse.put("date_debut_courseVue",dateCourse ); 
		LocalDate dateFinCourse = LocalDate.parse(this.tfDateFinCourse.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu")) ;
		donneesCourse.put("date_fin_courseVue",dateFinCourse ); 
		double budget = Double.parseDouble(this.tfBudget.getText());
		donneesCourse.put("budgetVue", budget);	
		int nbParticipantsInt = (Integer) this.spmNbParticipants.getValue();
		donneesCourse.put("nbParticipantsVue", nbParticipantsInt);		
		donneesCourse.put("agrementVue", cbAgrement.isSelected());		
		donneesCourse.put("type_epreuveVue", this.tfNomEvenement.getText());
		donneesCourse.put("formatVue", tfFormatCourse.getText());		
		donneesCourse.put("distance_natVue", this.parcoursTab.getValueAt(0, 1));		
		donneesCourse.put("distance_cycVue", this.parcoursTab.getValueAt(1, 1));
		donneesCourse.put("distance_couVue", this.parcoursTab.getValueAt(2, 1));
		donneesCourse.put("distanceArrivee", this.parcoursTab.getValueAt(3, 1));
		donneesCourse.put("nom_ville_natVue", this.parcoursTab.getValueAt(0, 2));
		donneesCourse.put("nom_ville_cycVue", this.parcoursTab.getValueAt(1, 2));
		donneesCourse.put("nom_ville_couVue", this.parcoursTab.getValueAt(2, 2));
		donneesCourse.put("nom_ville_arrVue", this.parcoursTab.getValueAt(3, 2));
		donneesCourse.put("CP_ville_natVue", this.parcoursTab.getValueAt(0, 3));
		donneesCourse.put("CP_ville_cycVue", this.parcoursTab.getValueAt(1, 3));
		donneesCourse.put("CP_ville_couVue", this.parcoursTab.getValueAt(2, 3));
		donneesCourse.put("CP_ville_arrVue", this.parcoursTab.getValueAt(3, 3));
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


	public int getId_Course() {
		return id_Course;
	}

	public JButton getBtValider() {
		return btValider;
	}
	
	public JFrame getFen() {
		return this.fen;
	}
}
/*
	class CustomKeyListener implements KeyListener{
		private VueNouvelleCourse vue = new VueNouvelleCourse();
		
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.vue.getTfTitreCourse().setForeground(Color.BLACK);

			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.vue.getTfTitreCourse().setForeground(Color.BLACK);
				this.vue.getBtValider().setEnabled(true);
			}

		}
		public void keyReleased(KeyEvent arg0) {
			
		}
	}
	*/
	
	class TabModele extends AbstractTableModel {
		private boolean DEBUG = false;

		
		String titresColonnes []  = {" ", "Distance","Ville","CP"};
		Object [][] donneesParcours = {
				{"Natation",new Integer(0),"",""},
				{"Cyclisme",new Integer(0),"",""},
				{"Course à pied",new Integer(0),"",""},
				{"Arriv\u00E9e",new Integer(0),"",""} // créer méthode
		};
		/*calculDistanceTotale()
		private Integer calculDistanceTotale() {
			return (Integer)donneesParcours[0][1]; //+ (Integer) getValueAt(1, 1) + (Integer)getValueAt(2, 1);
		}
		*/
	    public int getColumnCount() {
	      return titresColonnes.length;
	    }

		public int getRowCount() {
	      return donneesParcours.length;
	    }

	    public String getColumnName(int col) {
	      return titresColonnes[col];
	    }

	    public Object getValueAt(int row, int col) {
	      return donneesParcours[row][col];
	    }

	    /**
	     * JTable uses this method to determine the default renderer/ editor for
	     * each cell. If we didn't implement this method, then the last column
	     * would contain text ("true"/"false"), rather than a check box.
	     */
	    public Class getColumnClass(int c) {
	      return getValueAt(0, c).getClass();
	    }

	    /**
	     * Don't need to implement this method unless your table's editable.
	     */
	    public boolean isCellEditable(int row, int col) {
	      if (col < 1) 
	        return false;
	       else if (col == 1 && row == 3) 
	        return false;
	       else 
		    return true;

	    }
	    /**
	     * Don't need to implement this method unless your table's data can
	     * change.
	     */
	    
	    public void setValueAt(Object value, int row, int col) {
	    	donneesParcours[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	    
	}



	

	


