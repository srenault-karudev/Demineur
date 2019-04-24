
/**
 * La classe <code>Resultat</code> va nous permettre d'arreter la partie en signalant au joueur si il a gagn&eacute; ou perdu.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.awt.*;
import javax.swing.*;

public class Resultat extends JFrame{
    
    
    /**
     *Il va construire la fenetre de fin de jeu.
     *@param reponse soit 1=Victoire soit 0=D&eacute;faite.
     *@param dimX le nombre de case dans une ligne du tableau.
     *@param dimY le nombre de case dans une colonne du tableau.
     *@param grille tableau de la partie.
     */
    
    public Resultat(boolean reponse,int dimX,int dimY,Case[][] grille){
	super();
	this.setSize(600,(dimY*20)+100);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel res;
	if(reponse==true){
	    res=new JLabel("VICTOIRE");
	}else{
	    res=new JLabel("DEFAITE");
	}
	Font f=new Font("Arial",Font.BOLD,30);
	res.setFont(f);
	res.setHorizontalAlignment(JLabel.CENTER);
	this.add(res,BorderLayout.NORTH);

	JPanel p=new JPanel();

	p.setLayout(new GridLayout(dimY,dimX));
	for(int j=0;j<dimY;j++){
	    for(int i=0;i<dimX;i++){
		grille[i][j].setActif();
		p.add(grille[i][j]);
	    }
	}
	this.add(p,BorderLayout.CENTER);
	JPanel option=new JPanel();
	ControleurResultat observateur= new ControleurResultat(this);
	JButton menu =new JButton("Retour Menu");
	JButton quitter=new JButton("Quitter le Jeu");
	menu.addActionListener(observateur);
	quitter.addActionListener(observateur);
	option.add(menu);
	option.add(quitter);
	this.add(option,BorderLayout.SOUTH);
       
        
    }

   
}
	
	
