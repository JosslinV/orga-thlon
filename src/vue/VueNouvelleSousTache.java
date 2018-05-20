package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouvelleSousTache;
import controleur.ControleurNouvelleTache;

public class VueNouvelleSousTache extends JPanel {
	private int Id_ssTache;
	private JTextField tfLibelleSsTache;
	private JCheckBox cbSSTacheCompletee;
	private JTextArea taCommentaire;
	private JButton BTannuler;
	private JButton BTvalider;
	private JSlider slAvancementSousTache;
	private JTextField tfEtatAvancement;

	public VueNouvelleSousTache() {
		ControleurNouvelleSousTache controleur = new ControleurNouvelleSousTache(this);
		this.setBorder(new EmptyBorder(5,20,5,20));
		this.setLayout(new GridBagLayout());
		GridBagConstraints cNord = new GridBagConstraints();
		
		cNord.gridx = 0;
		cNord.gridy = 0;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(new JLabel("Titre"), cNord);
		
		this.tfLibelleSsTache = new JTextField();
		this.tfLibelleSsTache.setMinimumSize(new Dimension(70,20));
		this.tfLibelleSsTache.setColumns(50);
		cNord.gridx = 1;
		cNord.gridy = 0;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfLibelleSsTache);
		
		cNord.gridx = 0;
		cNord.gridy = 1;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(new JLabel("Sous-Tache Complétée"), cNord );
		
		this.cbSSTacheCompletee = new JCheckBox();
		cNord.gridx = 1;
		cNord.gridy = 1;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(this.cbSSTacheCompletee, cNord );
		
		JPanel pEtatAvancement = new JPanel();
		pEtatAvancement.setLayout(new FlowLayout());
		JLabel lbEtatAvancement = new JLabel("Etat d'avancement");
		lbEtatAvancement.setPreferredSize(new Dimension(150, 25));
		pEtatAvancement.add(lbEtatAvancement);			
		this.slAvancementSousTache = new JSlider();
		this.slAvancementSousTache.setMinimumSize(new Dimension(190, 26));
		this.slAvancementSousTache.setMaximum(200);
		this.slAvancementSousTache.setMaximumSize(new Dimension(200, 26));
		pEtatAvancement.add(this.slAvancementSousTache);				
		this.tfEtatAvancement = new JTextField();
		this.tfEtatAvancement.setColumns(3);
		this.tfEtatAvancement.setEditable(false);
		pEtatAvancement.add(this.tfEtatAvancement);			
		JLabel lbPourcent = new JLabel("%");
		lbPourcent.setPreferredSize(new Dimension(20, 20));
		pEtatAvancement.add(lbPourcent);
		cNord.gridx = 0;
		cNord.gridy = 3;
		cNord.gridwidth = 2;
		cNord.insets = new Insets(5, 0, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(pEtatAvancement, cNord);
		
		cNord.gridx = 0;
		cNord.gridy = 4;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.add(new JLabel("Notes"), cNord );

		cNord.gridx = 0;
		cNord.gridy = 5;
		cNord.gridheight = 2;
		cNord.gridwidth = 2;
		cNord.insets = new Insets(5, 5, 5, 5);
		cNord.anchor = GridBagConstraints.LINE_START;
		this.taCommentaire = new JTextArea();
		this.taCommentaire.setColumns(20);
		this.taCommentaire.setRows(10);
		cNord.fill = GridBagConstraints.BOTH;
		JScrollPane textSP = new JScrollPane(this.taCommentaire);
		textSP.setPreferredSize(new Dimension(15,60));
		this.add(textSP, cNord);
		
		JPanel pbtES = new JPanel(); 
		pbtES.setLayout(new GridLayout(1,2,150,0));
		pbtES.setPreferredSize(new Dimension(50,50));
		cNord.gridheight = 2;
		cNord.gridwidth = 2;
		cNord.fill = GridBagConstraints.BOTH;
		cNord.gridx = 0;
		cNord.gridy = 7;
		this.add(pbtES, cNord);

		
		this.BTannuler = new JButton("Annuler");
		this.BTannuler.setPreferredSize(new Dimension(30,10));
		pbtES.add(this.BTannuler);
		
		this.BTvalider = new JButton("Valider");
		pbtES.add(this.BTvalider);

		//BTannuler.addActionListener(controleur);
		//BTvalider.addActionListener(controleur);
	
	}
	
	
	public boolean estTacheCompleteeManuellement() {
			return (this.slAvancementSousTache.getValue() == 100 );	
	}
	/*
	public int getId_Tache() {
		return id_Tache;
	}


	public void setId_Tache(int id_Tache) {
		this.id_Tache = id_Tache;
	}


	public void setTfLibelle(JTextField tfLibelle) {
		this.tfLibelle = tfLibelle;
	}
*/

	public int getEtatAvancementSsTache() {
		return slAvancementSousTache.getValue();
	}


	public boolean estSsTacheCompletee() {
		return this.estSsTacheCompletee();
	}


	public void afficherEtatAvancement() {
		this.tfEtatAvancement.setText(String.valueOf(this.slAvancementSousTache.getValue()));
	}

	public int getId_ssTache() {
		return Id_ssTache;
	}

	public void setId_ssTache(int id_ssTache) {
		Id_ssTache = id_ssTache;
	}


	public void setActifComposants(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void modifierTexteBoutonsPourEdition(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public Object getDonneesSSTache() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
