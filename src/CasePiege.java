/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class CasePiege extends Case 
{

	private int index;
	private Joueur joueur;


    /**
     * constructeur de base
     * @param index
     * @param j
     */
	public CasePiege(int index, Joueur j) 
        {
		this.index = index;
		this.joueur = j;
	}


    /**
     * constructeur pour créer des cases pieges
     * @param index
     */
	public CasePiege(int index) 
        {
		this.index = index;
		this.joueur = null;
	}

    /**
     * @return true si la case est libre, false sinon
     */
        @Override
	public boolean estLibre()
        {
		return false;
	}

    /**
     * @return l'index de la case
     */
        @Override
	public int getIndexCase() 
        {
		return this.index;
	}

    /**
     * @return true si la case est occupee, false sinon
     */
        @Override
	public boolean estBloquer() 
        {
		return this.joueur != null;
	}

    /**
     * @param de
     * @return l'index de la case apres action
     */
        @Override
	public int Lance(int de) 
        {
		System.out.println("Le Joueur ci-dessous a rejoint une case piège ! ");
		return this.getIndexCase();
	}

    /**
     * @return le joueur
     */
        @Override
	public Joueur getJoueur() 
        {
		return this.joueur;
	}
        
    /**
     * @param j fixe le joueur
     */
        @Override
	public void setJoueur(Joueur j) 
        {
		this.joueur = j;
	}

    /**  
     * Méthode qui permet d'échanger la position des joueurs
     * @param j
     */
        @Override
	public void Echange(Joueur j)
        {
		if (this.getJoueur() != null && this.getJoueur() != j)
                {
			System.out.print("Le joueur "+this.getJoueur().toString()+" est déjà ici ! ");
			Joueur joueurAdeplacer = this.getJoueur();
			Case celluleDarrivee = j.getCase();
			joueurAdeplacer.setCase(celluleDarrivee);
                        System.out.println("Le joueur " +j.toString()+ " prends sa place et  "+joueurAdeplacer.toString()+ " va à la case numéro :" + celluleDarrivee.getIndexCase());
		}                        
	}

    /**
     * Méthode qui permet de passer le tour et affiche des informations suivant
     * le type de la case d'arrivée
     */
    @Override
	public void passeTour()
        {
		//System.out.println(" Ce joueur ci-dessous est dans une case piège ! "
		//		+ " Il doit attendre que quelqu'un rentre dans cette case ! ");
                System.out.println("Le joueur "+joueur.toString()+" est dans une case piège ! "
				+ " Il doit attendre que quelqu'un rentre dans cette case ! ");
	}
}