package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class VueNouvelleTache extends JPanel {
	private JTextField tfTitre;
	private JTextField tfMois;
	private JTextField tfJour;
	private JTextField tfDateDebut;
	private JTextField tfDateEcheance;
	private JTextField tfResponsable;
	private String [][] donneesSousTaches;
	private String [][] donneesEquipe;
	/**
	 * Create the panel.
	 */
	public VueNouvelleTache() {
		setMaximumSize(new Dimension(40000, 40000));
		setLayout(new BorderLayout(10, 25));
		
		JPanel pNord = new JPanel();
		add(pNord, BorderLayout.NORTH);
		GridBagLayout gbl_pNord = new GridBagLayout();
		gbl_pNord.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pNord.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pNord.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pNord.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pNord.setLayout(gbl_pNord);
		
		JLabel lbIdTache = new JLabel("Id t\u00E2che");
		GridBagConstraints gbc_lbIdTache = new GridBagConstraints();
		gbc_lbIdTache.anchor = GridBagConstraints.LINE_START;
		gbc_lbIdTache.insets = new Insets(5, 5, 5, 5);
		gbc_lbIdTache.gridx = 0;
		gbc_lbIdTache.gridy = 0;
		pNord.add(lbIdTache, gbc_lbIdTache);
		
		JLabel IdTache = new JLabel("");
		GridBagConstraints gbc_IdTache = new GridBagConstraints();
		gbc_IdTache.insets = new Insets(0, 0, 5, 5);
		gbc_IdTache.gridx = 1;
		gbc_IdTache.gridy = 0;
		pNord.add(IdTache, gbc_IdTache);
		
		JLabel lbCreateur = new JLabel("Cr\u00E9\u00E9 par");
		GridBagConstraints gbc_lbCreateur = new GridBagConstraints();
		gbc_lbCreateur.insets = new Insets(0, 0, 5, 0);
		gbc_lbCreateur.gridx = 2;
		gbc_lbCreateur.gridy = 0;
		pNord.add(lbCreateur, gbc_lbCreateur);
		
		JLabel lbTitre = new JLabel("Titre");
		GridBagConstraints gbc_lbTitre = new GridBagConstraints();
		gbc_lbTitre.anchor = GridBagConstraints.LINE_START;
		gbc_lbTitre.insets = new Insets(5, 5, 5, 5);
		gbc_lbTitre.gridx = 0;
		gbc_lbTitre.gridy = 1;
		pNord.add(lbTitre, gbc_lbTitre);
		
		tfTitre = new JTextField();
		tfTitre.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_tfTitre = new GridBagConstraints();
		gbc_tfTitre.insets = new Insets(0, 0, 5, 5);
		gbc_tfTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitre.anchor = GridBagConstraints.LINE_START;
		gbc_tfTitre.gridx = 1;
		gbc_tfTitre.gridy = 1;
		pNord.add(tfTitre, gbc_tfTitre);
		tfTitre.setColumns(10);
		
		JLabel auteur = new JLabel("          ");
		GridBagConstraints gbc_auteur = new GridBagConstraints();
		gbc_auteur.insets = new Insets(0, 5, 5, 5);
		gbc_auteur.gridx = 3;
		gbc_auteur.gridy = 0;
		pNord.add(auteur, gbc_auteur);
		
		JLabel lbResponsable = new JLabel("Responsable");
		lbResponsable.setPreferredSize(new Dimension(70, 14));
		GridBagConstraints cResponsable = new GridBagConstraints();
		cResponsable.anchor = GridBagConstraints.LINE_START;
		cResponsable.insets = new Insets(5, 5, 0, 5);
		cResponsable.gridx = 0;
		cResponsable.gridy = 2;
		pNord.add(lbResponsable, cResponsable);
		
		tfResponsable = new JTextField();
		tfResponsable.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_tfResponsable= new GridBagConstraints();
		gbc_tfResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfResponsable.anchor = GridBagConstraints.LINE_START;
		gbc_tfResponsable.insets = new Insets(0, 0, 0, 5);
		gbc_tfResponsable.gridx = 1;
		gbc_tfResponsable.gridy = 2;
		pNord.add(tfResponsable, gbc_tfResponsable);
		tfResponsable.setColumns(10);
		
		JPanel pEst = new JPanel();
		pEst.setBorder(new EmptyBorder(0, 0, 0, 5));
		add(pEst, BorderLayout.EAST);
		GridBagLayout gbl_pEst = new GridBagLayout();
		gbl_pEst.columnWidths = new int[] {0};
		gbl_pEst.rowHeights = new int[] {30, 30, 30, 30};
		gbl_pEst.columnWeights = new double[]{1.0, 1.0};
		gbl_pEst.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0};
		pEst.setLayout(gbl_pEst);
		
		JLabel lblPriorit = new JLabel("Priorit\u00E9");
		GridBagConstraints gbc_lblPriorit = new GridBagConstraints();
		gbc_lblPriorit.anchor = GridBagConstraints.LINE_START;
		gbc_lblPriorit.insets = new Insets(5, 5, 5, 5);
		gbc_lblPriorit.gridx = 0;
		gbc_lblPriorit.gridy = 0;
		pEst.add(lblPriorit, gbc_lblPriorit);
		
		JLabel lblTempsEstim = new JLabel("Temps estim\u00E9");
		GridBagConstraints gbc_lblTempsEstim = new GridBagConstraints();
		gbc_lblTempsEstim.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_lblTempsEstim.insets = new Insets(5, 5, 5, 5);
		gbc_lblTempsEstim.gridx = 0;
		gbc_lblTempsEstim.gridy = 1;
		pEst.add(lblTempsEstim, gbc_lblTempsEstim);
		
		JLabel lbDébut = new JLabel("D\u00E9but");
		GridBagConstraints gbc_lbDébut = new GridBagConstraints();
		gbc_lbDébut.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_lbDébut.insets = new Insets(5, 5, 5, 5);
		gbc_lbDébut.gridx = 0;
		gbc_lbDébut.gridy = 2;
		pEst.add(lbDébut, gbc_lbDébut);
		
		JPanel pDebut = new JPanel();
		pDebut.setLayout(null);
		GridBagConstraints gbc_pDebut = new GridBagConstraints();
		gbc_pDebut.insets = new Insets(0, 0, 5, 0);
		gbc_pDebut.fill = GridBagConstraints.BOTH;
		gbc_pDebut.gridx = 1;
		gbc_pDebut.gridy = 2;
		pEst.add(pDebut, gbc_pDebut);
		
		tfDateDebut = new JTextField();
		tfDateDebut.setBounds(0, 0, 86, 20);
		
		pDebut.add(tfDateDebut);
		tfDateDebut.setColumns(10);
		
		JButton btDateDebut = new JButton("");
		btDateDebut.setBounds(90, 0, 20, 20);
		btDateDebut.setMargin(new Insets(2, 5, 2, 5));
		btDateDebut.setPreferredSize(new Dimension(20, 20));
		pDebut.add(btDateDebut);
		
		JPanel pPriorité = new JPanel();
		GridBagConstraints gbc_pPriorité = new GridBagConstraints();
		gbc_pPriorité.anchor = GridBagConstraints.LINE_START;
		gbc_pPriorité.insets = new Insets(0, 0, 5, 0);
		gbc_pPriorité.gridx = 1;
		gbc_pPriorité.gridy = 0;
		pEst.add(pPriorité, gbc_pPriorité);
		pPriorité.setLayout(new GridLayout(0, 5, 0, 0));
		
		JRadioButton rbPriorite1 = new JRadioButton("");
		pPriorité.add(rbPriorite1);
		
		JRadioButton rbPriorite2 = new JRadioButton("");
		pPriorité.add(rbPriorite2);
		
		JRadioButton rbPriorite3 = new JRadioButton("");
		pPriorité.add(rbPriorite3);
		
		JRadioButton rbPriorite4 = new JRadioButton("");
		pPriorité.add(rbPriorite4);
		
		JRadioButton rbPriorite5 = new JRadioButton("");
		pPriorité.add(rbPriorite5);
		
		JPanel pTempsEstime = new JPanel();
		pTempsEstime.setBorder(new EmptyBorder(0, 20, 0, 20));
		GridBagConstraints gbc_pTempsEstime = new GridBagConstraints();
		gbc_pTempsEstime.anchor = GridBagConstraints.LINE_START;
		gbc_pTempsEstime.insets = new Insets(0, 0, 5, 0);
		gbc_pTempsEstime.gridx = 1;
		gbc_pTempsEstime.gridy = 1;
		pEst.add(pTempsEstime, gbc_pTempsEstime);
		pTempsEstime.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfJour = new JTextField();
		tfJour.setToolTipText("");
		pTempsEstime.add(tfJour);
		tfJour.setColumns(2);
		
		JLabel lbJour = new JLabel("Jours");
		pTempsEstime.add(lbJour);
		
		tfMois = new JTextField();
		pTempsEstime.add(tfMois);
		tfMois.setColumns(2);
		
		JLabel lbMois = new JLabel("Mois");
		pTempsEstime.add(lbMois);
		
		JLabel lbEchance = new JLabel("Ech\u00E9ance");
		GridBagConstraints gbc_lbEcheance = new GridBagConstraints();
		gbc_lbEcheance.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_lbEcheance.insets = new Insets(5, 5, 5, 5);
		gbc_lbEcheance.gridy = 3;
		gbc_lbEcheance.gridx = 0;
		pEst.add(lbEchance, gbc_lbEcheance);

		
		JPanel pEcheance = new JPanel();
		pEcheance.setLayout(null);
		GridBagConstraints gbc_pEcheance = new GridBagConstraints();
		gbc_pEcheance.insets = new Insets(0, 0, 5, 0);
		gbc_pEcheance.fill = GridBagConstraints.BOTH;
		gbc_pEcheance.gridx = 1;
		gbc_pEcheance.gridy = 3;
		pEst.add(pEcheance, gbc_pEcheance);
		

		
		tfDateEcheance = new JTextField();
		tfDateEcheance.setBounds(0, 0, 86, 20);
		tfDateEcheance.setColumns(10);
		pEcheance.add(tfDateEcheance);
		
		JButton btDateEcheance = new JButton("");
		btDateEcheance.setBounds(90, 0, 20, 20);
		btDateEcheance.setMargin(new Insets(2, 5, 2, 5));
		btDateEcheance.setPreferredSize(new Dimension(20, 20));
		pEcheance.add(btDateEcheance);
		
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
		add(pSud, BorderLayout.SOUTH);
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
		add(pOuest, BorderLayout.WEST);
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
		add(pCentre, BorderLayout.CENTER);
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

	}

}
