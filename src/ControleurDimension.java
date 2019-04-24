/**
 * La classe <code>ControleurDimension</code> est utilis&eacute;e pour v&eacute;rifier les differentes donn&eacute;s et ensuite les utilis&eacute; pour dessiner la grille et le plateau du jeu .
 *
 *@version 1
 *@author Steven Renault
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControleurDimension implements ActionListener{
	/**
	*la variable qui va contenir la fenetre dimension.
	*/
	private Dimension a;

	

	public ControleurDimension(Dimension dim) {
		this.a=dim;	
	}


	/**
	*Permet d'ex&eacute;cuter la requête du bouton valid&eacute;.
	*/
	public void actionPerformed(ActionEvent e) {
		String nomButton=e.getActionCommand();

		if(nomButton.equals("valider")){
			try{

				int colonne = Integer.parseInt(a.getColumns());
				int ligne = Integer.parseInt(a.getLine());
				int mine = Integer.parseInt(a.getTrap());





				if((a.contenuChamps(a.getColumns()) ==false && a.contenuChamps(a.getLine()) == false && a.contenuChamps(a.getTrap()) == false)){
					int jeux = 0;

					if(colonne <=30 && colonne >=4  && ligne >=4 && ligne <=30 && mine <= colonne * ligne){
						a.dispose();
						Case[][] grille = new Case[colonne][ligne];
						Grille g  =new Grille();
						g.initialiserGrille(colonne,ligne,mine,grille);
						Plateau p = new Plateau(colonne,ligne,mine,grille);
						p.setVisible(true);
					}

					else if (colonne >30 || colonne <4){
						new Erreur("le nombre de colonne  doit etre compris entre 4 et 30.");

					}
					
					else if(ligne <4 || ligne > 30){
						new Erreur("le nombre de ligne  doit etre compris entre 4 et 30.");	
					}

					else if(mine > colonne * ligne){
						new Erreur("le nombre de mine ne doit pas depasser le nombre de ligne * le nombre de colonne.");						
					}


				}
			}
			
			catch(NumberFormatException e1){
				new Erreur("Veuiller rentrer des entier.");
			}


			
		}

	}
	
	
}
