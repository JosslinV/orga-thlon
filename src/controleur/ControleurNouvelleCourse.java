package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreNouvelleCourse;
import vue.VueFenetreNouvelleCourse;
import vue.VueNouvelleCourse ;
import Database.InputDataBase.InputCourse;
import modele.Course ;
import Database.InputDataBase.InputCourse ;

public class ControleurNouvelleCourse implements ActionListener {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private FenetreNouvelleCourse vue;
	private modele.Course modele;
	private modele.Course courserentree ;
	
	
	public ControleurNouvelleCourse(VueFenetreNouvelleCourse vue) throws Exception {	
		this.vue = vue ;
		this.modele = new modele.Course("nouveau", false) ;
		this.etatCourant = Etats.EDITION ;
	}
	
	public void actionPerformed (ActionEvent e) {
		JButton b = (JButton) e.getSource() ;
			switch (this.etatCourant) {
	
			case EDITION :
				if 
				
				if (b.getText().equals("valider")) {
					
				
					try {
						
						courserentree = vue.getDonneesCourse() ;
						// ici il faudra adapter Nat
						InputCourse.input(courserentree) ;
						
						this.etatCourant = Etats.CONSULTATION ;
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				
				
			case CONSULTATION :
				
				if (boutonSource.getText().equals("editer")) {
					
					this.etatCourant = etats.EDITION ;
				}
				
			}
			
			}
}
	
	/*
	 * 
	 * 
	 * 					antisèche
	 * 
	 * 
	 * 
	 * 	public void actionPerformed(ActionEvent arg0) {
	
		JButton boutonSource = (JButton) arg0.getSource();
		
		if (boutonSource.getText().equals("VALIDER")) this.etatCourant=etats.CHOIX_POSITION; 
			
		
			
		switch(this.etatCourant) {
			
			case DEBUT_COMBINAISON :
				
				//sauvegarde la couleur choisie
				if (!vue.appartientPalette(boutonSource)) break;
				couleurChoisie = boutonSource.getBackground();
				this.etatCourant=etats.CHOIX_COULEUR;
				break;
			
			case CHOIX_COULEUR :
				
				// met la couleur sauvegardée dans le bouton de la combinaison choisie
				if(this.vue.appartientCombinaison(boutonSource, ligne)) {
				boutonSource.setBackground(couleurChoisie);
				this.etatCourant=etats.DEBUT_COMBINAISON;
				}
				break;
							
				
			case CHOIX_POSITION :
											
				if (!vue.combinaisonComplete(ligne)) {
					this.etatCourant=etats.DEBUT_COMBINAISON;
					break;
				}
				// afficher le nombre de couleurs bien placées de la combinaison courante
				int nbBP = this.modele.nbChiffresBienPlaces(vue.combinaisonEnEntiers(ligne));
				this.vue.afficherBP(ligne, nbBP);
				// afficher le nombre de couleurs mal placées de la combinaison courante
				int nbMP = this.modele.nbChiffresMalPlaces(vue.combinaisonEnEntiers(ligne));
				this.vue.afficherMP(ligne, nbMP);
				// désactiver les boutons de la combinaison courante
				this.vue.desactiverCombinaison(ligne);			
				
				if ( nbBP != this.vue.getTaille()) {
				// Si la combinaison n'est pas trouvée, 2 possibilités : il reste des essais ou pas
					
					if(ligne < nbEssai-1) {
						// Il reste encore des essais
						this.etatCourant = etats.DEBUT_COMBINAISON;
						this.ligne +=1;
						this.vue.activerCombinaison(ligne);
						break;
						
					}
				}else {
				// La combinaison est trouvée  
						// il ne reste plus d'essais
				this.etatCourant = etats.FIN;
				}
				
			case FIN :	
				
				this.vue.afficherCombinaisonOrdinateur(this.modele.getCombinaison());
				
			break;	
			}
		}
	 */
	
	

