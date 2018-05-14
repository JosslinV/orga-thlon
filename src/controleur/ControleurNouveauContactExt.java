package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Database.InputDataBase.InputContact;
import Database.InputDataBase.InputMateriel;
import Database.RequestDataBase.RequestContactExt;
import modele.Materiel;
import modele.contacts.ContactExterne;
import vue.VueNouveauContactExterne;

public class ControleurNouveauContactExt implements ActionListener{

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouveauContactExterne vue;
	private ContactExterne modele;
	
	public ControleurNouveauContactExt(VueNouveauContactExterne vue) {
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
					ContactExterne contact = vue.rassemblerDonnees();
					InputContact inp = new InputContact();
					inp.inputContact(contact);
				} catch(NullPointerException np) {
					np.printStackTrace();
					System.out.println("La classe n'a pu être créer (Libellé manquant?)");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
			if(button.getText() == "Annuler") {
				RequestContactExt requestContactExt = new RequestContactExt();
				try {
					vue.afficherDonnees(requestContactExt.requestContactExt(7));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.etatCourant = Etats.CONSULTATION;
			}
			break;
		case CONSULTATION:
			System.out.println("ok");
			vue.rendreIndisponible();
			break;
		}
		
	}

}
