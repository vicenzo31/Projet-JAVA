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
import java.util.StringTokenizer;

/**
 *
 * @author Vicenzo
 */
public class ProjetAeroport2016 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        System.out.println("********************************AVIONS********************************");
        try{
           BufferedReader entree = new BufferedReader(new FileReader("avionsFA-16-v1.txt")); 
           String ligne = null;
           while((ligne=entree.readLine()) != null){
           StringTokenizer st = new StringTokenizer(ligne, " ");         
               String imatavion = st.nextToken();
               String modelavion = st.nextToken();
               System.out.println("immatriculation: " + imatavion + " Modele : " + modelavion);    
           }
        }catch (IOException e){
            System.out.println(" Fichier non trouvé ");
        }
        System.out.println("\n");
        System.out.println("****************************************************************");
        System.out.println("********************************VOLS********************************");
        try{
           BufferedReader entree = new BufferedReader(new FileReader("ProgrammeVolsFA-16-v1.txt")); 
           String ligne = null;
           while((ligne=entree.readLine()) != null){
           StringTokenizer st = new StringTokenizer(ligne, " ");         
               String numvol = st.nextToken();
               String heure = st.nextToken();
               String minute = st.nextToken();
               String lieu = st.nextToken();
               String modelavion = st.nextToken();
               System.out.println("Num Vol: " + numvol + " Heure : " + heure + " h " + minute + " lieu : " + lieu + " Modele : " + modelavion);    
           }
        }catch (IOException e){
            System.out.println(" Fichier non trouvé ");
        }
        
        
    }

}
