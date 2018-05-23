package Kanban;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class TabKanbanModele extends AbstractTableModel {
	
	private String titresColonnes [] = {"A FAIRE", "EN COURS", "TERMINE", "EN ATTENTE"}; //chaque colonne est associée à l'état d'une tache
	public Carte nombreCartes [][] = { 
				
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
	};
	@Override
	public int getColumnCount() {
		return this.titresColonnes.length;
	}

	@Override
	public int getRowCount() {
		return this.nombreCartes.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return this.nombreCartes[row][col];
	}
	
	public Class getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	
	 public String getColumnName(int col) {
	    	return this.titresColonnes[col];
	 }
	 
	 public boolean isCellEditable(int row, int col) {
		    if ( col == 1) return true;
		    return false;
     }
	 
	 public void setValueAt(JPanel value, int row, int col) {
	    	this.nombreCartes[row][col] = (Carte) value;
	        fireTableCellUpdated(row, col);
	 }

}
