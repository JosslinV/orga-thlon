package Kanban;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class TabKanbanModele extends AbstractTableModel {
	
	private String titreColonne [] = {"A FAIRE", "EN COURS", "TERMINE", "EN ATTENTE"}; //chaque colonne est associée à l'état d'une tache
	private JPanel nombreCartes [][] = { 
				
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
						{new Carte (""), new Carte(""), new Carte (""), new Carte ("")},
	};
	@Override
	public int getColumnCount() {
		return this.titreColonne.length;
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

}
