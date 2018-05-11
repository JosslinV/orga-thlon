package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import vue.FenetreNouveauMateriel;
import vue.FenetreNouvelleCourse;

public class ControleurMateriel implements ActionListener {
	
	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private FenetreNouveauMateriel vue;
	private modele.Course modele;
	
	public ControleurMateriel(FenetreNouveauMateriel vue) {
		this.vue = vue;
		this.etatCourant = Etats.EDITION;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
