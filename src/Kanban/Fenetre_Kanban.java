package Kanban;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Fenetre_Kanban extends JFrame{
	public Fenetre_Kanban() {
		Map<String, LinkedList<VueCarte>> cartes = new 	HashMap<String, LinkedList<VueCarte>>();

		VueKanban kanban = null;
		VueCarte carteAFaire1 = new VueCarte("acheterPain1", kanban);
		VueCarte carteAFaire2 = new VueCarte("acheterPain2", kanban);
		VueCarte carteAFaire3 = new VueCarte("acheterPain3", kanban);

		VueCarte carteenCours1 = new VueCarte("achetePain1", kanban);
		VueCarte carteenCours2 = new VueCarte("achetePain2", kanban);

		VueCarte carteTerminee = new VueCarte("PainAcheté", kanban);
		LinkedList<VueCarte> A_FAIRE = new LinkedList<VueCarte>();
		LinkedList<VueCarte> EN_COURS = new LinkedList<VueCarte>();
		LinkedList<VueCarte> EN_ATTENTE = new LinkedList<VueCarte>();
		LinkedList<VueCarte> TERMINEE = new LinkedList<VueCarte>();
		A_FAIRE.add(carteAFaire1);
		A_FAIRE.add(carteAFaire2);
		A_FAIRE.add(carteAFaire3);
		EN_COURS.add(carteenCours1);
		EN_COURS.add(carteenCours2);
		TERMINEE.add(carteTerminee);
		cartes.put("aFaire", A_FAIRE);
		cartes.put("enCours", EN_COURS);
		cartes.put("Terminees", EN_ATTENTE);
		cartes.put("enAttente", TERMINEE);
		kanban = new VueKanban(cartes);

		this.add(kanban);
		this.setTitle("TABLEAU KANBAN");
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(1160, 650);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

