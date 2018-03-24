package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauBenevole extends JFrame{
	public FenetreNouveauBenevole() {
		this.setTitle("création d'une nouvelle fiche BENEVOLE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouveauContactBenevole());
		
		
		this.pack();
		this.setSize(750, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
