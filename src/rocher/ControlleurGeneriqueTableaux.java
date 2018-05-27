package rocher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modele.Materiel;
import modele.contacts.Benevole;
import modele.contacts.Contact;


public class ControlleurGeneriqueTableaux implements ActionListener {
	public enum EtatsVuesListe{BENEVOLE,MATERIEL,CONTACT};
	private ModeleDynamiqueTable modele;
	private ListeGenerique ls;
	private EtatsVuesListe etat;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public ControlleurGeneriqueTableaux(ListeGenerique listeGenerique,EtatsVuesListe etat) {
		this.ls=listeGenerique;
		this.etat=etat;
		switch (etat) {
		case BENEVOLE:
			this.modele = new ModeleDynamiqueTableBenevole();
			//this.ls.setTitle("Benevole");
			break;
		case MATERIEL:
			this.modele = new ModeleDynamiqueTableMateriel();
			//this.ls.setTitle("Materiel");
			break;
		case CONTACT:
			this.modele = new ModeleDynamiqueTableContact();
			//this.ls.setTitle("Contact");
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
