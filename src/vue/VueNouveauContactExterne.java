package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class VueNouveauContactExterne extends JPanel {
		
	private JTextField tfSociete;
	private JTextField tfTelephone;
	private JTextField tfNom;
	private JTextField tfMail;
	private JTextField tfPrenom;
	private JTextField tfAdresse1;
	private JTextField tfAdresse2;
	private JTextField tfAdresse3;
	private JTextField tfVille;
	private JTextField tfCP;

	public VueNouveauContactExterne() {
		
		this.setLayout(new BorderLayout(20,20));
		
		//p1 
		JPanel p1 = new JPanel();
		this.add(p1);
		p1.setLayout(new GridBagLayout());
		p1.setBorder(new EmptyBorder(20,0,0,0));
		GridBagConstraints c = new GridBagConstraints();
		//ligne 0 : Société  (Jlabel + JTextField) + Titre (JLabel + JComBox)
		JLabel lbSociete = new JLabel("Société");
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbSociete,c); 
		
		tfSociete = new JTextField("");
		tfSociete.setPreferredSize(new Dimension(250,25));
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(tfSociete, c);

		JLabel lbTitre = new JLabel("Titre");
		lbTitre.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbTitre, c);

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
		p1.add(titreEx, c);
		
		//ligne 1 : Téléphone  (Jlabel + JTextField) + Nom (JLabel + JTextField)
		JLabel lbTel = new JLabel("Téléphone   ");
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbTel,c); 
		
		tfTelephone = new JTextField("");
		tfTelephone.setPreferredSize(new Dimension(120,25));
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		
		p1.add(tfTelephone, c);
		
		JLabel lbNom = new JLabel("Nom");
		lbNom.setBorder(new EmptyBorder(0,40,0,0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbNom,c); 
		
		tfNom = new JTextField("");
		tfNom.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(tfNom, c);
		
		//ligne 2 : Email  (Jlabel + JTextField) + Prénom (JLabel + JTextField)
		JLabel lbMail = new JLabel("E-mail");
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbMail,c); 
		
		tfMail = new JTextField("");
		tfMail.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(tfMail, c);
		
		JLabel lbPrenom = new JLabel("Prénom");
		lbPrenom.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(lbPrenom,c); 
		
		tfPrenom = new JTextField("");
		tfPrenom.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(tfPrenom, c);	
		



		//ligne 3 : Adresse  (Jlabel + JTextField) + Description (JLabel + JTextField)
		JLabel lbAdresse = new JLabel("Adresse");
		lbAdresse.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		p1.add(lbAdresse,c); 
		
		JPanel pAdresse = new JPanel();
		pAdresse.setLayout(new GridLayout(3,1));
		pAdresse.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		p1.add(pAdresse, c);
		//paragraphe 1 
		tfAdresse1 = new JTextField("");
		tfAdresse1.setPreferredSize(new Dimension(235,25));
		pAdresse.add(tfAdresse1);
		//paragraphe 2 
		tfAdresse2 = new JTextField("");
		tfAdresse2.setPreferredSize(new Dimension(235,25));
		pAdresse.add(tfAdresse2);
		//paragraphe 3 
		tfAdresse3 = new JTextField("");
		tfAdresse3.setPreferredSize(new Dimension(235,25));
		pAdresse.add(tfAdresse3);
		
		JLabel lbNotes = new JLabel("Notes");
		lbNotes.setBorder(new EmptyBorder(20,40,0,0));
		c.gridx = 2;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		p1.add(lbNotes,c); 
		
		//p = new JPanel();
		//p.setLayout(new GridLayout(1,1));
		//p.setBorder(new EmptyBorder(20,0,0,0));
		JScrollPane textSPNotes = new JScrollPane(new JTextArea(7,5));
		textSPNotes.setPreferredSize(new Dimension(167,170));
		//p.add(textSP);
		c.gridheight = 5;
		c.gridx = 3;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		p1.add(textSPNotes,c);	
		
		//nom Ville (ligne 6)
		JLabel lbVille = new JLabel("Ville");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		p1.add(lbVille,c); 
		tfVille = new JTextField("");
		tfVille.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		p1.add(tfVille, c);
		//Code Postal (ligne 7)
		JLabel lbCP = new JLabel("Code Postal");
		c.gridx = 0;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		p1.add(lbCP,c); 
		tfCP = new JTextField("");
		tfCP.setPreferredSize(new Dimension(50,25));
		c.gridx = 1;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		p1.add(tfCP, c);
		
		//p2 : SUD
		JPanel p2 = new JPanel();
		this.add(p2, BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(1,2,150,0));
		p2.setBorder(new EmptyBorder(0,80,30,80));
		JButton btAnnuler = new JButton("Annuler");
		btAnnuler.setPreferredSize(new Dimension(40,40));
		p2.add(btAnnuler);
		JButton btValider = new JButton("Valider");
		btValider.setPreferredSize(new Dimension(40,40));
		p2.add(btValider);
		
		
	}
	/**
	public String formatTelephone (String tel) {
		if (tel.length() == 10) 
			return ""+tel.codePointAt(1)+tel.codePointAt(2)+" "
				  +tel.codePointAt(3)+tel.codePointAt(4)+" "
				  +tel.codePointAt(5)+tel.codePointAt(6)+" "
				  +tel.codePointAt(7)+tel.codePointAt(8)+" "
				  +tel.codePointAt(9)+tel.codePointAt(10)+" ";
		return "format invalide";
		
	}
	*/

}
