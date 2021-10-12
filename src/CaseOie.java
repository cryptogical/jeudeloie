/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */

public class CaseOie extends Case
{

	private int index;
	private Joueur joueur;


    /**
     * constructeur de base
     * @param index
     * @param j
     */
	public CaseOie(int index, Joueur j) 
        {
		this.index = index;
		this.joueur = j;
	}


    /**
     * constructeur pour creer des cases oie
     * @param index
     */
	public CaseOie(int index) 
        {
		this.index = index;
		this.joueur = null;
	}


    /**
     * @return l'index
     */
        @Override
	public int getIndexCase() 
        {
		return this.index;
	}

    /**
     * @return true si la case est libre, sinon false
     */
        @Override
	public boolean estLibre()
        {
		return true;
	}

    /**
     * @return true si la case est occupee, sinon false
     */
        @Override
	public boolean estBloquer() 
        {
		return this.joueur != null;
	}
        
    private int Aleatoire() 
    {	
       return (int)(1+ 3*Math.random());
    }

    /**
     * @param lanceDe
     * @return l'index de la case apres action
     */
        @Override
	public int Lance(int lanceDe) 
        {
            if(this.getIndexCase() == 9 && Aleatoire() == 3)
            {
                    int nouvIndex = 53;
                    System.out.println("Le joueur ci-dessous tombe sur la case "+this.getIndexCase()+".");
                    System.out.println("La chance vous sourie et vous allez à la case "+nouvIndex+" !");
                    return nouvIndex;  
            }
                
            else
            {
                System.out.print
                ("La case " + this.getIndexCase()+ " est une case oie ! ");
                int nouvIndex =  this.getIndexCase() + lanceDe;  // se déplace en plus du nombre affiché par les dés
		System.out.println(" Le Joueur ci-dessous est donc à la case numéro " +nouvIndex+".");
		return nouvIndex;
            }   
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
     * Méthode qui permet de passer le tour et affiche des informations suivant
     * le type de la case d'arrivée
     */
    @Override
	public void passeTour()
        {
        //System.out.println("La chance d'être tombé sur une case oie ...");
        }
}