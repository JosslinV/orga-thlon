package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import java.util.Date ;
import vue.VueNouvelleCourse;
import Database.InputDataBase.InputCourse;
import modele.Course ;
import Database.InputDataBase.InputCourse ;
import java.util.HashMap ;

public class ControleurNouvelleCourse implements ActionListener {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private VueNouvelleCourse vue;
	private modele.Course modele;
	
	
	public ControleurNouvelleCourse(VueNouvelleCourse vue) throws Exception {	
		this.vue = vue ;
		this.modele = new modele.Course("nouveau") ;
		this.etatCourant = Etats.EDITION;
	}
	
	public void actionPerformed (ActionEvent e) {
		JButton b = (JButton) e.getSource() ;
			switch (this.etatCourant) {
			case EDITION :
				if (b.getText().equals("valider")) {
					this.etatCourant = Etats.CONSULTATION ;
					//this.vue.titreFenetreSaisi(true);
					this.vue.setActifComposants(false);
					this.vue.modifierTexteBoutonsPourEdition(false);
					try {
						Course nouvelleCourse = new modele.Course("nouveau");
						nouvelleCourse = convertirMap(this.vue.getDonneesCourse()) ;
						
						InputCourse in = new InputCourse() ;
				    	
				    	in.inputCourse(nouvelleCourse) ;
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
					/*
					try {
						InputCourse.input(modele);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					*/
				}else if (b.getText().equals("annuler")) {
					System.exit(0);
				} //else if bouton effacer

			case CONSULTATION :

				if (b.getText().equals("retour")) {
					this.etatCourant = Etats.EDITION ;
					this.vue.modifierTexteBoutonsPourEdition(true);
					this.vue.setActifComposants(true);
					//this.vue.titreFenetreSaisi(false);
					
				}
			
			
				
			}
			
			}
	//"Sun Jan 01 00:00:00 CET 1950" // dd/MM/yyyy // EEE MMM HH:mm:ss zzz yyyy

	public Course convertirMap(HashMap <String, Object> donneesCourses) throws Exception {

        Course nouvelleCourse = new modele.Course("nouveau") ;

        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("nom_courseVue"))) ;

        //LocalDate d1 = LocalDate.parse(String.valueOf(donneesCourses.get("date_debut_courseVue")), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
       // LocalDate d2 = LocalDate.parse(String.valueOf(donneesCourses.get("date_debut_courseVue")), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        //String.valueOf(donneesCourses.get("date_debut_courseVue")),
        //String d1_en_str_mod = new SimpleDateFormat("dd/MM/yyyy").format(d1);
        //Date d1mod_en_date = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(d1_en_str_mod)) ; 
        //nouvelleCourse.setDate_debut_course(LocalDate.parse( String.valueOf(donneesCourses.get("date_debut_courseVue")), DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
        String s1 = String.valueOf(donneesCourses.get("date_debut_courseVue")) ;
        String s1mod = "" + s1.charAt(8) + s1.charAt(9)+"/"+ s1.charAt(5)+ s1.charAt(6) + "/" + s1.charAt(0)+ s1.charAt(1)+ s1.charAt(2)+ s1.charAt(3);
        nouvelleCourse.setDate_debut_course(LocalDate.parse( s1mod, DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
       
        String s2 = String.valueOf(donneesCourses.get("date_fin_courseVue")) ;
        String s2mod = "" + s2.charAt(8) + s2.charAt(9)+"/"+ s2.charAt(5)+ s2.charAt(6) + "/" + s2.charAt(0)+ s2.charAt(1)+ s2.charAt(2)+ s2.charAt(3);
        nouvelleCourse.setDate_fin_course(LocalDate.parse( s2mod, DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
        //nouvelleCourse.setDate_fin_course(LocalDate.parse(String.valueOf(donneesCourses.get("date_fin_courseVue")), DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
		//Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(donneesCourses.get("date_fin_courseVue")));
        //String d2_en_str_mod = new SimpleDateFormat("dd/MM/yyyy").format(d2);
        //Date d2mod_en_date = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(d2_en_str_mod)) ;
        //nouvelleCourse.setDate_debut_course(d2mod_en_date) ;
        //nouvelleCourse.setDate_fin_course(d2) ;
        nouvelleCourse.setNbParticipants( Integer.parseInt(String.valueOf( donneesCourses.get("nbParticipantsVue")))) ; 
        nouvelleCourse.setAgrement(Boolean.valueOf(String.valueOf( donneesCourses.get("agrementVue")))) ; 
        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("type_epreuveVue"))) ; 
        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("formatVue"))) ; 
        nouvelleCourse.setDistance_nat( Integer.parseInt(String.valueOf( donneesCourses.get("distance_natVue")))) ; 
        nouvelleCourse.setDistance_cyc( Integer.parseInt(String.valueOf( donneesCourses.get("distance_cycVue")))) ;
        nouvelleCourse.setDistance_cou( Integer.parseInt(String.valueOf( donneesCourses.get("distance_couVue")))) ;
        nouvelleCourse.setNom_ville_nat( String.valueOf( donneesCourses.get("nom_ville_natVue"))) ; 
        nouvelleCourse.setNom_ville_cyc( String.valueOf( donneesCourses.get("nom_ville_cycVue"))) ; 
        nouvelleCourse.setNom_ville_cou( String.valueOf( donneesCourses.get("nom_ville_couVue"))) ; 
        nouvelleCourse.setNom_ville_arr( String.valueOf( donneesCourses.get("nom_ville_arrVue"))) ; 
        nouvelleCourse.setCP_ville_nat( String.valueOf( donneesCourses.get("CP_ville_natVue"))) ; 
        nouvelleCourse.setCP_ville_cyc( String.valueOf( donneesCourses.get("CP_ville_cycVue"))) ; 
        nouvelleCourse.setCP_ville_cou( String.valueOf( donneesCourses.get("CP_ville_couVue"))) ;
        nouvelleCourse.setCP_ville_arr( String.valueOf( donneesCourses.get("CP_ville_arrVue"))) ; 
        nouvelleCourse.setDescriptionCourse( String.valueOf( donneesCourses.get("description_courseVue"))) ; 
        
        return nouvelleCourse ;
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
	
	

