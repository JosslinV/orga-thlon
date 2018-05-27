package Kanban;

import java.awt.BorderLayout;
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
	private JButton btnProloop;
	private JButton btnFlecheAvant;	
	
	public VueCarte(String texte) {
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.PAGE_START);
		
		JButton btnSupprimer = new JButton();
		btnSupprimer.setIcon(new ImageIcon("./src/Kanban/delete.png", "supprimer" ));		
		pNord.add(btnSupprimer);
		
		JButton btnPause = new JButton();
		btnPause.setIcon(new ImageIcon("./src/Kanban/pause.png", "pause"));
		pNord.add(btnPause);
		
		this.btnEditer = new JButton();
		btnEditer.setIcon(new ImageIcon("./src/Kanban/edit.png", "editer"));
		pNord.add(btnEditer);
		
		this.lblibelle= new JLabel("Libellé ");
		this.add(lblibelle, BorderLayout.CENTER);
		
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.SOUTH);
		pSud.setLayout(new GridLayout(1,3));
		this.btnFlecheAvant = new JButton(">>");	
		this.btnProloop = new JButton();
		this.btnFlecheArriere = new JButton("<<");
		this.btnProloop.setIcon(new ImageIcon("./src/Kanban/miniproloop.png", "proloop"));
		pSud.add(btnFlecheArriere);
		pSud.add(btnProloop);
		pSud.add(btnFlecheAvant);

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
}
