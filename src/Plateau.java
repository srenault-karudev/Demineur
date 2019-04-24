/**
 * La classe <code>Plateau</code> est utilis&eacute;e pour cr&eacute;er le plateau de jeu.
 *
 *@version 1
 *@author Pierre Villiers,Steven Renault
 */
import java.awt.*;
import javax.swing.*;

public class Plateau extends JFrame{
    /**
     *la variable qui est le nombre de ligne. 
     */
    private int x;
    /**
     *la variable qui est le nombre de colonne. 
     */
    private int y;
    /**
     *la variable qui est le nombre de mine. 
     */
    private int nbMine;
    /**
     *la variable qui va contenir le tableau.
     */
    private Case[][] grille;

    /**
     *@param xx est le nombre de ligne dans le tableau.
     *@pram yy est le nombre de colonne dans le tableau.
     *@param nb est le nombre de mine dans le tableau.
     *@param gg est le tableau de la partie.
     */

    public Plateau(int xx, int yy,int nb,Case[][] gg){
	super();
	this.x=xx;
	this.y=yy;
	this.nbMine=nb;
	this.grille=gg;
	this.setSize(600,20*this.y+100);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panbouton = new JPanel();
	JButton sauver = new JButton("sauver");
	JButton quitter = new JButton("quitter");
	panbouton.add(sauver);
	panbouton.add(quitter);
	this.add(panbouton,BorderLayout.SOUTH);

	JPanel panmine = new JPanel();
	JLabel textemine = new JLabel("nombres de mines : " +this.nbMine);
	panmine.add(textemine);
	this.add(panmine,BorderLayout.NORTH);

	ControleurPlateau controleurplateau = new ControleurPlateau(this,this.x,this.y,this.nbMine,this.grille);
	quitter.addActionListener(controleurplateau);
	sauver.addActionListener(controleurplateau);

	ControleurFenetre cf = new ControleurFenetre(this.x,this.y,this.nbMine,this.grille);
       	this.addWindowListener(cf);
						     

	GridLayout divise =new GridLayout(this.y,this.x);
	JPanel pan = new JPanel();
	pan.setLayout(divise);
	ControleurSouris cs=new ControleurSouris(this.x,this.y,this.grille,this);
        pan.addMouseListener(cs);
	for(int j=0;j<y;j++){
	    for(int i=0;i<x;i++){
		
		pan.add(this.grille[i][j]);
	    }
	    
	}
	this.add(pan,BorderLayout.CENTER);
	   
    }

    
}
