package controleur;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import javax.swing.JButton;

import Database.InputDataBase.InputCourse;
import modele.Tache;
import vue.Vue_nouvelleTache;

public class ControleurNouvelleTache {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private Vue_nouvelleTache vue;
	private modele.Tache modele;
	private LocalDate ajd = LocalDate.now();
	
	public ControleurNouvelleTache(Vue_nouvelleTache vue) throws Exception {	
		this.vue = vue ;
		this.modele = new modele.Tache("nouvelle tache", ajd) ;
		this.etatCourant = Etats.EDITION;
	}
	
	public void actionPerformed (ActionEvent e) {
		JButton b = (JButton) e.getSource() ;
			switch (this.etatCourant) {
			case EDITION :
				if (b.getText().equals("valider")) {
					this.etatCourant = Etats.CONSULTATION ;
					//this.vue.titreFenetreSaisi(true);
				//	this.vue.setActifComposants(false);
				//	this.vue.modifierTexteBoutonsPourEdition(false);
					try {
						Tache nouvelleTache = new modele.Tache("nouvelle tache", ajd);
						//nouvelleCourse = convertirMap(this.vue.getDonneesCourse()) ;
						
						InputCourse in = new InputCourse() ;
				    	
				    	//in.inputCourse(nouvelleCourse) ;
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
					
					try {
					//	InputCourse.input(modele);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					
				}else if (b.getText().equals("annuler")) {
					System.exit(0);
				} //else if bouton effacer

			case CONSULTATION :

				if (b.getText().equals("retour")) {
					this.etatCourant = Etats.EDITION ;
				//	this.vue.modifierTexteBoutonsPourEdition(true);
				//	this.vue.setActifComposants(true);
					//this.vue.titreFenetreSaisi(false);
					
				}
			
			
				
			}
			
			}
	
	
}

	




