package Kanban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCarte extends JPanel{
	private VueKanban vueKanban;
	private JLabel  lblibelle;
	private JButton btnEditer;
	private JButton btnFlecheArriere;
	private JButton btnFlecheAvant;
	private JLabel  lbProloop;
	private JButton btnSupprimer;
	private JButton btnPause;
	
	public VueCarte(String texte, VueKanban vueKanban) {
		ControleurCarte controleur = new ControleurCarte(this);
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.NORTH);
		
		this.btnSupprimer = new JButton();
		btnSupprimer.setIcon(new ImageIcon("./src/Kanban/delete.png", "supprimer" ));
		pNord.add(btnSupprimer);	
		this.btnPause = new JButton();
		btnPause.setIcon(new ImageIcon("./src/Kanban/pause.png", "suspendre"));
		pNord.add(btnPause);		
		this.btnEditer = new JButton();
		btnEditer.setIcon(new ImageIcon("./src/Kanban/edit.png", "editer"));
		pNord.add(btnEditer);		
		this.lblibelle= new JLabel("Libellé ");
		this.add(lblibelle, BorderLayout.CENTER);
		
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.SOUTH);
		pSud.setLayout(new FlowLayout());
		this.btnFlecheAvant = new JButton(">>");
		this.lbProloop = new JLabel();
		this.btnFlecheArriere = new JButton("<<");
		lbProloop.setIcon(new ImageIcon("./src/Kanban/miniproloop.png", "proloop"));
		pSud.add(btnFlecheArriere);
		pSud.add(lbProloop);
		pSud.add(btnFlecheAvant);
		
		this.btnEditer.addActionListener(controleur);
		this.btnFlecheArriere.addActionListener(controleur);
		this.btnFlecheAvant.addActionListener(controleur);
		this.btnPause.addActionListener(controleur);
		this.btnSupprimer.addActionListener(controleur);

	}
	
	public void setTitre(String titre) {
		lblibelle.setText(titre);
	}
	/*
	public boolean getActionBouton(JButton b) {
		//String action ="";

		System.out.println(b.equals(this.btnEditer));
		
		
	}
	*/
	
	
	public void afficherEtatBoutonsCarte(VueCarte carte, EtatCartes etat) {
		switch(etat) {
		case A_FAIRE:
			this.btnFlecheArriere.setEnabled(false);
			this.btnPause.setEnabled(false);
			this.btnFlecheAvant.setEnabled(true);
			this.btnEditer.setEnabled(true);
			this.btnSupprimer.setEnabled(true);
			break;
		case EN_COURS:
			
			break;
		case EN_ATTENTE:
			this.btnFlecheAvant.setEnabled(false);
			this.btnFlecheArriere.setEnabled(false);
			this.btnEditer.setEnabled(false);
			this.btnPause.setEnabled(true);
			this.btnSupprimer.setEnabled(true);
			break;
		case TERMINEE:
			this.btnFlecheAvant.setEnabled(false);
			this.btnPause.setEnabled(false);
			this.btnEditer.setEnabled(false);
			this.btnFlecheArriere.setEnabled(true);
			this.btnSupprimer.setEnabled(true);
			break;
		case SUPPRIME:
			this.setEnabled(false);
			break;
		}
	}
	
	/*
	public void afficherTacheRecurrente(boolean estRecurrente) {
		this.btnFlecheArriere.setVisible(!estRecurrente);
		this.btnFlecheAvant.setVisible(!estRecurrente);
		this.lbProloop.setVisible(estRecurrente); // !!! Label (récupérer le clic)
	}
	*/
	
	
	public VueKanban getVueKanban() {
		return vueKanban;
	}

	class ControleurCarte implements ActionListener{
		
		public EtatCartes etat;
		private VueCarte vueCarte;
		//private Tache tache;
		//private Date dateDebut;
		//private int nbMoisRestant;

		public ControleurCarte(VueCarte vue) {
			this.vueCarte = vue;
			this.etat = EtatCartes.A_FAIRE;
			//this.modele = new AFaire(tache);
			//this.nbMoisRestant = this.dateDebut - datesystem
			//this.nbMoisRestant = 12; //exemple pour tester
			
		}

		@Override  
		public void actionPerformed(ActionEvent e) {
			JButton b =(JButton) e.getSource();
			switch(this.etat) {
			case A_FAIRE:
				System.out.println("VueCarte : etat A_FAIRE");
				//this.vueCarte.afficherTacheRecurrente(false);
				if (b.getText().equals(">>")) {
					System.out.println("Passage à l'état enCours");
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(this.vueCarte, EtatCartes.A_FAIRE, EtatCartes.EN_COURS);
					this.etat = EtatCartes.EN_COURS;
				}else if (b.getIcon().toString() == "supprimer") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.A_FAIRE, EtatCartes.SUPPRIME);
					this.etat = EtatCartes.SUPPRIME;
				}
				break;
			case EN_COURS:
				System.out.println("VueCarte : etat EN_COURS");
				vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_COURS);
				if(b.getText().equals(">>")) {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.TERMINEE);
					this.etat = EtatCartes.TERMINEE;
				}else if(b.getText().equals("<<")) {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.A_FAIRE);
					this.etat = EtatCartes.A_FAIRE;
				}else if (b.getIcon().toString() == "supprimer") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.SUPPRIME);
					this.etat = EtatCartes.SUPPRIME;
				}else if (b.getIcon().toString() == "editer") {
					//vue NouvelleTache apparait mode Edition
				}else if(b.getIcon().toString() == "suspendre") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_COURS, EtatCartes.EN_ATTENTE);
					this.etat = EtatCartes.EN_ATTENTE;
				}
				break;
			case EN_ATTENTE:
				System.out.println("VueCarte : etat EN_ATTENTE");
				vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.EN_ATTENTE);
				if (b.getIcon().toString() == "suspendre") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_ATTENTE, EtatCartes.EN_COURS);
					this.etat = EtatCartes.EN_COURS;
				}else if (b.getIcon().toString() == "supprimer") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.EN_ATTENTE, EtatCartes.SUPPRIME);
					this.etat = EtatCartes.SUPPRIME;
				}
				break;
			case TERMINEE:
				System.out.println("VueCarte : etat TERMINEE");
				vueCarte.afficherEtatBoutonsCarte(vueCarte, EtatCartes.TERMINEE);
				if (b.getIcon().toString() == "supprimer") {
					this.vueCarte.vueKanban.afficherNouvelEtatCarte(vueCarte, EtatCartes.TERMINEE, EtatCartes.SUPPRIME);
					this.etat = EtatCartes.SUPPRIME;
				}
				break;
			case SUPPRIME:
				System.out.println("VueCarte : etat SUPPRIME");
				
				break;
			default: 
			}
		}
					

		

		
		
	}


	
	
	
	

	
	
	
	
	
	
}
