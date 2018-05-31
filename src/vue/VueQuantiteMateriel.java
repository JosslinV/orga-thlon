package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controleur.ControleurNouvelleCourse;
import controleur.ControleurVueQuantiteMateriel;
import modele.AffectationMateriel;

public class VueQuantiteMateriel extends JPanel {
	private JFrame fen;
	private JSpinner spQte;
	private JButton btValider;
	private JButton btAnnuler;
	private SpinnerModel spQtemod;
	private VueNouvelleListeMateriel vueMere;

	public VueQuantiteMateriel(AffectationMateriel am, VueNouvelleListeMateriel vqm) throws Exception {
		ControleurVueQuantiteMateriel controleur = new ControleurVueQuantiteMateriel(this, am);
		this.vueMere = vqm ;
		this.fen = new JFrame();
		this.fen.setTitle(" : " + "Quantité souhaitée");
		this.fen.setLayout(new GridLayout(1,1));	
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();	
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("Quelle quantité souhaitez-vous assigner ?"), c);
		
		c.gridx = 0;
		c.gridy = 1;
		
		
		this.spQtemod = new SpinnerNumberModel(1, 0, 50, 1);   
		this.spQte = new JSpinner(spQtemod);
		this.spQte.setPreferredSize(new Dimension(50,20));
		
		this.add(this.spQte, c);
				
		c.gridx = 0;
		c.gridy = 2;
		this.btValider = new JButton("valider");
		this.add(btValider,c);
		this.btValider.addActionListener(controleur);
		
		
		//génération fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(300, 200);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
	}

	public float getQuantite() {

			float a = ((Integer) this.spQte.getValue()).floatValue() ;
		
			return a ;
	}
	
	public JFrame getFen() {
		return this.fen;
	}
	
	public VueNouvelleListeMateriel getVueMere() {
		return this.vueMere;
	}
}
