package Kanban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCarte extends JPanel{
	private JLabel  lblibelle;
	private JButton btnEditer;
	private JButton btnFlecheArriere;
	private JButton btnFlecheAvant;
	private JLabel lbProloop;
	private JButton btnSupprimer;
	private JButton btnPause;
	
	public VueCarte(String texte) {
		ControleurKanban controleur = new ControleurKanban();
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.PAGE_START);
		
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
		pSud.setLayout(new GridLayout(1,3, 20,10));
		this.btnFlecheAvant = new JButton(">>");
		this.lbProloop = new JLabel();
		this.btnFlecheArriere = new JButton("<<");
		lbProloop.setIcon(new ImageIcon("./src/Kanban/miniproloop.png", "proloop"));
		pSud.add(btnFlecheArriere);
		pSud.add(lbProloop);
		pSud.add(btnFlecheAvant);
		
		this.btnEditer.addActionListener(controleur);


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
	
	
	public void afficherEtatBoutonsCarte(VueCarte carte, Etat etat) {
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
	
	
	public void afficherTacheRecurrente(boolean estRecurrente) {
		this.btnFlecheArriere.setVisible(!estRecurrente);
		this.btnFlecheAvant.setVisible(!estRecurrente);
		this.lbProloop.setVisible(estRecurrente); // !!! Label (récupérer le clic)
	}
	


	
	
	
	

	
	
	
	
	
	
}
