package vue;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VueNouvelleSousTache extends JPanel {
	public VueNouvelleSousTache() {
		this.setLayout(new BorderLayout()); 
		
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(); 
		
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.setBorder(new EmptyBorder(10,20,5,20));
		northPanel.setLayout(new GridLayout(3,1));
		

		northPanel.add(new JLabel("Titre"));
		northPanel.add(new JTextField());

		northPanel.add(new JLabel("Notes"));

		
		//panneau au centre

		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setBorder(new EmptyBorder(5,20,10,20));
		centerPanel.setLayout(new GridLayout(1,1));
		JScrollPane textSP = new JScrollPane(new JTextArea());
		centerPanel.add(textSP);

		
		//panneau au sud

		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setBorder(new EmptyBorder(10,15,10,15));
		southPanel.setLayout(new GridLayout(1,2,30,0));
		
		JButton BTannuler = new JButton("Annuler");
		southPanel.add(BTannuler);
		//BTannuler.addActionListener(controleur);
		JButton BTvalider = new JButton("Valider");
		southPanel.add(BTvalider);
		//BTvalider.addActionListener(controleur);
	}

}
