package rocher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class FenetreAccueil extends JFrame{
	
	public FenetreAccueil (ArrayList<Object> list) {
		this.setTitle("Orgathlon");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(300,300));
		ListeGenerique v = new ListeGenerique(list);
		this.setLayout(new BorderLayout());
		this.add(v,BorderLayout.CENTER);
		this.pack();
	}

}
