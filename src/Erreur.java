
/**
 * La classe <code>Erreur</code> est utilis&eacute;e pour g&eacute;rer les cas d'erreur en la specifiant avec une phrase.
 *
 *@version 1
 *@author Steven Renault
 */



import javax.swing.*;
import java.awt.*;


public class Erreur extends JFrame {
	/**
	*@param texte est une variable qui permmetra d'enregistrer le message d'erreur;
	*/
	public Erreur(String texte) {
		super("Erreur");
		this.setSize(texte.length()*10+30,100);
		this.setLocation(500-(texte.length()*5), 500);
    	this.add(new JLabel(texte),BorderLayout.CENTER);
    	this.setVisible(true);
	}
}
