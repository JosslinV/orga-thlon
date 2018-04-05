package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
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
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VueNouvelleTache extends JPanel {
	private JTextField tfTitre;
	private JTextField tfMois;
	private JTextField tfJour;
	private JTextField tfDateDebut;
	private JTextField tfDateEcheance;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VueNouvelleTache() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pSud = new JPanel();
		pSud.setBorder(new EmptyBorder(0, 80, 30, 80));
		add(pSud, BorderLayout.SOUTH);
		pSud.setLayout(new GridLayout(1, 0, 150, 0));
		
		JButton btAnnuler = new JButton("Annuler");
		pSud.add(btAnnuler);
		
		JButton btValider = new JButton("Valider");
		pSud.add(btValider);
		
		JPanel pNord = new JPanel();
		add(pNord, BorderLayout.NORTH);
		GridBagLayout gbl_pNord = new GridBagLayout();
		gbl_pNord.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pNord.rowHeights = new int[]{0, 0, 0};
		gbl_pNord.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pNord.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pNord.setLayout(gbl_pNord);
		
		JLabel lbIdTache = new JLabel("Id t\u00E2che");
		GridBagConstraints gbc_lbIdTache = new GridBagConstraints();
		gbc_lbIdTache.insets = new Insets(0, 0, 5, 5);
		gbc_lbIdTache.gridx = 0;
		gbc_lbIdTache.gridy = 0;
		pNord.add(lbIdTache, gbc_lbIdTache);
		
		JLabel lbCreateur = new JLabel("Cr\u00E9\u00E9 par");
		GridBagConstraints gbc_lbCreateur = new GridBagConstraints();
		gbc_lbCreateur.insets = new Insets(0, 0, 5, 0);
		gbc_lbCreateur.gridx = 2;
		gbc_lbCreateur.gridy = 0;
		pNord.add(lbCreateur, gbc_lbCreateur);
		
		tfTitre = new JTextField();
		tfTitre.setText("\"\"");
		GridBagConstraints gbc_tfTitre = new GridBagConstraints();
		gbc_tfTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitre.gridx = 1;
		gbc_tfTitre.gridy = 1;
		pNord.add(tfTitre, gbc_tfTitre);
		tfTitre.setColumns(10);
		
		JLabel lbTitre = new JLabel("Titre");
		GridBagConstraints gbc_lbTitre = new GridBagConstraints();
		gbc_lbTitre.insets = new Insets(0, 0, 0, 5);
		gbc_lbTitre.gridx = 0;
		gbc_lbTitre.gridy = 1;
		pNord.add(lbTitre, gbc_lbTitre);
		
		JPanel pEst = new JPanel();
		add(pEst, BorderLayout.EAST);
		GridBagLayout gbl_pEst = new GridBagLayout();
		gbl_pEst.columnWidths = new int[] {0};
		gbl_pEst.rowHeights = new int[] {0};
		gbl_pEst.columnWeights = new double[]{0.0, 0.0};
		gbl_pEst.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0};
		pEst.setLayout(gbl_pEst);
		
		JLabel lblPriorit = new JLabel("Priorit\u00E9");
		GridBagConstraints gbc_lblPriorit = new GridBagConstraints();
		gbc_lblPriorit.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriorit.gridx = 0;
		gbc_lblPriorit.gridy = 0;
		pEst.add(lblPriorit, gbc_lblPriorit);
		
		JLabel lblTempsEstim = new JLabel("Temps estim\u00E9");
		GridBagConstraints gbc_lblTempsEstim = new GridBagConstraints();
		gbc_lblTempsEstim.insets = new Insets(0, 0, 5, 5);
		gbc_lblTempsEstim.gridx = 0;
		gbc_lblTempsEstim.gridy = 1;
		pEst.add(lblTempsEstim, gbc_lblTempsEstim);
		
		JLabel lblDbut = new JLabel("D\u00E9but");
		GridBagConstraints gbc_lblDbut = new GridBagConstraints();
		gbc_lblDbut.insets = new Insets(0, 0, 5, 5);
		gbc_lblDbut.gridx = 0;
		gbc_lblDbut.gridy = 2;
		pEst.add(lblDbut, gbc_lblDbut);
		
		JPanel pDebut = new JPanel();
		FlowLayout fl_pDebut = (FlowLayout) pDebut.getLayout();
		fl_pDebut.setVgap(0);
		fl_pDebut.setHgap(1);
		GridBagConstraints gbc_pDebut = new GridBagConstraints();
		gbc_pDebut.insets = new Insets(0, 0, 5, 0);
		gbc_pDebut.fill = GridBagConstraints.BOTH;
		gbc_pDebut.gridx = 1;
		gbc_pDebut.gridy = 2;
		pEst.add(pDebut, gbc_pDebut);
		
		tfDateDebut = new JTextField();
		pDebut.add(tfDateDebut);
		tfDateDebut.setColumns(10);
		
		JButton btDateDebut = new JButton("");
		pDebut.add(btDateDebut);
		
		JLabel lblEchance = new JLabel("Ech\u00E9ance");
		GridBagConstraints gbc_lblEchance = new GridBagConstraints();
		gbc_lblEchance.insets = new Insets(0, 0, 5, 5);
		gbc_lblEchance.gridx = 0;
		gbc_lblEchance.gridy = 3;
		pEst.add(lblEchance, gbc_lblEchance);
		
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
		
		JPanel pEcheance = new JPanel();
		GridBagConstraints gbc_pEcheance = new GridBagConstraints();
		gbc_pEcheance.insets = new Insets(0, 0, 5, 0);
		gbc_pEcheance.fill = GridBagConstraints.BOTH;
		gbc_pEcheance.gridx = 1;
		gbc_pEcheance.gridy = 3;
		pEst.add(pEcheance, gbc_pEcheance);
		
		tfDateEcheance = new JTextField();
		tfDateEcheance.setColumns(10);
		pEcheance.add(tfDateEcheance);
		
		JButton btDateEcheance = new JButton("");
		pEcheance.add(btDateEcheance);
		
		JPanel pOuest = new JPanel();
		add(pOuest, BorderLayout.WEST);
		GridBagLayout gbl_pOuest = new GridBagLayout();
		gbl_pOuest.columnWidths = new int[]{0, 0, 0};
		gbl_pOuest.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pOuest.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pOuest.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		pOuest.setLayout(gbl_pOuest);
		
		JLabel lbResponsable = new JLabel("Responsable");
		GridBagConstraints Responsable = new GridBagConstraints();
		Responsable.insets = new Insets(0, 0, 5, 5);
		Responsable.gridx = 0;
		Responsable.gridy = 0;
		pOuest.add(lbResponsable, Responsable);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		pOuest.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lbEquipe = new JLabel("Equipe");
		GridBagConstraints gbc_lbEquipe = new GridBagConstraints();
		gbc_lbEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_lbEquipe.gridx = 0;
		gbc_lbEquipe.gridy = 1;
		pOuest.add(lbEquipe, gbc_lbEquipe);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		pOuest.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Responsable"
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		JPanel pCentre = new JPanel();
		pCentre.setBorder(new CompoundBorder(null, new EmptyBorder(50, 50, 50, 50)));
		add(pCentre, BorderLayout.CENTER);
		pCentre.setLayout(new GridLayout(2, 1, 0, 50));
		
		JButton btnNewButton_1 = new JButton("New button");
		pCentre.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		pCentre.add(btnNewButton);

	}

}
