/**
 * La classe <code>Raffraichisseur</code> est utilis&eacute;e pour repaindre les diffrentes cases de notre tableau.
 *@version 1
 *@author Steven Renault
 */


import javax.swing.*;

public class Raffraichisseur {
	/**
	* la valeur  qui est le nombre de ligne dans le tableau.
	*/
	private int dimX;
		/**
	* la valeur  qui est le nombre de colonne dans le tableau.
	*/
	private int dimY;
		/**
	* la valeur  qui est le tableau de la partie
	*/
	private Case[][] grille;


/**
*cette m&eacute;thode permet de raffraichir les diff&eacute;rents &eacute;lements du tableau de la partie.
*@param dx nombre de case dans une ligne du tableau.
*@param dy nombre de case dans une colonne du tableau.
*@param g tableau de la partie
*/
	public Raffraichisseur(int dx,int dy,Case[][] g){
		this.dimY=dy;
		this.dimX=dx;
		this.grille=g;

		for(int i=0;i<dy;i++){
			for(int j=0;j<dx;j++){
				grille[j][i].repaint();

			}

		}
	}
}
