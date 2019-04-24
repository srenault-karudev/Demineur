import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ControleurPlateau</code> est utilis&eacute;e pour d&eacute;finir les actions des diff&eacute;rents boutons de la classe Plateau .
 *
 *@version 1
 *@author Steven Renault
 */


public class ControleurPlateau implements ActionListener{
    /**
     * la variable permet de prendre la fenetre du plateau.
     */
    private JFrame fenetre;
    /**
     * la variable qui est le nombre de colonne.
     */
    private int dimY;
    /**
     * la variable qui est le nombre de ligne.
     */
     private int dimX;
     /**
      * la variable qui est le nombre de mine.
      */
    private int mine;
     /**
      * la variable qui va contenir le tableau.
      */
    private Case[][] grille;
	/**
	 *@param f est la fenetre du plateau.
	 *@param x est le nombre de ligne dans le tableau.
	 *@param y est le nombre de colonne dans le tableau.
	 *@param nb est le nombre de mine dans le tableau.
	 *@param g est le tableau de la partie.
  	*/
    public ControleurPlateau(JFrame f,int x,int y ,int nb,Case [][]g){
	super();
	this.fenetre=f;
	this.dimX=x;
	this.dimY=y;
	this.grille=g;
	this.mine=nb;
    }

   
    public void actionPerformed(ActionEvent e){
	String nomButton=e.getActionCommand();

	if(nomButton.equals("sauver")){
	    Fichier fichier =new Fichier();
	    fichier.sauvegarder(this.grille,this.dimX,this.dimY,this.mine);
 	  
	}

	else if(nomButton.equals("quitter")){

	    fenetre.dispose();
	}

    }

}
