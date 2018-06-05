package rocher;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class FenetreAccueil extends JFrame{
	
	public FenetreAccueil () {
		this.setTitle("Orgathlon");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(300,300));
		//this.setLayout(new BorderLayout());
		ListeGenerique v= new ListeGenerique(ControlleurGeneriqueTableaux.EtatsVuesListe.BENEVOLE);
		//VueTableau v= new VueTableau();
		this.setLayout(new BorderLayout());
		this.add(v,BorderLayout.CENTER);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
