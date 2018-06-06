package controleur;

import java.util.ArrayList;

import Database.RequestDataBase.RequestMateriel;
import modele.Materiel;
import modele.contacts.Benevole;
import modele.contacts.ContactExterne;
import vue.BenevolesOuContacts2;
import vue.VueNouvelleEquipe;
import vue.VueQuantiteMateriel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import Database.RequestDataBase.RequestBenevole;
import Database.RequestDataBase.RequestContactExt;

public class ControleurBenevolesOuContacts2 implements ActionListener {
	
	private BenevolesOuContacts2 vue ;
	
	public ControleurBenevolesOuContacts2 (BenevolesOuContacts2 vue) throws Exception {
		
		this.vue = vue ;
		
		}
	
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
	
		if (b.getText()  == "Benevoles" ) {
			RequestBenevole reqBen = new RequestBenevole();
			ArrayList<Benevole> benevoles;
			try {
				benevoles = reqBen.requestAll();
				ArrayList<String> nomBen = new ArrayList<String>();
				for(Benevole m: benevoles) {
					nomBen.add(m.toString());
				new VueNouvelleEquipe(nomBen);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (b.getText()  == "Contacts externes" ) {
				RequestContactExt reqCont = new RequestContactExt();
				ArrayList<ContactExterne> ContactsExternes;
				try {
					ContactsExternes = reqCont.requestAll();
					ArrayList<String> nomCont = new ArrayList<String>();
					for(ContactExterne c: ContactsExternes) {
						nomCont.add(c.toString());
					new VueNouvelleEquipe(nomCont);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
			
		}
	}
}
	
