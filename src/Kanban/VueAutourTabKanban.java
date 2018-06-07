package Kanban;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import controleur.ControleurAutourTableauKanban;
import controleur.ControleurNouvelleTache;
import vue.VueAccueil2;

import java.awt.Insets;

public class VueAutourTabKanban extends JPanel {
	private JPanel panelLabel = new JPanel();
	private JPanel bandeauHaut= new JPanel();
	private JButton nouvelleCourse=new JButton("Nouvelle Course");
	
	
	public VueAutourTabKanban() throws Exception{
		ControleurAutourTableauKanban controleur = new ControleurAutourTableauKanban(this);
		setLayout(new BorderLayout(0, 0));
		this.add(bandeauHaut,BorderLayout.NORTH);
		bandeauHaut.setLayout(new GridLayout(1,2));
		bandeauHaut.add(new JScrollPane(panelLabel));
		bandeauHaut.add(nouvelleCourse);
		this.nouvelleCourse.addActionListener(controleur);
		nouvelleCourse.setPreferredSize(new Dimension(50,50));
		//this.add(new JScrollPane(panelLabel),BorderLayout.NORTH);
		//panelLabel.setPreferredSize(new Dimension(50,250));
		GridBagLayout gbl_panelLabel = new GridBagLayout();
		gbl_panelLabel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelLabel.rowHeights = new int[]{0, 0, 0};
		gbl_panelLabel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelLabel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelLabel.setLayout(gbl_panelLabel);
		
		JLabel lblDateDebut = new JLabel("date debut: 05/05/05");
		lblDateDebut.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblDateDebut = new GridBagConstraints();
		gbc_lblDateDebut.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateDebut.gridx = 0;
		gbc_lblDateDebut.gridy = 0;
		panelLabel.add(lblDateDebut, gbc_lblDateDebut);
		
		JLabel lblDateFIn = new JLabel("Date fin : 05/8/46");
		lblDateFIn.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDateFIn = new GridBagConstraints();
		gbc_lblDateFIn.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateFIn.gridx = 1;
		gbc_lblDateFIn.gridy = 0;
		panelLabel.add(lblDateFIn, gbc_lblDateFIn);
		
		JLabel lblNomEpreuve = new JLabel("Epreuve : epreuve");
		lblNomEpreuve.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblNomEpreuve = new GridBagConstraints();
		gbc_lblNomEpreuve.insets = new Insets(0, 0, 0, 5);
		gbc_lblNomEpreuve.gridx = 0;
		gbc_lblNomEpreuve.gridy = 1;
		panelLabel.add(lblNomEpreuve, gbc_lblNomEpreuve);
		
		JLabel lblAuteur = new JLabel("Cr\u00E9er par : Thierry Beltran");
		lblAuteur.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblAuteur = new GridBagConstraints();
		gbc_lblAuteur.gridx = 1;
		gbc_lblAuteur.gridy = 1;
		panelLabel.add(lblAuteur, gbc_lblAuteur);
		ModeleKanban f = new ModeleKanban(); //à supprimer dès création de la map dans le modelKanban 
		this.add(new JScrollPane(new VueKanban(f.getCartes())),BorderLayout.CENTER);
	}

	
	
}
