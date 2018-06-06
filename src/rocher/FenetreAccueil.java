package rocher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import modele.contacts.Benevole;

public class FenetreAccueil extends JFrame{
	
	public FenetreAccueil (ArrayList<Object> list) {
		this.setTitle("Orgathlon");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(300,300));
		//this.setLayout(new BorderLayout());
		//ArrayList<Object> list=new ArrayList<>();
		//list.add(new Benevole("luc","besson"));
		ListeGenerique v = new ListeGenerique(list);
		//VueTableau v= new VueTableau();
		this.setLayout(new BorderLayout());
		this.add(v,BorderLayout.CENTER);
		this.pack();
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
