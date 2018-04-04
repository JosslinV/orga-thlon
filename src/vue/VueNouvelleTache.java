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

public class VueNouvelleTache extends JPanel {
	private JTextField tfTitre;
	private JTextField tfMois;
	private JTextField tfJour;

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
		gbl_pEst.columnWidths = new int[]{0, 0, 0};
		gbl_pEst.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pEst.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pEst.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pEst.setLayout(gbl_pEst);
		
		JLabel lblPriorit = new JLabel("Priorit\u00E9");
		GridBagConstraints gbc_lblPriorit = new GridBagConstraints();
		gbc_lblPriorit.insets = new Insets(0, 0, 5, 0);
		gbc_lblPriorit.gridx = 0;
		gbc_lblPriorit.gridy = 0;
		pEst.add(lblPriorit, gbc_lblPriorit);
		
		JLabel lblTempsEstim = new JLabel("Temps estim\u00E9");
		GridBagConstraints gbc_lblTempsEstim = new GridBagConstraints();
		gbc_lblTempsEstim.insets = new Insets(0, 0, 5, 0);
		gbc_lblTempsEstim.gridx = 0;
		gbc_lblTempsEstim.gridy = 1;
		pEst.add(lblTempsEstim, gbc_lblTempsEstim);
		
		JLabel lblDbut = new JLabel("D\u00E9but");
		GridBagConstraints gbc_lblDbut = new GridBagConstraints();
		gbc_lblDbut.insets = new Insets(0, 0, 5, 0);
		gbc_lblDbut.gridx = 0;
		gbc_lblDbut.gridy = 2;
		pEst.add(lblDbut, gbc_lblDbut);
		
		JLabel lblEchance = new JLabel("Ech\u00E9ance");
		GridBagConstraints gbc_lblEchance = new GridBagConstraints();
		gbc_lblEchance.insets = new Insets(0, 0, 5, 0);
		gbc_lblEchance.gridx = 0;
		gbc_lblEchance.gridy = 3;
		pEst.add(lblEchance, gbc_lblEchance);
		
		JPanel pPriorité = new JPanel();
		GridBagConstraints gbc_pPriorité = new GridBagConstraints();
		gbc_pPriorité.insets = new Insets(0, 0, 5, 0);
		gbc_pPriorité.fill = GridBagConstraints.BOTH;
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
		gbc_pTempsEstime.fill = GridBagConstraints.BOTH;
		gbc_pTempsEstime.gridx = 1;
		gbc_pTempsEstime.gridy = 1;
		pEst.add(pTempsEstime, gbc_pTempsEstime);
		pTempsEstime.setLayout(new GridLayout(1, 0, 0, 0));
		
		tfJour = new JTextField();
		pTempsEstime.add(tfJour);
		tfJour.setColumns(10);
		
		JLabel lbJour = new JLabel("Jours");
		pTempsEstime.add(lbJour);
		
		tfMois = new JTextField();
		pTempsEstime.add(tfMois);
		tfMois.setColumns(10);
		
		JLabel lbMois = new JLabel("Mois");
		pTempsEstime.add(lbMois);
		
		JPanel pOuest = new JPanel();
		add(pOuest, BorderLayout.WEST);
		
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
