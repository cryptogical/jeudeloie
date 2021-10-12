
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

public abstract class JeuDeLoie 
{

	private final int nbCases;
	private Case[] lesCases;

    /**
     * construit le jeu avec nbc cases
     * @param nbc
     */
	public JeuDeLoie (int nbc) 
        {
		this.nbCases = nbc;
	}
        

    /**
     * cré
     */
	public abstract void initTapisDeJeu();


    /**
     * @return le tableau des cases du jeu
     */
	public Case[] getCases() 
        {
		return this.lesCases;
	}


    /**
     * on change de tableau de case, en prenant 'c' comme nouveau tableau de case
     * @param c
     */
	public void setLesCases(Case[] c) 
        {
		this.lesCases = c;
	}


    /**
     * @param n
     * @return  la case numero n
     */
	public Case getCase(int n)
        {
		return this.getCases()[n];
	}


    /**
     * @return le nombre de case
     */
	public int getNbCases() 
        {
		return this.nbCases;
	}

}