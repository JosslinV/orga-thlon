package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.VueQuantiteMateriel ;
import javax.swing.JButton;
import javax.swing.JFrame;


//import com.sun.glass.ui.TouchInputSupport;


import modele.AffectationMateriel;


public class ControleurVueQuantiteMateriel implements ActionListener {

	private VueQuantiteMateriel vue;
	private modele.AffectationMateriel modele;
	private JFrame fen;
	
	public ControleurVueQuantiteMateriel(VueQuantiteMateriel vue, AffectationMateriel am) throws Exception {	
		this.vue = vue ;
		this.fen = vue.getFen();
		this.modele = am ;

	}


	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource() ;
		
					try {
						
						if (b.getText() == "valider") {
						this.modele.setQuantiteEnMemoire(this.vue.getQuantite());
						vue.getVueMere().miseAjourLigne(this.vue.getQuantite());
						vue.getFen().dispose();
						
						
						
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
		}
					
			

	}
	}
	    
	
	
	














