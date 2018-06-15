package rocher;

import javax.swing.table.AbstractTableModel;

public abstract class ModeleDynamiqueTable  extends AbstractTableModel {
   
    public ModeleDynamiqueTable() {
        
    }
 
    public abstract int getRowCount() ;
 
    public abstract int getColumnCount() ;
 
    public abstract String getColumnName(int columnIndex);
 
    public abstract Object getValueAt(int rowIndex, int columnIndex) ;
 
    public abstract void add(Object t) ;
 
    public abstract void remove(int[] rowIndex) ;
}