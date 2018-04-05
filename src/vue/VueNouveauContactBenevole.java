package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VueNouveauContactBenevole extends JPanel{
	private JLabel lb;
	private JCheckBox cb;
	private JTextField tf;
	private JComboBox<String> jc;
	private JButton b;
	private JPanel p;
	private JScrollPane sp;

	public VueNouveauContactBenevole() {
		this.setLayout(new BorderLayout());
		JPanel panneauPrincipal = new JPanel();
		this.add(panneauPrincipal, BorderLayout.NORTH);
		panneauPrincipal.setLayout(new GridBagLayout());
		panneauPrincipal.setBorder(new EmptyBorder(20,0,0,0));
		GridBagConstraints c = new GridBagConstraints();
		
		//ligne 0 : Nom ((Jlabel + JTextField) + Téléphone (Jlabel + JTextField) 
		JLabel lbNom = new JLabel("Nom");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbNom,c); 

		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(170,25));
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tf, c);
		
		JLabel lbTel = new JLabel("Téléphone   ");
		lbTel.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 4;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbTel,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(120,25));
		c.gridx = 5;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tf, c);
		
		//ligne 1 : Prénom (JLabel + JTextField) + E-mail (Jlabel + JTextField)
		JLabel lbPrenom = new JLabel("Prénom");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbPrenom,c); 

		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(170,25));
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tf, c);
		
		JLabel lbMail = new JLabel("E-mail");
		lbMail.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 4;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbMail,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		c.gridx = 5;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tf, c);
		
		this.add(panneauPrincipal, BorderLayout.CENTER);
		//ligne 2 : Rôle (JLabel + JComboList) + Adresse (JLabel + JTextField)
		JLabel lbRole = new JLabel("Rôle");
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbRole,c);
				
		String [] roleExemple = {
				"cuisinier",
				"trésorier",
				"com'",
				"..."
		};
		jc = new JComboBox<String>(roleExemple);
		jc.setEditable(true);
		jc.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(jc, c);
		
		JLabel lbAdresse = new JLabel("Adresse");
		lbAdresse.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 4;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panneauPrincipal.add(lbAdresse,c); 
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		c.gridx = 5;
		c.gridy = 2;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panneauPrincipal.add(p, c);
		//paragraphe 1 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		p.add(tf);
		//ligne 3 :  + Adresse (JTextField) 
		//paragraphe 2 (Adresse)
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		p.add(tf);
		
		//ligne 4 : Equipe (JLabel + JTextField) + CodePostal (JLabel + JTextField)
		JLabel lb = new JLabel("Responsable d'équipe");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lb,c); 
		cb = new JCheckBox();
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.CENTER;
		panneauPrincipal.add(cb,c);
		
		lb = new JLabel("Code Postal    ");
		c.gridx = 4;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lb.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lb,c); 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 5;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tf, c);
		
		//ligne 5 : Equipe (JLabel + JComboList) + Ville (JLabel + JTextField)
		lb = new JLabel("Equipe");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lb,c); 
		String [] EquipeExemple = {
				"Equipe 1",
				"Equipe 2",
				"Equipe 3",
				"..."
		};
		jc = new JComboBox<String>(EquipeExemple);
		jc.setEditable(true);
		jc.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(jc, c);
		b = new JButton("+");
		c.gridx = 2;
		c.gridy = 6;
		panneauPrincipal.add(b,c);
		
		lb = new JLabel("Ville");
		c.gridx = 4;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lb.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lb,c); 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tf, c);
		
		//ligne 8 : bouton "Equipe" + tableau Prêt Matériel
		b = new JButton("");
		c.gridx = 1;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,115);
		c.ipady = 40;
		panneauPrincipal.add(b,c);
		
		p = new JPanel();
		
		
		/**
		p = new JPanel();
		p.setBackground(Color.RED);
		p.setLayout(new BorderLayout());
		p.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 4;
		c.gridy = 8;
		c.gridheight = 4;
		c.gridwidth = 2;
		//c.fill = GridBagConstraints.HORIZONTAL;
		panneauPrincipal.add(p,c);
		JPanel np = new JPanel();
		p.add(np, BorderLayout.NORTH);
		lb = new JLabel("Prêt de matériel");
		np.add(lb); 
		JPanel cp = new JPanel();
		cp.setBackground(Color.BLUE);
		p.add(cp, BorderLayout.CENTER);
		String titresColonnes [] = {"Date", "Description","Tâche"};
		Object [][] donneesPretMateriel = {
				{"","",""},
				{"","",""},
				{"","",""},
		};
		JTable materielTab = new JTable(donneesPretMateriel, titresColonnes);
		JScrollPane tabSP = new JScrollPane(materielTab);
		tabSP.setPreferredSize(new Dimension(250,170));
		cp.add(tabSP); 
		*/
		//p : SUD
		JPanel ps = new JPanel();
		this.add(ps, BorderLayout.SOUTH);
		ps.setLayout(new GridLayout(1,2,150,0));
		ps.setBorder(new EmptyBorder(0,80,30,80));
		b = new JButton("Annuler");
		b.setPreferredSize(new Dimension(40,40));
		ps.add(b);
		b = new JButton("Valider");
		b.setPreferredSize(new Dimension(40,40));
		ps.add(b);
		
	}
}
