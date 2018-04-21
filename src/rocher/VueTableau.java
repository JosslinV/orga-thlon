package rocher;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueTableau extends JPanel{
	
	    public VueTableau() {
	 
	        JTable tableau = new JTable(new ModeleStatique());
	 
	        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
	 
	    }
	 

	}