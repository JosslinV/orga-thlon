package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Database.InputDataBase.InputContact;
import Database.RequestDataBase.RequestBenevole;
import modele.contacts.Benevole;
import vue.FenetreNouveauBenevole;
import vue.VueNouveauContactBenevole;

public class ControleurNouveauBenevole implements ActionListener {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouveauContactBenevole vue;
	private FenetreNouveauBenevole fen;
	private Benevole modele;
	
	public ControleurNouveauBenevole(VueNouveauContactBenevole vue) {
		this.vue = vue;
		this.etatCourant = Etats.EDITION;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(etatCourant) {
		case EDITION:
			vue.rendreDisponible();
			if(button.getText() == "Valider") {
				try {
					Benevole benevole = vue.rassemblerDonnees();
					InputContact inp = new InputContact();
					inp.inputContact(benevole);
				} catch(NullPointerException np) {
					np.printStackTrace();
					System.out.println("La classe n'a pu être créer (Libellé manquant?)");
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
			
			if(button.getText() == "Annuler") {
				System.out.println("N'oublie pas de trouver comment on ferme une fenêtre ^^");
				RequestBenevole request = new RequestBenevole();
				try {
					this.vue.afficherDonnees((Benevole) request.requestBenevole(2));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			break;
		case CONSULTATION:
			vue.rendreIndisponible();
			break;
		}
	}

}
