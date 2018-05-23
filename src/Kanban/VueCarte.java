package Kanban;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCarte extends JPanel{
	private JLabel lblibelle;

	private JButton btnEditer;

	private JButton btnSupprimer;

	private JButton btnPause;

	private JButton btnProloop;
	
	public VueCarte(String texte, boolean predefinie) {
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.PAGE_START);
		
		this.btnSupprimer = new JButton();
		btnSupprimer.setIcon(new ImageIcon("./src/Kanban/delete.png", "supprimer" ));		
		pNord.add(btnSupprimer);
		
		this.btnPause = new JButton();
		btnPause.setIcon(new ImageIcon("./src/Kanban/pause.png", "pause"));
		pNord.add(btnPause);
		
		this.btnEditer = new JButton();
		btnEditer.setIcon(new ImageIcon("./src/Kanban/edit.png", "editer"));
		pNord.add(btnEditer);
		
		this.lblibelle= new JLabel("Libellé ");
		this.add(lblibelle, BorderLayout.CENTER);
		
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.PAGE_END);
		this.btnProloop = new JButton();
		btnProloop.setIcon(new ImageIcon("./src/Kanban/miniproloop.png", "proloop"));
		pSud.add(btnProloop);
	}
	
	public void setTitre(String titre) {
		lblibelle.setText(titre);
	}
	
	public void afficherBoutonProloop(boolean estAffiche) {
		this.btnProloop.setVisible(estAffiche);
	}
	

}
