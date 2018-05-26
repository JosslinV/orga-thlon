package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modele.AffectationMateriel;
import vue.VueNouvelleListeMateriel;

public class ControleurNouvelleListeMateriel implements ActionListener, DocumentListener{
	private enum Etats {MATERIEL_DISPO, MATERIEL_EMPRUNTE, MATERIEL_ASSIGNE, MATERIEL_RENDU};
	private Etats etat;
	private VueNouvelleListeMateriel vue;
	private AffectationMateriel modele;

	public ControleurNouvelleListeMateriel(VueNouvelleListeMateriel vueNouvelleListeMateriel) {
	        this.vue = vueNouvelleListeMateriel;
	        this.modele = new AffectationMateriel();
	        this.etat = Etats.MATERIEL_DISPO;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	    }
	


