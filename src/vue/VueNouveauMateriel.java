package vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VueNouveauMateriel extends JPanel {
	
	public VueNouveauMateriel() {
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(); 
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setBorder(new EmptyBorder(10,20,0,20));
		northPanel.setLayout(new GridLayout(7,2));
		northPanel.add(new JLabel("Créée par ... "));
		northPanel.add(new JLabel("le ../../...."));
		northPanel.add(new JLabel("Libellé"));
		northPanel.add(new JTextField("",JTextField.LEFT));
		northPanel.add(new JLabel("Stock initial"));
		northPanel.add(new JLabel("?"));	
		northPanel.add(new JLabel("Quantité ajoutée"));
		JSpinner quantiteAjoutee = new JSpinner();
		northPanel.add(quantiteAjoutee);
		northPanel.add(new JLabel("Stock final"));
		northPanel.add(new JLabel("?"));
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
		JScrollPane textSP = new JScrollPane(new JTextArea());
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
		JSpinner spquantiteAllouee = new JSpinner();
		pquantiteAllouee.add(spquantiteAllouee);
		//tableau MTB
		String titresColonnes [] = {"Bénévole","Tâche","Quantité","Date prêt"};
		
		Object [][] donneesMTB = {
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
		//BTannuler.addActionListener(controleur);
		JButton BTvalider = new JButton("Valider");
		southPanel.add(BTvalider);
		//BTvalider.addActionListener(controleur);
	
	}

}
