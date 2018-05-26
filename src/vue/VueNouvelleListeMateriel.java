package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		
		public VueNouvelleListeMateriel(List<String> listeMaterielDisponible) {
			this.fen = new JFrame();
			this.fen.setTitle("Affectation de matériel à une tache");
			this.fen.setLayout(new GridLayout(1,1));
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());	
			//ControleurNouvelleListeMateriel controleur = new ControleurNouvelleListeMateriel(this);
			JPanel pMaterielDisponible = new JPanel();
			this.add(pMaterielDisponible, BorderLayout.WEST);
			
			this.ltMaterielDisponibleModel = new DefaultListModel<String>();
			for (String libelleMateriel : listeMaterielDisponible) {
				this.ltMaterielDisponibleModel.addElement(libelleMateriel);
			}
			
			this.ltMaterielDisponible = new JList<String>(this.ltMaterielDisponibleModel);
			this.ltMaterielDisponible.setSelectedIndex(0); //sélectionne le premier item
			//this.listeMaterielDisponible.addListSelectionListener(this);
			pMaterielDisponible.add( new JScrollPane(this.ltMaterielDisponible));
			
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
			
			this.ltMaterielDisponibleModel = new DefaultListModel<String>();
			for (String libelleMateriel : listeMaterielDisponible) {
				this.ltMaterielDisponibleModel.addElement(libelleMateriel);
			}
			
			JPanel pMaterielAssigne = new JPanel();
			this.add(pMaterielAssigne, BorderLayout.EAST);
			this.ltMaterielAssigne = new JList<String>(this.ltMaterielAssigneModel);
			this.ltMaterielAssigne.setSelectedIndex(0); //sélectionne le premier item
			//this.listeMaterielDisponible.addListSelectionListener(this);
			pMaterielAssigne.add(new JScrollPane(this.ltMaterielAssigne));
			
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

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
