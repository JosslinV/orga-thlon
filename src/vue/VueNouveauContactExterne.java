package vue;
import java.awt.BorderLayout;
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
	
	private JPanel northPanel;
	private JPanel p;
	private JLabel lb;
	private JTextField tf;
	private JScrollPane textSP;
	private String telephone;
	private JButton b;
	private JPanel southPanel;

		
	public VueNouveauContactExterne() {
		
		this.setLayout(new BorderLayout());
		
		//northPanel 
		northPanel = new JPanel();
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridBagLayout());
		northPanel.setBorder(new EmptyBorder(20,0,0,0));
		GridBagConstraints c = new GridBagConstraints();
		//ligne 0 : Société  (Jlabel + JTextField) + Titre (JLabel + JComBox)
		lb = new JLabel("Société");
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(250,25));
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(tf, c);

		lb = new JLabel("Titre");
		lb.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb, c);

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
		lb = new JLabel("Téléphone   ");
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(120,25));
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		
		northPanel.add(tf, c);
		
		lb = new JLabel("Nom");
		lb.setBorder(new EmptyBorder(0,40,0,0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(tf, c);
		
		//ligne 2 : Email  (Jlabel + JTextField) + Prénom (JLabel + JTextField)
		lb = new JLabel("E-mail");
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(tf, c);
		
		lb = new JLabel("Prénom");
		lb.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(lb,c); 
		
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(170,25));
		c.gridx = 3;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(tf, c);	
		



		//ligne 3 : Adresse  (Jlabel + JTextField) + Description (JLabel + JTextField)
		lb = new JLabel("Adresse");
		lb.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lb,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(p, c);
		//paragraphe 1 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		p.add(tf);
		//paragraphe 2 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		p.add(tf);
		//paragraphe 3 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		p.add(tf);
		
		lb = new JLabel("Notes");
		lb.setBorder(new EmptyBorder(20,40,0,0));
		c.gridx = 2;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lb,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		textSP = new JScrollPane(new JTextArea(7,5));
		textSP.setPreferredSize(new Dimension(167,125));
		p.add(textSP);
		c.gridheight = 5;
		c.gridx = 3;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		northPanel.add(p,c);	
		
		//nom Ville (ligne 6)
		lb = new JLabel("Ville");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(lb,c); 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(235,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		northPanel.add(tf, c);
		//Code Postal (ligne 7)
		lb = new JLabel("Code Postal");
		c.gridx = 0;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		northPanel.add(lb,c); 
		tf = new JTextField("");
		tf.setPreferredSize(new Dimension(50,25));
		c.gridx = 1;
		c.gridy = 7;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		northPanel.add(tf, c);

		//southPanel : SUD
		southPanel = new JPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1,2,150,0));
		southPanel.setBorder(new EmptyBorder(0,80,30,80));
		b = new JButton("Annuler");
		b.setPreferredSize(new Dimension(40,40));
		southPanel.add(b);
		b = new JButton("Valider");
		b.setPreferredSize(new Dimension(40,40));
		southPanel.add(b);

		
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
