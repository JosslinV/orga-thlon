package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import Database.InputDataBase.InputContact;
import Database.RequestDataBase.RequestBenevole;
import modele.contacts.Benevole;
import modele.contacts.ContactExterne;
import vue.VueNouveauContactBenevole;

public class ControleurNouveauBenevole implements ActionListener {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouveauContactBenevole vue;
	private Benevole modele;
	private JFrame fen;
	
	public ControleurNouveauBenevole(VueNouveauContactBenevole vue) {
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
					Benevole benevole = this.extraireDonnees(vue.rassemblerDonnees());
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
				this.fen.dispose();
			}
			break;
		case CONSULTATION:
			vue.rendreDisponible(false);
			break;
		}
	}
	
	public Benevole extraireDonnees(Map<String, Object> donnees) {
		Benevole benevole = new Benevole(null);
		benevole.setId_personne(Integer.parseInt(String.valueOf(donnees.get("id_Personne"))));
		benevole.setNom_c(String.valueOf(donnees.get("nom_benevole")));
		benevole.setPrenom_c(String.valueOf(donnees.get("prenom_benevole")));
		benevole.setAdresse(String.valueOf(donnees.get("adresse_benevole")));
		benevole.setCp_c(String.valueOf(donnees.get("codePostal_benevole")));
		benevole.setVille_c(String.valueOf(donnees.get("ville_benevole")));
		benevole.setTelephone_c(String.valueOf(donnees.get("telephone_benevole")));
		benevole.setMail_c(String.valueOf(donnees.get("mail_personnel")));
		benevole.setCommentaire(String.valueOf(donnees.get("commentaire_benevole")));

		return benevole;
	}


}
