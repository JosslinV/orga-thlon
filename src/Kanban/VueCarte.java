package Kanban;

import java.awt.BorderLayout;
import java.awt.Color;
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

import modele.Tache;

public class VueCarte extends JPanel{
	private VueKanban vueKanban;
	private JLabel  lblibelle;
	private JButton btnEditer;
	private JButton btnFlecheArriere;
	private JButton btnFlecheAvant;
	private JLabel  lbProloop;
	private JButton btnSupprimer;
	private JButton btnPause;
	private Tache tache;
	private ModeleKanban modele ;
	
	public VueCarte(Tache tache, ModeleKanban modele) {
		
		ControleurCarte2 controleur = new ControleurCarte2(this);
		
		this.tache = tache;
		this.modele = modele ;
		
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
		this.lblibelle= new JLabel(tache.getLibelle());
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
		if (this.tache.isPredefinie()) {
			this.lbProloop.setVisible(true); 
		}else {
			this.lbProloop.setVisible(false);
		}
	}
	
	public void setTitre(String titre) {
		lblibelle.setText(titre);
	}
	
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
			this.btnFlecheAvant.setEnabled(true);
			this.btnFlecheArriere.setEnabled(true);
			this.btnEditer.setEnabled(true);
			this.btnPause.setEnabled(true);
			this.btnSupprimer.setEnabled(true);
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
			this.btnFlecheArriere.setEnabled(false);
			this.btnSupprimer.setEnabled(true);
			break;
		case SUPPRIME:
			this.setEnabled(false);
			break;
		}	
	}
	
	public ModeleKanban getModele() {
		return this.modele;
	}

	public Tache getTache() {
		return tache;
	}

	
}

