package Kanban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
			switch (this.etatCarte) {
			case AFAIRE:
				if (b this.vue.getActionBouton(b);)
				
				break;
			case EN_COURS:
				
				break;
				
			case EN_ATTENTE:
				
				break;
			case TERMINE:
				
				break;
			case SUPPRIME:
				
				break;
				
			default:
			
			}
	}
				

	

	
	
}
