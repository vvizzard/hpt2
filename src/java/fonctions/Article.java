/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonctions;

public class Article {
    
/** ATTRIBUTS*/    
    private String id;
    private String nom;
    private double prix; 
    
/** CONSTRUCTOR*/
    public Article() {
    }
    public Article(String id, String nom, double prix) {
        this.setId(id);
        this.setNom(nom);
        this.setPrix(prix);
    }
    public Article(String nom,double prix) {        
        this.setNom(nom);
        this.setPrix(prix);
    }

/** GETTERS */
    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
    }
    public String getPrixString() {
        return Double.toString(prix);
    }    
    
/** SETTERS*/
    public void setId(String id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(String prix) {
        this.prix = Double.parseDouble(prix);
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
}

