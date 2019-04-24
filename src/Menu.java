import javax.swing.*;
import java.awt.*;
/**
 * La classe <code>Menu</code> est utilis&eacute;e pour afficher le menu principal du jeu.
 *
 *@version 1
 *@author Steven Renault
 */

public class Menu  extends JFrame {

 
public Menu(){
        super();
		this.setSize(1000, 1000);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton nouvelle = new JButton("Nouvelle Partie");
	       	JButton reprendre = new JButton("Reprendre Partie");	
		JButton quitter = new JButton("Quitter");
	
		JPanel menuprincipal = new JPanel();
		menuprincipal.add(nouvelle);
		Fichier f =new Fichier();
		if(f.fichierExiste()==true){ 
		menuprincipal.add(reprendre);
		}
		menuprincipal.add(quitter);
		menuprincipal.setBackground(Color.BLUE);

		DecorMenu decormenu = new DecorMenu();
        
		ControleurMenu controleurmenu = new ControleurMenu(this);

		this.add(menuprincipal,BorderLayout.SOUTH);
		this.add(decormenu,BorderLayout.CENTER);
		nouvelle.addActionListener(controleurmenu);
		quitter.addActionListener(controleurmenu);
		reprendre.addActionListener(controleurmenu);


	}
   
}
