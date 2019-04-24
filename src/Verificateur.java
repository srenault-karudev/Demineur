/**
 * La classe <code>Verificateur</code> est utilis&eacute;e pour pouvoir &eacute;x&eacute;cuter la methode valideVictoire.
 *
 *@version 1
 *@author Pierre Villiers
 */
public class Verificateur{
    public Verificateur(){
    }
    /**
     *On valide si toute les cases ont &eacute;t&eacute; activ&eacute;es sauf les mines.
     *@param dimX le nombre de case dans une ligne du tableau.
     *@param dimY le nombre de case dans une colonne du tableau.
     *@param grille tableau de la partie.
     *@return Renvoie true si il toutes les cases sont r&eacute;v&eacute;l&eacute; sauf les mines, sinon false.
     */
    public boolean valideVictoire(int dimX,int dimY,Case[][] grille){
	boolean valide=true;
	for(int j=0;j<dimY;j++){
	    for(int i=0;i<dimX;i++){
		if((grille[i][j].getActif()==false)&&(grille[i][j].getValeur()!='*')){
		    valide=false;
		}
	    }
	}
	return valide;
    }
}
	
