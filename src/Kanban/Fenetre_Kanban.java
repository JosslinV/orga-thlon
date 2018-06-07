package Kanban;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import Database.RequestDataBase.RequestTache;
import modele.Tache;

public class Fenetre_Kanban extends JFrame{
	Map<String, LinkedList<VueCarte>> cartes;
	public Fenetre_Kanban() {
		cartes = new HashMap<String, LinkedList<VueCarte>>();

		VueKanban kanban = null;
//		VueCarte carteAFaire1 = new VueCarte("acheterPain1", kanban);
//		VueCarte carteAFaire2 = new VueCarte("acheterPain2", kanban);
//		VueCarte carteAFaire3 = new VueCarte("acheterPain3", kanban);
//
//		VueCarte carteenCours1 = new VueCarte("achetePain1", kanban);
//		VueCarte carteenCours2 = new VueCarte("achetePain2", kanban);
//
//		VueCarte carteTerminee = new VueCarte("PainAcheté", kanban);
		LinkedList<VueCarte> A_FAIRE = new LinkedList<VueCarte>();
		LinkedList<VueCarte> EN_COURS = new LinkedList<VueCarte>();
		LinkedList<VueCarte> EN_ATTENTE = new LinkedList<VueCarte>();
		LinkedList<VueCarte> TERMINEE = new LinkedList<VueCarte>();
//		A_FAIRE.add(carteAFaire1);
//		A_FAIRE.add(carteAFaire2);
//		A_FAIRE.add(carteAFaire3);
//		EN_COURS.add(carteenCours1);
//		EN_COURS.add(carteenCours2);
//		TERMINEE.add(carteTerminee);
		
		RequestTache req = new RequestTache();
		
		ArrayList<Tache> list = new ArrayList<Tache>();
		try {
			list = req.requestAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Tache tac:list) {
			System.out.println(tac.getLibelle());
			/**************************************************************
			 * //VueCarte carte = new VueCarte(tac, kanban);
			 * A_FAIRE.add(carte);
			 * 
			 * 
			 * ************************************************************
			 */
			
		}
		
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
	public Map<String, LinkedList<VueCarte>> getCartes() {
		return cartes;
	}
}

