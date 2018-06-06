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
import modele.Etat.AFaire;
import modele.Etat.EnCours;
import modele.Etat.Suspendu;
import modele.Etat.Termine;

public class ModeleKanban extends JFrame{
	private Map<String, LinkedList<VueCarte>> cartes;
	private LinkedList<VueCarte> A_FAIRE;
	private LinkedList<VueCarte> EN_COURS;
	private LinkedList<VueCarte> EN_ATTENTE;
	private LinkedList<VueCarte> TERMINEE;

	
	
	public ModeleKanban() {
		cartes = new HashMap<String, LinkedList<VueCarte>>();
		VueKanban kanban = null;

		this.A_FAIRE = new LinkedList<VueCarte>();
		this.EN_COURS = new LinkedList<VueCarte>();
		this.EN_ATTENTE = new LinkedList<VueCarte>();
		this.TERMINEE = new LinkedList<VueCarte>();

		
		RequestTache req = new RequestTache();
		
		ArrayList<Tache> list = new ArrayList<Tache>();
		try {
			list = req.requestAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Tache tache:list) {
			System.out.println(tache.getLibelle());
			if (!tache.isEnPause()) {
				if (tache.getEtat() instanceof AFaire) {	//si etat Tache = afaire (etat avancement = 0)
					VueCarte carteAFaire = new VueCarte(tache, kanban);
					A_FAIRE.add(carteAFaire);
				}
				if (tache.getEtat() instanceof EnCours) {   // etat Tache = enCours (etat avancement 0< <100)
					VueCarte carteEnCours = new VueCarte(tache,kanban);
					EN_COURS.add(carteEnCours);
				}
				if (tache.getEtat() instanceof Termine) {   //etat Tache = terminé (etat avancement =100)
					VueCarte carteTerminee = new VueCarte(tache,kanban);
					TERMINEE.add(carteTerminee);
				}
			else if (tache.getEtat() instanceof Suspendu) {
					VueCarte carteSuspendue = new VueCarte(tache,kanban);
					EN_ATTENTE.add(carteSuspendue);
			}
		}
		
		cartes.put("aFaire", A_FAIRE);
		cartes.put("enCours", EN_COURS);
		cartes.put("Terminee", EN_ATTENTE);
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
	
	public void afficherNouvelEtatCarte(VueCarte carte, EtatCartes ancienEtat, EtatCartes nouvelEtat) {
		switch(nouvelEtat) {
		case A_FAIRE:
			System.out.println("Modelekanban : etat A_FAIRE");
			if(ancienEtat.equals(EtatCartes.EN_COURS)) {
				this.cartes.get("enCours").remove(carte);
			}
			this.cartes.get("aFaire").add(carte);
			break;
		case EN_COURS:
			System.out.println("Vuekanban : etat EN_COURS");

			if (ancienEtat.equals(EtatCartes.EN_ATTENTE)) {
				this.cartes.get("enAttente").remove(carte);
			}
			if (ancienEtat.equals(EtatCartes.A_FAIRE)) {
				this.cartes.get("aFaire").remove(carte);
			}
			this.cartes.get("enCours").add(carte);
			break;
		case EN_ATTENTE:
			System.out.println("Vuekanban : etat EN_ATTENTE");
			this.cartes.get("enAttente").add(carte);
			this.cartes.get("enCours").remove(carte);
			break;
		case TERMINEE:
			System.out.println("Vuekanban : etat TERMINEE");

			this.cartes.get("enCours").remove(carte);
			this.cartes.get("Terminee").add(carte);
			break;
		case SUPPRIME:
			System.out.println("Vuekanban : etat SUPPRIME");

			if (ancienEtat.equals(EtatCartes.EN_COURS)) {
				this.cartes.get("enCours").remove(carte);
			}
			if (ancienEtat.equals(EtatCartes.A_FAIRE)) {
				this.cartes.get("aFaire").remove(carte);
			}
			if (ancienEtat.equals(EtatCartes.EN_ATTENTE)) {
				this.cartes.get("enAttente").remove(carte);
			}
			if (ancienEtat.equals(EtatCartes.TERMINEE)) {
				this.cartes.get("Terminee").remove(carte);
			}		
		}
	} 
	
	public Map<String, LinkedList<VueCarte>> getCartes() {
		return cartes;
	}
	
	
}

