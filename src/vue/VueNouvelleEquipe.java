package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouvelleEquipe;
import controleur.ControleurNouvelleListeMateriel;

public class VueNouvelleEquipe extends JPanel {		
		private JFrame fen;
		
		private JTable tablisteBenevoles; 
		private String titreBenevoles [] = {"Liste des Bénévoles"};
		private String [][] listeBenevoles = {
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
				{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},
		};
		private JTable tabEquipe; 
		private String titreEquipe [] = {"Equipe"};
		private String [][] donneesEquipe = {
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
		
		public VueNouvelleEquipe(List<String> listeTotaleContacts) {
			this.fen = new JFrame();
			this.fen.setTitle("Constitution d'une équipe");
			this.fen.setLayout(new GridLayout(1,1));
			//this.fen.addWindowListener(new ControleurNouvelleListeMateriel(this));
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());	

			ControleurNouvelleEquipe controleur = new ControleurNouvelleEquipe(this);

			JPanel pBenevoles = new JPanel();
			this.add(pBenevoles, BorderLayout.WEST);
			this.tablisteBenevoles = new JTable(new TabAssignationModele(this.titreBenevoles, this.listeBenevoles));
			this.tablisteBenevoles.setPreferredScrollableViewportSize(new Dimension(250,620)); 
			pBenevoles.add(new JScrollPane(this.tablisteBenevoles));
			
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
			this.tabEquipe = new JTable(new TabAssignationModele(this.titreEquipe, this.donneesEquipe));
			this.tabEquipe.setPreferredScrollableViewportSize(new Dimension(250,620)); 
			pMaterielAssigne.add(new JScrollPane(this.tabEquipe));
			
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


