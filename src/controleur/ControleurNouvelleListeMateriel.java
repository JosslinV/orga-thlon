package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import vue.VueQuantiteMateriel;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Database.RequestDataBase.RequestMateriel;
import Database.RequestDataBase.RequestTache;
import modele.AffectationMateriel;
import modele.Materiel;
import modele.Tache;
import vue.VueNouvelleListeMateriel;
import Database.InputDataBase.InputUtiliser ;

public class ControleurNouvelleListeMateriel implements ActionListener, DocumentListener{
	private enum Etats {MATERIEL_DISPO, MATERIEL_EMPRUNTE, MATERIEL_ASSIGNE};
	private Etats etat;
	private VueNouvelleListeMateriel vue;
	private VueQuantiteMateriel vueQuantite ;
	private AffectationMateriel modele;
	private Tache tachetest ;
	private ArrayList<Materiel> materiels ;
	private float quantiteAffectee ;

	public ControleurNouvelleListeMateriel(VueNouvelleListeMateriel vueNouvelleListeMateriel) throws Exception {
	        this.vue = vueNouvelleListeMateriel;
	        this.modele = new AffectationMateriel();
	        this.etat = Etats.MATERIEL_DISPO;
	        //RequestTache rt = new  RequestTache();
	        //this.tachetest = rt.requestTache(8); TODO requête qui fonctionne
	        this.tachetest = new Tache ("panem", LocalDate.now()) ;
	        this.tachetest.setId_tache(8);
	        RequestMateriel reqMat = new RequestMateriel();
			this.materiels = reqMat.requestAll();
			ArrayList<String> nom = new ArrayList<String>();
			for(Materiel m: this.materiels) {
			    nom.add(m.toString());
			quantiteAffectee = 1 ;
	}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		switch(this.etat) {
		case MATERIEL_DISPO:
			
			if (b.getText()  == ">>" ) {
				
				try {
					this.vueQuantite = new VueQuantiteMateriel(this.modele, this.vue) ;
					this.vue.ajouterLigne(this.vue.getLtMaterielDisponible().getSelectedValue());
					//TODO rendre la fenêtre dessous inactive
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
			
			break;
			
		case MATERIEL_ASSIGNE:
			
			if (b.getText()  == "Valider" ) {
				
				
				//this.vue.getLtMaterielDisponible().getSelectedIndex();
				 modele.AffecterMateriel(tachetest, materiels.get(this.vue.getLtMaterielDisponible().getSelectedIndex()) , quantiteAffectee);
				 InputUtiliser iu = new InputUtiliser() ;
				 try {
					iu.inputUtiliser( this.materiels.get(this.vue.getLtMaterielDisponible().getSelectedIndex()), tachetest, quantiteAffectee) ;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}	 
			break;
			
		case MATERIEL_EMPRUNTE:
			break;
		
		}
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<String> materielEnString(ArrayList<Materiel> listematerielDisponible){
		ArrayList<String> listematerielDisponibleStr = new ArrayList<String>();
		for(Materiel m: listematerielDisponible) {
			listematerielDisponibleStr.add(m.toString());
		}
		return listematerielDisponibleStr;
	 }
	
	public List<Materiel> getListe() {
		return this.materiels ;
	}
}
	


