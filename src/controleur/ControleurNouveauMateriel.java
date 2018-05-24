package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Database.InputDataBase.InputMateriel;
import modele.Materiel;

import vue.VueNouveauMateriel;

public class ControleurNouveauMateriel implements ActionListener {
	
	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouveauMateriel vue;
	private Materiel modele;
	
	public ControleurNouveauMateriel(VueNouveauMateriel vue){
		this.vue = vue;
		this.etatCourant = Etats.EDITION;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(etatCourant) {
		case EDITION:
			vue.rendreDisponible(true);
			if(button.getText() == "Valider") {
				try {
					Materiel materiel = vue.rassemblerDonnees();
					InputMateriel inp = new InputMateriel();
					inp.inputMateriel(materiel);
				} catch(NullPointerException np) {
					np.printStackTrace();
					System.out.println("La classe n'a pu être créer (Libellé manquant?)");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
			if(button.getText() == "Annuler") {
				System.out.println("N'oublie pas de trouver comment on ferme une fenêtre ^^");
			}
			break;
		case CONSULTATION:
			vue.rendreDisponible(false);
			break;
		}
	}
	
	
}
