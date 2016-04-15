/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.aeroport.pkg2016;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Vicenzo
 */
public class MainAeroport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //Chargement des fichiers
        System.out.println("********************************Chargement des fichiers********************************");
        System.out.println("Chargement fichier Avion");
        Avion.chargerFichierAvions();
        System.out.println("Chargement fichier Vol");
        Vol.chargerFichierVols();
        System.out.println("Chargement fichier Vol Arrivee");
        VolArrive.chargerFichierVolsArrivee();
 

        
        
        // La partie 1 et la partie 2 sont obsolète pour le projet
        //J'ai laissé cette partie pour montrer comment nous faisons pour lire un fichier
        //Le but est de stocker les informations dans une hashtable
        System.out.println("********************************Test d'un menu********************************");
        boolean fini = false;
        while (fini == false) {
            System.out.println(" 1- Lecture liste des avions \n 2- Lecture fichier la liste des vols \n 3- Afficher la liste des avions charger dans la hashtable\n 4- Afficher la liste des vols charger dans la hashtable\n 5- Afficher la liste des vols arrivés \n0- Quitter le programme");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            switch (str) {
                case "1": //1- Afficher la liste des avions 
                {
                    try {
                        BufferedReader entree = new BufferedReader(new FileReader("avionsFA-16-v1.txt"));
                        String ligne = null;
                        while ((ligne = entree.readLine()) != null) {
                            StringTokenizer st = new StringTokenizer(ligne, " ");
                            String imatavion = st.nextToken();
                            String modelavion = st.nextToken();
                            System.out.println("immatriculation: " + imatavion + " Modele : " + modelavion);
                        }
                    } catch (IOException e) {
                        System.out.println(" Fichier non trouvé ");
                    }
                    break;
                }

                case "2": //2- Afficher la liste des vols
                {
                    try {
                        BufferedReader entree = new BufferedReader(new FileReader("ProgrammeVolsFA-16-v1.txt"));
                        String ligne = null;
                        String vol = null;
                        while ((ligne = entree.readLine()) != null) {
                            StringTokenizer st = new StringTokenizer(ligne, " ");
                            String numvol = st.nextToken();
                            String heure = st.nextToken();
                            String minute = st.nextToken();
                            String lieu = st.nextToken();
                            String modelavion = st.nextToken();
                            if (vol == null || !modelavion.equals(vol)) {
                                System.out.println("Num Vol: " + numvol + " Heure : " + heure + " h " + minute + " lieu : " + lieu + " Modele : " + modelavion + " ARRIVEE");
                                vol = modelavion;
                            } else if (vol.equals(modelavion)) {
                                System.out.println("Num Vol: " + numvol + " Heure : " + heure + " h " + minute + " lieu : " + lieu + " Modele : " + modelavion + " DEPART");
                            }

                        }
                    } catch (IOException e) {
                        System.out.println(" Fichier non trouvé ");
                    }
                    break;
                }
                
                case "3": //3- Afficher la liste des avions hashtable
                {
                    Avion.afficherLesAvions();
                    break;
                }
                case "4": //4- Afficher la liste des vols hashtable
                {
                    Vol.afficherLesVols();
                    break;
                }
                case "5": //5- Afficher la liste des vols arrivés hashtable
                {
                    VolArrive.afficherLesVolsArrivee();;
                    break;
                }
                case "6": //5- Afficher la liste des vols départ hashtable
                {
                    Vol.afficherLesVols();
                    break;
                }

                case "0":
                    fini = true;
                    break;
                default: {
                    System.out.println("Saisie invalide");
                    break;
                }
            }
        }

        System.out.println("********************************Lecture des fichiers********************************");
        System.out.println("********************************AVIONS********************************");
        try {
            BufferedReader entree = new BufferedReader(new FileReader("avionsFA-16-v1.txt"));
            String ligne = null;
            while ((ligne = entree.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(ligne, " ");
                String imatavion = st.nextToken();
                String modelavion = st.nextToken();
                System.out.println("immatriculation: " + imatavion + " Modele : " + modelavion);
            }
        } catch (IOException e) {
            System.out.println(" Fichier non trouvé ");
        }
        System.out.println("\n");
        System.out.println("****************************************************************");
        System.out.println("********************************VOLS********************************");
        try {
            BufferedReader entree = new BufferedReader(new FileReader("ProgrammeVolsFA-16-v1.txt"));
            String ligne = null;
            String vol = null;
            while ((ligne = entree.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(ligne, " ");
                String numvol = st.nextToken();
                String heure = st.nextToken();
                String minute = st.nextToken();
                String lieu = st.nextToken();
                String modelavion = st.nextToken();
                if(vol == null || !vol.equals(modelavion)){
                 System.out.println("Num Vol: " + numvol + " Heure : " + heure + " h " + minute + " lieu : " + lieu + " Modele : " + modelavion + "ARRIVE");
                 vol = modelavion;
                }
                else{
                    System.out.println("Num Vol: " + numvol + " Heure : " + heure + " h " + minute + " lieu : " + lieu + " Modele : " + modelavion + "DEPART"); 
                }
               
            }
        } catch (IOException e) {
            System.out.println(" Fichier non trouvé ");
        }

    }

}
