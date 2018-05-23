package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Fenetre_NouvelleTache extends JFrame {
	public Fenetre_NouvelleTache() throws Exception {
		Vue_nouvelleTache vue = new Vue_nouvelleTache();
		this.setTitle( vue.getId_Tache() +" : " + "création d'une nouvelle fiche TACHE");
		this.add(vue);
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(1160, 650);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

