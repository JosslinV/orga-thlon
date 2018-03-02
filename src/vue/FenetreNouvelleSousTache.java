package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouvelleSousTache extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreNouvelleSousTache() {
		this.setTitle("création d'une nouvelle fiche SOUS-TÂCHE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouvelleSousTache());
		
		this.pack();
		this.setSize(400, 300);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
