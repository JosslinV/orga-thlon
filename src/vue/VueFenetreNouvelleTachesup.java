package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VueFenetreNouvelleTachesup  extends JFrame  {
		public VueFenetreNouvelleTachesup() throws Exception {
			this.setTitle("cr�ation d'une nouvelle fiche TACHE");
			this.setLayout(new GridLayout(1,1));
			this.add(new Vue_nouvelleTache());

			this.pack();
			this.setSize(800, 600);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);	
		}

	}

