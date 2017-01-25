/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonctions;

public class Medecin {
    public String id;
    public String nom;
    public String prenom;
    public String dateNaissance;
    public String salaire;
    public String specialite;
    
    public Medecin(String i,String nm,String pn,String dn,String sl,String sp){
        id = i;
        nom = nm;
        prenom = pn;
        dateNaissance = dn;
        salaire = sl;
        specialite = sp;
    }
}

