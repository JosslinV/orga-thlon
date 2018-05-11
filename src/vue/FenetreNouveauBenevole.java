package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauBenevole extends JFrame{
	public FenetreNouveauBenevole() {
		VueNouveauContactBenevole vue = new VueNouveauContactBenevole(); //en paramÃ¨tre du constructeur?
		this.setTitle(vue.getIdBenevole() + ": " + "création d'une nouvelle fiche BENEVOLE");
		this.setLayout(new GridLayout(1,1));
		this.add(vue);
		this.pack();
		this.setSize(900, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
