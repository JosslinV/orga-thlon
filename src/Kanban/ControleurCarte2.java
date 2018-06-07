package Kanban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Tache;

class ControleurCarte2 implements ActionListener{
		
		public EtatCartes etat;
		private VueCarte vueCarte;
		private ModeleKanban modele;
		//private Tache tache;
		//private Date dateDebut;
		//private int nbMoisRestant;

		public ControleurCarte2(VueCarte vue) {
			this.vueCarte = vue;
			this.modele = vue.getModele();
			this.etat = EtatCartes.A_FAIRE;
			//this.modele = getModele();
			
			//this.nbMoisRestant = this.dateDebut - datesystem
			//this.nbMoisRestant = 12; //exemple pour tester
			
		}

		@Override  
		public void actionPerformed(ActionEvent e) {
			JButton b =(JButton) e.getSource();
			switch(this.etat) {
			
			
			case A_FAIRE:
				ModeleKanban modeleTest = this.modele ;
				ModeleKanban test = vueCarte.getModele().getModeleTest();
			//	VueCarte vuetest = this.vueCarte ;
				//EtatCartes etattest = EtatCartes.A_FAIRE ;
				//System.out.println("VueCarte : etat A_FAIRE");
				vueCarte.afficherTacheRecurrente(false);
				if (b.getText().equals(">>")) {
					System.out.println("Passage � l'�tat enCours");
					vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_COURS);
					vueCarte.getModele().afficherNouvelEtatCarte(this.vueCarte, EtatCartes.A_FAIRE, EtatCartes.EN_COURS);
					//vueCarte.getModele().getKanban().removeAll();
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.EN_COURS;
				}else if (b.getIcon().toString() == "supprimer") {
					this.modele.afficherNouvelEtatCarte(vueCarte, EtatCartes.A_FAIRE, EtatCartes.SUPPRIME);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.SUPPRIME;
				}
				
				break;
				
				
			case EN_COURS:
				//System.out.println("VueCarte : etat EN_COURS");
				vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_COURS);
				if(b.getText().equals(">>")) {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.TERMINEE);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.TERMINEE;
				}else if(b.getText().equals("<<")) {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.A_FAIRE);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.A_FAIRE;
				}else if (b.getIcon().toString() == "supprimer") {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.SUPPRIME);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.SUPPRIME;
				}else if (b.getIcon().toString() == "editer") {
					//vue NouvelleTache apparait mode Edition
				}else if(b.getIcon().toString() == "suspendre") {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.EN_ATTENTE);
					vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_ATTENTE);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.EN_ATTENTE;
				}
				break;
				
				
				
			case EN_ATTENTE:
				//System.out.println("VueCarte : etat EN_ATTENTE");
				if (b.getIcon().toString() == "suspendre") {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_ATTENTE, EtatCartes.EN_COURS);
					vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_COURS);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.EN_COURS;
				}else if (b.getIcon().toString() == "supprimer") {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_ATTENTE, EtatCartes.SUPPRIME);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.SUPPRIME;
				}
				break;
				
				
				
				
			case TERMINEE:
				//System.out.println("VueCarte : etat TERMINEE");
				vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.TERMINEE);
				if (b.getIcon().toString() == "supprimer") {
					vueCarte.getModele().afficherNouvelEtatCarte(vueCarte, EtatCartes.TERMINEE, EtatCartes.SUPPRIME);
					vueCarte.getModele().relancerFenetre();
					this.etat = EtatCartes.SUPPRIME;
				}
				break;
			case SUPPRIME:
				//System.out.println("VueCarte : etat SUPPRIME");
				
				break;
			default: 
				
			}
		}
	
}


		

		
		
