package Kanban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modele.Tache;
import modele.Etat.AFaire;
import modele.Etat.Etat;

//ref machine à Etats p.30 du dossier de Conception

public class ControleurCarte implements ActionListener{
	
	private enum Etats {AFAIRE, EN_COURS, TERMINE, EN_ATTENTE, SUPPRIME};
	public Etats etatCarte;
	private VueCarte vue;
	private Etat modele;
	private Tache tache;
	private Date dateDebut;
	private int nbMoisRestant;

	public ControleurCarte(VueCarte vue) {
		this.vue = vue;
		this.modele = new AFaire(tache);
		this.etatCarte = Etats.AFAIRE;
		//this.nbMoisRestant = this.dateDebut - datesystem
		this.nbMoisRestant = 12; //exemple pour tester	
		if (tache.isPredefinie()) {
			this.vue.afficherBoutonProloop(true);
		}
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
			switch (this.etatCarte) {
			case AFAIRE:
				
				if (b.getIcon().toString() == "supprimer") {
					this.etatCarte = Etats.SUPPRIME;
				}else if( || b.getIcon().toString() == "proloop") { ///drag and drop vers colonne en cours
					this.etatCarte = Etats.EN_COURS;
				}
					
				break;
			case EN_COURS:
				if (b.getIcon().toString() == "pause") {
					this.etatCarte = Etats.EN_ATTENTE;
				}else if( ) { ///drag and drop vers colonne terminé
					this.etatCarte = Etats.TERMINE;
				}else if (b.getIcon().toString() == "supprimer" ) {
					this.etatCarte = Etats.SUPPRIME;
				}
				break;
				
			case EN_ATTENTE:
				if ( b.getIcon().toString() == "pause" ) {///b == icon pause
					//icone pause devient icone lecture 
					this.etatCarte = Etats.EN_COURS;
				} else if (b.getIcon().toString() == "supprimer"){
					this.etatCarte = Etats.SUPPRIME;
				}
				break;
			case TERMINE:
				if (b.getIcon().toString() == "supprimer") {
					this.etatCarte = Etats.SUPPRIME;
				}
				
				break;
			case SUPPRIME:
				
				
				break;
				
			default:
			
			}
	}
}

	
	
}
