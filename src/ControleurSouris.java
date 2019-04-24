/**
 * La classe <code>ControleurSouris</code> est utilis&eacute;e pour r&eacute;cup&eacute;rer les informations sur la souris.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.awt.event.*;
import javax.swing.*;

public class ControleurSouris implements MouseListener{
     /**
     *La variable qui est le nombre de ligne dans le tableau.
     */
    private int dimY;
     /**
     *La variable qui est  le nombre de colonne dans le tableau.
     */
    private int dimX;
     /**
     *La variable qui va contenir le tabeau de la partie.
     */
    private Case[][] grille;
     /**
     *La variable qui va d&eacute;finir si la souris est dans la zone d&eacute;sir&eacute;.
     */
    private boolean focus;
    /**
     *La variable qui va permettre de pouvoir fermer la fenêtre.
     */
    private Plateau plat;
    
    public ControleurSouris(int dx,int dy,Case[][] g,Plateau p){
	super();
	this.dimX=dx;
	this.dimY=dy;
	this.grille=g;
	this.focus=false;
	this.plat=p;
    }
    /**
     *Il va r&eacute;agir &agrave; chaque clique de la souris dans la zone
     *et ainsi modifier l'un des paramètre de la case selection,&eacute; ,voir d'autre.
     */ 
    public void mouseClicked(MouseEvent evenement){
	int bouton=evenement.getButton();
	ActionClic clique =new ActionClic();
	int x=clique.getXClic(this.dimX,evenement.getX());
	int y=clique.getYClic(this.dimY,evenement.getY());
	if(this.focus==true){
	    if(bouton==MouseEvent.BUTTON3){   
		char m=this.grille[x][y].getMarque();
		this.grille[x][y].incMarque();
	    }else if(bouton==MouseEvent.BUTTON1){  
		if(this.grille[x][y].getMarque()=='0'){
		    
		    int retour=clique.caseCliquer(x,y,this.grille,this.dimX,this.dimY);
		    if(retour==-1){
			Resultat res=new Resultat(false,this.dimX,this.dimY,this.grille);
			res.setVisible(true);
			this.plat.dispose();

		    }else{
			Verificateur verif =new Verificateur();
			boolean ok=verif.valideVictoire(this.dimX,this.dimY,this.grille);
			if(ok==true){
			    Resultat res=new Resultat(true,this.dimX,this.dimY,this.grille);
			    this.plat.dispose();
			    res.setVisible(true);
			}
		    }
		}
	    }
	}
    }
    /**
     *S'active si la souris sort de la zone.
     */	
    public void mouseEntered(MouseEvent evenement){
	this.focus=true;
    }
    /**
     *S'active si la souris rentre dans la zone.
     */	
    public void mouseExited(MouseEvent evenement){
	this.focus=false;
    }
    public void mousePressed(MouseEvent evenement){}          
    public void mouseReleased(MouseEvent evenement){}
}
