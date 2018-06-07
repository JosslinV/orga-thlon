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

	private VueKanban kanban;
	
	
	public ModeleKanban() {
		cartes = new HashMap<String, LinkedList<VueCarte>>();
		

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
		
		
		/*for(Tache tache:list) {
			System.out.println(tache.getLibelle());
		}
		*/
		
		
		for(Tache tache:list) {
			
			//System.out.println(tache.getLibelle());
			if (!tache.isEnPause()) {
				
				if (tache.getEtat() instanceof AFaire) {	//si etat Tache = afaire (etat avancement = 0)
					VueCarte carte = new VueCarte(tache, this);
					this.A_FAIRE.add(carte);
				}
				if (tache.getEtat() instanceof EnCours) {   // etat Tache = enCours (etat avancement 0< <100)
					VueCarte carte = new VueCarte(tache, this);
					this.EN_COURS.add(carte);
				}
				if (tache.getEtat() instanceof Termine) {   //etat Tache = terminé (etat avancement =100)
					VueCarte carte = new VueCarte(tache, this);
					this.TERMINEE.add(carte);
				}
			}
			else if (tache.getEtat() instanceof Suspendu) {
					VueCarte carte = new VueCarte(tache, this);
					this.EN_ATTENTE.add(carte);
			}
		}
		
		cartes.put("aFaire", A_FAIRE);
		cartes.put("enCours", EN_COURS);
		cartes.put("enAttente", EN_ATTENTE);
		cartes.put("Terminee", TERMINEE);
		
		kanban = new VueKanban(cartes, this);

		this.add(kanban);
		this.setTitle("TABLEAU KANBAN");
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(1160, 650);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
			
	}
	
	public void afficherNouvelEtatCarte(VueCarte carte, EtatCartes ancienEtat, EtatCartes nouvelEtat) {

		switch(nouvelEtat) {
		case A_FAIRE:
			
			this.cartes.get("aFaire").add(carte);
			System.out.println("Modelekanban : etat A_FAIRE");
			if(ancienEtat.equals(EtatCartes.EN_COURS)) {
				
				this.cartes.get("enCours").remove(carte);
			}
			
	
			
			break;
		case EN_COURS:
			System.out.println("Vuekanban : etat EN_COURS");
			this.cartes.get("enCours").add(carte);
			if (ancienEtat.equals(EtatCartes.EN_ATTENTE)) {
				
				this.cartes.get("enAttente").remove(carte);
			}
			if (ancienEtat.equals(EtatCartes.A_FAIRE)) {
				this.cartes.get("aFaire").remove(carte);
			}
			
			
	
			
			
			break;
		case EN_ATTENTE:
			System.out.println("Vuekanban : etat EN_ATTENTE");
			this.cartes.get("enAttente").add(carte);
			this.cartes.get("enCours").remove(carte);
		
			break;
		case TERMINEE:
			System.out.println("Vuekanban : etat TERMINEE");
			this.cartes.get("Terminee").add(carte);
			this.cartes.get("enCours").remove(carte);
		
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
		
			break;
		}
		
		
		
	} 
	
	public Map<String, LinkedList<VueCarte>> getCartes() {
		return cartes;
	}
	
	
	public ModeleKanban getModeleTest() {
		return this;
	}
	
	
	public VueKanban getKanban() {
		return this.kanban;
	}
	
	public void relancerFenetre() {
		
		this.remove(kanban);
		kanban = new VueKanban(cartes, this);

		
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

