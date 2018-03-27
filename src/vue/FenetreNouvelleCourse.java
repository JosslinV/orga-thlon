package vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouvelleCourse extends JFrame {
	
	public FenetreNouvelleCourse() {
		this.setTitle("création d'une nouvelle fiche COURSE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouvelleCourse());
		
		this.pack();
		this.setSize(700, 550);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
		
	

}
