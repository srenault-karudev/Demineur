/**
 * La classe <code>ActionClic</code> est utilis&eacute;e  pour contenir toute les actions 
 *qui vont être entrain&eacute;es par un clic.
 *@version 1
 *@author Pierre Villiers
 */
import javax.swing.*;
public class ActionClic{
    public ActionClic(){
    }
    /**
     *Cette m&eacute;thode va permettre de changer l'&eacute;tat de la case ,ainsi que les autre en fonction de certaine condition.
     *@param x position de la case s&eacute;lectionn&eacute; dans une ligne du tableau.
     *@param y position de la case s&eacute;lectionn&eacute; dans une colonne du tableau.
     *@param grille le tableau de la partie.
     *@param dimX nombre de colonne dans le tableau.
     *@param dimY nombre de ligne dans le tableau.
     *@return Renvoie une valeur -1 en cas de rencontre avec une mine.
     */
    public int caseCliquer(int x,int y,Case[][] grille,int dimX,int dimY){
	grille[x][y].setActif();
	if(grille[x][y].getValeur()=='*'){ 
	    grille[x][y].setExplose();
	    return -1;
	}
	if(grille[x][y].getValeur()=='0'){
	    for(int j=y-1;j<=y+1;j++){
		for(int i=x-1;i<=x+1;i++){
		    if((i<dimX)&&(i>=0)&&(j<dimY)&&(j>=0)&&((x!=i)||(y!=j))){
			if(grille[i][j].getActif()==false){
			    if(grille[i][j].getValeur()=='0'){ 
				int res;
				res=this.caseCliquer(i,j,grille,dimX,dimY);
				if(res==-1){
				    return -1;
				}
			    }else{
				grille[i][j].setActif();
			    }
			}
		    }
		}
	    }
	}
	return 1;
    }
    /**
     *Donne le num&eacute;ro de case dans une ligne.
     *@param dimX nombre de colonne en largeur du panneau.
     *@param x les coordonn&eacute;es en largeur &agrave; l'endroit où le joueur a cliqu&eacute;.
     */
    public int getXClic(int dimX,int x){
	for(int i=0;i<dimX;i++){
	    if((x>=(600/dimX)*i)&&(x<=(600/dimX)*(i+1))){
		return i;
	    }
	}
	return -1;
    }
    /**
     *Donne le num&eacute;ro de case dans une colonne.
     *@param dimY nombre de ligne en longueur du panneau.
     *@param y les coordonn&eacute;es en longueur &agrave; l'endroit où le joueur a cliqu&eacute;.
     */
    
    public int getYClic(int dimY,int y){
	for(int i=0;i<dimY;i++){
	    if((y>=(20*i))&&(y<=(20*(i+1)))){
		return i;
	    }
	}
	return -1;
    }
	
}
