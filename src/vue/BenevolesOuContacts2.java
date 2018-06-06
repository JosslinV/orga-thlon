package vue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controleur.ControleurBenevolesOuContacts2;
import controleur.ControleurNouvelleCourse;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class BenevolesOuContacts2 extends JPanel {

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BenevolesOuContacts2() throws Exception {
		ControleurBenevolesOuContacts2 controleur = new ControleurBenevolesOuContacts2(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Contacts");
		btnNewButton.addActionListener(controleur);
		btnNewButton.setIcon(new ImageIcon("./src/RessourcesImages/User-Profile-128.png"));
		//btnNewButton.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
		//btnNewButton.setVerticalAlignment(SwingConstants.TOP );
		

		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.weightx = 1.0;
		gbc_btnNewButton.weighty = 1.0;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnBenevoles = new JButton("Benevoles");
		btnBenevoles.addActionListener(controleur);
		btnBenevoles.setIcon(new ImageIcon("./src/RessourcesImages/User-Profile-128.png"));
		
	//	btnBenevoles.setHorizontalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnBenevoles = new GridBagConstraints();
		gbc_btnBenevoles.weightx = 1.0;
		gbc_btnBenevoles.insets = new Insets(0, 0, 5, 0);
		gbc_btnBenevoles.gridx = 2;
		gbc_btnBenevoles.gridy = 0;
		add(btnBenevoles, gbc_btnBenevoles);
		
		JButton btnNewButton_1 = new JButton("Retour");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.weightx = 1.0;
		gbc_btnNewButton_1.weighty = 1.0;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}
}
