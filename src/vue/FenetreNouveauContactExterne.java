package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauContactExterne extends JFrame{
	public FenetreNouveauContactExterne() {
		this.setTitle("création d'une nouvelle fiche CONTACT EXTERNE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouveauContactExterne());
		
		
		this.pack();
		this.setSize(750, 360);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
