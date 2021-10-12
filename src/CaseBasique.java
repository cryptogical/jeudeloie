/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class CaseBasique extends Case 
{

	private int index;
	private Joueur joueur;
	

    /**
     * constructeur de base
     * @param index
     * @param j
     */
	public CaseBasique(int index, Joueur j) 
        {
		this.index = index;
		this.joueur = j;
	}


    /**
     * constructeur pour créer case basique sans joueurs
     * @param index
     */
	public CaseBasique(int index) 
        {
		this.index = index;
		this.joueur = null;
	}

    /**
     * @return true si le joueur est libre, false sinon
     */
        @Override
	public boolean estLibre()
        {
		return true;
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
     * @return l'index de la case speciale, ici case attente
     */
        @Override
	public int Lance(int de) 
        {
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
     * fixe le joueur
     * @param jc
     */
        @Override
	public void setJoueur(Joueur jc) 
        {
		this.joueur = jc;
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
        //System.out.println("Rien à faire ici ...");
        }
}
