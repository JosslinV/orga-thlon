package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controleur.ControleurNouveauMateriel;
import modele.Course;
import modele.Materiel;
import vue.Vue_nouvelleTache.TabModele;

public class VueNouveauMateriel extends JPanel {
	
	protected JLabel auteur;
	private JLabel dateCreation;
	private JTextField libelle;
	private JLabel stockInit;
	private JSpinner quantite;
	private JLabel stockFin;
	private JTextArea description;
	private JSpinner quantiteAllouee;
	private JTable tabMTB;
	private JFrame fen;	
	
	private String titresColonnes [] = {"B�n�vole","T�che","Quantit�","Date pr�t"};
	
	private String [][] donneesMTB = {
			{"","","",""},
			{"","","",""},
			{"","","",""},
			{"","","",""},
			{"","","",""},
			{"","","",""}
	};
	private int idMateriel;
	
	
	
	public VueNouveauMateriel(Course course) {
		this.fen = new JFrame();
		this.fen.setTitle("Nouvelle Fiche Mat�riel");
		this.fen.setLayout(new GridLayout(1,1));
		
		//this.fen.addWindowListener(new ControleurFenetreMateriel(this));
		
		ControleurNouveauMateriel contr = new ControleurNouveauMateriel(this);
		
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(); 
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setBorder(new EmptyBorder(10,20,0,20));
		northPanel.setLayout(new GridLayout(7,2));
		this.auteur = new JLabel("Course cr��e par ");
		northPanel.add(this.auteur);
		northPanel.add(new JLabel(course.getAuteurCourse()));
		northPanel.add(new JLabel("Libell�"));
		northPanel.add(this.libelle = new JTextField("",JTextField.LEFT));
		northPanel.add(new JLabel("Stock initial"));
		northPanel.add(this.stockInit = new JLabel("?"));	
		northPanel.add(new JLabel("Quantit� ajout�e"));
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
		
		//zone tableau Mat�riel-T�che-B�n�vole
		JPanel pGrille = new JPanel();
		centerPanel.add(pGrille);
		pGrille.setLayout(new GridLayout(1,1));
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		pGrille.add(p2);
		
		//Etiquette quantit� allou�e
		JPanel pquantiteAllouee = new JPanel();
		p2.add(pquantiteAllouee, BorderLayout.NORTH);
		pquantiteAllouee.setLayout(new GridLayout(1,2));
		JLabel lbquantiteAllouee = new JLabel("Quantit� allou�e totale: ");
		pquantiteAllouee.add(lbquantiteAllouee);
		pquantiteAllouee.add(this.quantiteAllouee = new JSpinner());
		
		//tableau MTB
		
		/*
		this.tabMTB = new JTable(new TabModele(this.titresColonnes, this.donneesMTB));
		this.tabMTB.setPreferredScrollableViewportSize(new Dimension(100,70)); 
		p2.add(new JScrollPane(this.tabMTB), BorderLayout.SOUTH);
*/
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setBorder(new EmptyBorder(10,15,10,15));
		southPanel.setLayout(new GridLayout(1,2,30,0));
		
		JButton BTannuler = new JButton("Annuler");
		southPanel.add(BTannuler);
		BTannuler.addActionListener(contr);
		
		JButton BTvalider = new JButton("Valider");
		southPanel.add(BTvalider);
		BTvalider.addActionListener(contr);
		
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(500, 400);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
	
	}

	public void afficherDonnees(int id, String libelle, String description, Double stockInit) {
		this.idMateriel = id;
		this.libelle.setText(libelle);
		this.description.setText(description);
		this.stockInit.setText(Double.toString(stockInit));
		//this.stockFin.setText(Double.toString(modele.getStock() + new Double(this.quantite.getValue()).doubleValue()));

	}
	
	public Map<String,Object> rassemblerDonnees() {
		if(!this.libelle.getText().isEmpty()) {
			HashMap<String,Object> donnees = new HashMap<String, Object>();
			donnees.put("id_Materiel", this.idMateriel);
			donnees.put("libelle_mat", this.libelle.getText());
			donnees.put("stock",this.stockInit.getText());
			donnees.put("description_mat",this.description.getText());
			return donnees;
		} else {
			this.libelle.setBackground(Color.RED);
		}
		return null;
	}
	
	public void rendreDisponible(boolean active) {
		this.libelle.setEditable(active);
		this.quantite.setEnabled(active);
		this.description.setEditable(active);
		this.quantiteAllouee.setEnabled(active);
	}
	
	public JFrame getFen() {
		return fen;
	}

/* for (int i = 0; i < NB_MAX_SOUSTACHES; i++) {
			donneesSousTaches[i][0]= "" ;
			donneesSousTaches[i][1]= new Float(0.0F);
			//this.mapSousTaches.put(String.valueOf(donneesSousTaches[i][0]), (Float) donneesSousTaches[i][1]);
			//System.out.println("numeroSousTache"+ i + "libelle :"+ donneesSousTaches[i][0] + "TauxCompletion :"+ this.mapSousTaches.get(donneesSousTaches[i][0]) );
		}
 */


}
