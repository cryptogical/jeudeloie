
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class CaseDepart extends Case
{

	private int index;
	private List<Joueur> lesJoueurs;

    /**
     * constructeur de base
     * @param index
     * @param lesjoueursDepart
     */
	public CaseDepart(int index, List<Joueur> lesjoueursDepart) 
        {
		this.index = index;
		this.lesJoueurs = lesjoueursDepart;
	}


    /**
     * constructeur pour créer case basique sans joueurs
     * @param index
     */
	public CaseDepart(int index) 
        {
		this.index = index;
		this.lesJoueurs = new ArrayList<>();
	}

    /**
     * @return true si le joueur peut se deplacer, false sinon
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
		return this.lesJoueurs != null;
	}

    /**
     * @param de
     * @return l'index de la case speciale (0), ici case depart
     */
        @Override
	public int Lance(int de) 
        {
		return 0;
	}

    /**
     * @return la liste des joueurs
     */
	public List<Joueur> getJoueurs() 
        {
		return this.lesJoueurs;
	}

    /**
     * @return le joueur
     */
        @Override
	public Joueur getJoueur() 
        {
                // ou if(this.getJoueurs().size() == 0)
		if(this.getJoueurs().isEmpty()) return null;
		return this.getJoueurs().get(0);
	}

    /**
     * @param j fixe le joueur à la case depart
     */
        @Override
	public void setJoueur(Joueur j) 
        {
		if(!this.getJoueurs().contains(j))
                {
			this.getJoueurs().add(j);
			j.setCase(this);
		}
	}

    /**  
     * Méthode qui permet d'échanger la position des joueurs
     * @param j
     */
    @Override
	public void Echange(Joueur j)
        {
        System.out.println("Sur la case départ il est autorisé d'être plusieurs");
        }

    /**
     * Méthode qui permet de passer le tour et affiche des informations suivant
     * le type de la case d'arrivée
     */
    @Override
	public void passeTour()
        {
        //System.out.println("Début du Jeu");
        }
}