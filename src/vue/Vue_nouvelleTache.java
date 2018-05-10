package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

//import controleur.ControleurNouvelleTache;

import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

public class Vue_nouvelleTache extends JPanel {
	
	private static final int PRIORITE_MAX = 5;
	private static final int NB_MAX_SOUSTACHES = 100;
	private static final int NB_MAX_EQUIPE = 50;
	private static final int NB_MAX_MATERIEL = 50;
	private int id_Tache;
	private String auteur_Tache;
	private JTextField tfLibelle;
	private JTextField tfResponsableNom; 
	private JTextField tfResponsablePrenom; 
	private int priorite;
	private List<Boolean> priorites;
	private TreeMap<String, Float> mapSousTaches;
	private JTextField tfMois;
	private JTextField tfJour;
	private JTextField tfDateDebut;
	private JTextField tfDateEcheance;
	private JButton btDateDebut;
	private JButton btDateEcheance;
	private JButton btAjouterSousTaches;
	private JTable tabssTaches;
	private JTextArea taCommentaire;
	private JButton btAnnuler;
	private JButton btValider;
	private JCheckBox cbTacheCompletee;
	private JTable tabEquipe;
	private JSlider slAvancementTache;
	private JButton btContact;
	private JButton btMateriel;
	private JTable tabMateriel;
	private JButton btSupprimerSousTaches;

	public Vue_nouvelleTache()  {
		//ControleurNouvelleTache controleur = new ControleurNouvelleTache(this);
		this.setLayout(new BorderLayout());
		
		JPanel pNord = new JPanel();
		this.add(pNord, BorderLayout.PAGE_START);
		pNord.setBorder(new EmptyBorder(10,20,10,20));
		
		pNord.setLayout(new GridBagLayout());
		GridBagConstraints cNord1 = new GridBagConstraints();
		cNord1.insets = new Insets(5, 5, 5, 5);
		
		JLabel lbIdTache = new JLabel("T\u00E2che n°" + this.id_Tache);
		cNord1.anchor = GridBagConstraints.FIRST_LINE_START;
		cNord1.weightx = 10;
		cNord1.gridx = 0;
		cNord1.gridy = 0;
		pNord.add(lbIdTache, cNord1);
		
		JLabel lbCreateur = new JLabel("Cr\u00E9\u00E9 par "+this.auteur_Tache );
		cNord1.anchor = GridBagConstraints.FIRST_LINE_END;
		cNord1.weightx = 10;
		cNord1.gridx = 1;
		cNord1.gridy = 0;
		pNord.add(lbCreateur, cNord1);
		
		JLabel lbLibelle = new JLabel("Libellé ");
		cNord1.anchor = GridBagConstraints.LINE_START;
		cNord1.weightx = 30;
		cNord1.gridx = 0;
		cNord1.gridy = 1;
		pNord.add(lbLibelle, cNord1);
		
		this.tfLibelle = new JTextField();
		this.tfLibelle.setColumns(50);
		cNord1.weightx = 70;
		cNord1.fill = GridBagConstraints.HORIZONTAL;
		cNord1.gridwidth = 2;
		cNord1.gridx = 1;
		cNord1.gridy = 1;
		pNord.add(this.tfLibelle, cNord1);
		
		GridBagConstraints cNord2 = new GridBagConstraints();
		cNord2.insets = new Insets(5, 5, 5, 5);
		cNord2.anchor = GridBagConstraints.LINE_START;
		
		cNord2.gridx = 0;
		cNord2.gridy = 2;
		cNord2.anchor = GridBagConstraints.LINE_START;
		pNord.add(new JLabel("Tache Complétée"), cNord2 );
		
		this.cbTacheCompletee = new JCheckBox();
		cNord2.gridx = 1;
		cNord2.gridy = 2;
		cNord2.anchor = GridBagConstraints.LINE_START;
		pNord.add(this.cbTacheCompletee, cNord2 );
		
		JLabel lbResponsable = new JLabel("Responsable :");
		lbResponsable.setPreferredSize(new Dimension(80, 14));
		cNord2.gridx = 2;
		cNord2.gridy = 2;
		cNord2.anchor = GridBagConstraints.LINE_END;
		pNord.add(lbResponsable, cNord2);
		
		JPanel pResponsable = new JPanel();
		pResponsable.setLayout(new FlowLayout());
		cNord2.gridx = 3;
		cNord2.gridy = 2;
		cNord2.gridwidth = 3;
		cNord2.weightx = 50;
		JLabel lbResponsablenom = new JLabel("Nom");
		lbResponsablenom.setPreferredSize(new Dimension(30, 14));
		pResponsable.add(lbResponsablenom);	
		this.tfResponsableNom = new JTextField();
		this.tfResponsableNom.setColumns(10);
		pResponsable.add(this.tfResponsableNom);		
		JLabel lbResponsableprenom = new JLabel("Prénom");
		lbResponsableprenom.setPreferredSize(new Dimension(60, 14));
		pResponsable.add(lbResponsableprenom);		
		this.tfResponsablePrenom = new JTextField();
		this.tfResponsablePrenom.setColumns(10);
		pResponsable.add(this.tfResponsablePrenom);
		pNord.add(pResponsable, cNord2);
		
		JPanel pEst = new JPanel();
		pEst.setBorder(new EmptyBorder(0, 0, 0, 20));
		this.add(pEst, BorderLayout.EAST);
		pEst.setLayout(new GridBagLayout());		
		GridBagConstraints cEst = new GridBagConstraints();
		cEst.anchor = GridBagConstraints.LINE_START;

		JLabel lbDebut = new JLabel("Date de D\u00E9but");
		cEst.insets = new Insets(5, 10, 5, 5);
		cEst.gridx = 0;
		cEst.gridy = 0;
		pEst.add(lbDebut, cEst);
		
		JPanel pDateDebut = new JPanel();
		cEst.insets = new Insets(5, 0, 5, 5);
		cEst.gridx = 1;
		cEst.gridy = 0;
		cEst.weightx = 1;
		cEst.fill = GridBagConstraints.HORIZONTAL;
		pEst.add(pDateDebut, cEst);
		this.tfDateDebut = new JTextField();
		this.tfDateDebut.setColumns(8);
		pDateDebut.add(this.tfDateDebut);		
		this.btDateDebut = new JButton();
		this.btDateDebut.setPreferredSize(new Dimension(20, 20));
		this.btDateDebut.setIcon(new ImageIcon("./src/vue/calendar.png"));
		pDateDebut.add(this.btDateDebut);
		
		JLabel lbEchance = new JLabel("Date d'\u00E9ch\u00E9ance");
		cEst.insets = new Insets(5, 10, 5, 5);
		cEst.gridx = 0;
		cEst.gridy = 1;
		pEst.add(lbEchance, cEst);

		JPanel pEcheance = new JPanel();
		cEst.insets = new Insets(5, 0, 5, 5);
		cEst.gridx = 1;
		cEst.gridy = 1;
		cEst.weightx = 1;
		cEst.fill = GridBagConstraints.HORIZONTAL;
		pEst.add(pEcheance, cEst);
		this.tfDateEcheance = new JTextField();
		this.tfDateEcheance.setColumns(8);
		pEcheance.add(this.tfDateEcheance);		
		this.btDateEcheance = new JButton();
		this.btDateEcheance.setPreferredSize(new Dimension(20, 20));
		this.btDateEcheance.setIcon(new ImageIcon("./src/vue/calendar.png"));
		pEcheance.add(this.btDateEcheance);
		
		JLabel lbTempsEstim = new JLabel("Temps estim\u00E9");
		cEst.insets = new Insets(5, 10, 5, 5);
		cEst.gridx = 0;
		cEst.gridy = 2;
		pEst.add(lbTempsEstim, cEst);
		
		JPanel pTempsEstime = new JPanel();
		cEst.insets = new Insets(10, 23, 5, 15);
		cEst.gridx = 1;
		cEst.gridy = 2;
		pEst.add(pTempsEstime, cEst);
		pTempsEstime.setLayout(new FlowLayout(FlowLayout.CENTER));	
		this.tfMois = new JTextField();
		pTempsEstime.add(this.tfMois);
		this.tfMois.setColumns(2);		
		JLabel lbMois = new JLabel("Mois");
		pTempsEstime.add(lbMois);	
		this.tfJour = new JTextField();
		pTempsEstime.add(this.tfJour);
		this.tfJour.setColumns(2);
		JLabel lbJour = new JLabel("Jours");
		pTempsEstime.add(lbJour);
		
		JLabel lbPriorite = new JLabel("Priorit\u00E9");
		cEst.insets = new Insets(10, 10, 5, 5);
		cEst.gridx = 0;
		cEst.gridy = 3;
		pEst.add(lbPriorite, cEst);
		
		JPanel pPriorite = new JPanel();
		cEst.insets = new Insets(10, 85, 5, 65);
		pPriorite.setLayout(new GridLayout(0, 5, 1, 0));
		cEst.gridx = 1;
		cEst.gridy = 3;
		pEst.add(pPriorite, cEst);
		this.priorites = new ArrayList<Boolean>();
		for (int i = 0; i < PRIORITE_MAX; i++) 
			this.priorites.add(false);
		activerBtRadioPriorite(this.priorite);
		JRadioButton rbPriorite0 = new JRadioButton("", priorites.get(0));
		pPriorite.add(rbPriorite0);
		JRadioButton rbPriorite1 = new JRadioButton("", priorites.get(1));
		pPriorite.add(rbPriorite1);
		JRadioButton rbPriorite2 = new JRadioButton("", priorites.get(2));
		pPriorite.add(rbPriorite2);
		JRadioButton rbPriorite3 = new JRadioButton("", priorites.get(3));
		pPriorite.add(rbPriorite3);
		JRadioButton rbPriorite4 = new JRadioButton("", priorites.get(4));
		pPriorite.add(rbPriorite4);
		
		JLabel lbSsTaches = new JLabel("Sous-t\u00E2ches");
		cEst.anchor = GridBagConstraints.LINE_START;
		cEst.insets = new Insets(10, 10, 5, 5);
		cEst.gridx = 0;
		cEst.gridy = 4;
		pEst.add(lbSsTaches, cEst);
		
		JPanel pAjouterSupprimerSSTache = new JPanel();
		cEst.gridx = 1;
		cEst.gridy = 4;
		//cEst.gridwidth = 2;
		cEst.insets = new Insets(10, 85, 5, 5);
		cEst.fill = GridBagConstraints.WEST;
		pEst.add(pAjouterSupprimerSSTache, cEst);		
		this.btAjouterSousTaches = new JButton("+");
		//this.btAjouterSousTaches.addActionListener(controleur);
		pAjouterSupprimerSSTache.add(this.btAjouterSousTaches);		
		this.btSupprimerSousTaches = new JButton("-");
		//this.btSupprimerSousTaches.addActionListener(controleur);
		pAjouterSupprimerSSTache.add(this.btSupprimerSousTaches);
		
		this.mapSousTaches = new TreeMap<String, Float>(); //clé : libellé de la sstâche, valeur : pourcentage (de complétion)
		String titresColonnesSsTaches [] = {"Libell\u00E9", " % "};
		Object [][] donneesSousTaches = new Object [100][2];
		Iterator <String> itLibelles = mapSousTaches.keySet().iterator();
		int numeroSousTache = 0;
		while (itLibelles.hasNext() && numeroSousTache < NB_MAX_SOUSTACHES) {
				String cle = itLibelles.next();
				donneesSousTaches[numeroSousTache][0]= cle ;
				donneesSousTaches[numeroSousTache][1]= mapSousTaches.get(cle);
				numeroSousTache ++;
		};
		this.tabssTaches = new JTable(donneesSousTaches, titresColonnesSsTaches);
		JScrollPane tabSP = new JScrollPane(tabssTaches);
		tabSP.setMinimumSize(new Dimension(400,85)); 
		cEst.gridx = 0;
		cEst.gridy = 6;
		cEst.gridheight = 3;
		cEst.gridwidth = 2;
		cEst.insets = new Insets(5, 10, 5, 5);
		cEst.anchor = GridBagConstraints.LINE_START;
		pEst.add(tabSP, cEst);
		
		JPanel pOuest = new JPanel();
		pOuest.setBorder(new EmptyBorder(0, 20, 0, 0));
		pOuest.setPreferredSize(new Dimension(500, 50));
		this.add(pOuest, BorderLayout.WEST);
		pOuest.setLayout(new BorderLayout());
		JPanel pEtatAvancement = new JPanel();
		pEtatAvancement.setLayout(new GridLayout(2,1));
		pEtatAvancement.setLayout(new BorderLayout());
		pEtatAvancement.add(new JLabel("Etat d'avancement"), BorderLayout.NORTH);		
		this.slAvancementTache = new JSlider();
		this.slAvancementTache.setMinimumSize(new Dimension(190, 26));
		this.slAvancementTache.setMaximum(200);
		this.slAvancementTache.setMaximumSize(new Dimension(200, 26));
		pEtatAvancement.add(this.slAvancementTache);
		pOuest.add(pEtatAvancement, BorderLayout.NORTH);
		
		JPanel pEquipeMateriel = new JPanel();
		pEquipeMateriel.setLayout(new GridLayout(2,1));

		JPanel pEquipe = new JPanel();
		pEquipe.setLayout(new BorderLayout());
		JLabel lbEquipe = new JLabel("Equipe");
		lbEquipe.setPreferredSize(new Dimension(70, 25));
		pEquipe.add(lbEquipe, BorderLayout.NORTH);
		String titresColonnesEquipe [] = {"Responsable", "Nom", "Pr\u00E9nom", "R\u00F4le"};
		String [][] donneesEquipe = new String [50][4];
		for (int ligne = 0; ligne < 50  ; ligne++ ) {
			donneesEquipe[ligne][0]= "";
			donneesEquipe[ligne][1]= "";
			donneesEquipe[ligne][2]= "";
			donneesEquipe[ligne][3]= "";
		};	
		this.tabEquipe = new JTable(donneesEquipe, titresColonnesEquipe);
		pEquipe.add(new JScrollPane(this.tabEquipe));
		
		JPanel pMateriel = new JPanel();
		pMateriel.setLayout(new BorderLayout());
		JLabel lbMateriel = new JLabel("Mat\u00E9riel");
		lbMateriel.setPreferredSize(new Dimension(70, 25));
		pMateriel.add(lbMateriel, BorderLayout.NORTH);
		String titresColonnesMateriel [] = {"Libelle", "Nom", "Pr\u00E9nom", "Qt\u00E9"};
		String [][] donneesMateriel = new String [50][4];
		for (int ligne = 0; ligne < 50  ; ligne++ ) {
			donneesMateriel[ligne][0]= "";
			donneesMateriel[ligne][1]= "";
			donneesMateriel[ligne][2]= "";
			donneesMateriel[ligne][3]= "";
		};	
		this.tabMateriel = new JTable(donneesMateriel, titresColonnesMateriel);
		pMateriel.add(new JScrollPane(this.tabMateriel));
		pEquipeMateriel.add(pEquipe);	
		pEquipeMateriel.add(pMateriel);
		pOuest.add(pEquipeMateriel);	

		
		JPanel pCentre = new JPanel();
		pCentre.setBorder(new CompoundBorder(null, new EmptyBorder(50, 50, 50, 50)));
		this.add(pCentre, BorderLayout.CENTER);
		pCentre.setLayout(new GridLayout(2, 1, 20, 70));
		
		this.btContact = new JButton("New button");
		this.btContact.setMinimumSize(new Dimension(30, 30));
		this.btContact.setMaximumSize(new Dimension(40, 40));
		this.btContact.setPreferredSize(new Dimension(40, 40));
		pCentre.add(this.btContact);
		
		this.btMateriel = new JButton("New button");
		this.btMateriel.setPreferredSize(new Dimension(40, 40));
		pCentre.add(this.btMateriel);
		
		
		JPanel pSud = new JPanel();
		pSud.setBorder(new EmptyBorder(0, 20, 0, 20));
		this.add(pSud, BorderLayout.PAGE_END);
		pSud.setLayout(new GridBagLayout());
		GridBagConstraints cSud = new GridBagConstraints();
		cSud.anchor = GridBagConstraints.LINE_START;
		
		JLabel lbCommentaire = new JLabel("Commentaire");
		lbCommentaire.setPreferredSize(new Dimension(100, 25));
		cSud.anchor = GridBagConstraints.LINE_START;
		cSud.insets = new Insets(0, 0, 5, 5);
		cSud.gridx = 0;
		cSud.gridy = 0;
		pSud.add(lbCommentaire, cSud);
		 
		this.taCommentaire = new JTextArea();
		this.taCommentaire.setColumns(60);
		this.taCommentaire.setRows(5);	
		JScrollPane spCommentaire = new JScrollPane(this.taCommentaire);
		spCommentaire.setPreferredSize(new Dimension(1140, 100));
		cSud.insets = new Insets(0, 0, 5, 0);
		cSud.gridheight = 2;
		cSud.gridwidth = 6;
		cSud.anchor = GridBagConstraints.LINE_START;
		cSud.fill = GridBagConstraints.BOTH;
		cSud.gridx = 0;
		cSud.gridy = 1;
		pSud.add(spCommentaire, cSud);
		
		JPanel pbtES = new JPanel();  
		pbtES.setLayout(new GridLayout(1,2,150,0));
		cSud.gridwidth = 15;
		cSud.fill = GridBagConstraints.HORIZONTAL;
		cSud.gridx = 0;
		cSud.gridy = 3;
		pSud.add(pbtES, cSud);

		
		this.btAnnuler = new JButton("Annuler");
		this.btAnnuler.setPreferredSize(new Dimension(40,40));
		pbtES.add(this.btAnnuler, cSud);
		
		this.btValider = new JButton("Valider");
		pbtES.add(this.btValider, cSud);
		
		//this.btAnnuler.addActionListener(controleur);
		//this.btValider.addActionListener(controleur);

	}
	

	public HashMap<String, Object> getDonneesCourse() throws ParseException {
		HashMap<String,Object> donneesTache = new HashMap<String, Object>();
		
		donneesTache.put("id_Tache", this.id_Tache);
		donneesTache.put("auteur_Tache", this.auteur_Tache);
		donneesTache.put("libelle", this.tfLibelle.getText());
		donneesTache.put("nom_responsable", this.tfResponsableNom.getText());
		donneesTache.put("prenom_responsable", this.tfResponsablePrenom.getText());
		Date dateDebut = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateDebut.getText());
		donneesTache.put("dateDebut", dateDebut);
		Date dateEcheance = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateEcheance.getText());
		donneesTache.put("dateDebut", dateEcheance);
		int teMoisInt = Integer.parseInt(this.tfMois.getText()) ;
		int teJourInt = Integer.parseInt(this.tfJour.getText());
		int tempsEstimeJour = teMoisInt * 30 + teJourInt; // attention : 1mois = 30 j
		donneesTache.put("TempsEstime", tempsEstimeJour );
		donneesTache.put("priorite", this.priorite);
		donneesTache.put("ListeSsTache", this.mapSousTaches);

		
		return donneesTache;

	}
	
	public void afficherDonnees(int id_Tache, String auteur_Tache, String libelle, String responsableNom, String responsablePrenom, Date dateDebut, Date dateEcheance, int tempsEstimeJourInt, int priorite, TreeMap<String, Float> ListeSousTaches   ) {
		this.id_Tache = id_Tache;
		this.auteur_Tache = auteur_Tache;
		this.tfLibelle.setText(libelle);
		this.tfResponsableNom.setText(responsableNom);
		this.tfResponsablePrenom.setText(responsablePrenom);
		String dateDebutStr = dateDebut.toString();
		this.tfDateDebut.setText(dateDebutStr);
		String dateEcheanceStr = dateEcheance.toString();
		this.tfDateEcheance.setText(dateEcheanceStr);
		int teJourInt = tempsEstimeJourInt % 30 ;
		int teMoisInt = (tempsEstimeJourInt - teJourInt)/30;
		this.tfMois.setText(String.valueOf(teMoisInt));
		this.tfJour.setText(String.valueOf(teJourInt));
		this.priorite = priorite;
		this.mapSousTaches = ListeSousTaches;

	}

	private void activerBtRadioPriorite(int priorite) {
		for (int i = 0; i < priorite; i++) 
			this.priorites.set(i, true);
	}
	
	private void ajouterSousTacheVue(String libelleSSTache, float tauxCompletion) {
		this.mapSousTaches.put(libelleSSTache, tauxCompletion);
	}
	
	private void supprimerSousTacheVue(String libelleSSTache, float tauxCompletion) {
		this.mapSousTaches.remove(libelleSSTache, tauxCompletion);
	}


	public int getId_Tache() {
		return id_Tache;
	}


	public void setId_Tache(int id_Tache) {
		this.id_Tache = id_Tache;
	}


	public JTextField getTfLibelle() {
		return tfLibelle;
	}


	public void setTfLibelle(JTextField tfLibelle) {
		this.tfLibelle = tfLibelle;
	}

    
}
