/**
 * La classe <code>Fichier</code> a pour but de sauvegarder une partie ou charger une partie.
 *
 *@version 1
 *@author Pierre Villiers
 */
import java.io.*;
import java.nio.*;
public class Fichier{
    public Fichier(){}
    /**
     *Permet de vérifier si le fichier existe.
     *@return si il existe retourne true sinon false.
     */
    public boolean fichierExiste(){
	try{
	    FileReader f =new FileReader("save.txt");
	    
	    try{
		f.close();
	    }catch(IOException e){
		System.err.println("IOException de fichierExiste en fermeture");
		return false;
	    }
	    return true;    
	}catch(FileNotFoundException e){
	    return false; 
	}
    }
    /**
     *Permet de sauvegarder une partie.
     *@param grille il contient le tableau de la partie.
     *@param x le nombre de colonne dans le tableau.
     *@param y le nombre de ligne dans le tableau.
     *@param nbMine le nombre de mine dans la partie.
     */
    public void sauvegarder(Case[][] grille,int x,int y,int nbMine){
	try{
	    FileWriter fichier = new FileWriter("save.txt");
	    BufferedWriter flux =new BufferedWriter(fichier);
	    try{
		
		flux.write(x);  
		flux.newLine();
	      
		flux.write(y);   
		flux.newLine();
	       
		flux.write(nbMine); 
		flux.newLine();
		for(int j=0;j<y;j++){
		    char[] ligne= new char[x*3];
		    int pointeur=0;
		    for(int i=0;i<x;i++){
		    
			ligne[pointeur]=grille[i][j].getValeur();
			pointeur++;
		      
			if(grille[i][j].getActif()==true){   
			    ligne[pointeur]='1';
			}else{
			    ligne[pointeur]='0';
			}
			pointeur++;
   
			ligne[pointeur]=grille[i][j].getMarque();
			pointeur++;
		    }
		    
		    flux.write(ligne,0,x*3);
		    flux.newLine();
		}
	    }catch(IOException e){
		 System.err.println("IOException de sauvegarde en ecriture");
	    }
	    try{
		flux.close();
	    }catch(IOException e){
		 System.err.println("IOException de sauvegarde en fermeture");
	    }
	    
	}catch(IOException e){
	     System.err.println("IOException de sauvegarde en ouverture");
	}
    }
    /**
     *Permet de charger le tableau de la partie.
     *@return Renvoie le tableau de la partie sauvegarder.
     */
    public Case[][] chargerTableau(){
	try{
	    FileReader fichier = new FileReader("save.txt");
	    BufferedReader flux= new BufferedReader(fichier);
	    try{
		int pb;
		int x=flux.read(); 
		pb=flux.read();
       
		int y=flux.read();
		pb=flux.read();
		
		int nbMine=flux.read();  
		pb=flux.read();
		Grille g=new Grille();
		Case[][] grille=new Case[x][y];
		g.initialiserGrille(x,y,nbMine,grille);
		Plateau p = new Plateau(x,y,nbMine,grille);
		p.setVisible(true);
	
		char[] ligne=new char[x*3];
		for(int j=0;j<y;j++){
		    String buff=flux.readLine();
		    buff.getChars(0,x*3,ligne,0);
		    int pointeur=0;
		    for(int i=0;i<x;i++){
			grille[i][j].setValeur(ligne[pointeur]);
			pointeur++;
	      
			if(ligne[pointeur]=='1'){     
			    grille[i][j].setActif();
			}
			pointeur++;
			grille[i][j].setMarque(ligne[pointeur]);
			pointeur++;
		    }
		}
		try{
		    flux.close();
		}catch(IOException e){
		    System.err.println("IOException de chargerTableau en fermeture");
		}
		return grille;
	    }catch(IOException e){
		System.err.println("IOException de chargerTableau en lecture");
		return new Case[1][1];
	    }
	    
	}catch(FileNotFoundException e){
	    System.err.println("Fichier inexistant de chargerTableau en ouverture");
	    return new Case[1][1];
	}
    }

    /**
     *Permet de charger les paramètre du tableau de la partie.
     *@return Renvoie un tableau des paramètres de la partie sauvegarder.
     */
    public int[] chargerParametreNb(){
	int[] tab=new int[3];
	int pb;
	try{
	    FileReader fichier = new FileReader("save.txt");
	    BufferedReader flux= new BufferedReader(fichier);
	    try{
		tab[0]=flux.read();
		pb=flux.read();
		tab[1]=flux.read();
		pb=flux.read();		
		tab[2]=flux.read();
		try{
		    flux.close();
		}catch(IOException e){
		    System.err.println("IOException de chargerParametre en fermeture");
		}
		return tab;
	    }catch(IOException e){
		System.err.println("IOException de chargerParametre en lecture");
		return new int[1];
	    }
	    
	}catch(FileNotFoundException e){
	    System.err.println("Fichier inexistant de chargerParametre en ouverture");
	    return new int[1];
	}
    
    }

}
