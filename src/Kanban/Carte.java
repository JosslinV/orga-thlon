package Kanban;

import javax.swing.JPanel;

import rocher.ResizableImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Carte extends JPanel{
	private JLabel lblTitre;
	
	public Carte(String texte) {
	
		setBackground(SystemColor.activeCaptionBorder);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		/*File a = new File("");
		System.out.println(a.getAbsolutePath()+"\\Kanban\\Data-Edit-128.png");*/
		JButton btnSupprimer = new JButton();
		btnSupprimer.setSelectedIcon(new ImageIcon(Carte.class.getResource("/Kanban/Garbage-Full-128.png")));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.anchor = GridBagConstraints.WEST;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 0;
		gbc_btnSupprimer.gridy = 0;
		add(btnSupprimer, gbc_btnSupprimer);
		
		JButton btnPause = new JButton("Pause");
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.anchor = GridBagConstraints.EAST;
		gbc_btnPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPause.gridx = 1;
		gbc_btnPause.gridy = 0;
		add(btnPause, gbc_btnPause);
		
		JButton btnEditer = new JButton("Editer");
		btnEditer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditer.anchor = GridBagConstraints.EAST;
		gbc_btnEditer.gridx = 2;
		gbc_btnEditer.gridy = 0;
		add(btnEditer, gbc_btnEditer);
		
		lblTitre= new JLabel(texte);
		GridBagConstraints gbc_lblDescriptiontitre = new GridBagConstraints();
		gbc_lblDescriptiontitre.gridwidth = 3;
		gbc_lblDescriptiontitre.gridx = 0;
		gbc_lblDescriptiontitre.gridy = 1;
		add(lblTitre, gbc_lblDescriptiontitre);
	}
	
	public void setTitre(String titre) {
		lblTitre.setText(titre);
	}

}
