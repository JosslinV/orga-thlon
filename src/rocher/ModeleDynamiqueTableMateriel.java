package rocher;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Materiel;
import modele.contacts.Benevole;


public class ModeleDynamiqueTableMateriel extends ModeleDynamiqueTable {
    private final List<Materiel> materiels = new ArrayList<Materiel>();
 
    private final String[] entetes = {"Libellé", "Stock", "Budget","Description"};
 
    public ModeleDynamiqueTableMateriel(ArrayList<Object> al) {
        super();
 
        for ( Object b : al) {
       	 materiels.add( (Materiel) b);
        }
        
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
                return materiels.get(rowIndex).getStock();
            case 2:
                return materiels.get(rowIndex).getBudget();
            case 3:
                return materiels.get(rowIndex).getDescription();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void add(Object contact) {
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