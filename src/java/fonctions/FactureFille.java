/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FactureFille {
    
/** ATTRIBUTS*/    
    private String id;
    private Article article;
    private FactureMere factureMere;
    private double remise;
    private int quantite; 
    private double montant;
    
/** CONSTRUCTOR*/
    public FactureFille() {
    }
    public FactureFille(String id, Article article, FactureMere factureMere, double remise, int quantite) {
        this.setId(id);
        this.setArticle(article);
        this.setFactureMere(factureMere);
        this.setRemise(remise);
        this.setQuantite(quantite);
    }
    public FactureFille(Article article, FactureMere factureMere, double remise, int quantite) {
        this.setArticle(article);
        this.setFactureMere(factureMere);
        this.setRemise(remise);
        this.setQuantite(quantite);
    }
    public FactureFille(String id, Article article, FactureMere factureMere, String remise, String quantite) {
        this.setId(id);
        this.setArticle(article);
        this.setFactureMere(factureMere);
        this.setRemise(remise);
        this.setQuantite(quantite);
    }    
    public FactureFille(Article article, FactureMere factureMere, String remise, String quantite) {
        this.setArticle(article);
        this.setFactureMere(factureMere);
        this.setRemise(remise);
        this.setQuantite(quantite);
    }    

/** GETTERS */
    public String getId() {
        return id;
    }
    public Article getArticle() {
        return article;
    }
    public FactureMere getFactureMere() {
        return factureMere;
    }
    public double getRemise() {
        return remise;
    }
    public String getRemiseString() {
        return Double.toString(remise);
    }
    public int getQuantite() {
        return quantite;
    }
    public String getQuantiteString() {
        return Integer.toString(quantite);
    }
    public double getMontant(){
        return article.getPrix()*quantite;
    }

/** SETTERS*/
    public void setId(String id) {
        this.id = id;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public void setFactureMere(FactureMere factureMere) {
        this.factureMere = factureMere;
    }
    public void setRemise(double remise) {
        this.remise = remise;
    }
    public void setRemise(String remise) {
        this.remise = Double.parseDouble(remise);
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setQuantite(String quantite) {
        this.quantite = Integer.parseInt(quantite);
    }
}

