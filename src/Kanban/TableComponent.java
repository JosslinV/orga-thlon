package Kanban;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableComponent extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int col) {
		if (value instanceof JPanel)
			return (JPanel) value;
		return null;
	}

}
