/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.aeroport.pkg2016;

import java.util.Hashtable;
import java.util.Iterator;

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
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        String maChaine = "Avion numero " + code + "\n Nom : " + nom;
        return maChaine;
    }

    public static Avion getAvionParCode(String code) {

        return ensembleAvion.get(code);
    }

    public static String toStringAll() {
        String maChaine = new String();
        Iterator<Avion> it = ensembleAvion.values().iterator();
        while (it.hasNext()) {

            maChaine += ((Avion) it.next()).toString() + "\n\n";

        }
        return maChaine;
    }

}
