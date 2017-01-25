package fonctions;

public class Payement {
    private String idPayement;
    private double montant;
    private DetailPayement facture;

//  CONSTRUCTOR    
    public Payement(double montant, DetailPayement facture) throws Exception {
        this.setFacture(facture);
        this.setMontant(montant); 
    }
    
    public Payement(String montant, DetailPayement facture) throws Exception {
        this.setFacture(facture);
        this.setMontant(montant); 
    }
    
//  GETTERS
    public String getIdPayement() {
        return idPayement;
    }

    public double getMontant() {
        return montant;
    }
    
    public String getMontantString() {
        return Double.toString(montant);
    }

    public DetailPayement getFacture() {
        return facture;
    }
    
//  SETTERS    
    public void setIdPayement(String idPayement) {
        this.idPayement = idPayement;
    }

    public void setMontant(double montant) throws Exception {
        if(this.facture.getReste()<montant)throw new Exception("le montant est suppérieur au reste à payer");
        this.montant = montant;
    }
    
    public void setMontant(String montant) throws Exception {
        if(this.facture.getReste()<Double.parseDouble(montant))throw new Exception("le montant est suppérieur au reste à payer");
        this.montant = Double.parseDouble(montant);
    }

    public void setFacture(DetailPayement facture) {
        this.facture = facture;
    }
}
