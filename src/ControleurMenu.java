
/**
 * La classe <code>ControleurMenu</code> est utilis&eacute;e pour d&eacute;marrer une nouvelle,reprendre une nouvelle partie ou bien quitter le jeu.
 *
 *@version 1
 *@author Steven Renault
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ControleurMenu implements ActionListener{
	/**
	*la variable permet de prendre la fenetre du menu.
	*/
	private JFrame fenetre;
	
	public ControleurMenu(JFrame f){
		this.fenetre=f;
	}
	
	/**
	*il va permettre d'&eacute;cuter la requete du bouton appuy&eacute;
	*/
	public void actionPerformed(ActionEvent e){
		String nomButton=e.getActionCommand();


		if(nomButton.equals("Nouvelle Partie")){
			fenetre.dispose();
			Dimension dimension= new Dimension();
			dimension.setVisible(true); 

		}
		else if(nomButton.equals("Reprendre Partie")){
			fenetre.dispose();
			Fichier fichier= new Fichier();
			fichier.chargerTableau();
			fichier.chargerParametreNb();
	

		}

		else if(nomButton.equals("Quitter")){

				fenetre.dispose();
		}
	}
}
