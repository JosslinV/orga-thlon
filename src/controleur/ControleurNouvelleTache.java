package controleur;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Database.InputDataBase.InputCourse;
import Database.InputDataBase.InputTache;
import modele.Course;
import modele.Tache;
import vue.Vue_nouvelleTache;

public class ControleurNouvelleTache implements ActionListener, ChangeListener{

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
		
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource() ;
		
				switch (this.etatCourant) {
			case EDITION :
				if (b.getText().equals("Valider")) {
					this.etatCourant = Etats.CONSULTATION ;
					//this.vue.titreFenetreSaisi(true);
					this.vue.setActifComposants(false);
					this.vue.modifierTexteBoutonsPourEdition(false);
					try {
						Tache nouvelleTache = new modele.Tache("nouvelle tache", ajd);
						nouvelleTache = convertirMap_principale(this.vue.getDonneesTache()) ;
						
						InputTache in = new InputTache() ;
				    	
				    	in.inputTache(nouvelleTache) ;
				
			
					
					
				
					
						
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

				break ;
				
			case CONSULTATION :

				if (b.getText().equals("retour")) {
					this.etatCourant = Etats.EDITION ;
				this.vue.modifierTexteBoutonsPourEdition(true);
				this.vue.setActifComposants(true);
					//this.vue.titreFenetreSaisi(false);
				break ;
				}
			}
				
		} else {
			JRadioButton b = (JRadioButton) e.getSource();
			
			switch (this.etatCourant) {
			case EDITION :
					
					try {
				vue.resetBtRadio() ;
				b.setSelected(true);
				vue.majRadio();
			
				    	break ;
					
					
				
					
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					
					}
					
			

				
				
			case CONSULTATION :

			{
				}
			}
		}
				
	}
		
	
	public void stateChanged(ChangeEvent e) {
	    JSlider source = (JSlider)e.getSource();
	    switch (this.etatCourant) {
	    
		    case EDITION :
		    	
		    	if (source.getValueIsAdjusting()) {
			      
			        
			       this.vue.afficherEtatAvancement() ;
			        } else {
			          
			     
			        }
		    	
		    break ;
		    
			case CONSULTATION :
				{}
				break ;
		}
	}

	    
	    
	
	
			public Tache convertirMap_principale(HashMap <String, Object> donneesTache) throws Exception {

		        Tache nouvelleTache = new modele.Tache("nouvelle_tache", ajd) ;
		        
		        nouvelleTache.setLibelle(String.valueOf(donneesTache.get("libelle"))) ;
		        //nouvelleTache.setId_tache(Integer.parseInt(String.valueOf(donneesTache.get("id_tache"))));
		        nouvelleTache.setNomResponsableTache(String.valueOf(donneesTache.get("nom_responsable"))) ;
		        nouvelleTache.setPrenomResponsableTache(String.valueOf(donneesTache.get("prenom_responsable"))) ;
		        nouvelleTache.setNomAuteurTache(String.valueOf(donneesTache.get("auteur_Tache"))) ;
		        String s1 = String.valueOf(donneesTache.get("dateDebut")) ;
		        String s1mod = "" + s1.charAt(8) + s1.charAt(9)+"/"+ s1.charAt(5)+ s1.charAt(6) + "/" + s1.charAt(0)+ s1.charAt(1)+ s1.charAt(2)+ s1.charAt(3);
		        nouvelleTache.setDateDebut(LocalDate.parse( s1mod, DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
		        String s2 = String.valueOf(donneesTache.get("dateEcheance")) ;
		        String s2mod = "" + s2.charAt(8) + s2.charAt(9)+"/"+ s2.charAt(5)+ s2.charAt(6) + "/" + s2.charAt(0)+ s2.charAt(1)+ s2.charAt(2)+ s2.charAt(3);
		        nouvelleTache.setDateEcheance(LocalDate.parse( s2mod, DateTimeFormatter.ofPattern("dd/MM/uuuu"))) ;
		        
		        nouvelleTache.setPriorite(Integer.parseInt(String.valueOf(donneesTache.get("priorite"))));
		        nouvelleTache.setEtatAvancement(Float.parseFloat(String.valueOf(donneesTache.get("Etat Avancement"))));
		        nouvelleTache.setCommentaire(String.valueOf(donneesTache.get("auteur_Tache"))) ;
		        nouvelleTache.setPredefinie(Boolean.valueOf(String.valueOf( donneesTache.get("estTachePredfinie")))) ; 
			
		        
		        return nouvelleTache ;
			}
	}


















		        /*
				public HashMap<String, Object> getDonneesTache() throws ParseException {
					HashMap<String,Object> donneesTache = new HashMap<String, Object>();
					
					-donneesTache.put("id_Tache", this.id_Tache);
					-donneesTache.put("auteur_Tache", this.auteur_Tache);
					-donneesTache.put("libelle", this.tfLibelle.getText());  //ok
					-donneesTache.put("nom_responsable", this.tfResponsableNom.getText());
					-donneesTache.put("prenom_responsable", this.tfResponsablePrenom.getText());
					-LocalDate dateDebut = LocalDate.parse(this.tfDateDebut.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
					-donneesTache.put("dateDebut", dateDebut);
					-LocalDate dateEcheance = LocalDate.parse(this.tfDateEcheance.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
					-donneesTache.put("dateEcheance", dateEcheance);
					int teMoisInt = Integer.parseInt(this.tfMois.getText()) ;
					int teJourInt = Integer.parseInt(this.tfJour.getText());
					int tempsEstimeJour = teMoisInt * 30 + teJourInt; // attention : 1mois = 30 j
					donneesTache.put("tempsEstime", tempsEstimeJour );
					donneesTache.put("priorite", this.priorite);
					donneesTache.put("Etat Avancement", this.slAvancementTache.getValue());
					donneesTache.put("commentaire", this.taCommentaire);
					
					return donneesTache;
					*/
		        
		        
		       
				
				
			
				
			
			
			
	
	







