package vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;

public class VueNouvelleCourse extends JPanel {
	public VueNouvelleCourse() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		//northPanel
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setBorder(new EmptyBorder(10,20,10,20));
		northPanel.add(new JLabel("Titre de la course"));
		JTextField titre = new JTextField();
		titre.setPreferredSize(new Dimension(500,30));
		northPanel.add(titre);
		
		//centerPanel
		this.add(centerPanel,BorderLayout.CENTER);
		JPanel spGauche = new JPanel();
		JPanel spDroite = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spGauche, spDroite);
		centerPanel.add(sp);
		sp.setPreferredSize(new Dimension(650,370)); // édition de la dimension du JSplitPane
		sp.setOneTouchExpandable(true); //permet de faire glisser le séparateur avec la souris
		sp.setDividerLocation(270); //définir la position du séprarateur
		//sp.setBorder(BorderFactory.createEmptyBorder()); //effacer les bordures noires moches
		sp.setBorder(new EmptyBorder(10,20,10,20));

		//à  Gauche du séparateur
		spGauche.setLayout(new BorderLayout());
		//panneau 1 
		JPanel p1G = new JPanel();
		spGauche.add(p1G, BorderLayout.NORTH);		
		p1G.setLayout(new GridLayout(4,2));
		p1G.add(new JLabel("Date"));
		p1G.add(new JTextField(""));
		p1G.add(new JLabel("Durée"));
		p1G.add(new JTextField(""));
		p1G.add(new JLabel("Budget"));
		p1G.add(new JTextField(""));
		p1G.add(new JLabel("Nb de participants"));
		p1G.add(new JTextField(""));
		//panneau 2
		JPanel p2Ggrille = new JPanel();
		spGauche.add(p2Ggrille, BorderLayout.SOUTH);
		p2Ggrille.setLayout(new GridLayout(1,1));
		JPanel p2G = new JPanel();
		p2G.setLayout(new BorderLayout());
		p2Ggrille.add(p2G);
		//Etiquette Descriptiion
		JLabel descriptionlb = new JLabel("Notes"); 
		descriptionlb.setBorder(new EmptyBorder(0,0,5,0)); //positionnement du JLabel par rapport au JtextArea
		p2G.add(descriptionlb, BorderLayout.NORTH);
		//Text Area Description
		JScrollPane textSP = new JScrollPane(new JTextArea(10,10));
		textSP.setPreferredSize(new Dimension(170,170));
		p2G.add(textSP, BorderLayout.SOUTH);
		//à  Droite du séparateur
		spDroite.setMinimumSize(new Dimension(400,400));
		spDroite.setLayout(new BorderLayout());
		//panneau1
		JPanel p1D = new JPanel();
		spDroite.add(p1D, BorderLayout.NORTH);
		p1D.setBorder(new EmptyBorder(0,20,0,0));
		p1D.setLayout(new GridLayout(3,2));
		p1D.add(new JLabel("Agrément FFTri"));
		p1D.add(new JCheckBox());
		p1D.add(new JLabel("Nom de l'événement"));
		p1D.add(new JTextField(""));
		p1D.add(new JLabel("Format du triathlon"));
		String [] formatExemples = {
				"Equipe relais (4X)",
				"Distance super sprint",
				"Distance sprint",
				"Distance standard",
				"Moyenne distance",
				"Longue distance"};
		JComboBox<String> formatListEx = new JComboBox<String>(formatExemples);
		formatListEx.setEditable(true);
		p1D.add(formatListEx);
		//panneau 2
		JPanel p2Dgrille = new JPanel();
		spDroite.add(p2Dgrille, BorderLayout.SOUTH);
		p2Dgrille.setLayout(new GridLayout(1,1));
		JPanel p2D = new JPanel();
		p2D.setLayout(new BorderLayout());
		p2Dgrille.add(p2D);
		//Etiquette Parcours
		JLabel parcourslb = new JLabel("Parcours du triathlon");
		parcourslb.setBorder(new EmptyBorder(0,0,5,0)); //positionnement du JLabel par rapport au Jtable
		p2D.add(parcourslb, BorderLayout.NORTH);	
		p2D.setBorder(new EmptyBorder(0,20,0,0));
		//Tableau parcours
		String titresColonnes []  = {" ", "Distance (m)","Ville étape","Code Postal"};
		
		Object[][] donneesParcours = {
				{"Départ","","",""},
				{ "Natation","","",""},
				{"Cyclisme","","",""},
				{"Course à  pied","","",""},
				{"Arrivée","","",""}
		};
		JTable parcoursTab = new JTable(donneesParcours, titresColonnes);
		parcoursTab.setRowHeight(30);
		JScrollPane tabSP = new JScrollPane(parcoursTab);
		tabSP.setPreferredSize(new Dimension(150,170));
		p2D.add(tabSP, BorderLayout.SOUTH);
		
		//southPanel
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1,2,150,0));
		southPanel.setBorder(new EmptyBorder(30,100,30,100));
		JButton annuler = new JButton("annuler");
		annuler.setPreferredSize(new Dimension(40,40));
		southPanel.add(annuler);
		JButton valider = new JButton("valider");
		southPanel.add(valider);
		
		
		
		
	}

}
