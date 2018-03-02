package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouveauMateriel extends JFrame{
	public FenetreNouveauMateriel() {
		this.setTitle("création d'une nouvelle fiche MATÉRIEL");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouveauMateriel());
		

		
		this.pack();
		this.setSize(400, 670);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
				
	}

}
