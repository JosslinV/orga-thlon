package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauContactExterne extends JFrame{
	public FenetreNouveauContactExterne() {
		this.setTitle("cr�ation d'une nouvelle fiche CONTACT EXTERNE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouveauContactExterne());
		
		
		this.pack();
		this.setSize(750, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
