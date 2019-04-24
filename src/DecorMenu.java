/**
 * La classe <code>DecorMenu</code> est utilis&eacute; pour g&eacute;rer les differents caracteristique du titre et l'emplacement de l'image sur le menu principal du jeu .
 *@version 1
 *@author Steven Renault
 */
 

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;


public class DecorMenu extends JComponent {
    /**
     *la variable qui va contenir l'image de la bombe pour le menu principal
     */
  private Image bombe;
  public DecorMenu(){
    super();
    bombe=Toolkit.getDefaultToolkit().getImage("../Images/bombe.png");
  }
  @Override
  public void paintComponent(Graphics pinceau) {
 
    Graphics secondPinceau = pinceau.create();
    
    if (this.isOpaque()) {
   
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
  
    secondPinceau.setColor(Color.BLUE);
    secondPinceau.setFont(new Font("Comics sans Ms",Font.BOLD,70));
    secondPinceau.drawString("DEMINEUR",300,100);

     secondPinceau.drawImage(bombe,150,180,this);
  }
}
