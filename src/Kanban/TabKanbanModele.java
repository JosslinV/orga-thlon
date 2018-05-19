package Kanban;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class TabKanbanModele extends AbstractTableModel {
	
	private String titresColonnes [] = {"A FAIRE", "EN COURS", "TERMINE", "EN ATTENTE"}; //chaque colonne est associ�e � l'�tat d'une tache
	private JPanel nombreTableauKanbanComposantT�ches [][] = { 
				
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
		return this.nombreTableauKanbanComposantT�ches.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return this.nombreTableauKanbanComposantT�ches[row][col];
	}
	
	public Class getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	
	 public String getColumnName(int col) {
	    	return this.titresColonnes[col];
	 }
	 
	 public boolean isCellEditable(int row, int col) {
		    return true;
     }
	 
	 public void setValueAt(JPanel value, int row, int col) {
	    	this.nombreTableauKanbanComposantT�ches[row][col] = value;
	        fireTableCellUpdated(row, col);
	 }

}
