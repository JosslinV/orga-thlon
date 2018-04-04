package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauContactExterne extends JFrame{
	public FenetreNouveauContactExterne() {
		this.setTitle("cr�ation d'une nouvelle fiche CONTACT EXTERNE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouveauContactExterne());
		
		
		this.pack();
		this.setSize(650, 380);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
