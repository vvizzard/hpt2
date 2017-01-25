package fonctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailPayement {
    private String idFacture;
    private Date deadline;
    private Patient patient;
    private double montant;
    private double paye;
    private double reste;

//  CONSTRUCTOR
    public DetailPayement(){}
    
    public DetailPayement(String idFacture, Date deadline, Patient patient, double montant, double paye, double reste) {
        this.idFacture = idFacture;
        this.deadline = deadline;
        this.patient = patient;
        this.montant = montant;
        this.paye = paye;
        this.reste = reste;
    }
    
    public DetailPayement(String idFacture, String deadline, Patient patient, double montant, double paye, double reste) {
        this.setIdFacture(idFacture);
        this.setDeadline(deadline);
        this.setPatient(patient);
        this.setMontant(montant);
        this.setPaye(paye);
        this.setReste(reste);
    }
        
//  SETTERS
    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public void setDeadline(String deadline) {
        String[] dt = deadline.split("[\\-\\/\\.]");        
        if(dt[0].length()<=2)dt[0] = "20"+dt[0];
        this.deadline = new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public void setMontant(String montant) {
        this.montant = Double.parseDouble(montant);
    }

    public void setPaye(double paye) {
        this.paye = paye;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

//  GETTERS
    public String getIdFacture() {
        return idFacture;
    }

    public Date getDeadline() {
        return deadline;
    }
    
    public String getDeadlineString() {
        return new SimpleDateFormat("dd-MM-yyyy").format(deadline);
    }

    public Patient getPatient() {
        return patient;
    }

    public double getMontant() {
        return montant;
    }

    public double getPaye() {
        return paye;
    }

    public double getReste() {
        return reste;
    }
        
}
