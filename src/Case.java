/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */

/*
Note: Ceci est la classe mère, les autres classe du genre "CaseOie" etc... hérite
de cette classe.
*/
public abstract class Case 
{
   
    /**
     * Récupère le joueur d'une case
     * @return le joueur
     */

	public abstract Joueur getJoueur();
        
    /**
     * Fixe le joueur sur une case
     * @param j est le joueur en parametre
     */

	public abstract void setJoueur(Joueur j);
    
        
    /**  
     * Méthode qui permet d'échanger la position des joueurs
     * @param j
     */

	public abstract void Echange(Joueur j);
    
    /**
     * @return true si seulement un autre joueur passe sur cette case 
     * et donc que le joueur bloqué est débloqué
     *  sinon il attend X tours
     */
        
        public abstract boolean estLibre();  
        
    /**
     * Méthode qui permet de passer le tour et affiche des informations suivant
     * le type de la case d'arrivée
     */

	public abstract void passeTour();

        
    /**
     * @return true si case occupée false sinon
     */

	public abstract boolean estBloquer();
        
    /**
     * @return l'index de la case
     */
        
	public abstract int getIndexCase();

    /**
     * Méthode qui simule le lancé des dés
     * @param lanceDe
     * @return l'index de la case atteinte par le jour a la fin
     */

	public abstract int Lance(int lanceDe);

}