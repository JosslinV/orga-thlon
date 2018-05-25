package controleur;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vue.VueAccueil2;

public class ControleurGeneral implements ActionListener {
	
	private enum Etats {COURSE, CONTACT, MATERIEL, ACCUEIL};
	private Etats etatsCourant;
	private VueAccueil2 vue;
	
	public ControleurGeneral(VueAccueil2 vue) {
		this.etatsCourant = Etats.ACCUEIL;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bouton = (JButton) e.getSource();
		
		CardLayout cardLayout = vue.getCardLayout();
		JPanel panneauPrincipal = vue.getPanneauPrincipal();
		
		
		switch(etatsCourant) {
		case ACCUEIL:
			//Ajouter affichage vue accueil
			if(bouton.getIcon().toString() == "ImgCourse") {
				this.etatsCourant = Etats.COURSE;
			}
			
			if(bouton.getIcon().toString() == "ImgContacts") {
				this.etatsCourant = Etats.CONTACT;
			}
			
			if(bouton.getIcon().toString() == "ImgMateriel") {
				this.etatsCourant = Etats.MATERIEL;
			}
			break;
		case CONTACT:
			cardLayout.show(panneauPrincipal,"BenevolesOuContacts");
			if(bouton.getIcon().toString() == "ImgCourse") {
				this.etatsCourant = Etats.COURSE;
			}
			
			if(bouton.getIcon().toString() == "ImgMateriel") {
				this.etatsCourant = Etats.MATERIEL;
			}
			break;
		case MATERIEL:
			cardLayout.show(panneauPrincipal,"listeMateriel");
			if(bouton.getIcon().toString() == "ImgCourse") {
				this.etatsCourant = Etats.COURSE;
			}
			
			if(bouton.getIcon().toString() == "ImgContacts") {
				this.etatsCourant = Etats.CONTACT;
			}
			break;
		case COURSE:
			cardLayout.show(panneauPrincipal,"TableauKanban");
			if(bouton.getIcon().toString() == "ImgContacts") {
				this.etatsCourant = Etats.CONTACT;
			}
			
			if(bouton.getIcon().toString() == "ImgMateriel") {
				this.etatsCourant = Etats.MATERIEL;
			}
			break;
		}
		
	}

}
