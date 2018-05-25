package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

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
	private JFrame fen;
	
	public ControleurNouveauContactExt(VueNouveauContactExterne vue) {
		this.vue = vue;
		this.etatCourant = Etats.EDITION;
		this.fen = vue.getFen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(etatCourant) {
		case EDITION:
			vue.rendreDisponible(true);
			if(button.getText() == "Valider") {
				try {
					ContactExterne contact = this.extraireDonnees(vue.rassemblerDonnees());
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
				this.fen.dispose();
			}
			break;
		case CONSULTATION:
			System.out.println("ok");
			vue.rendreDisponible(false);
			break;
		}
		
	}
	
	public ContactExterne extraireDonnees(Map<String, Object> donnees) {
		ContactExterne contactExterne = new ContactExterne(null, null);
		contactExterne.setId_personne(Integer.parseInt(String.valueOf(donnees.get("id_Contact"))));
		contactExterne.setNom_c(String.valueOf(donnees.get("nom_contact")));
		contactExterne.setNomSociete(String.valueOf(donnees.get("nom_societe")));
		contactExterne.setPrenom_c(String.valueOf(donnees.get("prenom_contact")));
		contactExterne.setAdresse(String.valueOf(donnees.get("adresse1_contact")));
		contactExterne.setCp_c(String.valueOf(donnees.get("code_Postal_contact")));
		contactExterne.setVille_c(String.valueOf(donnees.get("ville_contact")));
		contactExterne.setTelephone_c(String.valueOf(donnees.get("telephone_contact")));
		contactExterne.setMail_c(String.valueOf(donnees.get("mail_contact")));
		contactExterne.setCommentaire(String.valueOf(donnees.get("commentaire_contact")));
		
		return contactExterne;
	}

}
