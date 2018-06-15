package rocher;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Materiel;
import modele.contacts.Benevole;


public class ModeleDynamiqueTableMateriel extends ModeleDynamiqueTable {
    private final List<Materiel> materiels = new ArrayList<Materiel>();
 
    private final String[] entetes = {"Libele", "Stock", "Budget","Description"};
 
    public ModeleDynamiqueTableMateriel(ArrayList<Object> al) {
        super();
 
        
        for ( Object b : al) {
       	 materiels.add( (Materiel) b);
        }
       /* materiels.add(new Materiel("Johnathan"));
        materiels.add(new Materiel("Nicolas"));
        materiels.add(new Materiel("Damien"));
        materiels.add(new Materiel("Corinne"));
        materiels.add(new Materiel("Emilie"));
        materiels.add(new Materiel("Delphine"));
        materiels.add(new Materiel("Eric"));
        
        */
        
    }
 
    public int getRowCount() {
        return materiels.size();
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
                return materiels.get(rowIndex).getLibelle();
            case 1:
                return materiels.get(rowIndex).getStockInitial();
            case 2:
                return materiels.get(rowIndex).getBudget();
            case 3:
                return materiels.get(rowIndex).getDescription();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void add(Object contact) {
    	//System.out.println("added");
        materiels.add((Materiel)contact);
        fireTableRowsInserted(materiels.size() -1, materiels.size() -1);
    }
 
    public void remove(int[] rowIndex) {
    	for(int i=rowIndex.length-1;i>=0;i--) {
    	System.out.println(rowIndex[i]);
        materiels.remove(rowIndex[i]);
    	}
        fireTableRowsDeleted(rowIndex[0], rowIndex.length-1);
    }
}