/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class JeuDeBase extends JeuDeLoie 
{

    /**
     * constructeur de JeuDeBase
     */
	public JeuDeBase() 
        {
		super(64); // appelle le constructeur de JeuDeLoie avec la valeur 64
	}
        
    /**
     * construit le tableau du jeu 
     */
        @Override
	public void initTapisDeJeu()
        {
		Case[] Tapis = new Case[64];
                Tapis[0] = new CaseDepart(0);
                
		for (int i = 1; i < 64; i++) 
                {
			Tapis[i] = new CaseBasique(i);
		}    
                
                /*int CaseOie[] = {9, 18, 27, 36, 45};

		for (int i : CaseOie) 
                {

			Jeu [i] = new CaseOie(i);
		}*/
                
                //ou car qql bug
                Tapis[6]  = new CaseTP(6);
                Tapis[9]  = new CaseOie(9);
                Tapis[18] = new CaseOie(18);
		Tapis[19] = new CaseAttente(19,2);
                Tapis[27] = new CaseOie(27);
		Tapis[31] = new CasePiege(31);
                Tapis[36] = new CaseOie(36);
                Tapis[45] = new CaseOie(45);
		Tapis[52] = new CasePiege(52);
                Tapis[42] = new CaseTP(42);
                Tapis[54] = new CaseOie(54);
		Tapis[58] = new CaseTP(58);		
		this.setLesCases(Tapis);

	}
}