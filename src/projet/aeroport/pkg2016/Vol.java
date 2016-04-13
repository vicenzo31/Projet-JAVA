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
import packhoraires.Horaire;

/**
 *
 * @author vrio
 */
public class Vol {

    private String codeVol;
    private Horaire horaire;
    private String codeAvion;
    private String lieux;
    private static Hashtable<String, Vol> lesVols = new Hashtable<String, Vol>();

    public Vol() {
    }

    public Vol(String cV, int heure, int minute, String l, String cA) {
        codeVol = cV;
        horaire = new Horaire(heure, minute);
        lieux = l;
        codeAvion = cA;
        lesVols.put(codeVol, this);
    }

    public String getCodeVol() {
        return codeVol;
    }

    public String getCodeAvion() {
        return codeAvion;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public String getLieux() {
        return lieux;
    }

    @Override
    public String toString() {
        return " Numero du vol: " + codeVol + "\n Horaire: " + horaire + "\n Lieux: " + lieux + "\n Code Avion: " + codeAvion + "\n Hall" + "\n Porte" + '\n';
    }

    public void afficherVol() {
        System.out.println(toString());
    }

    public static String toStringAll() {
        String info = new String();
        Iterator<Vol> it = lesVols.values().iterator();

        while (it.hasNext()) {
            info = info + ((Vol) it.next()).toString() + "\n";
        }
        return info;
    }

    public static void afficherLesVols() {
        System.out.println(toStringAll());
    }

    public static void chargerFichierVols() throws IOException {
        try {

            // Chemin absolu OU Chemin relatif : ajouter le fichier dans Project/Proprieties/Linked Ressources/New/File
            BufferedReader entree = new BufferedReader(new FileReader("ProgrammeVolsFA-16-v1.txt"));
            String ligne = entree.readLine();
            while (ligne != null && ligne.length() > 3 && ligne != "") {
                StringTokenizer st = new StringTokenizer(ligne);
                String code = st.nextToken();
                int heure = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                String lieux = st.nextToken();
                String codeAvion = st.nextToken();
                Vol newVol = new Vol(code, heure, minute, lieux, codeAvion);
                //ligne suivante
                ligne = entree.readLine();
            }

            System.out.println("Chargement termine");
            entree.close();
            System.out.println("fichier ferme");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
