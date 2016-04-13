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
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author vrio
 */
public class Avion {

    private String code;
    private String nom;

    private static Hashtable<String, Avion> ensembleAvion = new Hashtable<String, Avion>();

    public Avion(String code, String nom) {
        this.code = code;
        this.nom = nom;
        ensembleAvion.put(code, this);
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        String maChaine = " Avion numero " + code + "\n Nom : " + nom;
        return maChaine;
    }

    public static String toStringAll() {
        String maChaine = new String();
        Iterator<Avion> it = ensembleAvion.values().iterator();
        while (it.hasNext()) {

            maChaine += ((Avion) it.next()).toString() + "\n\n";

        }
        return maChaine;
    }

    public static void afficherLesAvions() {
        System.out.println(toStringAll());
    }

    public static void chargerFichierAvions() throws IOException {
        try {
            // Chemin absolu OU Chemin relatif : ajouter le fichier dans Project/Proprieties/Linked Ressources/New/File
            BufferedReader entree = new BufferedReader(new FileReader("avionsFA-16-v1.txt"));

            String ligne = entree.readLine();
            while (ligne != null && ligne.length() > 3 && ligne != "") {
                StringTokenizer st = new StringTokenizer(ligne);
                String code = st.nextToken();
                String nom = st.nextToken();
                Avion avion = new Avion(code, nom);
                //ligne suivante
                ligne = entree.readLine();
                //System.out.println(i++);
            }
            System.out.println("Chargement termine");
            entree.close();
            System.out.println("fichier ferme");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
