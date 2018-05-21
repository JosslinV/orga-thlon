package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouveauMateriel;
import modele.Materiel;

public class VueNouveauMateriel extends JPanel {
	
	protected JLabel auteur;
	private JLabel dateCreation;
	private JTextField libelle;
	private JLabel stockInit;
	private JSpinner quantite;
	private JLabel stockFin;
	private JTextArea description;
	private JSpinner quantiteAllouee;
	private JFrame fen;
	
	
	
	public VueNouveauMateriel() {
		
		this.fen = new JFrame();
		this.fen.setTitle("création d'une nouvelle fiche MATERIEL");
		this.fen.setLayout(new GridLayout(1,1));
		
		ControleurNouveauMateriel contr = new ControleurNouveauMateriel(this);
		
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(); 
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setBorder(new EmptyBorder(10,20,0,20));
		northPanel.setLayout(new GridLayout(7,2));
		this.auteur = new JLabel("Créée par ... ");
		northPanel.add(this.auteur);
		northPanel.add(this.dateCreation = new JLabel("le ../../...."));
		northPanel.add(new JLabel("Libellé"));
		northPanel.add(this.libelle = new JTextField("",JTextField.LEFT));
		northPanel.add(new JLabel("Stock initial"));
		northPanel.add(this.stockInit = new JLabel("?"));	
		northPanel.add(new JLabel("Quantité ajoutée"));
		northPanel.add(this.quantite = new JSpinner());
		northPanel.add(new JLabel("Stock final"));
		northPanel.add(this.stockFin = new JLabel("?"));
		
		//panneau au centre
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setBorder(new EmptyBorder(0,20,10,20));
		centerPanel.setLayout(new GridLayout(2,1));
		JPanel pGrille1 = new JPanel();
		centerPanel.add(pGrille1);
		pGrille1.setLayout(new GridLayout(1,1));
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		pGrille1.add(p1);
		
		//zone de description
		//Etiquette description
		JLabel lbdescription = new JLabel("Description");
		lbdescription.setBorder(new EmptyBorder(0,0,5,0));
		p1.add(lbdescription, BorderLayout.NORTH);
		
		//TextArea description
		JScrollPane textSP = new JScrollPane(this.description = new JTextArea());
		textSP.setPreferredSize(new Dimension(100,100));
		p1.add(textSP, BorderLayout.CENTER);
		
		//zone tableau Matériel-Tâche-Bénévole
		JPanel pGrille = new JPanel();
		centerPanel.add(pGrille);
		pGrille.setLayout(new GridLayout(1,1));
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		pGrille.add(p2);
		
		//Etiquette quantité allouée
		JPanel pquantiteAllouee = new JPanel();
		p2.add(pquantiteAllouee, BorderLayout.NORTH);
		pquantiteAllouee.setLayout(new GridLayout(1,2));
		JLabel lbquantiteAllouee = new JLabel("Quantité allouée totale: ");
		pquantiteAllouee.add(lbquantiteAllouee);
		pquantiteAllouee.add(this.quantiteAllouee = new JSpinner());
		
		//tableau MTB
		String titresColonnes [] = {"Bénévole","Tâche","Quantité","Date prêt"};
		
		String [][] donneesMTB = {
				{"","","",""},
				{"","","",""},
				{"","","",""}
		};
		JTable tabMTB = new JTable(donneesMTB, titresColonnes);
		JScrollPane tabMTBSP = new JScrollPane(tabMTB);
		tabMTBSP.setPreferredSize(new Dimension(100,70));
		p2.add(tabMTBSP, BorderLayout.SOUTH);		


		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setBorder(new EmptyBorder(10,15,10,15));
		southPanel.setLayout(new GridLayout(1,2,30,0));
		
		JButton BTannuler = new JButton("Annuler");
		southPanel.add(BTannuler);
		BTannuler.addActionListener(contr);
		
		JButton BTvalider = new JButton("Valider");
		southPanel.add(BTvalider);
		BTvalider.addActionListener(contr);
		
		//génération de la fenêtre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(320, 510);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);	
	
	}

	public void afficherDonnees(Materiel modele) {
		this.libelle.setText(modele.getLibelle());
		this.description.setText(modele.getDescription());
		this.stockInit.setText(Double.toString(modele.getStock()));
		//this.stockFin.setText(Double.toString(modele.getStock() + new Double(this.quantite.getValue()).doubleValue()));

	}
	
	public Materiel rassemblerDonnees() {
		if(!this.libelle.getText().isEmpty()) {
			Materiel materiel = new Materiel(this.libelle.getText());
			materiel.setDescription(this.description.getText());
			//materiel.setStock(Double.parseDouble(this.stockFin.getText()));
			return materiel;
		} else {
			this.libelle.setBackground(Color.RED);
		}
		return null;
	}
	
	public void rendreIndisponible() {
		this.libelle.setEnabled(false);
		this.quantite.setEnabled(false);
		this.description.setEnabled(false);
		this.quantiteAllouee.setEnabled(false);
	}
	
	public void rendreDisponible() {
		this.libelle.setEnabled(true);
		this.quantite.setEnabled(true);
		this.description.setEnabled(true);
		this.quantiteAllouee.setEnabled(true);
	}


}
