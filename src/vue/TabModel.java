package vue;

import javax.swing.table.AbstractTableModel;

public class TabModel extends AbstractTableModel{
	
	private Object[][] donnees;
	private String[] titresColonnes;

	public TabModel(Object[][] donnees, String[] titresColonnes) {
		this.donnees = donnees;
		this.titresColonnes = titresColonnes;
	}

	@Override
	public int getColumnCount() {
		return this.titresColonnes.length;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int l, int c) {
		return this.donnees[l][c];
	} 
	
	public String getColumnName(int c) {
		return this.titresColonnes[c];
	}
	
	public Class getColumnClass(int c) {
		return this.donnees[0][c].getClass();
	}
	
	public boolean isCellEditable(int l, int c) {
		if (getValueAt(0, c) instanceof String)
			return false;
		return true;
	}
	
}
