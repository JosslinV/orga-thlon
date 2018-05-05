package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.ControleurNouvelleCourse;
import controleur.ControleurNouvelleTache;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class FenetreNouvelleTache extends JFrame {
	
	private static final int PRIORITE_MAX = 5;
	private int id_Tache;
	private String auteur_Tache;
	private JTextField tfLibelle;
	private JTextField tfResponsable; // nom? prénom?
	private int priorite;
	private List<Boolean> priorites;
	private JTextField tfMois;
	private JTextField tfJour;
	private JTextField tfDateDebut;
	private JTextField tfDateEcheance;
	private String [][] donneesSousTaches;
	private String [][] donneesEquipe;
	private JButton btDateDebut;
	private JButton btDateEcheance;


	/**
	 * Create the panel.
	 */
	public FenetreNouvelleTache() {
		//ControleurNouvelleTache controleur = new ControleurNouvelleTache(this);

		
		this.setTitle(this.id_Tache +" : " + "création d'une nouvelle fiche TACHE");
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(765, 700);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(10, 25));

	
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

		JLabel lbResponsable = new JLabel("Responsable");
		lbResponsable.setPreferredSize(new Dimension(100, 14));
		cNord2.gridx = 0;
		cNord2.gridy = 2;
		pNord.add(lbResponsable, cNord2);
		
		this.tfResponsable = new JTextField();
		this.tfResponsable.setColumns(10);
		cNord2.gridwidth = 1;
		cNord2.gridx = 1;
		cNord2.gridy = 2;
		pNord.add(this.tfResponsable, cNord2);
		
		JPanel pEst = new JPanel();
		pEst.setBorder(new EmptyBorder(0, 0, 0, 20));
		this.add(pEst, BorderLayout.EAST);
		pEst.setLayout(new GridBagLayout());
		
		GridBagConstraints cEst0 = new GridBagConstraints();
		cEst0.anchor = GridBagConstraints.LINE_START;

		JLabel lbDebut = new JLabel("Date de D\u00E9but");
		cEst0.insets = new Insets(5, 10, 5, 5);
		cEst0.gridx = 0;
		cEst0.gridy = 0;
		pEst.add(lbDebut, cEst0);
		
		JPanel pDateDebut = new JPanel();
		cEst0.insets = new Insets(5, 0, 5, 5);
		cEst0.gridx = 1;
		cEst0.gridy = 0;
		cEst0.weightx = 1;
		cEst0.fill = GridBagConstraints.HORIZONTAL;
		pEst.add(pDateDebut, cEst0);
		this.tfDateDebut = new JTextField();
		this.tfDateDebut.setColumns(8);
		pDateDebut.add(this.tfDateDebut);		
		this.btDateDebut = new JButton();
		this.btDateDebut.setPreferredSize(new Dimension(20, 20));
		this.btDateDebut.setIcon(new ImageIcon("./src/vue/calendar.png"));
		pDateDebut.add(this.btDateDebut);
		
		JLabel lbEchance = new JLabel("Date d'\u00E9ch\u00E9ance");
		cEst0.insets = new Insets(5, 10, 5, 5);
		cEst0.gridx = 0;
		cEst0.gridy = 1;
		pEst.add(lbEchance, cEst0);

		JPanel pEcheance = new JPanel();
		cEst0.insets = new Insets(5, 0, 5, 5);
		cEst0.gridx = 1;
		cEst0.gridy = 1;
		cEst0.weightx = 1;
		cEst0.fill = GridBagConstraints.HORIZONTAL;
		pEst.add(pEcheance, cEst0);
		this.tfDateEcheance = new JTextField();
		this.tfDateEcheance.setColumns(8);
		pEcheance.add(this.tfDateEcheance);		
		this.btDateEcheance = new JButton();
		this.btDateEcheance.setPreferredSize(new Dimension(20, 20));
		this.btDateEcheance.setIcon(new ImageIcon("./src/vue/calendar.png"));
		pEcheance.add(this.btDateEcheance);
		
		JLabel lbTempsEstim = new JLabel("Temps estim\u00E9");
		cEst0.insets = new Insets(5, 10, 5, 5);
		cEst0.gridx = 0;
		cEst0.gridy = 2;
		pEst.add(lbTempsEstim, cEst0);
		
		JPanel pTempsEstime = new JPanel();
		cEst0.gridx = 1;
		cEst0.gridy = 2;
		pEst.add(pTempsEstime, cEst0);
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
		cEst0.insets = new Insets(5, 10, 5, 5);
		cEst0.gridx = 0;
		cEst0.gridy = 3;
		pEst.add(lbPriorite, cEst0);
		
		JPanel pPriorite = new JPanel();
		pPriorite.setLayout(new GridLayout(0, 5, 5, 0));
		cEst0.gridx = 1;
		cEst0.gridy = 3;
		cEst0.weightx = 1;
		cEst0.fill = GridBagConstraints.HORIZONTAL;
		pEst.add(pPriorite, cEst0);
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
		
		
		
		/*

		JPanel pSousTache = new JPanel();
		GridBagConstraints gbc_pSousTache = new GridBagConstraints();
		gbc_pSousTache.gridwidth = 2;
		gbc_pSousTache.insets = new Insets(0, 0, 5, 0);
		gbc_pSousTache.fill = GridBagConstraints.BOTH;
		gbc_pSousTache.gridx = 0;
		gbc_pSousTache.gridy = 4;
		pEst.add(pSousTache, gbc_pSousTache);
		GridBagLayout gbl_pSousTache = new GridBagLayout();
		gbl_pSousTache.columnWidths = new int[]{48, 59, 0, 0};
		gbl_pSousTache.rowHeights = new int[]{14, 0, 0, 0};
		gbl_pSousTache.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pSousTache.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		pSousTache.setLayout(gbl_pSousTache);
		
		JLabel lbSoustaches = new JLabel("Sous-t\u00E2ches");
		GridBagConstraints gbc_lbSoustaches = new GridBagConstraints();
		gbc_lbSoustaches.insets = new Insets(5, 5, 5, 5);
		gbc_lbSoustaches.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbSoustaches.gridx = 0;
		gbc_lbSoustaches.gridy = 0;
		pSousTache.add(lbSoustaches, gbc_lbSoustaches);
		
		JButton btSousTaches = new JButton("");
		btSousTaches.setMargin(new Insets(5, 5, 5, 5));
		btSousTaches.setHorizontalAlignment(SwingConstants.LEFT);
		btSousTaches.setPreferredSize(new Dimension(20, 20));

		btSousTaches.setActionCommand("");
		GridBagConstraints gbc_btSousTaches = new GridBagConstraints();
		gbc_btSousTaches.gridx = 1;
		gbc_btSousTaches.gridy = 0;
		pSousTache.add(btSousTaches, gbc_btSousTaches);
		String titresColonnesSsTaches [] = {
				"", "Libell\u00E9"
			};
		String [][] donneesSousTaches = {
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""}

			};
		
		JTable tabSousTaches = new JTable(donneesSousTaches,titresColonnesSsTaches );
		tabSousTaches.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
			},
			new String[] {
				"", "Libell\u00E9"
			}
		));
		tabSousTaches.getColumnModel().getColumn(0).setPreferredWidth(15);
		tabSousTaches.setPreferredSize(new Dimension(100, 200));

		JScrollPane spSousTaches = new JScrollPane(tabSousTaches);
		spSousTaches.setPreferredSize(new Dimension(150, 300));
		GridBagConstraints gbc_spSousTaches = new GridBagConstraints();
		gbc_spSousTaches.gridheight = 2;
		gbc_spSousTaches.gridwidth = 2;
		gbc_spSousTaches.anchor = GridBagConstraints.LINE_START;
		gbc_spSousTaches.insets = new Insets(0, 5, 5, 0);
		gbc_spSousTaches.fill = GridBagConstraints.BOTH;
		gbc_spSousTaches.gridx = 0;
		gbc_spSousTaches.gridy = 1;
		pSousTache.add(spSousTaches, gbc_spSousTaches);
		
		JPanel pSud = new JPanel();
		pSud.setBorder(new EmptyBorder(0, 80, 30, 80));
		this.add(pSud, BorderLayout.SOUTH);
		GridBagLayout gbl_pSud = new GridBagLayout();
		gbl_pSud.columnWidths = new int[] {80, 70, 190, 70, 80};
		gbl_pSud.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_pSud.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pSud.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pSud.setLayout(gbl_pSud);
		
		JLabel lbCommentaire = new JLabel("Commentaire");
		GridBagConstraints gbc_lbCommentaire = new GridBagConstraints();
		gbc_lbCommentaire.anchor = GridBagConstraints.LINE_START;
		gbc_lbCommentaire.insets = new Insets(0, 0, 5, 5);
		gbc_lbCommentaire.gridx = 0;
		gbc_lbCommentaire.gridy = 0;
		pSud.add(lbCommentaire, gbc_lbCommentaire);
		
		JTextArea taCommentaire = new JTextArea();
		taCommentaire.setPreferredSize(new Dimension(4, 32));
		GridBagConstraints gbc_taCommentaire = new GridBagConstraints();
		gbc_taCommentaire.insets = new Insets(0, 0, 5, 0);
		gbc_taCommentaire.gridheight = 2;
		gbc_taCommentaire.anchor = GridBagConstraints.LINE_START;
		gbc_taCommentaire.gridwidth = 6;
		gbc_taCommentaire.fill = GridBagConstraints.BOTH;
		gbc_taCommentaire.gridx = 0;
		gbc_taCommentaire.gridy = 1;
		pSud.add(taCommentaire, gbc_taCommentaire);
		
		JButton btAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btAnnuler = new GridBagConstraints();
		gbc_btAnnuler.fill = GridBagConstraints.BOTH;
		gbc_btAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btAnnuler.gridx = 1;
		gbc_btAnnuler.gridy = 4;
		pSud.add(btAnnuler, gbc_btAnnuler);
		
		JButton btValider = new JButton("Valider");
		GridBagConstraints gbc_btValider = new GridBagConstraints();
		gbc_btValider.insets = new Insets(0, 0, 0, 5);
		gbc_btValider.fill = GridBagConstraints.BOTH;
		gbc_btValider.gridx = 3;
		gbc_btValider.gridy = 4;
		pSud.add(btValider, gbc_btValider);
		
		JPanel pOuest = new JPanel();
		pOuest.setBorder(new EmptyBorder(0, 5, 0, 0));
		pOuest.setPreferredSize(new Dimension(300, 50));
		this.add(pOuest, BorderLayout.WEST);
		GridBagLayout gbl_pOuest = new GridBagLayout();
		gbl_pOuest.columnWidths = new int[] {30};
		gbl_pOuest.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pOuest.columnWeights = new double[]{1.0};
		gbl_pOuest.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pOuest.setLayout(gbl_pOuest);
		

		
		JLabel lbEquipe = new JLabel("Equipe");
		lbEquipe.setPreferredSize(new Dimension(70, 14));
		GridBagConstraints gbc_lbEquipe = new GridBagConstraints();
		gbc_lbEquipe.anchor = GridBagConstraints.LINE_START;
		gbc_lbEquipe.insets = new Insets(5, 0, 5, 5);
		gbc_lbEquipe.gridx = 0;
		gbc_lbEquipe.gridy = 0;
		pOuest.add(lbEquipe, gbc_lbEquipe);
		
		GridBagConstraints gbc_tabSP = new GridBagConstraints();
		gbc_tabSP.fill = GridBagConstraints.BOTH;
		gbc_tabSP.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_tabSP.insets = new Insets(0, 0, 5, 0);
		gbc_tabSP.gridwidth = 2;
		gbc_tabSP.gridheight = 2;
		gbc_tabSP.gridx = 0;
		gbc_tabSP.gridy = 2;

		
		String titresColonnesEquipe [] = {
				"Responsable", "Nom", "Pr\u00E9nom", "R\u00F4le"
			};
		String [][] donneesEquipe = {
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""}

			};
		JTable tabEquipe = new JTable(donneesEquipe,titresColonnesEquipe );

		
		JScrollPane spEquipe = new JScrollPane(tabEquipe);
		spEquipe.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_spEquipe = new GridBagConstraints();
		gbc_spEquipe.gridheight = 4;
		gbc_spEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_spEquipe.fill = GridBagConstraints.BOTH;
		gbc_spEquipe.gridx = 0;
		gbc_spEquipe.gridy = 1;
		pOuest.add(spEquipe, gbc_spEquipe);
		
		JSlider slider_1 = new JSlider();
		slider_1.setMinimumSize(new Dimension(190, 26));
		slider_1.setMaximum(200);
		slider_1.setMaximumSize(new Dimension(200, 26));
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.anchor = GridBagConstraints.WEST;
		gbc_slider_1.insets = new Insets(0, 0, 0, 5);
		gbc_slider_1.gridx = 0;
		gbc_slider_1.gridy = 7;
		pOuest.add(slider_1, gbc_slider_1);
		
		JLabel lbEtatAvancement = new JLabel("Etat d'avancement");
		lbEtatAvancement.setPreferredSize(new Dimension(200, 14));
		GridBagConstraints gbc_lbEtatAvancement = new GridBagConstraints();
		gbc_lbEtatAvancement.anchor = GridBagConstraints.LINE_START;
		gbc_lbEtatAvancement.insets = new Insets(0, 0, 0, 5);
		gbc_lbEtatAvancement.gridx = 0;
		gbc_lbEtatAvancement.gridy = 6;
		pOuest.add(lbEtatAvancement, gbc_lbEtatAvancement);
		
		JPanel pCentre = new JPanel();
		pCentre.setBorder(new CompoundBorder(null, new EmptyBorder(50, 50, 50, 50)));
		this.add(pCentre, BorderLayout.CENTER);
		pCentre.setLayout(new GridLayout(2, 1, 20, 70));
		
		JButton btContact = new JButton("New button");
		btContact.setMinimumSize(new Dimension(50, 50));
		btContact.setMaximumSize(new Dimension(50, 50));
		btContact.setMargin(new Insets(0, 0, 0, 0));
		btContact.setPreferredSize(new Dimension(50, 50));
		pCentre.add(btContact);
		
		JButton btMateriel = new JButton("New button");
		btMateriel.setPreferredSize(new Dimension(50, 50));
		btMateriel.setMargin(new Insets(2, 14, 0, 0));
		pCentre.add(btMateriel);
*/

	}
	

	public HashMap<String, Object> getDonneesCourse() throws ParseException {
		HashMap<String,Object> donneesTache = new HashMap<String, Object>();
		
		donneesTache.put("id_Tache", this.id_Tache);
		donneesTache.put("auteur_Tache", this.auteur_Tache);
		donneesTache.put("libelle", this.tfLibelle.getText());
		donneesTache.put("responsable", this.tfResponsable.getText());
		Date dateDebut = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateDebut.getText());
		donneesTache.put("dateDebut", dateDebut);
		Date dateEcheance = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfDateEcheance.getText());
		donneesTache.put("dateDebut", dateEcheance);
		
		donneesTache.put("priorite", this.priorite);

		
		return donneesTache;

	}
	
	public void afficherDonnees(int id_Tache, String auteur_Tache, String libelle, String responsable, int priorite, Date dateDebut, Date dateEcheance  ) {
		this.id_Tache = id_Tache;
		this.auteur_Tache = auteur_Tache;
		this.tfLibelle.setText(libelle);
		this.tfResponsable.setText(responsable);
		String dateDebutStr = dateDebut.toString();
		this.tfDateDebut.setText(dateDebutStr);
		String dateEcheanceStr = dateEcheance.toString();
		this.tfDateEcheance.setText(dateEcheanceStr);
		this.priorite = priorite;
		
	}

	private void activerBtRadioPriorite(int priorite) {
		for (int i = 0; i < priorite; i++) 
			this.priorites.set(i, true);
	}
	
	
	
}
