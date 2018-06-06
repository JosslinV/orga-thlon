package controleur;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Database.RequestDataBase.RequestContactExt;
import Database.RequestDataBase.RequestMateriel;
import modele.Materiel;
import modele.contacts.ContactExterne;
import rocher.FenetreAccueil;
import vue.VueAccueil2;

public class ControleurGeneral implements ActionListener {
	
	private enum Etats {COURSE, CONTACT, MATERIEL, ACCUEIL};
	private Etats etatsCourant;
	private VueAccueil2 vue;
	private ArrayList<Object> aom ;
	
	public ControleurGeneral(VueAccueil2 vue) {
		this.etatsCourant = Etats.ACCUEIL;
		this.vue = vue;
		RequestMateriel reqMat = new RequestMateriel();
		ArrayList<Materiel> materiels;
		try {
			materiels = reqMat.requestAll();
			ArrayList<Object> aom = new ArrayList<Object>() ;
			for (Materiel mat : materiels) {
				aom.add(mat);
			}
		}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		}
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
			RequestMateriel reqMat = new RequestMateriel();
			ArrayList<Materiel> materiels;
			try {
				materiels = reqMat.requestAll();
				ArrayList<Object> aom = new ArrayList<Object>() ;
				for (Materiel mat : materiels) {
					aom.add(mat);
				}
		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
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
			break ;	
		} 
		
	}
	
	public ArrayList<Object> getAom() {
		return this.aom;
	}

}
