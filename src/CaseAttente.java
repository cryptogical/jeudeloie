/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class CaseAttente extends Case 
{

    
	private int index;
	private Joueur joueur;
	private int nbToursAttendre;


    /**
     * constructeur de base
     * @param index
     * @param j
     */
	public CaseAttente(int index, Joueur j) 
        {
		this.index = index;
		this.joueur = j;
		this.nbToursAttendre = 2;
	}

	

    /**
     * constructeur pour créer des cases attentes sans joueurs
     * @param index
     * @param nba
     */
	public CaseAttente(int index, int nba) 
        {
		this.index = index;
		this.joueur = null;
		this.nbToursAttendre = nba;
	}


    /**
     * @return le nombre de tour à attendre
     */
	public int getNbToursAttendre()
        {
		return this.nbToursAttendre;
	}

 

    /**
     * fixe le nombre de tour à attendre
     * @param nb
     */
	public void setNbToursAttendre(int nb)
        {
		this.nbToursAttendre = nb;
	}


    /**
     * @return true si le joueur peut bouger, false sinon
     */
        @Override
	public boolean estLibre()
        {
            return this.getNbToursAttendre() == 0;
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
     * @return true si une casse est occupee, false sinon
     */
        @Override
	public boolean estBloquer() 
        {
		return this.joueur != null;
	}


    /**
     * @param de
     * @return l'index de la case
     */
        @Override
	public int Lance(int de) 
        {
		//System.out.println(" Le joueur ci-dessous rentre dans une case d'attente ! ");
                System.out.println("Le joueur ci-dessous rentre dans une case d'attente ! ");
		return this.getIndexCase();
	}

    /**
     * @return le joueur
     */
        @Override
	public Joueur getJoueur() {
		return this.joueur;
	}

    /**
     * @param j fixe le joueur
     */
	public void setJoueur(Joueur j) {
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
	public void passeTour(){
		System.out.println("Le joueur " +this.getJoueur() +" doit attendre : "
				+ this.getNbToursAttendre() + " tours avant de pouvoir jouer ! ");
		int nbtRestant = this.getNbToursAttendre() - 1;
		this.setNbToursAttendre(nbtRestant);
		}
}
