package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import Database.InputDataBase.InputMateriel;
import modele.Materiel;
import modele.contacts.ContactExterne;
import vue.VueNouveauMateriel;

public class ControleurNouveauMateriel implements ActionListener {
	
	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouveauMateriel vue;
	private Materiel modele;
	private JFrame fen;
	
	public ControleurNouveauMateriel(VueNouveauMateriel vue){
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
					Materiel materiel = this.extraireDonnees(vue.rassemblerDonnees());
					InputMateriel inp = new InputMateriel();
					inp.inputMateriel(materiel);
				} catch(NullPointerException np) {
					np.printStackTrace();
					System.out.println("La classe n'a pu être créée (Libellé manquant?)");
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
	
	public Materiel extraireDonnees(Map<String, Object> donnees) {
		Materiel materiel = new Materiel(null);
		materiel.setId_materiel(Integer.parseInt(String.valueOf(donnees.get("id_Materiel"))));
		materiel.setLibelle(String.valueOf(donnees.get("libelle_mat")));
		materiel.setStockInitial(Double.parseDouble(String.valueOf(donnees.get("stock"))));
		materiel.setDescription(String.valueOf(donnees.get("prenom_contact")));
		
		return materiel;
	}
	
	
	
}
