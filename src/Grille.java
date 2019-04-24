/**
 * La classe <code>Grille</code> est utilis&eacute;e pour cr&eacute;er une grille de Case.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.util.Random;
public class Grille{
    public Grille(){}
    /**
     *On va cr&eacute;er la grille qui va être la r&eacute;f&eacute;rence logique du jeu.
     *@param x il est le nombre de colonne dans le tableau.
     *@param y il est le nombre de ligne dans le tableau.
     *@param nbMine il est le nombre de mine dans le tabeau.
     *@param grille il est le tableau de la partie.
     */
    public void initialiserGrille(int x,int y,int nbMine,Case[][] grille){
	Random alea=new Random();  
	boolean vide=false;
	int r=0; 

	for(int j=0;j<y;j++){
	    for(int i=0;i<x;i++){
		int a=alea.nextInt((x*y-r)-nbMine+1)+nbMine; 
		grille[i][j]=new Case();
		if((a==nbMine)&&(vide!=true)){
		    grille[i][j].setValeur('*');
		    nbMine--;
		    if(nbMine==0){
		        vide=true;
		    }
		}
		r++;
		
	    }
	}

	for(int j=0;j<y;j++){
	    for(int i=0;i<x;i++){
		if(grille[i][j].getValeur()!='*'){
		    grille[i][j].setValeur(this.valeurCase(grille,x,y,i,j));
		}
	    }
	}
    }
    /**
     *Il va permettre de d&eacute;termine le nombre de mine qui sont adjacent &agrave; cette case.
     *@param i Position de la case dans la ligne.
     *@param j Position de la case dans la colonne.
     *@return Renvoie la valeur de la case après analyse de son environnement.
     */
    public char valeurCase(Case[][] grille,int x,int y,int i,int j){
	    char nb='0';
	    
	    if((i>0)&&(j>0)&&(grille[i-1][j-1].getValeur()=='*')){
		nb++;
	    }
	    if((j>0)&&(grille[i][j-1].getValeur()=='*')){
		nb++;
	    }
	    if((i<x-1)&&(j>0)&&(grille[i+1][j-1].getValeur()=='*')){
		nb++;
	    }
	    if((i>0)&&(grille[i-1][j].getValeur()=='*')){
		nb++;
	    }
	    if((i<x-1)&&(grille[i+1][j].getValeur()=='*')){
		nb++;
	    }
	    if((i>0)&&(j<y-1)&&(grille[i-1][j+1].getValeur()=='*')){
		nb++;
	    }
	    if((j<y-1)&&(grille[i][j+1].getValeur()=='*')){
		nb++;
	    }
	    if((i<x-1)&&(j<y-1)&&(grille[i+1][j+1].getValeur()=='*')){
		nb++;
	    }
	    
	    return nb;
    }
}
