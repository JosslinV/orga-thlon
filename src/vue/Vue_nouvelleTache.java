package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controleur.ControleurNouvelleTache;
import modele.Materiel;
import modele.SousTache;
import modele.contacts.Benevole;

public class Vue_nouvelleTache extends JPanel {
	
	private static final int PRIORITE_MAX = 5;
	private static final int NB_MAX_SOUSTACHES = 100;
	private static final int NB_MAX_EQUIPE = 50;
	private static final int NB_MAX_MATERIEL = 50;
	private int id_Tache;
	private String auteur_Tache;
	private String date_Creation;
	private JTextField tfLibelle;
	private int priorite;
	private List<Boolean> priorites;
	private JTextField tfDateDebut;
	private JTextField tfDateEcheance;
	//private JButton btDateDebut;
	//private JButton btDateEcheance;
	private JButton btAjouterSousTaches;
	private JTable tabssTaches;
	private JTextArea taCommentaire;
	private JButton btAnnuler;
	private JButton btValider;
	private JCheckBox cbTacheRecurrente;
	private JTable tabEquipe;
	private JSlider slAvancementTache;
	private JButton btContact;
	private JButton btMateriel;
	private JTable tabMateriel;
	private JButton btSupprimerSousTaches;
	private JTextField tfEtatAvancement;
	private JButton btAjouterEquipe;
	private JButton btSupprimerEquipe;
	private JButton btAjouterMateriel;
	private JButton btSupprimerMateriel;
	private JRadioButton rbPriorite0;
	private JRadioButton rbPriorite1;
	private JRadioButton rbPriorite2;
	private JRadioButton rbPriorite3;
	private JRadioButton rbPriorite4;
	private JRadioButton[] rbpriorites ;
	private JButton btChoisirResponsable;
	private JLabel lbMois;
	private JLabel lbJour;
	private JLabel lbResponsableNom;
	private JLabel lbResponsablePrenom; 
	
	private String titresColonnesSsTaches [] = {"Libell\u00E9", " Avancement "};
	private Object [][] donneesSousTaches = { 
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
			{ "", new JProgressBar()},
};
	
	private String titresColonnesEquipe [] = { "Nom", "Pr\u00E9nom", "R\u00F4le"};
	private Object [][] donneesEquipe = { 
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""},
			{ "", "", ""}	
};
	
	private String titresColonnesMateriel [] = {"Libelle", "Nom", "Pr\u00E9nom", "Qt\u00E9"};
	private Object [][] donneesMateriel = { 
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)},
			{ "", "", "", new Integer(0)}
};




	public Vue_nouvelleTache() throws Exception {
		ControleurNouvelleTache controleur = new ControleurNouvelleTache(this);
		this.setLayout(new BorderLayout());
		
		JPanel pNord = new JPanel();
		this.add(pNord, BorderLayout.PAGE_START);
		pNord.setBorder(new EmptyBorder(10,20,10,20));
		
		pNord.setLayout(new GridBagLayout());
		GridBagConstraints cNord1 = new GridBagConstraints();
		cNord1.insets = new Insets(5, 5, 5, 5);
		
		//JLabel lbIdTache = new JLabel("T\u00E2che n�" + this.id_Tache);
		JLabel lbIdTache = new JLabel("T\u00E2che n�" + 85);

		cNord1.anchor = GridBagConstraints.FIRST_LINE_START;
		cNord1.weightx = 10;
		cNord1.gridx = 0;
		cNord1.gridy = 0;
		pNord.add(lbIdTache, cNord1);
		
		//ajoute label icones supprimer, pause
		
		//JLabel lbCreateur = new JLabel("Cr\u00E9\u00E9 par "+ this.auteur_Tache  );
		JLabel lbCreateur = new JLabel("Cr\u00E9\u00E9 par "+ "Thierry Beltrand"  );

		cNord1.anchor = GridBagConstraints.FIRST_LINE_END;
		cNord1.weightx = 10;
		cNord1.gridx = 1;
		cNord1.gridy = 0;
		pNord.add(lbCreateur, cNord1);
		
		//JLabel lbDateCreation = new JLabel("le "+ this.date_Creation );
		JLabel lbDateCreation = new JLabel("le "+ "06/06/2018" );
		cNord1.anchor = GridBagConstraints.FIRST_LINE_END;
		cNord1.weightx = 10;
		cNord1.gridx = 2;
		cNord1.gridy = 0;
		pNord.add(lbDateCreation, cNord1);
		
		JLabel lbLibelle = new JLabel("Libell� ");
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
		
		
		cNord1.gridx = 5;
		cNord1.gridy = 1;
		cNord1.anchor = GridBagConstraints.LINE_END;
		pNord.add(new JLabel("Tache r�currente"), cNord1 );
		
		this.cbTacheRecurrente = new JCheckBox();
		cNord1.gridx = 6;
		cNord1.gridy = 1;
		cNord1.anchor = GridBagConstraints.LINE_START;
		pNord.add(this.cbTacheRecurrente, cNord1 );
		
		GridBagConstraints cNord2 = new GridBagConstraints();
		cNord2.insets = new Insets(5, 5, 5, 5);
		cNord2.anchor = GridBagConstraints.LINE_START;
		
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
		JLabel lbResponsablenom = new JLabel("Nom:");
		lbResponsablenom.setPreferredSize(new Dimension(60, 14));
		pResponsable.add(lbResponsablenom);	
		this.lbResponsableNom = new JLabel("Julien");
		this.lbResponsableNom.setPreferredSize(new Dimension(60, 14));
		pResponsable.add(this.lbResponsableNom);		
		JLabel lbResponsableprenom = new JLabel("Pr�nom:");
		lbResponsableprenom.setPreferredSize(new Dimension(60, 14));
		pResponsable.add(lbResponsableprenom);		
		this.lbResponsablePrenom = new JLabel("Margot");
		this.lbResponsablePrenom.setPreferredSize(new Dimension(60, 14));
		pResponsable.add(this.lbResponsablePrenom);
		this.btChoisirResponsable = new JButton();
		this.btChoisirResponsable.setPreferredSize(new Dimension(30, 20));
		//this.btDateDebut.setIcon(new ImageIcon("./src/vue/calendar.png"));
		pResponsable.add(btChoisirResponsable);
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
		//this.btDateDebut = new JButton();
		//this.btDateDebut.setPreferredSize(new Dimension(20, 20));
		//this.btDateDebut.setIcon(new ImageIcon("./src/vue/calendar.png"));
		//pDateDebut.add(this.btDateDebut);
		
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
		//this.btDateEcheance = new JButton();
		//this.btDateEcheance.setPreferredSize(new Dimension(20, 20));
		//this.btDateEcheance.setIcon(new ImageIcon("./src/vue/calendar.png"));
		//pEcheance.add(this.btDateEcheance);
		
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
		this.lbMois = new JLabel("00");
		this.lbMois.setForeground(Color.gray);
		this.lbMois.setPreferredSize(new Dimension (30,20));
		pTempsEstime.add(this.lbMois);
		JLabel lbMois = new JLabel("Mois");
		pTempsEstime.add(lbMois);	
		this.lbJour = new JLabel("00");
		this.lbJour.setForeground(Color.gray);
		pTempsEstime.add(this.lbJour);
		this.lbJour.setPreferredSize(new Dimension (30,20));
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
		this.rbPriorite0 = new JRadioButton("", priorites.get(0));
		pPriorite.add(rbPriorite0);
		this.rbPriorite1 = new JRadioButton("", priorites.get(1));
		pPriorite.add(rbPriorite1);
		this.rbPriorite2 = new JRadioButton("", priorites.get(2));
		pPriorite.add(rbPriorite2);
		this.rbPriorite3 = new JRadioButton("", priorites.get(3));
		pPriorite.add(rbPriorite3);
		this.rbPriorite4 = new JRadioButton("", priorites.get(4));
		pPriorite.add(rbPriorite4);
		this.rbpriorites = new JRadioButton[5] ;
		this.rbpriorites[0] = this.rbPriorite0 ;
		this.rbpriorites[1] = this.rbPriorite1 ;
		this.rbpriorites[2] = this.rbPriorite2 ;
		this.rbpriorites[3] = this.rbPriorite3 ;
		this.rbpriorites[4] = this.rbPriorite4 ;
		
		
		JPanel pAjouterSupprimerSSTache = new JPanel();	
		pAjouterSupprimerSSTache.setLayout(new FlowLayout());
		cEst.gridx = 0;
		cEst.gridy = 4;
		cEst.anchor = GridBagConstraints.CENTER;
		cEst.insets = new Insets(5, 5, 5, 5);
		pEst.add(pAjouterSupprimerSSTache, cEst);
		this.btAjouterSousTaches = new JButton("+");
		this.btSupprimerSousTaches = new JButton("-");
		pAjouterSupprimerSSTache.add(new JLabel("SOUS-TACHES"));
		pAjouterSupprimerSSTache.add(this.btAjouterSousTaches);		
		pAjouterSupprimerSSTache.add(this.btSupprimerSousTaches);
		
		this.tabssTaches = new JTable(new TabModele(this.titresColonnesSsTaches, this.donneesSousTaches));
		this.tabssTaches.setPreferredScrollableViewportSize(new Dimension(400,65)); 
		JScrollPane tabSP = new JScrollPane(this.tabssTaches);
		this.tabssTaches.setDefaultRenderer(JProgressBar.class, new TableComponent());
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
		pEtatAvancement.setLayout(new FlowLayout());
		JLabel lbEtatAvancement = new JLabel("Etat d'avancement");
		lbEtatAvancement.setPreferredSize(new Dimension(150, 25));
		pEtatAvancement.add(lbEtatAvancement);			
		this.slAvancementTache = new JSlider();
		this.slAvancementTache.setMinimumSize(new Dimension(190, 26));
		this.slAvancementTache.setMaximum(100);
		this.slAvancementTache.setMaximumSize(new Dimension(200, 26));
		pEtatAvancement.add(this.slAvancementTache);				
		this.tfEtatAvancement = new JTextField();
		this.tfEtatAvancement.setColumns(3);
		this.tfEtatAvancement.setEditable(false);
		pEtatAvancement.add(this.tfEtatAvancement);			
		JLabel lbPourcent = new JLabel("%");
		lbPourcent.setPreferredSize(new Dimension(20, 20));
		pEtatAvancement.add(lbPourcent);
		pOuest.add(pEtatAvancement, BorderLayout.NORTH);
		
		JPanel pEquipeMateriel = new JPanel();
		pEquipeMateriel.setLayout(new GridLayout(2,1));
		
		
		JPanel pEquipe = new JPanel();
		pEquipe.setLayout(new BorderLayout());	
		JPanel pAjouterSupprimerEquipe = new JPanel();
		pAjouterSupprimerEquipe.add(new JLabel("EQUIPE"));
		pEquipe.add(pAjouterSupprimerEquipe, BorderLayout.NORTH);		
		this.btAjouterEquipe = new JButton("+");
		pAjouterSupprimerEquipe.add(this.btAjouterEquipe);		
		this.btSupprimerEquipe = new JButton("-");
		pAjouterSupprimerEquipe.add(this.btSupprimerEquipe);		
		this.tabEquipe = new JTable(new TabModele(this.titresColonnesEquipe, this.donneesEquipe));
		this.tabEquipe.setPreferredScrollableViewportSize(new Dimension(250,50)); 
		pEquipe.add(new JScrollPane(this.tabEquipe));
		
		JPanel pMateriel = new JPanel();
		pMateriel.setLayout(new BorderLayout());
		JPanel pAjouterSupprimerMateriel = new JPanel();
		pAjouterSupprimerMateriel.add(new JLabel("MATERIEL"));
		pMateriel.add(pAjouterSupprimerMateriel, BorderLayout.NORTH);		
		this.btAjouterMateriel = new JButton("+");
		pAjouterSupprimerMateriel.add(this.btAjouterMateriel);		
		this.btSupprimerMateriel = new JButton("-");
		pAjouterSupprimerMateriel.add(this.btSupprimerMateriel);		
		this.tabMateriel = new JTable(new TabModele(this.titresColonnesMateriel, this.donneesMateriel));
		this.tabMateriel.setPreferredScrollableViewportSize(new Dimension(250,50)); 
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
		this.btContact.setPreferredSize(new Dimension(70, 70));
		this.btContact.setIcon(new ImageIcon("./src/vue/contact.png"));
		pCentre.add(this.btContact);		
		this.btMateriel = new JButton("New button");
		this.btMateriel.setPreferredSize(new Dimension(70, 70));
		this.btMateriel.setIcon(new ImageIcon("./src/vue/materiel.png"));
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
		this.taCommentaire.setColumns(35);
		this.taCommentaire.setRows(5);	
		JScrollPane spCommentaire = new JScrollPane(this.taCommentaire);
		spCommentaire.setPreferredSize(new Dimension(1110, 100));
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
		
		this.btAnnuler.addActionListener(controleur);
		this.btValider.addActionListener(controleur);
		this.slAvancementTache.addChangeListener(controleur);
		this.rbPriorite0.addActionListener(controleur) ;
		this.rbPriorite1.addActionListener(controleur) ;
		this.rbPriorite2.addActionListener(controleur) ;
		this.rbPriorite3.addActionListener(controleur) ;
		this.rbPriorite4.addActionListener(controleur) ;
		//this.btAjouterSousTaches.addActionListener(controleur);
		//this.btSupprimerSousTaches.addActionListener(controleur);
		//this.btAjouterEquipe.addActionListener(controleur);
		//this.btAnnulerEquipe.addActionListener(controleur);

		
	}
	

	public HashMap<String, Object> getDonneesTache() throws ParseException {
		HashMap<String,Object> donneesTache = new HashMap<String, Object>();
		
		donneesTache.put("id_Tache", this.id_Tache);
		donneesTache.put("auteur_Tache", this.auteur_Tache);
		donneesTache.put("Date Creation", this.date_Creation);
		donneesTache.put("libelle", this.tfLibelle.getText()); 
		LocalDate dateDebut = LocalDate.parse(this.tfDateDebut.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
		donneesTache.put("dateDebut", dateDebut);
		LocalDate dateEcheance = LocalDate.parse(this.tfDateEcheance.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
		donneesTache.put("dateEcheance", dateEcheance);
		int p = this.prioriteInt();
		donneesTache.put("priorite", p);
		donneesTache.put("Etat Avancement", this.slAvancementTache.getValue());
		donneesTache.put("commentaire", this.taCommentaire);
		donneesTache.put("estTachePredfinie", this.cbTacheRecurrente.isSelected());
		
		return donneesTache;

	}
	
	public SortedSet<Benevole> getEquipePourCetteTache() {
		SortedSet <Benevole> ensembleBenevole = new TreeSet<Benevole>();
		Benevole benevole = null;
		for (int ligne = 0; ligne < this.tabEquipe.getRowCount(); ligne ++) {
			benevole = new Benevole((String)this.tabEquipe.getValueAt(ligne, 0 ),
												 (String)this.tabEquipe.getValueAt(ligne, 1 ),
												 (String)this.tabEquipe.getValueAt(ligne, 2 ));
			ensembleBenevole.add(benevole);
		}
		return ensembleBenevole;
	}
	
	public List<Materiel> getListeMaterielPourcetteTache(){
		List <Materiel> listeMateriel = new ArrayList<Materiel>();
		Materiel materiel = null;
		for (int ligne = 0; ligne < this.tabMateriel.getRowCount(); ligne ++) {
			materiel = new Materiel((String) this.tabMateriel.getValueAt(ligne, 0),
									 (String) this.tabMateriel.getValueAt(ligne, 1),
									 (String) this.tabMateriel.getValueAt(ligne, 2),
									 (Integer) this.tabMateriel.getValueAt(ligne, 3));
			listeMateriel.add(materiel);
		}
		return listeMateriel;
	}
	
	public List<SousTache> getListeSousTaches(){
		List<SousTache> listeSousTaches = new ArrayList<SousTache>();
		SousTache sousTache = null;
		for (int ligne = 0; ligne < this.tabssTaches.getRowCount(); ligne ++) {
			sousTache = new SousTache((String) this.tabssTaches.getValueAt(ligne, 0),
									   (Float) this.tabssTaches.getValueAt(ligne, 1));
			listeSousTaches.add(sousTache);
		}
		return listeSousTaches;

	}
	
	public void afficherDonnees(int id_Tache, String auteur_Tache, String libelle, String responsableNom, String responsablePrenom, Date dateDebut, Date dateEcheance, int tempsEstimeJourInt, int priorite, Map<String, Float> listeSousTaches, int etatAvancement, String commentaire, String date_Creation, boolean estPredefinie, int Avancement) {
		this.id_Tache = id_Tache;
		this.auteur_Tache = auteur_Tache;
		this.date_Creation = date_Creation;
		this.tfLibelle.setText(libelle);
		this.lbResponsableNom.setText(responsableNom);
		this.lbResponsablePrenom.setText(responsablePrenom);
		String dateDebutStr = dateDebut.toString();
		this.tfDateDebut.setText(dateDebutStr);
		String dateEcheanceStr = dateEcheance.toString();
		this.tfDateEcheance.setText(dateEcheanceStr);
		int teJourInt = tempsEstimeJourInt % 30 ;
		int teMoisInt = (tempsEstimeJourInt - teJourInt)/30;
		this.lbMois.setText(String.valueOf(teMoisInt));
		this.lbJour.setText(String.valueOf(teJourInt));
		this.priorite = priorite;
		this.slAvancementTache.setValue(Avancement); 
		this.taCommentaire.setText(commentaire);
		this.cbTacheRecurrente.setSelected(estPredefinie);
		
	}
	/*
	 * for (int l = 0; l < NB_MAX_SOUSTACHES; l++ ) {
			donneesTache.put("listeSsTache", this.tabssTaches.getValueAt(l, 0));
			donneesTache.put("listeSsTache", this.tabssTaches.getValueAt(l, 1));
		}
	 */

	public void setActifComposants(boolean actif){
		this.tfLibelle.setEditable(actif);
		this.tfDateDebut.setEditable(actif);
		this.tfDateEcheance.setEditable(actif);
		this.rbPriorite0.setEnabled(actif);
		this.rbPriorite1.setEnabled(actif);
		this.rbPriorite2.setEnabled(actif);
		this.rbPriorite3.setEnabled(actif);
		this.rbPriorite4.setEnabled(actif);
		this.btAjouterSousTaches.setEnabled(actif);
		this.btSupprimerSousTaches.setEnabled(actif);
		this.tabssTaches.setEnabled(actif); //� modifier : utiliser isCellEditable
		this.slAvancementTache.setEnabled(actif);
		this.tabEquipe.setEnabled(actif);    //� modifier : utiliser isCellEditable
		this.btAjouterEquipe.setEnabled(actif);
		this.btSupprimerEquipe.setEnabled(actif);
		this.btAjouterMateriel.setEnabled(actif);
		this.btContact.setEnabled(actif);
		this.btMateriel.setEnabled(actif);
		this.tabMateriel.setEnabled(actif);
		this.btSupprimerMateriel.setEnabled(actif);
		this.taCommentaire.setEditable(actif);
		this.btDateDebut.setEnabled(actif);
		this.btDateEcheance.setEnabled(actif);
		this.cbTacheRecurrente.setEnabled(actif);
	}
	
	public void modifierTexteBoutonsPourEdition(boolean estEditable) {
		if (estEditable) {
			this.btValider.setText("Valider");
			this.btAnnuler.setText("Annuler");
		}else {
			this.btValider.setText("imprimer");
			this.btAnnuler.setText("retour");
		}
	}
	
	public void activerBtRadioPriorite(int priorite) {
		for (int i = 0; i < priorite; i++) 
			this.priorites.set(i, true);
	}
	
	public List<Boolean> getPriorites() {
		return priorites;
	}
	
	
	public void setPriorites(List<Boolean> priorites) {
		this.priorites = priorites;
	}

/*
	public void ajouterSousTacheVue(String libelleSSTache, float tauxCompletion) {
		this.mapSousTaches.put(libelleSSTache, tauxCompletion);
	}
	
	public void supprimerSousTacheVue(String libelleSSTache, float tauxCompletion) {
		this.mapSousTaches.remove(libelleSSTache, tauxCompletion);
	}
	
	public boolean estTacheCompleteeAutomatiquement() {
		for (float tauxcompletion : this.mapSousTaches.values()) {
			if (tauxcompletion != 1.0F) 
				return false;
		}
		return true;
	}
	*/
	public boolean estTacheCompleteeManuellement() {
			return (this.slAvancementTache.getValue() == 100 );	
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


	public int getEtatAvancementTache() {
		return slAvancementTache.getValue();
	}

	/*
	public boolean estTacheCompletee() {
		return (this.estTacheCompleteeAutomatiquement() || this.estTacheCompleteeManuellement());
	}
	*/
	public void afficherEtatAvancement() {
		this.tfEtatAvancement.setText(String.valueOf(this.slAvancementTache.getValue()));
	}
	
	
	
	
	class TabModele extends AbstractTableModel {
		private boolean DEBUG = false;
		private String [] titresColonnes ;
		private Object [][] donnees;		

		
		public TabModele(String[] titresColonnes, Object[][] donnees) {
			this.titresColonnes = titresColonnes;
			this.donnees = donnees;
		}
		
	    public int getColumnCount() {
	    	return titresColonnes.length;
	    }

		public int getRowCount() {
			return donnees.length;
	    }

	    public String getColumnName(int col) {
	    	return titresColonnes[col];
	    }

	    public Object getValueAt(int row, int col) {
	    	return donnees[row][col];
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
		    return false;
	    }
	    /**
	     * Don't need to implement this method unless your table's data can
	     * change.
	     */
	    
	    public void setValueAt(Object value, int row, int col) {
	    	donnees[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	    
	}

	
	public class TableComponent extends DefaultTableCellRenderer {

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    if (value instanceof JProgressBar)
	      return (JProgressBar) value;
	    else
	      return this;
	  }
	}
	
	public int prioriteInt() {
		int p = 0 ;
        for (int i=0 ; i<5; i++) {
        	if (rbpriorites[i].isSelected()) {
        		p = i +1 ;
        	}
        }
        return p;
    }
	
	public void resetBtRadio() {
		this.rbPriorite0.setSelected(false);
		this.rbPriorite1.setSelected(false);
		this.rbPriorite2.setSelected(false);
		this.rbPriorite3.setSelected(false);
		this.rbPriorite4.setSelected(false);
	}
	
	public void majRadio() {
		int p = prioriteInt() ;
		//activerBtRadioPriorite(p);
		switch (p) {
		case 1 : 
			
			this.rbPriorite0.setSelected(true);
			this.rbPriorite1.setSelected(false);
			this.rbPriorite2.setSelected(false);
			this.rbPriorite3.setSelected(false);
			this.rbPriorite4.setSelected(false);
			break;
		case 2 : 
			
			this.rbPriorite0.setSelected(true);
			this.rbPriorite1.setSelected(true);
			this.rbPriorite2.setSelected(false);
			this.rbPriorite3.setSelected(false);
			this.rbPriorite4.setSelected(false);
			break ;
		case 3 : 
		
			this.rbPriorite0.setSelected(true);
			this.rbPriorite1.setSelected(true);
			this.rbPriorite2.setSelected(true);
			this.rbPriorite3.setSelected(false);
			this.rbPriorite4.setSelected(false);
			break ;
		case 4 : 
			
			this.rbPriorite0.setSelected(true);
			this.rbPriorite1.setSelected(true);
			this.rbPriorite2.setSelected(true);
			this.rbPriorite3.setSelected(true);
			this.rbPriorite4.setSelected(false);
			break;
			
		case 5 : 
			
			rbPriorite0.setSelected(true);
			rbPriorite1.setSelected(true);
			rbPriorite2.setSelected(true);
			rbPriorite3.setSelected(true);
			rbPriorite4.setSelected(true);
			break;
			
		}
		
	}
	
/*
 * for (int i = 0; i < NB_MAX_SOUSTACHES; i++) {
			donneesSousTaches[i][0]= "" ;
			donneesSousTaches[i][1]= new Float(0.0F);
			//this.mapSousTaches.put(String.valueOf(donneesSousTaches[i][0]), (Float) donneesSousTaches[i][1]);
			//System.out.println("numeroSousTache"+ i + "libelle :"+ donneesSousTaches[i][0] + "TauxCompletion :"+ this.mapSousTaches.get(donneesSousTaches[i][0]) );
		}
 */

    
}
