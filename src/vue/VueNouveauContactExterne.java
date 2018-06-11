package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import controleur.ControleurFenetreContactExterne;
import controleur.ControleurNouveauContactExt;
import modele.Materiel;
import modele.contacts.ContactExterne;



public class VueNouveauContactExterne extends JPanel {
	
	private JFrame fen;
	private JPanel northPanel;
	private JPanel p;
	private JScrollPane textSP;
	private JPanel southPanel;
	private JTextField tfSociete;
	private JTextField tfTelephone;
	private JTextField tfNom;
	private JTextField tfEmail;
	private JTextField tfPrenom;
	private JTextField tfAdresse;
	private JTextField tfAdressecompl;
	private JTextArea taNote;
	private JTextField tfCp;
	private JTextField tfVille;
	private int idContactExt;

		
	public VueNouveauContactExterne() {
		
		this.fen = new JFrame();
		this.fen.setTitle("création d'une nouvelle fiche CONTACT EXTERNE");
		this.fen.setLayout(new GridLayout(1,1));

		//this.fen.addWindowListener(new ControleurFenetreContactExterne(this));
		
		ControleurNouveauContactExt contr = new ControleurNouveauContactExt(this);
		
		this.setLayout(new BorderLayout());
		
		//northPanel 
		northPanel = new JPanel();
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridBagLayout());
		northPanel.setBorder(new EmptyBorder(20,0,0,0));
		GridBagConstraints c = new GridBagConstraints();
		//ligne 0 : Société  (Jlabel + JTextField) + Titre (JLabel + JComBox)
		JLabel lbSociete = new JLabel("Société");
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbSociete,c); 
		
		this.tfSociete = new JTextField("");
		this.tfSociete.setPreferredSize(new Dimension(250,25));
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(this.tfSociete, c);

		JLabel lbTitre = new JLabel("Titre");
		lbTitre.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbTitre, c);

		String [] titreExemples = {
				"M",
				"Mme",
				"Melle"
				};
		JComboBox<String> titreEx = new JComboBox<String>(titreExemples);
		titreEx.setEditable(true);
		c.gridx = 3;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(titreEx, c);
		
		//ligne 1 : Téléphone  (Jlabel + JTextField) + Nom (JLabel + JTextField)
		JLabel lbTelephone = new JLabel("Téléphone   ");
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbTelephone,c); 
		
		this.tfTelephone = new JTextField();
		this.tfTelephone.setPreferredSize(new Dimension(120,25));
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		
		northPanel.add(this.tfTelephone, c);
		
		JLabel lbNom = new JLabel("Nom");
		lbNom.setBorder(new EmptyBorder(0,40,0,0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbNom,c); 
		
		this.tfNom = new JTextField();
		this.tfNom.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(this.tfNom, c);
		
		//ligne 2 : Email  (Jlabel + JTextField) + Prénom (JLabel + JTextField)
		JLabel lbEmail = new JLabel("E-mail");
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbEmail,c); 
		
		this.tfEmail = new JTextField();
		this.tfEmail.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(this.tfEmail, c);
		
		JLabel lbPrenom = new JLabel("Prénom    ");
		lbPrenom.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lbPrenom,c); 
		
		this.tfPrenom = new JTextField();
		this.tfPrenom.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(this.tfPrenom, c);	
		



		//ligne 3 : Adresse  (Jlabel + JTextField) + Description (JLabel + JTextField)
		JLabel lbAdresse = new JLabel("Adresse");
		lbAdresse.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lbAdresse,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(p, c);
		
		//Adresse
		this.tfAdresse = new JTextField();
		this.tfAdresse.setPreferredSize(new Dimension(235,25));
		p.add(this.tfAdresse);
		
		//Complement d'adresse 
		this.tfAdressecompl = new JTextField();
		this.tfAdressecompl.setPreferredSize(new Dimension(235,25));
		p.add(this.tfAdressecompl);

		
		JLabel lbNote = new JLabel("Notes");
		lbNote.setBorder(new EmptyBorder(20,40,0,0));
		c.gridx = 2;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lbNote,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		this.taNote = new JTextArea(7,5);
		textSP = new JScrollPane(this.taNote);
		textSP.setPreferredSize(new Dimension(167,125));
		p.add(textSP);
		c.gridheight = 5;
		c.gridx = 3;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(p,c);	
		
		//nom Ville (ligne 6)
		JLabel lbVille = new JLabel("Ville");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lbVille,c); 
		
		this.tfVille = new JTextField();
		this.tfVille.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(this.tfVille, c);
		
		//Code Postal (ligne 7)
		JLabel lbCp = new JLabel("Code Postal    ");
		c.gridx = 0;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		northPanel.add(lbCp,c);
		
		this.tfCp = new JTextField();
		this.tfCp.setPreferredSize(new Dimension(50,25));
		c.gridx = 1;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		northPanel.add(this.tfCp, c);

		//southPanel : SUD
		southPanel = new JPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1,2,150,0));
		southPanel.setBorder(new EmptyBorder(0,80,30,80));
		
		JButton bpAnnuler = new JButton("Annuler");
		bpAnnuler.setPreferredSize(new Dimension(40,40));
		southPanel.add(bpAnnuler);
		bpAnnuler.addActionListener(contr);
		
		JButton bpValider = new JButton("Valider");
		bpValider.setPreferredSize(new Dimension(40,40));
		southPanel.add(bpValider);
		bpValider.addActionListener(contr);
		
		//génération de la fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(750, 360);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
	}
	
	public void rendreDisponible(boolean active) {
		this.tfSociete.setEditable(active);
		this.tfNom.setEditable(active);
		this.tfPrenom.setEditable(active);
		this.tfAdresse.setEditable(active);
		this.tfCp.setEditable(active);
		this.tfVille.setEditable(active);
		this.tfTelephone.setEditable(active);
		this.tfEmail.setEditable(active);
		this.taNote.setEditable(active);
	}
	
	public void afficherDonnees(int id, String nomSociete, String nom, String prenom, String adresse, String cp, String ville, String telephone, String mail, String commentaire) {
		this.idContactExt = id;
		this.tfSociete.setText(nomSociete);
		this.tfNom.setText(nom);
		this.tfPrenom.setText(prenom);
		this.tfAdresse.setText(adresse);
		this.tfCp.setText(cp);
		this.tfVille.setText(ville);
		this.tfTelephone.setText(telephone);
		this.tfEmail.setText(mail);
		this.taNote.setText(commentaire);
	}

	public Map<String,Object> rassemblerDonnees() {
		if(!this.tfNom.getText().isEmpty()) {
			HashMap<String,Object> donnees = new HashMap<String, Object>();
			donnees.put("id_Contact", this.idContactExt);
			donnees.put("nom_contact", this.tfNom.getText());
			donnees.put("nom_societe",this.tfSociete.getText());
			donnees.put("prenom_contact",this.tfPrenom.getText());
			donnees.put("adresse1_contact",this.tfAdresse.getText());
			donnees.put("code_Postal_contact",this.tfCp.getText());
			donnees.put("ville_contact",this.tfVille.getText());
			donnees.put("telephone_contact",this.tfTelephone.getText());
			donnees.put("mail_contact",this.tfEmail.getText());
			donnees.put("commentaire_contact",this.taNote.getText());
			
			return donnees;
		}else {
			System.out.println("Champs vide");
			if(this.tfNom.getText().isEmpty())
				this.tfNom.setBackground(Color.red);
			if(this.tfSociete.getText().isEmpty())
				this.tfSociete.setBackground(Color.red);
		}
		return null;
	}
	
	public JFrame getFen() {
		return fen;
	}

}
