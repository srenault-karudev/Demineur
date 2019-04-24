/**
 * La classe <code>ControleurResultat</code> est utilis&eacute;e pour d&eacute;finir les actions des diff&eacute;rents boutons de la classe Resultat.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.awt.event.*;
import javax.swing.*;

public class ControleurResultat implements ActionListener{
    /**
     *La variable qui va contenir la fenêtre r&eacute;sultat de cette partie .
     */
    private Resultat res;
    public ControleurResultat(Resultat r){
	super();
	this.res=r;
    }
    @Override
    /**
     *Il va permettre d'ex&eacute;cuter la requête du bouton appuy&eacute;.
     */
    public void actionPerformed(ActionEvent event){
	String name=event.getActionCommand();


		if (name.equals("Retour Menu")){
	    Menu menu =new Menu();
	    this.res.dispose();
 	    menu.setVisible(true);
	    }
	
    
	else if(name.equals("Quitter le Jeu")){
	    this.res.dispose();
 	    
	}
    }


}
	
