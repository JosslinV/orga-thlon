package Kanban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VueGridKanban extends JPanel {
	public VueGridKanban(){
		this.setLayout(new BorderLayout());
		JPanel ptitres = new JPanel();
		ptitres.setLayout(new GridLayout(1,4));
		ptitres.add(new JLabel("A FAIRE", JLabel.CENTER));
		ptitres.add(new JLabel("EN COURS", JLabel.CENTER));
		ptitres.add(new JLabel("TERMINE", JLabel.CENTER));
		ptitres.add(new JLabel("EN ATTENTE", JLabel.CENTER));




		JPanel pCartes = new JPanel();
		pCartes.setLayout(new GridLayout(1,4));
		this.add(ptitres, BorderLayout.NORTH);
		this.add(pCartes);
		
		
		JPanel pAfaire = new JPanel();
		pAfaire.setBackground(Color.white);
		pAfaire.setBorder(new EmptyBorder(20,20,20,20));
		VueCarte carteAFaire =new VueCarte("");
		pAfaire.add(carteAFaire);		
		pCartes.add(pAfaire);
		
		JPanel pEnCours = new JPanel();
		pEnCours.setBackground(Color.LIGHT_GRAY);
		pEnCours.setBorder(new EmptyBorder(20,20,20,20));
		VueCarte carteEnCours =new VueCarte("");
		pEnCours.add(carteEnCours);			
		pCartes.add(pEnCours);
		
		JPanel pTermine = new JPanel();
		pTermine.setBackground(Color.gray);
		pTermine.setBorder(new EmptyBorder(20,20,20,20));
		VueCarte carteTermine =new VueCarte("");
		pTermine.add(carteTermine);	
		pCartes.add(pTermine);
		
		JPanel pEnAttente = new JPanel();
		pEnAttente.setBackground(Color.LIGHT_GRAY);
		pEnAttente.setBorder(new EmptyBorder(20,20,20,20));
		VueCarte carteEnAttente =new VueCarte("");
		pEnAttente.add(carteEnAttente);	
		pCartes.add(pEnAttente);

		
		
		
		
		/*
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(20,20,20,20));
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		//c.weightx = 25;

		
		c.gridx = 0;
		c.gridy = 0;	
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(new JLabel("A FAIRE"),c);
		c.gridx = 0;
		c.gridy = 1;
		Carte carteAFaire =new Carte("");
		carteAFaire.setVisible(true);
		this.add(carteAFaire,c);
			
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(new JLabel("EN COURS"),c);
		c.gridx = 1;
		c.gridy = 1;
		Carte carteEnCours =new Carte("");
		carteEnCours.setVisible(true);
		this.add(carteEnCours,c);
			
		c.gridx = 2;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(new JLabel("TERMINE"),c);
		c.gridx = 2;
		c.gridy = 1;
		Carte carteTermine =new Carte("");
		carteTermine.setVisible(true);
		this.add(carteTermine,c);
		
		
		
		c.gridx = 3;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(new JLabel("EN ATTENTE"),c);
		c.gridx = 3;
		c.gridy = 1;
		Carte carteEnAttente =new Carte("");
		carteEnAttente.setVisible(false);
		this.add(carteEnAttente,c);
		*/
		
	}

}
