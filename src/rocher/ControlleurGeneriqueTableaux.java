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
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public ControlleurGeneriqueTableaux(ListeGenerique listeGenerique,ArrayList<Object> list) {
		this.ls=listeGenerique;
		
		if(list.get(0) instanceof Benevole) {
			this.modele = new ModeleDynamiqueTableBenevole(list);
			this.etat=EtatsVuesListe.BENEVOLE;
			//this.ls.setTitle("Benevole");
		}
		if(list.get(0) instanceof Materiel) {
			this.modele = new ModeleDynamiqueTableMateriel();
			this.etat=EtatsVuesListe.MATERIEL;
			//this.ls.setTitle("Materiel");
		}	
		if(list.get(0) instanceof ContactExterne) {
			this.modele = new ModeleDynamiqueTableContact();
			this.etat=EtatsVuesListe.CONTACT;
			//this.ls.setTitle("Contact");
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("ok");
		JButton a = (JButton)arg0.getSource();
		switch (etat) {
		case BENEVOLE:
			if(a.getText()=="Ajouter")
				modele.add(new Benevole("Bene","Bene"));
			else {
				int[] selection = ls.getPanelPrincipal().getJTable().getSelectedRows();
				modele.remove(selection);
			}
			break;
		case MATERIEL:
			if(a.getText()=="Ajouter")
				modele.add(new Materiel("Matos"));
			else {
				int[] selection = ls.getPanelPrincipal().getJTable().getSelectedRows();
				modele.remove(selection);
			}
			break;
		case CONTACT:
			if(a.getText()=="Ajouter")
				modele.add(new ContactExterne("Megan","contact"));
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
 /*
	  private class AddAction extends AbstractAction {
	        private AddAction() {
	            super("Ajouter");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	            modele.addContact(new Contact("Megan"));
	        }
	    }
	    
	    
Here be dragons	 	
___________________________________________________
@@@@@@@@@@@@@@@@@@@@@**^^""~~~"^@@^*@*@@**@@@@@@@@@
@@@@@@@@@@@@@*^^'"~   , - ' '; ,@@b. '  -e@@@@@@@@@
@@@@@@@@*^"~      . '     . ' ,@@@@(  e@*@@@@@@@@@@
@@@@@^~         .       .   ' @@@@@@, ~^@@@@@@@@@@@
@@@~ ,e**@@*e,  ,e**e, .    ' '@@@@@@e,  "*@@@@@'^@
@',e@@@@@@@@@@ e@@@@@@       ' '*@@@@@@    @@@'   0
@@@@@@@@@@@@@@@@@@@@@',e,     ;  ~^*^'    ;^~   ' 0
@@@@@@@@@@@@@@@^""^@@e@@@   .'           ,'   .'  @
@@@@@@@@@@@@@@'    '@@@@@ '         ,  ,e'  .    ;@
@@@@@@@@@@@@@' ,&&,  ^@*'     ,  .  i^"@e, ,e@e  @@
@@@@@@@@@@@@' ,@@@@,          ;  ,& !,,@@@e@@@@ e@@
@@@@@,~*@@*' ,@@@@@@e,   ',   e^~^@,   ~'@@@@@@,@@@
@@@@@@, ~" ,e@@@@@@@@@*e*@*  ,@e  @@""@e,,@@@@@@@@@
@@@@@@@@ee@@@@@@@@@@@@@@@" ,e@' ,e@' e@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@" ,@" ,e@@e,,@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@~ ,@@@,,0@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@,,@@@@@@@@@@@@@@@@@@@@@@@@@
"""""""""""""""""""""""""""""""""""""""""""""""""""

	    private class RemoveAction extends AbstractAction {
	        private RemoveAction() {
	            super("Supprimmer");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	            int[] selection = tableau.getSelectedRows();
	 
	            for(int i = selection.length - 1; i >= 0; i--){
	                modele.removeContact(selection[i]);
	            }
	        }
	    }
	    */
	

}
