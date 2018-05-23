package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
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
	
	private String titresColonnes [] = {"Bénévole","Tâche","Quantité","Date prêt"};
	
	private String [][] donneesMTB = {
			{"","","",""},
			{"","","",""},
			{"","","",""}
	};	
	
	
	public VueNouveauMateriel() {
		
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
		
		
		this.tabMTB = new JTable(new TabModele(this.titresColonnes, this.donneesMTB));
		this.tabMTB.setPreferredScrollableViewportSize(new Dimension(100,70)); 
		p2.add(new JScrollPane(this.tabMTB), BorderLayout.SOUTH);

		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setBorder(new EmptyBorder(10,15,10,15));
		southPanel.setLayout(new GridLayout(1,2,30,0));
		
		JButton BTannuler = new JButton("Annuler");
		southPanel.add(BTannuler);
		BTannuler.addActionListener(contr);
		
		JButton BTvalider = new JButton("Valider");
		southPanel.add(BTvalider);
		BTvalider.addActionListener(contr);
	
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
	
	public void rendreDisponible(boolean active) {
		this.libelle.setEditable(active);
		this.quantite.setEnabled(active);
		this.description.setEditable(active);
		this.quantiteAllouee.setEnabled(active);
	}
	
	class TabModele extends AbstractTableModel {
		private boolean DEBUG = false;
		private String [] titresColonnes ;
		private Object [][] donnees;		

		
		public TabModele(String[] titresColonnes, Object[][] donnees) {
			this.titresColonnes = titresColonnes;
			this.donnees = donnees;
		}
		
	    public int getColumnCount() {
	    	return titresColonnes.length;
	    }

		public int getRowCount() {
			return donnees.length;
	    }

	    public String getColumnName(int col) {
	    	return titresColonnes[col];
	    }

	    public Object getValueAt(int row, int col) {
	    	return donnees[row][col];
	    }

	    /**
	     * JTable uses this method to determine the default renderer/ editor for
	     * each cell. If we didn't implement this method, then the last column
	     * would contain text ("true"/"false"), rather than a check box.
	     */
	    public Class getColumnClass(int c) {
	      return getValueAt(0, c).getClass();
	    }

	    /**
	     * Don't need to implement this method unless your table's editable.
	     */
	    public boolean isCellEditable(int row, int col) {
		    return true;
	    }
	    /**
	     * Don't need to implement this method unless your table's data can
	     * change.
	     */
	    
	    public void setValueAt(Object value, int row, int col) {
	    	donnees[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	    
	}

	
	public class TableComponent extends DefaultTableCellRenderer {

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    if (value instanceof JProgressBar)
	      return (JProgressBar) value;
	    else
	      return this;
	  }
	}
/*
 * for (int i = 0; i < NB_MAX_SOUSTACHES; i++) {
			donneesSousTaches[i][0]= "" ;
			donneesSousTaches[i][1]= new Float(0.0F);
			//this.mapSousTaches.put(String.valueOf(donneesSousTaches[i][0]), (Float) donneesSousTaches[i][1]);
			//System.out.println("numeroSousTache"+ i + "libelle :"+ donneesSousTaches[i][0] + "TauxCompletion :"+ this.mapSousTaches.get(donneesSousTaches[i][0]) );
		}
 */


}
