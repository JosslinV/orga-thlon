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
import java.util.ArrayList;
import javax.swing.JScrollPane;


public class ListeGenerique extends JPanel {
	private JScrollPane panelPrincipal;
 
	private JLabel lblTitre;
		
	//ControlleurGeneriqueTableaux.EtatsVuesListe
	public ListeGenerique(ArrayList<Object> list) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel BandeauHaut_Benevoles = new JPanel();
		add(BandeauHaut_Benevoles, BorderLayout.NORTH);
		BandeauHaut_Benevoles.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel();
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		BandeauHaut_Benevoles.add(lblTitre);
		
		ControlleurGeneriqueTableaux controleur = new ControlleurGeneriqueTableaux(this,list);
		this.panelPrincipal = new VueTableau(controleur.getModele());
		add(panelPrincipal, BorderLayout.CENTER);
		
		
		
		JPanel panel_bas_boutons = new JPanel();
		add(panel_bas_boutons, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_bas_boutons = new GridBagLayout();
		gbl_panel_bas_boutons.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_bas_boutons.rowHeights = new int[]{0, 0, 0};
		gbl_panel_bas_boutons.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_bas_boutons.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_bas_boutons.setLayout(gbl_panel_bas_boutons);
		
		JButton bt_supprimer = new JButton("Supprimer");
		GridBagConstraints gbc_bt_supprimer = new GridBagConstraints();
		gbc_bt_supprimer.insets = new Insets(0, 0, 5, 5);
		gbc_bt_supprimer.gridx = 0;
		gbc_bt_supprimer.gridy = 0;
		bt_supprimer.addActionListener(controleur);
		panel_bas_boutons.add(bt_supprimer, gbc_bt_supprimer);
		
		JButton bt_Editer = new JButton("Editer");
		GridBagConstraints gbc_bt_Editer = new GridBagConstraints();
		gbc_bt_Editer.insets = new Insets(0, 0, 5, 5);
		gbc_bt_Editer.gridx = 1;
		gbc_bt_Editer.gridy = 0;
		panel_bas_boutons.add(bt_Editer, gbc_bt_Editer);
		
		JButton bt_Ajouter = new JButton("Ajouter");
		GridBagConstraints gbc_bt_Ajouter = new GridBagConstraints();
		gbc_bt_Ajouter.insets = new Insets(0, 0, 5, 0);
		gbc_bt_Ajouter.gridx = 2;
		gbc_bt_Ajouter.gridy = 0;
		bt_Ajouter.addActionListener(controleur);
		panel_bas_boutons.add(bt_Ajouter, gbc_bt_Ajouter);
		
		JButton bt_Retour = new JButton("Retour");
		GridBagConstraints gbc_bt_Retour = new GridBagConstraints();
		gbc_bt_Retour.insets = new Insets(0, 0, 0, 5);
		gbc_bt_Retour.gridx = 0;
		gbc_bt_Retour.gridy = 1;
		panel_bas_boutons.add(bt_Retour, gbc_bt_Retour);
		

	}
	
	public VueTableau getPanelPrincipal(){
		return (VueTableau) this.panelPrincipal;
	}
	public void setTitle(String title) {
		lblTitre.setText(title);
	}

}
