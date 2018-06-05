package rocher;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.contacts.Contact;
import modele.contacts.ContactExterne;

public class ModeleDynamiqueTableContact extends ModeleDynamiqueTable {
    private final List<Contact> contacts = new ArrayList<Contact>();
 
    private final String[] entetes = {"Commentaire", "Civilite", "Nom","prenom", "adresse", "code postal","ville","telephone","mail"};
 
    public ModeleDynamiqueTableContact() {
        super();
 
        contacts.add(new ContactExterne("Johnathan","Contact"));
        contacts.add(new ContactExterne("Nicolas","Contact"));
        contacts.add(new ContactExterne("Damien","Contact"));
        contacts.add(new ContactExterne("Corinne","Contact"));
        contacts.add(new ContactExterne("Emilie","Contact"));
        contacts.add(new ContactExterne("Delphine","Contact"));
        contacts.add(new ContactExterne("Eric","Contact"));
    }
 
    public int getRowCount() {
        return contacts.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return contacts.get(rowIndex).getCommentaire();
            case 1:
                return contacts.get(rowIndex).getCivilite();
            case 2:
                return contacts.get(rowIndex).getNom_c();
            case 3:
                return contacts.get(rowIndex).getPrenom_c();
            case 4:
                return contacts.get(rowIndex).getAdresse();
            case 5:
            	return contacts.get(rowIndex).getCp_c();
            case 6:
            	return contacts.get(rowIndex).getVille_c();
            case 7:
            	return contacts.get(rowIndex).getTelephone_c();
            case 8:
            	return contacts.get(rowIndex).getMail_c();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void add(Object contact) {
    	//System.out.println("added");
        contacts.add((Contact)contact);
        fireTableRowsInserted(contacts.size() -1, contacts.size() -1);
    }
 
    public void remove(int[] rowIndex) {
    	for(int i=rowIndex.length-1;i>=0;i--) {
    	System.out.println(rowIndex[i]);
        contacts.remove(rowIndex[i]);
    	}
        fireTableRowsDeleted(rowIndex[0], rowIndex.length-1);
    }
}