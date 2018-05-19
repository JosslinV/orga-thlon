package Kanban;
import java.awt.BorderLayout;
import java.awt.Color;
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
		JScrollPane spKanban = new JScrollPane(this.tabKanban);
		spKanban.setPreferredSize(new Dimension(1150,1150));
		this.tabKanban.setPreferredScrollableViewportSize(new Dimension(1150,1150)); 
		
		this.add(spKanban, BorderLayout.CENTER);
		this.tabKanban.setFillsViewportHeight(true);
		this.tabKanban.setDefaultRenderer(JPanel.class, new TableComponent());
		for(int i = 0; i< this.tabKanban.getRowCount(); i++) {
			this.tabKanban.setRowHeight(i, 110);
		}
	}
	
	
}
