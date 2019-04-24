/**
 * La classe <code>ControleurFenetre</code> est utilis&eacute;e pour sauvegarder la partie en cours avant que la fenetre soit ferm&eacute;e.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.awt.event.*;
import javax.swing.*;

public class ControleurFenetre implements WindowListener{
    
    /**
     *La variable qui est le nombre de ligne dans le tableau.
     */
    private int dimY;
     /**
     *La variable qui est le nombre de colonne dans le tableau.
     */
    private int dimX;
    /**
     *La variable qui est le nombre de mine dans le tableau.
     */ 
    private int mine;
     /**
     *La variable qui va contenir le tabeau de la partie.
     */
    private Case[][] grille;
    
    public ControleurFenetre(int x,int y,int nb,Case[][] g){
	super();
	this.dimX=x;
	this.dimY=y;
	this.grille=g;
	this.mine=nb;
    }
    /**
     *On sauvegarde les données la partie si la fenêtre est ferm&eacute; avant la fin de partie.
     */
    public void windowClosing(WindowEvent evenement){
	Fichier f=new Fichier();
	f.sauvegarder(this.grille,this.dimX,this.dimY,this.mine);
    }
    
    public void windowActivated(WindowEvent evenement){}      
    public void windowClosed(WindowEvent evenement){}        

    public void windowDeactivated(WindowEvent evenement){}
    public void windowDeiconified(WindowEvent evenement){} 
    public void windowIconified(WindowEvent evenement){}     
    public void windowOpened(WindowEvent evenement){}
}
