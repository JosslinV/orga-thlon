package Kanban;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueTabKanban extends JPanel{
	
	private JTable tabKanban;

	public VueTabKanban  () {
		this.setLayout(new BorderLayout());
		
		this.tabKanban = new JTable(new TabKanbanModele());
		this.add(this.tabKanban.getTableHeader(), BorderLayout.PAGE_START);
		this.add(new JScrollPane(this.tabKanban), BorderLayout.CENTER);
		this.tabKanban.setFillsViewportHeight(true);

		this.tabKanban.setDefaultRenderer(JPanel.class, new TableComponent());
	}
	
	
}
