package Kanban;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueTabKanban extends JFrame{
	
	private JTable tabKanban;

	public VueTabKanban  () {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TABLEAU KANBAN");
		this.setSize(1160, 800);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
		this.setLayout(new GridLayout(1,1));

		this.tabKanban = new JTable(new TabKanbanModele());
		this.getContentPane().add(new JScrollPane(this.tabKanban));
		this.tabKanban.setDefaultRenderer(JPanel.class, new TableComponent());
	}
	
	
}
