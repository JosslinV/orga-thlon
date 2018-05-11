package rocher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import modele.contacts.Contact;


public class VueTableau extends JScrollPane{
	private JTable tableau;

    public VueTableau(ModeleDynamiqueTable modeleDynamiqueTable) {
    	this.tableau =new JTable(modeleDynamiqueTable);
        this.getViewport().add((tableau));
 
    }
 
   public JTable getJTable() {
	   return this.tableau;
	   
   }
}

/*
package rocher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.contacts.Contact;

public class VueTableau extends JScrollPane{
	private JTable tableau;

    public VueTableau(ModeleDynamiqueTable modeleDynamiqueTable) {
    	this.tableau =new JTable(modeleDynamiqueTable);
        this.getViewport().add((tableau));
    	
*/