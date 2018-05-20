package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouvelleSousTache extends JFrame{

	private static final long serialVersionUID = 1L;

	public FenetreNouvelleSousTache() {
		VueNouvelleSousTache vue = new VueNouvelleSousTache();
		this.setTitle(vue.getId_ssTache() +" : " + "création d'une nouvelle fiche SOUS-TACHE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouvelleSousTache());
		this.pack();
		this.setSize(775, 350);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
