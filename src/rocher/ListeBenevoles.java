package rocher;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListeBenevoles extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListeBenevoles() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel BandeauHaut_Benevoles = new JPanel();
		add(BandeauHaut_Benevoles, BorderLayout.NORTH);
		BandeauHaut_Benevoles.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBenevoles = new JLabel("Benevoles");
		lblBenevoles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBenevoles.setHorizontalAlignment(SwingConstants.LEFT);
		BandeauHaut_Benevoles.add(lblBenevoles);
		
		JPanel panelPrincipal = new JPanel();
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelPrincipal.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Supprimer contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditer.gridx = 1;
		gbc_btnEditer.gridy = 0;
		panel.add(btnEditer, gbc_btnEditer);
		
		JButton btnAjouterContact = new JButton("Ajouter contact");
		GridBagConstraints gbc_btnAjouterContact = new GridBagConstraints();
		gbc_btnAjouterContact.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouterContact.gridx = 2;
		gbc_btnAjouterContact.gridy = 0;
		panel.add(btnAjouterContact, gbc_btnAjouterContact);
		
		JButton btnRetour = new JButton("Retour");
		GridBagConstraints gbc_btnRetour = new GridBagConstraints();
		gbc_btnRetour.insets = new Insets(0, 0, 0, 5);
		gbc_btnRetour.gridx = 0;
		gbc_btnRetour.gridy = 1;
		panel.add(btnRetour, gbc_btnRetour);
		
		JPanel panel_1 = new JPanel();
		panelPrincipal.add(panel_1, BorderLayout.CENTER);

	}

}
