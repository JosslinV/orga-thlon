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
	private Icon icProloop;
	private Icon icEditer;
	private Icon icPause;
	private Icon icSupprimer;
	private JButton btnEditer;
	
	
	public VueCarte(String texte, boolean predefinie) {
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.PAGE_START);
		
		JButton btnSupprimer = new JButton();
		this.icSupprimer = new ImageIcon("./src/Kanban/delete.png", "supprimer" );
		btnSupprimer.setIcon(icSupprimer);		
		pNord.add(btnSupprimer);
		
		JButton btnPause = new JButton();
		this.icPause = new ImageIcon("./src/Kanban/pause.png", "pause");
		btnPause.setIcon(icPause);
		pNord.add(btnPause);
		
		this.btnEditer = new JButton();
		this.icEditer = new ImageIcon("./src/Kanban/edit.png", "editer");
		btnEditer.setIcon(icEditer);
		pNord.add(btnEditer);
		
		this.lblibelle= new JLabel("Libellé ");
		this.add(lblibelle, BorderLayout.CENTER);
		
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.PAGE_END);
		JButton btnProloop = new JButton();
		this.icProloop = new ImageIcon("./src/Kanban/miniproloop.png", "proloop");
		btnProloop.setIcon(icProloop);
		if ()
		btnProloop.setVisible(true);
		pSud.add(btnProloop);
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
