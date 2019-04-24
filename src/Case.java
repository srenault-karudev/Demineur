/**
 * La classe <code>Case</code> est utilis&eacute;e comme structure et composant graphique,il repr&eacute;sente une case dans la grille.
 *
 *@version 1
 *@author Pierre Villiers
 */
import javax.swing.*;
import java.awt.*;

public class Case extends JComponent{
    /**
     *La variable d'identification de la case.
     */
    private char valeur;
    /**
     *La variable qui d&eacute;finie si cette case est cach&eacute; ou r&eacute;v&eacute;l&eacute;.
     */
    private boolean actif;
    /**
     *La variable qui va contenir toute les chemins des images.
     */
    private String[] fichier;
    /**
     *La variable qui dit si cette case &agrave; explos&eacute;.
     */
    private boolean explose;
    /**
     *La variable qui possède le type de marqueur pour cette case.
     */
    private char marque;
    /**
     *On Initialise la case en affectant des valeur par d&eacute;faut pour 
     *les varaiable. 
     */
    public Case(){
	super();
	this.valeur=0;
	this.actif=false;
	String[] s={null,"../Images/un.png","../Images/deux.png","../Images/trois.png","../Images/quatre.png","../Images/cinq.png","../Images/six.png","../Images/sept.png","../Images/huit.png","../Images/mine.png","../Images/explose.png","../Images/danger.png","../Images/doute.png"};
	this.fichier=s;
	this.explose=false;
	this.marque='0';
    }
    /**
     *Il va permettre d'activer cette case et donc va être afficher sur le plateau de jeu. 
     */
    public void setActif(){
	this.actif=true;
    }
    /**
     *Savoir si cette case est caché ou actif.
     */
    public boolean getActif(){
	return this.actif;
    }
    /**
     *Il va permettre d'affecter un caractere choisie.
     *@param c'est valeur de la case (0-9,ou *)
     */
    public void setValeur(char c){
	this.valeur=c;
    }
    /**
     *Connaitre le caractere de cette case.
     */
    public char getValeur(){
	return this.valeur;
    }
    /**
     *Si le joueur clique sur cette case et que c'est une mine elle explose.
     */
    public void setExplose(){
	this.explose=true;
    }

    /**
     *Connaitre l'état de la mine si c'en est une.
     */
    public boolean getExplose(){
	return this.explose;
    }

    /**
     *Si le joueur veut changer le marqueur sur une case cach&eacute;.
     */
    public void incMarque(){
	if(this.marque=='2'){
	    this.marque='0';
	}else{
	    this.marque++;
	}
    }
    /**
     *Affecte une nouvelle valeur de marqueur.
     */
    public void setMarque(char m){
	this.marque=m;
    }

    /**
     *Connaitre le type de marqueur sur la case si elle est cach&eacute;.
     */
    public char getMarque(){
	return this.marque;
    }
    
    /**
     *On va afficher l'image correspondant &agrave; cette case.
     */
    @Override
    public void paintComponent(Graphics p) {
	Graphics pinceau = p.create();
	int v;
	
	if(this.valeur=='*'){
	    if(this.explose==true){
		v=10;
	    }else{
		v=9;
	    }
	}else{
	    v=Character.getNumericValue(this.valeur);
	}
	int w=10+Character.getNumericValue(this.marque);

	Image img1=Toolkit.getDefaultToolkit().getImage(fichier[v]);
	Image img2=Toolkit.getDefaultToolkit().getImage(fichier[w]); 

	pinceau.setColor(new Color(0,0,0));
	pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	Color c;
	if(this.actif==true){
	    if(this.explose==true){
		c=new Color(255,255,0);
	    }else{
		c=new Color(255,255,255);
	    }
	}else{	
	    c= new Color(150,150,150);
	}
	pinceau.setColor(c);
	pinceau.fillRect(2, 2, this.getWidth()-2, this.getHeight()-2);


	if((v<=10)&&(this.actif==true)&&(v>0)){
	    pinceau.drawImage(img1,2,2,this);	
	}
	if((this.marque!='0')&&(this.actif==false)){
		 pinceau.drawImage(img2,2,2,this);
	}
	this.repaint();
    }
}
