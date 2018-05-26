package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class VueNouvelleEquipe extends JPanel {		
		private JFrame fen;
		
		private JList<String> ltBenevoles;
		private DefaultListModel<String> ltBenevolesModel;
		private JList<String> ltEquipe;
		private DefaultListModel<String> ltEquipeModel;
		private JButton btDegaucheVersDroite;
		private JButton btDeDroiteVersGauche;
		private JButton btAnnuler;
		private JButton btValider;
		
		public VueNouvelleEquipe(List<String> listeBenevoles) {
			this.fen = new JFrame();
			this.fen.setTitle("Constitution d'une équipe");
			this.fen.setLayout(new GridLayout(1,1));
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());	
			//ControleurNouvelleEquipe controleur = new ControleurNouvelleEquipe(this);
			JPanel pBenevoles = new JPanel();
			pBenevoles.setLayout(new BorderLayout());
			this.add(pBenevoles, BorderLayout.WEST);
			pBenevoles.add(new JLabel("Bénévoles", JLabel.CENTER), BorderLayout.NORTH);
			this.ltBenevolesModel = new DefaultListModel<String>();
			for (String benevoleStr : listeBenevoles) {
				this.ltBenevolesModel.addElement(benevoleStr);
			}
			this.ltBenevoles = new JList<String>(this.ltBenevolesModel);
			this.ltBenevoles.setSelectedIndex(0); //sélectionne le premier item
			this.ltBenevoles.setPreferredSize(new Dimension(150,820));
			//this.listeMaterielDisponible.addListSelectionListener(this);
			JScrollPane spBenevole = new JScrollPane(this.ltBenevoles);
			spBenevole.setPreferredSize(new Dimension(220, 550));
			pBenevoles.add(spBenevole);
			
			JPanel pboutonsAssignation = new JPanel();
			this.add(pboutonsAssignation, BorderLayout.CENTER);
			pboutonsAssignation.setLayout(new GridBagLayout());	
			GridBagConstraints c = new GridBagConstraints();
			c.insets =  new Insets(10,10,10,10);
			c.gridx = 0;
			c.gridy = 0;
			this.btDegaucheVersDroite = new JButton(">>");
			//this.btMatDispoVersAssigne.setIcon(new ImageIcon("./src/vue/contact.png"));
			pboutonsAssignation.add(this.btDegaucheVersDroite, c);	
			c.gridx = 0;
			c.gridy = 1;
			this.btDeDroiteVersGauche = new JButton("<<");
			//this.btMatAssigneVersDispo.setIcon(new ImageIcon("./src/vue/materiel.png"));
			pboutonsAssignation.add(this.btDeDroiteVersGauche, c);
			
			JPanel pEquipe = new JPanel();
			pEquipe.setLayout(new BorderLayout());
			this.add(pEquipe, BorderLayout.EAST);
			pEquipe.add(new JLabel("Equipe", JLabel.CENTER), BorderLayout.NORTH);
			this.ltEquipeModel = new DefaultListModel<String>();
			this.ltEquipe = new JList<String>(this.ltEquipeModel);
			this.ltEquipe.setSelectedIndex(0); //sélectionne le premier item
			this.ltEquipe.setPreferredSize(new Dimension(150,820));
			//this.listeMaterielDisponible.addListSelectionListener(this);
			JScrollPane spEquipe = new JScrollPane(this.ltEquipe);
			spEquipe.setPreferredSize(new Dimension(220, 550));
			pEquipe.add(spEquipe);
			
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
			this.fen.setSize(600, 750);
			this.fen.setResizable(true);
			this.fen.setVisible(true);
			this.fen.setLocationRelativeTo(null);		
		}
		
		
	}


