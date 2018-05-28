package Kanban;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class Fenetre_Kanban extends JFrame{
	public Fenetre_Kanban() {
		VueCarte carte1 = new VueCarte("acheterPain1");
		VueCarte carte2 = new VueCarte("acheterPain2");
		VueCarte carte3 = new VueCarte("acheterPain3");

		
		List<VueCarte> tachesRecurrentes = new LinkedList<VueCarte>(); 
		tachesRecurrentes.add(carte1);
		tachesRecurrentes.add(carte2);
		tachesRecurrentes.add(carte3);
		
		VueGridKanban vue = new VueGridKanban(tachesRecurrentes);
		
		vue.deAfaireVersEnCours(carte1);
		vue.supprimerCarteAFaire(carte3);
		
		this.add(vue);
		this.setTitle("TABLEAU KANBAN");
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(1160, 650);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

