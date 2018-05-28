package Kanban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

public class ControleurKanban implements ActionListener {
	
	private Etat etat;
	private VueGridKanban vue;
	private ModelKanban modele;
	private List<VueCarte> tachesRecurrentes;
	
	public ControleurKanban( VueGridKanban vueGenerale, VueCarte vueCarte) {
		this.vue = vue;
		this.modele = new ModelKanban();
		this.etat = Etat.A_FAIRE;		
	}

	@Override  
	public void actionPerformed(ActionEvent e) {
		VueCarte carte = new VueCarte("bla1");

		JButton b =(JButton) e.getSource();
		switch(this.etat) {
		case A_FAIRE:
			carte.afficherTacheRecurrente(false);
			if (b.getText().equals(">>")) {
				this.vue.afficherNouvelEtatCarte(carte, Etat.A_FAIRE, Etat.EN_COURS);
				this.etat = Etat.EN_COURS;
			}else if (b.getIcon().toString() == "supprimer") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.A_FAIRE, Etat.SUPPRIME);
				this.etat = Etat.SUPPRIME;
			}
			break;
		case EN_COURS:
			carte.afficherEtatBoutonsCarte(carte, Etat.EN_COURS);
			if(b.getText().equals(">>")) {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_COURS, Etat.TERMINEE);
				this.etat = Etat.TERMINEE;
			}else if(b.getText().equals("<<")) {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_COURS, Etat.A_FAIRE);
				this.etat = Etat.A_FAIRE;
			}else if (b.getIcon().toString() == "supprimer") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_COURS, Etat.SUPPRIME);
				this.etat = Etat.SUPPRIME;
			}else if (b.getIcon().toString() == "editer") {
				//vue NouvelleTache apparait mode Edition
			}else if(b.getIcon().toString() == "suspendre") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_COURS, Etat.EN_ATTENTE);
				this.etat = Etat.EN_ATTENTE;
			}
			break;
		case EN_ATTENTE:
			carte.afficherEtatBoutonsCarte(carte, Etat.EN_ATTENTE);
			if (b.getIcon().toString() == "suspendre") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_ATTENTE, Etat.EN_COURS);
				this.etat = Etat.EN_COURS;
			}else if (b.getIcon().toString() == "supprimer") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.EN_ATTENTE, Etat.SUPPRIME);
				this.etat = Etat.SUPPRIME;
			}
			break;
		case TERMINEE:
			carte.afficherEtatBoutonsCarte(carte, Etat.TERMINEE);
			if (b.getIcon().toString() == "supprimer") {
				this.vue.afficherNouvelEtatCarte(carte, Etat.TERMINEE, Etat.SUPPRIME);
				this.etat = Etat.SUPPRIME;
			}
			break;
		case SUPPRIME:
			carte.afficherEtatBoutonsCarte(carte, Etat.SUPPRIME);
			break;
		default: 
		}
	}
	

}
