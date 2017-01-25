/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FactureMere {
    
/** ATTRIBUTS*/    
    private String id;
    private double tva;
    private Patient patient;
    private Date deadline; 
    private double montant;
    private Date date;
    
/** CONSTRUCTOR*/
    public FactureMere() {
    }

    public FactureMere(String id, double tva, Patient patient, Date deadline) {
        this.setId(id);
        this.setTva(tva);
        this.setPatient(patient);
        this.setDeadline(deadline);
    }
    public FactureMere(double tva, Patient patient, Date deadline) {        
        this.setTva(tva);
        this.setPatient(patient);
        this.setDeadline(deadline);
    }
    public FactureMere(double tva, Patient patient, String deadline) {        
        this.setTva(tva);
        this.setPatient(patient);
        this.setDate(deadline);
    }
    public FactureMere(String id, String tva, Patient patient, Date deadline) {
        this.setId(id);
        this.setTva(tva);
        this.setPatient(patient);
        this.setDeadline(deadline);
    }
    public FactureMere(String tva, Patient patient, Date deadline) {        
        this.setTva(tva);
        this.setPatient(patient);
        this.setDeadline(deadline);
    }
    public FactureMere(String tva, Patient patient, String deadline) {        
        this.setTva(tva);
        this.setPatient(patient);
        this.setDate(deadline);
    }

/** GETTERS */
    public String getId() {
        return id;
    }
    public double getTva() {
        return montant * new Login().getTva()/100;
    }
    public String getTvaString() {
        return Double.toString(tva);
    }
    public Patient getPatient() {
        return patient;
    }
    public Date getDeadline() {
        return deadline;
    }
    public String getDeadlineString() {
    //  de la forme (yyy-mm-dd)
        return new SimpleDateFormat("yyyy-MM-dd").format(deadline);
    }
    public String getDate() {
    //  de la forme (dd-mm-yyyy)
        return new SimpleDateFormat("dd-MM-yyyy").format(deadline);
    }
    public double getMontant() {
        return montant;
    }
    public double getMontantTTC() {
        return montant + getTva();
    }
    public String getDateCons(){
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
    

/** SETTERS*/
    public void setId(String id) {
        this.id = id;
    }
    public void setTva(double tva) {
        this.tva = tva;
    }
    public void setTva(String tva) {
        this.tva = Double.parseDouble(tva);
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public void setDeadline(String deadline) {
        String[] dt = deadline.split("[\\-\\/\\.]");        
        if(dt[2].length()<=2)dt[2] = "20"+dt[2];
        this.deadline = new Date(Integer.parseInt(dt[2])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[0]));
    } 
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void setMontant(String montant) {
        this.montant = Double.parseDouble(montant);
    }
    public void setDate(String d){
        String[] dt = d.split("[\\-\\/\\.]");        
        if(dt[0].length()<=2)dt[0] = "20"+dt[0];
        date = new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
        deadline = new Date(Integer.parseInt(dt[0])-1900+1,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
    }
}

