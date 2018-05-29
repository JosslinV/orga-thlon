package Kanban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VueGridKanban extends JPanel {
	private JPanel pAfaire;
	private JPanel pEnCours;
	private JPanel pEnAttente;
	private JPanel pTermine;
	
	public VueGridKanban(List<VueCarte> tachesrecurrentes){
		this.setLayout(new BorderLayout());
		JPanel ptitres = new JPanel();
		ptitres.setLayout(new GridLayout(1,4));
		ptitres.add(new JLabel("A FAIRE", JLabel.CENTER));
		ptitres.add(new JLabel("EN COURS", JLabel.CENTER));
		ptitres.add(new JLabel("TERMINE", JLabel.CENTER));
		ptitres.add(new JLabel("EN ATTENTE", JLabel.CENTER));

		JPanel pCartes = new JPanel();
		pCartes.setLayout(new GridLayout(1,4));
		this.add(ptitres, BorderLayout.NORTH);
		this.add(pCartes);
		
		
		this.pAfaire = new JPanel();
		pAfaire.setBackground(Color.white);
		pAfaire.setBorder(new EmptyBorder(20,20,20,20));
		for (VueCarte carteAFaireRec : tachesrecurrentes) {
			//carteAFaire.estTacheRecurrente(true);
			pAfaire.add(carteAFaireRec);
		}
		pCartes.add(pAfaire);
		
		this.pEnCours = new JPanel();
		pEnCours.setBackground(Color.LIGHT_GRAY);
		pEnCours.setBorder(new EmptyBorder(20,20,20,20));		
		pCartes.add(pEnCours);
		
		this.pTermine = new JPanel();
		pTermine.setBackground(Color.gray);
		pTermine.setBorder(new EmptyBorder(20,20,20,20));	
		pCartes.add(pTermine);
		
		this.pEnAttente = new JPanel();
		pEnAttente.setBackground(Color.LIGHT_GRAY);
		pEnAttente.setBorder(new EmptyBorder(20,20,20,20));
		pCartes.add(pEnAttente);
		
	}
	


	public void afficherNouvelEtatCarte(VueCarte carte, Etat ancienEtat, Etat nouvelEtat) {
		switch(nouvelEtat) {
		case A_FAIRE:
			if(ancienEtat.equals(Etat.EN_COURS)) {
				pEnCours.remove(carte);
			}
			pAfaire.add(carte);
			break;
		case EN_COURS:
			if (ancienEtat.equals(Etat.EN_ATTENTE)) {
				pEnAttente.remove(carte);
			}
			if (ancienEtat.equals(Etat.A_FAIRE)) {
				pAfaire.remove(carte);
			}
			pEnCours.add(carte);
			break;
		case EN_ATTENTE:
			pEnAttente.add(carte);
			pEnCours.remove(carte);
			break;
		case TERMINEE:
			pEnCours.remove(carte);
			pTermine.add(carte);
			break;
		case SUPPRIME:
			if (ancienEtat.equals(Etat.EN_COURS)) {
				pEnCours.remove(carte);
			}
			if (ancienEtat.equals(Etat.A_FAIRE)) {
				pAfaire.remove(carte);
			}
			if (ancienEtat.equals(Etat.EN_ATTENTE)) {
				pEnAttente.remove(carte);
			}
			if (ancienEtat.equals(Etat.TERMINEE)) {
				pTermine.remove(carte);
			}		
		}
	}

	

}
