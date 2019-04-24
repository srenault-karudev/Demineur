
/**
 * La classe <code>Dimension</code> est utilis&eacute;e pour inscire les differentes donn&eacute;es dans les champs attribu&eacute;s.
 *@version 1
 *@author Steven Renault
 */


import javax.swing.*;
import java.awt.*;



public class Dimension extends JFrame{
	/**
	*la varaible du champ de texte de la colonne.
	*/
	private JTextArea colonne;
	/**
	*la varaible du champ de texte de la ligne.
	*/
	private JTextArea ligne;
	/**
	*la varaible du champ de texte de la mine.
	*/
	private JTextArea mine;

	public Dimension(){
		super();
		this.setSize(1000,1000);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.ligne = new JTextArea();
		this.colonne = new JTextArea();
		this.mine = new JTextArea();
	
		GridLayout gestionnaire= new GridLayout(8,2);
		this.setLayout(gestionnaire);

		JLabel textecolonne = new JLabel(" Nombre de Colonnes :");
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(textecolonne);
		this.add(colonne); 

		JLabel texteligne = new JLabel(" Nombre de lignes : ");	
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(texteligne);
		this.add(ligne); 

		JLabel textemine = new JLabel(" Nombre de mines  : ");
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(textemine);
		this.add(mine); 

		JButton valider = new JButton("valider");
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(valider);

		ControleurDimension controleurdimension = new ControleurDimension(this);
		valider.addActionListener(controleurdimension);		
	}

/**
*retourne le contenu du JTextArea colonne. 
*/
	public String getColumns(){
		return this.colonne.getText();
	}

/**
*retourne le contenu du JTextArea ligne. 	
*/
	public String getLine(){
		return this.ligne.getText();
	}
/**
*retourne le contenu du JTextArea mine.
*/
	public String getTrap(){
		return this.mine.getText();
	}


/**
*verifie si le champ d'un JTextArea est vide ou remplie.
*@param s est une chaine de caractere d'un champ JTextArea.
*/
	
public boolean contenuChamps(String s){
	if(s.equals(" ")){
		return true;
	}
	else{
		return false;
	}
}


} 
