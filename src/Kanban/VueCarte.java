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
	
	
	public VueCarte(String texte) {
		
		this.setLayout(new BorderLayout());
		JPanel pNord = new JPanel();
		pNord.setLayout(new FlowLayout());
		this.add(pNord, BorderLayout.PAGE_START);
		
		JButton btnSupprimer = new JButton();
		this.icSupprimer = new ImageIcon("./src/Kanban/delete.png");
		btnSupprimer.setIcon(icSupprimer);		
		pNord.add(btnSupprimer);
		
		JButton btnPause = new JButton();
		this.icPause = new ImageIcon("./src/Kanban/pause.png");
		btnPause.setIcon(icPause);
		pNord.add(btnPause);
		
		this.btnEditer = new JButton();
		this.icEditer = new ImageIcon("./src/Kanban/edit.png");
		btnEditer.setIcon(icEditer);
		pNord.add(btnEditer);
		
		this.lblibelle= new JLabel("Libellé ");
		this.add(lblibelle, BorderLayout.CENTER);
		
		JPanel pSud = new JPanel();
		this.add(pSud, BorderLayout.PAGE_END);
		JButton btnProloop = new JButton();
		this.icProloop = new ImageIcon("./src/Kanban/miniproloop.png");
		btnProloop.setIcon(icProloop);
		btnProloop.setVisible(true);
		pSud.add(btnProloop);
	}
	
	public void setTitre(String titre) {
		lblibelle.setText(titre);
	}
	
	public void getActionBouton(JButton b) {
		//String action ="";

		System.out.println(b.equals(this.btnEditer));
		
		
	}
	
}
