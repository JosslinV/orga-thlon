package Kanban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		this.add(pSud, BorderLayout.SOUTH);
		this.icProloop = new ImageIcon("./src/Kanban/miniproloop.png", "proloop");
		GridBagLayout gbl_pSud = new GridBagLayout();
		gbl_pSud.columnWidths = new int[]{72, 209, 0, 0};
		gbl_pSud.rowHeights = new int[]{9, 0};
		gbl_pSud.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pSud.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pSud.setLayout(gbl_pSud);
		
		JButton btnFlecheArriere = new JButton("<<");
		//btnFlecheArriere.setPreferredSize(new Dimension(50,20));
		btnFlecheArriere.setIcon(null);
		GridBagConstraints gbc_btnFlecheArriere = new GridBagConstraints();
		gbc_btnFlecheArriere.anchor = GridBagConstraints.WEST;
		gbc_btnFlecheArriere.insets = new Insets(0, 0, 0, 5);
		gbc_btnFlecheArriere.gridx = 0;
		gbc_btnFlecheArriere.gridy = 0;
		pSud.add(btnFlecheArriere, gbc_btnFlecheArriere);
		JButton btnProloop = new JButton();
		btnProloop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProloop.setIcon(icProloop);
		//if ()
		//btnProloop.setVisible(true);
		GridBagConstraints gbc_btnProloop = new GridBagConstraints();
		gbc_btnProloop.weightx = 1.0;
		gbc_btnProloop.insets = new Insets(0, 0, 0, 5);
		gbc_btnProloop.anchor = GridBagConstraints.NORTH;
		gbc_btnProloop.gridx = 1;
		gbc_btnProloop.gridy = 0;
		pSud.add(btnProloop, gbc_btnProloop);
		
		JButton btnFlecheAvant = new JButton(">>");
		btnFlecheAvant.setIcon(null);
		GridBagConstraints gbc_btnFlecheAvant = new GridBagConstraints();
		gbc_btnFlecheAvant.anchor = GridBagConstraints.EAST;
		gbc_btnFlecheAvant.weightx = 1.0;
		gbc_btnFlecheAvant.gridx = 2;
		gbc_btnFlecheAvant.gridy = 0;
		pSud.add(btnFlecheAvant, gbc_btnFlecheAvant);
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
