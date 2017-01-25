/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonctions;

public class Patient {
    
/** ATTRIBUTS*/    
    private String id;
//  private Dossier dossier;
    private String nom;
    private String prenom;
    private String dateNaissance; 
    
/** CONSTRUCTOR*/
    public Patient() {
    }
    public Patient(String id, String nom, String prenom, String dateNaissance) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }
    public Patient(String nom, String prenom, String dateNaissance) {        
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }

/** GETTERS */
    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }    
    
/** SETTERS*/
    public void setId(String id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

