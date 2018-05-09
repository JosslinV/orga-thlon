package rocher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modele.Materiel;
import modele.contacts.Benevole;
import modele.contacts.Contact;


public class ControlleurTableauBenevoles implements ActionListener {
	public enum EtatsVuesListe{BENEVOLE,MATERIEL,CONTACT};
	private ModeleDynamiqueTable modele;
	private ListeBenevoles ls;
	private EtatsVuesListe etat;
	
	public ControlleurTableauBenevoles(ListeBenevoles ls,EtatsVuesListe etat) {
		this.ls=ls;
		this.etat=etat;
		switch (etat) {
		case BENEVOLE:
			this.modele = new ModeleDynamiqueTableBenevole();
			break;
		case MATERIEL:
			this.modele = new ModeleDynamiqueTableMateriel();
			break;
		case CONTACT:
			this.modele = new ModeleDynamiqueTableContact();
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("ok");
		JButton a = (JButton)arg0.getSource();
		switch (etat) {
		case BENEVOLE:
			if(a.getText()=="Ajouter")
				modele.add(new Benevole("Bene"));
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
				modele.add(new Contact("Megan"));
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
	    
	    
Here be dragon	 	
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
