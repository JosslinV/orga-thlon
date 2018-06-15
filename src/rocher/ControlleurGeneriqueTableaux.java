package rocher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modele.Materiel;
import modele.contacts.Benevole;
import modele.contacts.Contact;
import modele.contacts.ContactExterne;


public class ControlleurGeneriqueTableaux implements ActionListener {
	public enum EtatsVuesListe{BENEVOLE,MATERIEL,CONTACT};
	private ModeleDynamiqueTable modele;
	private ListeGenerique ls;
	private EtatsVuesListe etat;
	
	public ControlleurGeneriqueTableaux(ListeGenerique listeGenerique,ArrayList<Object> list) {
		this.ls=listeGenerique;
		
		if(list.get(0) instanceof Benevole) {
			this.modele = new ModeleDynamiqueTableBenevole(list);
			this.etat=EtatsVuesListe.BENEVOLE;
		}
		if(list.get(0) instanceof Materiel) {
			this.modele = new ModeleDynamiqueTableMateriel(list);
			this.etat=EtatsVuesListe.MATERIEL;
		}	
		if(list.get(0) instanceof ContactExterne) {
			this.modele = new ModeleDynamiqueTableContact(list);
			this.etat=EtatsVuesListe.CONTACT;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton a = (JButton)arg0.getSource();
		switch (etat) {
		case BENEVOLE:
			if(a.getText()=="Ajouter")
				modele.add(new Benevole("Nouveau","Nouveau"));
			else {
				int[] selection = ls.getPanelPrincipal().getJTable().getSelectedRows();
				modele.remove(selection);
			}
			break;
		case MATERIEL:
			if(a.getText()=="Ajouter")
				modele.add(new Materiel("Nouveau"));
			else {
				int[] selection = ls.getPanelPrincipal().getJTable().getSelectedRows();
				modele.remove(selection);
			}
			break;
		case CONTACT:
			if(a.getText()=="Ajouter")
				modele.add(new ContactExterne("Nouveau","Nouveau"));
			else {
				int[] selection = ls.getPanelPrincipal().getJTable().getSelectedRows();
				modele.remove(selection);
			}
			break;
		}
		
		
		
	}
	
	public ModeleDynamiqueTable getModele() {
		return this.modele;
	}

}
