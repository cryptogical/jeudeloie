
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ssky
 */
public class Main 
{

    /**
     * Methode main : créé l'instance de JeuDeLoie qui va permettre de jouer 
                créer une intance de LeJeu, on passe en parametre 'jeu'
                de type JeuDeLoie, on lance le jeu avec initTapisDeJeu(),
                on créer X joueurs puis on les ajoutes au LeJeu,
                on fixe le nombre de tours à jouer,
                le jeu se termine avant si un joueur
                a gagné, sinon le jeu continue jusqu'au
                Xieme tour que la partie soit gagnee ou non.
     *                
     * @param args
     */
    public static void main(String[] args)
	{
                        JeuDeLoie jeu = new JeuDeBase();
                        LeJeu Jeu1 = new LeJeu (jeu);
                        Jeu1.getJeu().initTapisDeJeu();
                        String info = ("BEGIN ----> Notez bien que ce jeu est une modélisation\n"
                                +" du jeu réel il colle assez bien à la réalité \n"
                                +" toute fois il peut persister encore quelques \n"
                                +" bugs non résolus et non trouves par manque de temps. \n"
                                +" Toute fois c'était un projet très intéréssant à coder \n"
                                +" et j'espère qu'il vous plaira. END <----");
                        
                        String debut = " Bienvenu dans le Jeu de L'Oie ! \n"
                        +" Choisissez le nombre de joueur puis saisissez \n"
                        +" le nom des joueurs, puis la partie commencera \n"
                        +" Vous pourrez arrêter la partie en cours si vous le voulez. \n"
                        +" Bon jeu à vous !";
            
                        //System.out.println(info);
                        System.out.println();
                        System.out.println();
                        System.out.println("Dicton : La plupart des gens trouvent le concept de la programmation évident, mais la réalisation impossible.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        System.out.println("<< ...... ???? >>");
                        
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        System.out.println("<< On peut passer au projet sinon ? >>");
                        
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        System.out.println("............");
                        System.out.println();
                        System.out.println();
                        System.out.println(debut);
                        System.out.println();
                        System.out.println();
                        
                        System.out.println("A combien voulez-vous jouer? Le chiffre doit être 2,3 ou 4");
                        String Snombre = Lire.S();
                        int nombre = Integer.parseInt(Snombre);
                        do{
                            
                        if(nombre == 2)
                        {
                                System.out.println("Saisir le nom du joueur 1 :");
                                String nom1 = Lire.S();
                                if(nom1.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom1 = Lire.S();
                                }
                                System.out.println("Saisir le nom du joueur 2 :");
                                String nom2 = Lire.S();
                                if(nom2.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom2 = Lire.S();
                                }
                                Joueur joueur1 = new Joueur(nom1);
                                Joueur joueur2 = new Joueur(nom2);
                                Jeu1.ajoutJoueur(joueur1);
                                Jeu1.ajoutJoueur(joueur2);
                                Jeu1.nombredeTours(50);    
                        }
                        
                        if(nombre == 3)
                        {
                                System.out.println("Saisir le nom du joueur 1 :");
                                String nom1 = Lire.S();
                                if(nom1.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom1 = Lire.S();
                                }
                                System.out.println("Saisir le nom du joueur 2 :");
                                String nom2 = Lire.S();
                                if(nom2.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom2 = Lire.S();
                                }
                                System.out.println("Saisir le nom du joueur 3 :");
                                String nom3 = Lire.S();
                                if(nom3.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom3 = Lire.S();
                                }
                                Joueur joueur1 = new Joueur(nom1);
                                Joueur joueur2 = new Joueur(nom2);
                                Joueur joueur3 = new Joueur(nom3);
                                Jeu1.ajoutJoueur(joueur1);
                                Jeu1.ajoutJoueur(joueur2);
                                Jeu1.ajoutJoueur(joueur3);
                                Jeu1.nombredeTours(50);   
                        }
                        
                        if (nombre == 4)
                            
                        {
                                System.out.println("Saisir le nom du joueur 1 :");
                                String nom1 = Lire.S();
                                if(nom1.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom1 = Lire.S();
                                }

                                System.out.println("Saisir le nom du joueur 2 :");
                                String nom2 = Lire.S();
                                if(nom2.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom2 = Lire.S();
                                }
                                
                                
                                System.out.println("Saisir le nom du joueur 3 :");
                                String nom3 = Lire.S();
                                if(nom3.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom3 = Lire.S();
                                }
                                System.out.println("Saisir le nom du joueur 4 :");
                                String nom4 = Lire.S();
                                if(nom4.isEmpty())
                                {
                                    System.out.println("Impossible le nom ne peut pas être vide, retaper :");
                                    nom4 = Lire.S();
                                }
                                
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
                            System.out.println("Vous avez fais planter l'application, relancez là !");
                            System.err.close();
                        }
                        
                        }while(nombre > 1 && nombre < 4);
	}
}