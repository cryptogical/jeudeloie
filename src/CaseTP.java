/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class CaseTP extends Case
{

	private int index;
	private Joueur joueur;


    /**
     * constructeur de base
     * @param index
     * @param j
     */
	public CaseTP(int index, Joueur j) 
        {
		this.index = index;
		this.joueur = j;
	}

    /**
     * constructeur pour créer des cases teleportations
     * @param index
     */
	public CaseTP(int index) 
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
     * @return l'index de la case apres action
     */
        @Override
	public int Lance(int de) 
        {

		int tpIndex = 0;

		if(this.getIndexCase() == 6) 
                { 
                tpIndex = 12;
                System.out.print("Le joueur ci-dessous a rejoint une case de téléportation, case n° 6.");
		System.out.println(" Il est alors maintenant dans la case " + tpIndex);
                }

		if(this.getIndexCase() == 42) 
                { 
                tpIndex = 30;
                System.out.print("Le joueur ci-dessous a rejoint la case labyrinthe, case n° 42.");
		System.out.println(" Il est alors maintenant dans la case " + tpIndex);
                }

		if(this.getIndexCase() == 58) 
                { 
                tpIndex = 1;
                System.out.print("Le joueur ci-dessous a rejoint la case Tête de mort, case n° 58.");
		System.out.println(" Il est alors maintenant dans la case " + tpIndex);
                }
                
		return tpIndex;
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
     * @param j
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
     * Rien à faire ici
     */
    @Override
	public void passeTour(){
        System.out.println("");
        }
}
