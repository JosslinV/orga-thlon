package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouvelleTache extends JFrame{
		public FenetreNouvelleTache() {
			this.setTitle("création d'une nouvelle fiche TACHE");
			this.setLayout(new GridLayout(1,1));
			this.add(new VueNouvelleTache());

			this.pack();
			this.setSize(800, 800);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);	
		}

	}

