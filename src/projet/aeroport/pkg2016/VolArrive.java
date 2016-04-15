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
public class VolArrive extends Vol {

    private String provenance;
    private static Hashtable<String, VolArrive> lesVolsArrivee = new Hashtable<String, VolArrive>();

    // Constructeurs
    public VolArrive(String cV, int heure, int minute, String prov,/*String l,*/ String cA) {
        super(cV, heure, minute, cA);
        provenance = prov;
        lesVolsArrivee.put(cV, this);
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String toStringVolArrivee() {
        String info = toString() + " Provenance : " + provenance;
        return (info);
    }

    public void afficherVolArrivee() {
        System.out.println(toStringVolArrivee());
    }

    public static String toStringAllVolsArrivee() {
        String info = new String();
        Iterator<VolArrive> it = lesVolsArrivee.values().iterator();

        while (it.hasNext()) {
            info = info + ((VolArrive) it.next()).toString() + "\n";
        }

        return info;
    }

    public static void afficherLesVolsArrivee() {
        System.out.println(toStringAll());
    }

    public static void chargerFichierVolsArrivee() throws IOException {
        try {

            // Chemin absolu OU Chemin relatif : ajouter le fichier dans Project/Proprieties/Linked Ressources/New/File
            BufferedReader entree = new BufferedReader(new FileReader("ProgrammeVolsFA-16-v1.txt"));

            String ligne = entree.readLine();
			//int i=0;

            while (ligne != null && ligne.length() > 3 && ligne != "") {
                StringTokenizer st = new StringTokenizer(ligne);

                String code = st.nextToken();
                int heure = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                String prov = st.nextToken();
                String codeAvion = st.nextToken();

                VolArrive newVolA = new VolArrive(code, heure, minute, prov, codeAvion);

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
