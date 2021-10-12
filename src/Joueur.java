/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class Joueur 
{

    private Case cc;
    private String nom;

    

    /**
     * constructeur de base
     * @param n
     * @param c
     */
    public Joueur (String n, Case c)
    {
        this.nom = n;
        this.cc = c;
    }

    /**
     * constructeur de base sans joueur
     * @param nom
     */
    public Joueur (String nom)
    {
        this(nom, null);
    }

    // retourne le nom du joueur
    @Override
    public String toString() 
    { 
        return nom; 
    }


    /**
     * @return la case du joueur courant
     */
    public Case getCase() 
    { 
       return this.cc ; 
    }

    /**
     * fixe la case du joueur courant
     * @param nouvCase
     */
    public void setCase(Case nouvCase) 
    { 
       this.cc = nouvCase; 
    }    

    // methode de simulation du lancé de dé
    private int lanceDe() 
    {	
       return (int)(1+ 6*Math.random());
    }
    
    /**
     *  simule deux lancés de dé
     * @return resultat
     */
    public int deuxLance() 
    {
        int resultat = lanceDe() + lanceDe();
        return resultat;
    }
}