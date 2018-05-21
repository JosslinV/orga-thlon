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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouveauBenevole;
import modele.contacts.Benevole;
import modele.contacts.ContactExterne;

public class VueNouveauContactBenevole extends JPanel{
	private int IdBenevole;
	private JFrame fen;


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
	private JButton bpEquipe;
	private JTextArea taNote;
	private JTextField tfVille;


	public VueNouveauContactBenevole() {
		
		this.fen = new JFrame();
		this.fen.setTitle(": " + "création d'une nouvelle fiche BENEVOLE");
		this.fen.setLayout(new GridLayout(1,1));

		
		ControleurNouveauBenevole contr = new ControleurNouveauBenevole(this);
		
		this.setLayout(new BorderLayout());
		JPanel panneauPrincipal = new JPanel();
		this.add(panneauPrincipal, BorderLayout.NORTH);
		panneauPrincipal.setLayout(new GridBagLayout());
		panneauPrincipal.setBorder(new EmptyBorder(0,0,0,0));
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
		
		tfCP = new JTextField();
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
		
		this.tfVille = new JTextField();
		this.tfVille.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tfVille, c);
		
		//ligne 8 : bouton "Equipe" + tableau Prét Matériel
		this.bpEquipe = new JButton();
		c.gridx = 1;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,115);
		c.ipady = 40;
		panneauPrincipal.add(bpEquipe,c);
		
		JLabel lbNote = new JLabel("Note");
		c.gridx = 4;
		c.gridy = 8;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbNote.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbNote,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		this.taNote = new JTextArea(10,5);
		JScrollPane textSP = new JScrollPane(this.taNote);
		textSP.setPreferredSize(new Dimension(250,125));
		p.add(textSP);
		c.gridheight = 5;
		c.gridx = 5;
		c.gridy = 8;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(p,c);

		//p : SUD
		JPanel ps = new JPanel();
		this.add(ps, BorderLayout.SOUTH);
		ps.setLayout(new GridLayout(1,2,150,0));
		ps.setBorder(new EmptyBorder(0,80,30,80));
		
		JButton bpAnnuler = new JButton("Annuler");
		bpAnnuler.setPreferredSize(new Dimension(40,40));
		ps.add(bpAnnuler);
		bpAnnuler.addActionListener(contr);
		
		JButton bpValider = new JButton("Valider");
		bpValider.setPreferredSize(new Dimension(40,40));
		ps.add(bpValider);
		bpValider.addActionListener(contr);
		
		//génération de la fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(900, 550);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
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
	
	public JFrame getFen() {
		return fen;
	}

	public void rendreDisponible() {
		this.tfNom.setEnabled(true);
		this.tfTelephone.setEnabled(true);
		this.tfPrenom.setEnabled(true);
		this.tfMail.setEnabled(true);
		this.tfRole.setEnabled(true);
		this.tfAdresse1.setEnabled(true);
		this.tfAdresse2.setEnabled(true);
		this.tfCP.setEnabled(true);
		this.tfVille.setEnabled(true);
		this.taNote.setEnabled(true);
		this.cbEstResponsableEquipe.setEnabled(true);
		this.btAjouterEquipe.setEnabled(true);
		this.bpEquipe.setEnabled(true);
	}


	public void rendreIndisponible() {
		this.tfNom.setEnabled(false);
		this.tfTelephone.setEnabled(false);
		this.tfPrenom.setEnabled(false);
		this.tfMail.setEnabled(false);
		this.tfRole.setEnabled(false);
		this.tfAdresse1.setEnabled(false);
		this.tfAdresse2.setEnabled(false);
		this.tfCP.setEnabled(false);
		this.tfVille.setEnabled(false);
		this.taNote.setEnabled(false);
		this.cbEstResponsableEquipe.setEnabled(false);
		this.btAjouterEquipe.setEnabled(false);
		this.bpEquipe.setEnabled(false);
	}


	public Benevole rassemblerDonnees() {
		if(!this.tfNom.getText().isEmpty()) {
			Benevole benevole = new Benevole(this.tfNom.getText());
			benevole.setPrenom_c(this.tfPrenom.getText());
			benevole.setAdresse(this.tfAdresse1.getText());
			benevole.setCp_c(this.tfCP.getText());
			benevole.setVille_c(this.tfVille.getText());
			benevole.setTelephone_c(this.tfTelephone.getText());
			benevole.setMail_c(this.tfMail.getText());
			benevole.setCommentaire(this.taNote.getText());
			return benevole;
			
		}else {
			if(this.tfNom.getText().isEmpty())
				this.tfNom.setBackground(Color.red);
		}
		return null;
	}
	
	public void afficherDonnees(Benevole modele) {
		this.tfNom.setText(modele.getNom_c());
		this.tfPrenom.setText(modele.getPrenom_c());
		this.tfAdresse1.setText(modele.getAdresse());
		this.tfCP.setText(modele.getCp_c());
		this.tfVille.setText(modele.getVille_c());
		this.tfTelephone.setText(modele.getTelephone_c());
		this.tfMail.setText(modele.getMail_c());
		this.taNote.setText(modele.getCommentaire());
	}
}
