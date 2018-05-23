package Kanban;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueTabKanban extends JPanel{
	
	


	public VueTabKanban  () {
		this.setLayout(new BorderLayout());
		
		JTable tabKanban = new JTable(new TabKanbanModele());
		this.add(tabKanban.getTableHeader(), BorderLayout.PAGE_START);
		JScrollPane spKanban = new JScrollPane(tabKanban);
		spKanban.setPreferredSize(new Dimension(1150,1150));
		tabKanban.setPreferredScrollableViewportSize(new Dimension(1150,1150)); 
		tabKanban.setDefaultRenderer(JPanel.class, new TableComponent());
		
		add(spKanban, BorderLayout.CENTER);
		tabKanban.setFillsViewportHeight(true);
		tabKanban.setDefaultRenderer(Carte.class, new TableComponent());
		for(int i = 0; i< tabKanban.getRowCount(); i++) {
			tabKanban.setRowHeight(i, 110);
		}
	}
	
	
}
