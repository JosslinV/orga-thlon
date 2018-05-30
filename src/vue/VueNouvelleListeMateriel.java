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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.ControleurNouvelleListeMateriel;

public class VueNouvelleListeMateriel extends JPanel implements ListSelectionListener {
	
		private JFrame fen;
		
		private JList<String> ltMaterielDisponible;
		private DefaultListModel<String> ltMaterielDisponibleModel;
		private JList<String> ltMaterielAssigne;
		private DefaultListModel<String> ltMaterielAssigneModel;		
		private JButton btDegaucheVersDroite;
		private JButton btDeDroiteVersGauche;
		private JButton btAnnuler;
		private JButton btValider;
		
		public VueNouvelleListeMateriel(List<String> listeMaterielDisponible) throws Exception {
			ControleurNouvelleListeMateriel controleur = new ControleurNouvelleListeMateriel(this);
			this.fen = new JFrame();
			this.fen.setTitle("Affectation de matériel à une tache");
			this.fen.setLayout(new GridLayout(1,1));
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());	
			
			JPanel pMaterielDisponible = new JPanel();
			pMaterielDisponible.setLayout(new BorderLayout());
			this.add(pMaterielDisponible, BorderLayout.WEST);
			pMaterielDisponible.add(new JLabel("Matériel Disponible", JLabel.CENTER), BorderLayout.NORTH);
			this.ltMaterielDisponibleModel = new DefaultListModel<String>();
			for (String libelleMateriel : listeMaterielDisponible) {
				this.ltMaterielDisponibleModel.addElement(libelleMateriel);
			}
			
			this.ltMaterielDisponible = new JList<String>(this.ltMaterielDisponibleModel);
			this.ltMaterielDisponible.setSelectedIndex(0); //sélectionne le premier item
			this.ltMaterielDisponible.setPreferredSize(new Dimension(150,820));
			//this.ltMaterielDisponible.addListSelectionListener(this);
			JScrollPane spMaterielDisponible = new JScrollPane(this.ltMaterielDisponible);
			spMaterielDisponible.setPreferredSize(new Dimension(220, 550));
			pMaterielDisponible.add(spMaterielDisponible);
			
			JPanel pboutonsAssignation = new JPanel();
			this.add(pboutonsAssignation, BorderLayout.CENTER);
			pboutonsAssignation.setLayout(new GridBagLayout());	
			GridBagConstraints c = new GridBagConstraints();
			c.insets =  new Insets(10,10,10,10);
			c.gridx = 0;
			c.gridy = 0;
			this.btDegaucheVersDroite = new JButton(">>");
			this.btDegaucheVersDroite.addActionListener(controleur);
			//this.btMatDispoVersAssigne.setIcon(new ImageIcon("./src/vue/contact.png"));
			pboutonsAssignation.add(this.btDegaucheVersDroite, c);	
			c.gridx = 0;
			c.gridy = 1;
			this.btDeDroiteVersGauche = new JButton("<<");
			//this.btMatAssigneVersDispo.setIcon(new ImageIcon("./src/vue/materiel.png"));
			pboutonsAssignation.add(this.btDeDroiteVersGauche, c);
			
			this.ltMaterielDisponibleModel = new DefaultListModel<String>();
			for (String libelleMateriel : listeMaterielDisponible) {
				this.ltMaterielDisponibleModel.addElement(libelleMateriel);
			}
			
			JPanel pMaterielAssigne = new JPanel();  
			pMaterielAssigne.setLayout(new BorderLayout());
			this.add(pMaterielAssigne, BorderLayout.EAST);
			pMaterielAssigne.add(new JLabel("Matériel Assigné", JLabel.CENTER), BorderLayout.NORTH);
			this.ltMaterielAssigneModel = new DefaultListModel<String>();
			this.ltMaterielAssigne = new JList<String>(this.ltMaterielAssigneModel); // controleur récupérer liste de droite si elle est pas vide 
			this.ltMaterielAssigne.setSelectedIndex(0); //sélectionne le premier item
			this.ltMaterielAssigne.setPreferredSize(new Dimension(150,820));
			//this.listeMaterielDisponible.addListSelectionListener(this);
			JScrollPane spMaterielAssigne = new JScrollPane(this.ltMaterielAssigne);
			spMaterielAssigne.setPreferredSize(new Dimension(220, 550));
			pMaterielAssigne.add(spMaterielAssigne);
			
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
		
		
		

		public JList<String> getLtMaterielDisponible() {
			return ltMaterielDisponible;
		}




		public void setLtMaterielDisponible(JList<String> ltMaterielDisponible) {
			this.ltMaterielDisponible = ltMaterielDisponible;
		}




		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void ajouterLigne(String s) {
			
			this.ltMaterielAssigneModel.addElement(s);
			this.ltMaterielAssigne = new JList<String>(this.ltMaterielAssigneModel);
		}
		
}
