package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouvelleListeMateriel;
import modele.Materiel;

public class VueNouvelleListeMateriel extends JPanel{
	
	private JFrame fen;
	
	private JTable tabMaterielDisponible; 
	private String titreMaterielDisponible [] = {"Matériel Disponible"};
	private String [][] listeMaterielDisponible = {
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
			{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
	};
	private JTable tabMaterielAssigne; 
	private String titreMaterielAssigne [] = {"Matériel Assigné"};
	private String [][] listeMaterielAssigne = {
			{""},
			{""},
			{""},
			{""},
			{""},
			{""}
	};
	private JButton btDegaucheVersDroite;
	private JButton btDeDroiteVersGauche;
	private JButton btAnnuler;
	private JButton btValider;
	
	public VueNouvelleListeMateriel(List<String> listeTotaleMateriel) {
		this.fen = new JFrame();
		this.fen.setTitle("Affectation de matériel à une tache");
		this.fen.setLayout(new GridLayout(1,1));
		//this.fen.addWindowListener(new ControleurNouvelleListeMateriel(this));
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());	

		ControleurNouvelleListeMateriel controleur = new ControleurNouvelleListeMateriel(this);

		JPanel pMaterielDisponible = new JPanel();
		this.add(pMaterielDisponible, BorderLayout.WEST);
		this.tabMaterielDisponible = new JTable(new TabAssignationModele(this.titreMaterielDisponible, this.listeMaterielDisponible));
		this.tabMaterielDisponible.setPreferredScrollableViewportSize(new Dimension(250,620)); 
		pMaterielDisponible.add(new JScrollPane(this.tabMaterielDisponible));
		
		JPanel pboutonsAssignation = new JPanel();
		this.add(pboutonsAssignation, BorderLayout.CENTER);
		pboutonsAssignation.setLayout(new GridLayout(2, 1, 70, 170));	
		this.btDegaucheVersDroite = new JButton(">>");
		this.btDegaucheVersDroite.setPreferredSize(new Dimension(10, 15));
		this.btDegaucheVersDroite.setMaximumSize(new Dimension(30, 30));
		//this.btMatDispoVersAssigne.setIcon(new ImageIcon("./src/vue/contact.png"));
		pboutonsAssignation.add(this.btDegaucheVersDroite);		
		this.btDeDroiteVersGauche = new JButton("<<");
		this.btDeDroiteVersGauche.setPreferredSize(new Dimension(10, 15));
		//this.btMatAssigneVersDispo.setIcon(new ImageIcon("./src/vue/materiel.png"));
		pboutonsAssignation.add(this.btDeDroiteVersGauche);
		
		
		JPanel pMaterielAssigne = new JPanel();
		this.add(pMaterielAssigne, BorderLayout.EAST);
		this.tabMaterielAssigne = new JTable(new TabAssignationModele(this.titreMaterielAssigne, this.listeMaterielAssigne));
		this.tabMaterielAssigne.setPreferredScrollableViewportSize(new Dimension(250,620)); 
		pMaterielAssigne.add(new JScrollPane(this.tabMaterielAssigne));
		
		JPanel pboutonsAnnulerValider = new JPanel();
		this.add(pboutonsAnnulerValider, BorderLayout.SOUTH);
		pboutonsAnnulerValider.setLayout(new GridLayout(1,2,150,0));
		pboutonsAnnulerValider.setBorder(new EmptyBorder(30,100,30,100));
		this.btAnnuler = new JButton("annuler");
		this.btAnnuler.setPreferredSize(new Dimension(80,40));
		this.btValider = new JButton("valider");
		pboutonsAnnulerValider.add(this.btAnnuler);
		pboutonsAnnulerValider.add(this.btValider);		
		//this.btAnnuler.addActionListener(controleur);
	//	this.btValider.addActionListener(controleur);
		
		//génération de la fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(700, 800);
		this.fen.setResizable(true);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);		
		
		
		
		
		
	}
	
	
}
