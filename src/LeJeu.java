
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class LeJeu 
{

	String[] phrases = 
                {
                 "La chance va sourire à quelqu'un !"
                ,"Les dés doivent ête pipés, on risque pas de finir"
                ,"Y'aura-t-il un gagnant ?"
                ,"Jamais de chance de toute façon ..!"
                ,"Allez on y est presque ..."
                ,"Pourquoi on joue à ce jeu franhement?"
                ,"Le tapis de jeu va sortir par la fenêtre attention ..."
                ,"Je commence à m'agacer ..!"
                ,"Ehhh dis-donc toi arrête de tricher !"
                ,"Tu veux pas que je t'aide toi à truquer le dé?"
                };
        
        private final String end = ("------ Fin du Jeu ------"); 
	private List<Joueur> lesJoueurs = new ArrayList<>();
	private final JeuDeLoie jeu;
	private boolean finJeu;
        
    /**
     * constructeur du jeu
     * @param jeu
     */
	public LeJeu (JeuDeLoie jeu) 
        {
		this.jeu = jeu;
		this.lesJoueurs = new ArrayList<> ();
		this.finJeu = false;
	}

        public String PhraseAleatoire()
        {
          return phrases[((int)(Math.random() * phrases.length))];
        }
        
    /**
     *
     * @return true si le jeu est finit, false sinon
     */
	public boolean getFinJeu() 
        {
		return this.finJeu;
	}
        
    /**
     * fixe la fin du jeu ou non
     * @param fin
     */
	public void setFinJeu(boolean fin) 
        {
		this.finJeu = fin;
	}


    /**
     *
     * @return l'instance de JeuDeLoie
     */
	public JeuDeLoie getJeu() 
        {
		return this.jeu;
	}


    /**
     * l'ajout d'un joueur p au jeu
     * @param j
     */
	public void ajoutJoueur(Joueur j) 
        {
		this.lesJoueurs.add(j);
		this.getJeu().getCases()[0].setJoueur(j);
	}


    /**
     * methode 'execute' entre autre, permet le deroulement du jeu
     */
	public void deroulementJeu()
        { 
            Scanner scanner = new Scanner(System.in);        
            int tailleJeu = this.getJeu().getNbCases() - 1;
	
            
                tourdejeu: // (label) tour de jeu
		for (Joueur j : lesJoueurs) {
                    
                        // si le joueur est 'libre' cad le joueur peut quitter la case
			if (j.getCase().estLibre()) {
                                 
                                int lanceDe = j.deuxLance();
                                int indexDepart = j.getCase().getIndexCase();
				int indexApresLance = indexDepart + lanceDe;
				int indexCalcul;
				int destination;

				/* If the player is not out of the board */

				if (indexApresLance < tailleJeu + 1) {
					indexCalcul = indexApresLance;
                                        destination = this.getJeu().getCase(indexCalcul).Lance(lanceDe);
				} else {
					indexCalcul = tailleJeu - (lanceDe - (tailleJeu - indexDepart));
					destination = indexCalcul;
                                }
				/* gives the status of the player */
				System.out.print(j.toString() + " est dans la case n° : " +indexDepart +".");
				System.out.println(" Résultat des dés : " +lanceDe + ". Il arrive dans la case n° : " +indexCalcul +".");
                                // bug, echange au niveau de la case de depart et non de fin
				Case CaseDestination = this.getJeu().getCase(destination);			
				CaseDestination.Echange(j);
				j.setCase(CaseDestination);
				this.getJeu().getCase(destination).setJoueur(j);
                                
                                        if (destination == tailleJeu) 
                                        { // Si un joueur a gagné
                                                System.out.println(j.toString() + " est dans la case " +destination
                                                                +" il a donc gagné ! Youpi !");
                                                this.setFinJeu(true);
                                                break;
                                        }
                                
                                        } else 
                                        { // sinon on passe le tour                        
                                                j.getCase().passeTour();
                                        }  
                        
                                } 
                System.out.println();
                System.out.println("Pour lancer le tour suivant appuyez sur Entrer, pour quitter appuyez sur N puis Entrer");
                if(scanner.nextLine().equalsIgnoreCase("N"))
                {
                    System.out.println();
                    System.out.println();
                    System.out.println(end);
                    System.exit(0);
                }
        }      

        
    /**
     * fixe le nombre de tour, toute fois le jeu peut se terminer avant le nombre de tours si un joueur a gagne
     * @param nbTours
     */
	public void nombredeTours(int nbTours) 
        {
                
		int i = 0;
                    while (i < nbTours & !this.getFinJeu()){ // si le nombre de tour n'est pas dépassé et si le jeu n'est pas finis
                            System.out.println("\n"+ "Tour : "+(i+1)+"\n");
                            System.out.println();
                                if( i >= 3)
                                {
                                System.out.println("Un joueur pense à haute voix ... : "+PhraseAleatoire());
                                }
                            System.out.println();
                            this.deroulementJeu();
                            i++;
                            }
                
                if(this.getFinJeu())
                {
                        System.out.println(end);
                        System.out.println();
                        System.out.println("Voulez-vous rejouer? (Oui/Non)");
                        String prop = Lire.S();
                        if(prop.equalsIgnoreCase("Oui"))
                            
                        {
                            
                            JeuDeLoie nouvPartie = new JeuDeBase();
                            LeJeu Jeu1 = new LeJeu (nouvPartie);
                            Jeu1.getJeu().initTapisDeJeu();
                            System.out.println("Voulez vous supprimer un joueur ?");
                            String rep = Lire.S();

                                if(rep.equalsIgnoreCase("Non"))
                                {
                                    System.out.println("Voulez vous ajouter un joueur ?"); // AJOUT DES JOUEURS AU PLUS 4 
                                    String ajout = Lire.S();

                                    if(ajout.equalsIgnoreCase("Oui"))
                                    {
                                        int last = lesJoueurs.size();

                                         if(last==2)
                                            {                       
                                            System.out.println("Saisir le nom du joueur 1 :");
                                            String nom1 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 2 :");
                                            String nom2 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 3 :");
                                            String nom3 = Lire.S();
                                            Joueur joueur1 = new Joueur(nom1);
                                            Joueur joueur2 = new Joueur(nom2);
                                            Joueur joueur3 = new Joueur(nom3);
                                            Jeu1.ajoutJoueur(joueur1);
                                            Jeu1.ajoutJoueur(joueur2);
                                            Jeu1.ajoutJoueur(joueur3);
                                            Jeu1.nombredeTours(50);
                                            }
                            
                                            if(last==3)
                                            {                       
                                            System.out.println("Saisir le nom du joueur 1 :");
                                            String nom1 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 2 :");
                                            String nom2 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 3 :");
                                            String nom3 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 4 :");
                                            String nom4 = Lire.S();
                                            Joueur joueur1 = new Joueur(nom1);
                                            Joueur joueur2 = new Joueur(nom2);
                                            Joueur joueur3 = new Joueur(nom3);
                                            Joueur joueur4 = new Joueur(nom4);
                                            Jeu1.ajoutJoueur(joueur1);
                                            Jeu1.ajoutJoueur(joueur2);
                                            Jeu1.ajoutJoueur(joueur3);
                                            Jeu1.ajoutJoueur(joueur4);
                                            Jeu1.nombredeTours(50);
                                            }
                            
                                    if(last==4)
                                        {   
                                            System.out.println("Trop nombreux donc trop de bazar, impossible de jouer!");
                                            System.out.println();
                                            System.out.println("Voulez vous rejouer à 4 ?");
                                            String reponse = Lire.S();
                                            
                                            if(reponse.equalsIgnoreCase("Oui"))
                                                {
                                            System.out.println("Saisir le nom du joueur 1 :");
                                            String nom1 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 2 :");
                                            String nom2 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 3 :");
                                            String nom3 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 4 :");
                                            String nom4 = Lire.S();
                                            Joueur joueur1 = new Joueur(nom1);
                                            Joueur joueur2 = new Joueur(nom2);
                                            Joueur joueur3 = new Joueur(nom3);
                                            Joueur joueur4 = new Joueur(nom4);
                                            Jeu1.ajoutJoueur(joueur1);
                                            Jeu1.ajoutJoueur(joueur2);
                                            Jeu1.ajoutJoueur(joueur3);
                                            Jeu1.ajoutJoueur(joueur4);
                                            Jeu1.nombredeTours(50); 
                                                }
                                            
                                            else
                                                {
                                            System.out.println("Au revoir !");
                                            System.out.println(end);
                                            System.exit(0);
                                                }
                                        }
                                    }
                                }
                                
                            else
                            {
                                int last = lesJoueurs.size();
                                lesJoueurs.remove(last-1);                      
                                System.out.println();
                                                 
                        
                                if(last-1==1)
                                {       
                                    System.out.println("C'est trop triste de joueur seul quand meme, impossible de jouer seul!");
                                    System.out.println("Voulez vous rejouer à 2 ?");
                                    String reponse = Lire.S();
                                    if(reponse.equalsIgnoreCase("Oui"))
                                    {
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("Saisir le nom du joueur 1 :");
                                    String nom1 = Lire.S();
                                    System.out.println("Saisir le nom du joueur 2 :");
                                    String nom2 = Lire.S();
                                    Joueur joueur1 = new Joueur(nom1);
                                    Joueur joueur2 = new Joueur(nom2);
                                    Jeu1.ajoutJoueur(joueur1);
                                    Jeu1.ajoutJoueur(joueur2);
                                    Jeu1.nombredeTours(50); 
                                    }
                                    
                                    else
                                    {
                                    System.out.println("Au revoir !");
                                    System.out.println(end);
                                    System.exit(0);
                                    }
                                }   
                        
                                    if(last-1==2) // DELETE DES JOUEURS AU MOINS 2
                                    {       System.out.println("Joueur numéro "+(last)+" supprimé ");
                                            System.out.println("Que "+(last-1)+" joueurs maintenant !"); 
                                            System.out.println();
                                            System.out.println();
                                            System.out.println("Saisir le nom du joueur 1 :");
                                            String nom1 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 2 :");
                                            String nom2 = Lire.S();
                                            Joueur joueur1 = new Joueur(nom1);
                                            Joueur joueur2 = new Joueur(nom2);
                                            Jeu1.ajoutJoueur(joueur1);
                                            Jeu1.ajoutJoueur(joueur2);
                                            Jeu1.nombredeTours(50);
                                    }
                            
                                    if((last-1)==3)
                                    {        
                                            System.out.println("Joueur numéro "+(last)+" supprimé ");
                                            System.out.println("Que "+(last-1)+" joueurs maintenant !");
                                            System.out.println("Saisir le nom du joueur 1 :");
                                            String nom1 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 2 :");
                                            String nom2 = Lire.S();
                                            System.out.println("Saisir le nom du joueur 3 :");
                                            String nom3 = Lire.S();
                                            Joueur joueur1 = new Joueur(nom1);
                                            Joueur joueur2 = new Joueur(nom2);
                                            Joueur joueur3 = new Joueur(nom3);
                                            Jeu1.ajoutJoueur(joueur1);
                                            Jeu1.ajoutJoueur(joueur2);
                                            Jeu1.ajoutJoueur(joueur3);
                                            Jeu1.nombredeTours(50);
                                    }
                            
                                    if((last-1)==4)
                                    {                               
                                        System.exit(0);
                                    }
                                }
                        } 
                        
                    {
                        System.exit(0);
                    }
                }   
	}    
}

