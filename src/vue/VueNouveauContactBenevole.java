package vue;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VueNouveauContactBenevole extends JPanel{
	private int IdBenevole;
	private JTextField tfNom;
	private JTextField tfTelephone;
	private JTextField tfPrenom;
	private JTextField tfMail;
	private JTextField tfRole;
	private JTextField tfAdresse1;
	private JTextField tfAdresse2;
	private JLabel lbResponsable;
	private JCheckBox cbEstResponsableEquipe;
	private JCheckBox cbEstResponsableTache;
	private JTextField tfCP;
	private JButton btAjouterEquipe;
	private JButton b;


	public VueNouveauContactBenevole() {
		this.setLayout(new BorderLayout());
		JPanel panneauPrincipal = new JPanel();
		this.add(panneauPrincipal, BorderLayout.NORTH);
		panneauPrincipal.setLayout(new GridBagLayout());
		panneauPrincipal.setBorder(new EmptyBorder(0,20,0,20));
		GridBagConstraints c = new GridBagConstraints();
		
		//ligne 0 : Nom ((Jlabel + JTextField) + Téléphone (Jlabel + JTextField) 
		JLabel lbNom = new JLabel("Nom");
		c.insets = new Insets(5, 0, 5, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbNom,c); 

		tfNom = new JTextField();
		tfNom.setPreferredSize(new Dimension(170,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 1;
		c.gridy = 0;
		//c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfNom, c);
		
		JLabel lbTelephone = new JLabel("Téléphone");
		lbTelephone.setBorder(new EmptyBorder(0,40,0,0));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 4;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbTelephone,c); 
		
		tfTelephone = new JTextField("");
		tfTelephone.setPreferredSize(new Dimension(120,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 5;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfTelephone, c);
		
		//ligne 1 : Prénom (JLabel + JTextField) + E-mail (Jlabel + JTextField)
		JLabel lbPrenom = new JLabel("Prénom");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbPrenom,c); 

		tfPrenom = new JTextField();
		tfPrenom.setPreferredSize(new Dimension(170,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfPrenom, c);
		
		JLabel lbMail = new JLabel("E-mail");
		lbMail.setBorder(new EmptyBorder(0,40,0,0));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 4;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbMail,c); 
		
		tfMail = new JTextField();
		tfMail.setPreferredSize(new Dimension(235,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 5;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfMail, c);
		
		this.add(panneauPrincipal, BorderLayout.CENTER);
		//ligne 2 : Réle (JLabel + JComboList) + Adresse (JLabel + JTextField)
		JLabel lbRole = new JLabel("Réle");
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbRole,c);
		
		tfRole = new JTextField();
		tfRole.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfRole, c);
		
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
		tfAdresse1 = new JTextField("");
		tfAdresse1.setPreferredSize(new Dimension(235,25));
		p.add(tfAdresse1);
		//ligne 3 :  + Adresse (JTextField) 
		//paragraphe 2 (Adresse)
		tfAdresse2 = new JTextField("");
		tfAdresse2.setPreferredSize(new Dimension(235,25));
		p.add(tfAdresse2);
		
		//ligne 4 : Equipe (JLabel + JTextField) + CodePostal (JLabel + JTextField)
		lbResponsable = new JLabel("Responsable d'équipe");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbResponsable,c); 
		this.cbEstResponsableEquipe = new JCheckBox();
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.CENTER;
		panneauPrincipal.add(this.cbEstResponsableEquipe,c);
		
		JLabel lbCP = new JLabel("Code Postal");
		c.gridx = 4;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbCP.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbCP,c); 
		tfCP = new JTextField("");
		tfCP.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 5;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tfCP, c);
		
		//ligne 5 : Equipe (JLabel + JComboList) + Ville (JLabel + JTextField)
		JLabel lbEquipe = new JLabel("Equipe");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbEquipe,c); 
		String [] EquipeExemple = {
				"Equipe 1",
				"Equipe 2",
				"Equipe 3",
				"..."
		};
		JComboBox<String> jc = new JComboBox<String>(EquipeExemple);
		jc.setEditable(true);
		jc.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(jc, c);
		btAjouterEquipe = new JButton("+");
		c.gridx = 2;
		c.gridy = 6;
		panneauPrincipal.add(btAjouterEquipe,c);
		
		lbCP = new JLabel("Ville");
		c.gridx = 4;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbCP.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbCP,c); 
		tfCP = new JTextField("");
		tfCP.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tfCP, c);
		
		//ligne 8 : bouton "Equipe" + tableau Prét Matériel
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
		lb = new JLabel("Prét de matériel");
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


	public int getIdBenevole() {
		return IdBenevole;
	}

	public String getTfNom() {
		return tfNom.getText();
	}

	public String getTfPrenom() {
		return tfPrenom.getText();
	}

	public boolean getEstResponsableEquipe() {
		return this.cbEstResponsableEquipe.isSelected();
	}

	public boolean getEstResponsableTache() {
		return this.cbEstResponsableEquipe.isSelected();
	}
	
}
