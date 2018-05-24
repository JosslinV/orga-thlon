package vue;

import javax.swing.table.AbstractTableModel;

public class TabAssignationModele extends AbstractTableModel {
		private boolean DEBUG = false;
		private String [] titreColonne ;
		private String [][] liste;		

		
		public TabAssignationModele(String[] titreColonne, String [][] liste) {
			this.titreColonne = titreColonne;
			this.liste = liste;
		}
		
		@Override
	    public int getColumnCount() {
	    	return titreColonne.length;
	    }

		@Override
		public int getRowCount() {
			return liste.length;
	    }

	    public String getColumnName(int col) {
	    	return titreColonne[col];
	    }
	    
		@Override
	    public Object getValueAt(int row, int col) {
	    	return liste[row][col];
	    }

	    public Class getColumnClass(int c) {
	      return getValueAt(0, c).getClass();
	    }

	    public boolean isCellEditable(int row, int col) {
		    return false;
	    }
	    
	    public void setValueAt(String value, int row, int col) {
	    	liste[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	    

}
