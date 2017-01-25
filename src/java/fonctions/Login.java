/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonctions;

/**
 *
 * @
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Java Discover
 */
public class Login {
    
public DetailPayement getDetailPayementById(String id){    
    DetailPayement val = null;
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT id_facture_mere, deadline, nompatient, prenompatient, montant, paye::money::numeric::float8, reste_payer FROM detail_payement where id_facture_mere = "+id;
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {                        
            val = new DetailPayement(rs.getString("id_facture_mere"),rs.getString("deadline"),this.getPatient(rs.getString("nompatient"), rs.getString("prenompatient")),rs.getDouble("montant"),rs.getDouble("paye"),rs.getDouble("reste_payer"));                
        }        
        return val;
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return val;            
}
    
public DetailPayement[] getListDetailPayement(Patient t){
    DetailPayement[] farany = null;
    ArrayList<DetailPayement> val = new ArrayList<DetailPayement>();
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT id_facture_mere, deadline, montant, paye::money::numeric::float8, reste_payer FROM detail_payement where nompatient = '"+t.getNom()+"' and prenompatient = '"+t.getPrenom()+"' and reste_payer != 0";
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {                        
            val.add(new DetailPayement(rs.getString("id_facture_mere"),rs.getString("deadline"),t,rs.getDouble("montant"),rs.getDouble("paye"),rs.getDouble("reste_payer")));                
        }
        farany = new DetailPayement[val.size()];             
        return val.toArray(farany);
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return farany;            
}
    
public boolean insertPayement(String idFac, double mt)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();                
                String qry = "INSERT INTO payement(id_facture,montant) VALUES("+idFac+","+mt+")";
	        ResultSet rs = stat.executeQuery(qry);    
	        return true;
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
                //throw new Exception("erreur dans la base");
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return false;            
	 }  
    
    
public String getFMId(FactureMere fm){
    Connection con = null;
    try{
        con = createConnection();        
	Statement stat = con.createStatement(); 
        String qry = "select id_facture_mere from facture_mere where deadline = '"+fm.getDeadlineString()+"' and idpatient ="+fm.getPatient().getId();
        ResultSet rs = stat.executeQuery(qry);
        String val = "";
        while(rs.next()) val = rs.getString("id_facture_mere");
        return val;
    }
    catch (Exception e) 
	    {
	        e.printStackTrace();
                //throw new Exception("erreur dans la base");
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
    return "";
}
    
public boolean insertFactureMere(FactureMere f)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();                
                String qry = "INSERT INTO facture_mere(id_tva,idpatient,deadline,montant) VALUES(1,"+f.getPatient().getId()+",'"+f.getDeadlineString()+"',"+Double.toString(f.getMontantTTC()).split(",")[0]+")";
	        ResultSet rs = stat.executeQuery(qry);    
	        return true;
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
                //throw new Exception("erreur dans la base");
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return false;            
	 }    
    
public boolean insertFactureFille(FactureFille f)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();                
                String qry = "INSERT INTO facture_fille(idarticle,id_facture_mere,quantite,montant) VALUES("+f.getArticle().getId()+","+f.getFactureMere().getId()+","+f.getQuantiteString()+","+Double.toString(f.getMontant()).split(",")[0]+")";
	        ResultSet rs = stat.executeQuery(qry);    
	        return true;
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
                //throw new Exception("erreur dans la base");
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return false;            
	 }
    
public int getRemise(String idr)
{  
    int val = 0;
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT valeur_remise FROM remise WHERE id_remise = "+idr;
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val=Integer.parseInt(rs.getString(1));                
        }	                        
        return val;
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return val;            
 }

public int getTva()
{  
    int val = 0;
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT valeur_tva FROM tva";
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val=Integer.parseInt(rs.getString(1));                
        }	                        
        return val;
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return val;            
 }
    
public Article[] getListeMedicament(){
    Article[] farany = null;
    ArrayList<Article> val = new ArrayList<Article>(50);
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT idarticle,nom,prix::money::numeric::float8 FROM medicament_prix_idarticle";
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {                        
            val.add(new Article(rs.getString("idarticle"),rs.getString("nom"),rs.getDouble("prix")));                
        }
        farany = new Article[val.size()];             
        return val.toArray(farany);
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return farany;            
}
    
public Article[] getListeArticle(){
    Article[] farany = null;
    ArrayList<Article> val = new ArrayList<Article>(50);
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry = "SELECT idarticle,nom,prix::money::numeric::float8 FROM article_prix";
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val.add(new Article(rs.getString("idarticle"),rs.getString("nom"),rs.getDouble("prix")));                
        }
        farany = new Article[val.size()];             
        return val.toArray(farany);
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    return farany;            
}
 
public String[] getSpecialite()
	{  
	    String[] farany = null;
	    ArrayList<String> val = new ArrayList<String>(50);
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "SELECT nom FROM specialisation";
	        ResultSet rs = stat.executeQuery(qry);    
	        while(rs.next())
	        {
	            val.add(rs.getString(1));                
	        }
	        farany = new String[val.size()];     
                //for(int j = 0; j < farany.length; j++)System.out.println(val.get(j));
                return val.toArray(farany);
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return farany;            
	 }

public String[] getCategorie()
	{  
	    String[] farany = null;
	    ArrayList<String> val = new ArrayList<String>(50);
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "SELECT idspecialisation FROM specialisation";
	        ResultSet rs = stat.executeQuery(qry);    
	        while(rs.next())
	        {
	            val.add(rs.getString(1));                
	        }
	        farany = new String[val.size()];     
                //for(int j = 0; j < farany.length; j++)System.out.println(val.get(j));
                return val.toArray(farany);
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return farany;            
	 }

public void deleteCategorie(String id)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "delete from specialisation where idspecialisation = "+id;
	        ResultSet rs = stat.executeQuery(qry);    	        
	    }
	    catch (Exception e) 
	    {
	        throw e;
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }                                  
	 }

public void modifCategorie(String id, String nom)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "UPDATE specialisation SET nom = '"+nom+"' WHERE idspecialisation = "+id;
	        ResultSet rs = stat.executeQuery(qry);    	        
	    }
	    catch (Exception e) 
	    {
	        throw e;
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }                                  
	 }

public void deleteMedecin(String id)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "delete from medecin where idmedecin = "+id;
	        ResultSet rs = stat.executeQuery(qry);    	        
	    }
	    catch (Exception e) 
	    {
	        throw e;
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }                                  
	 }

public void modifMed(String id,String nom,String prenom,String datedenaissance,String salaire,int spe)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
	        String qry = "UPDATE medecin SET nommedecin = '"+nom+"',prenommedecin = '"+prenom+"',datedenaissance = '"+datedenaissance+"',salairemedecin = "+salaire+",idspecialisation = "+Integer.toString(spe)+" where idmedecin = "+id;
	        ResultSet rs = stat.executeQuery(qry);    	        
	    }
	    catch (Exception e) 
	    {
	        throw e;
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }                                  
	 }

public Patient[] getPatient(String id, String nom, String prenom, String date1, String date2)throws Exception
{        
    String scr = " where ";
    String scrId = "idpatient ilike ";
    String scrNom = "AND nompatient ilike ";
    String scrPrenom = "AND prenompatient ilike ";
    String scrD1 = "AND datedenaissance > ";
    String scrD2 = "AND datedenaissance < ";   
    
    if(id.compareTo("")==0 ){
        scrId = "";
        scrNom = " nompatient ilike ";
    }
   // if(id.compareTo("*")==0)scrId = scrId +id+" ";
    if(nom.compareTo("")==0){
        scrNom = "";
        if(id.compareTo("")==0)scrPrenom = " prenompatient ilike ";
    }
    if(nom.compareTo("")!=0)scrNom = scrNom + "'"+nom+"%' "; 
    if(prenom.compareTo("")==0){
        scrPrenom = "";
        if(nom.compareTo("")==0 && id.compareTo("")==0)scrD1 = "datedenaissance >";
    }
    if(prenom.compareTo("")!=0) scrPrenom = scrPrenom + "'"+prenom+"%' ";
    if(date1 == null){
        scrD1 = "";
        if(nom == null && id == null && date1 == null)scrD2 = "datedenaissance <";
    }
    if(date1!=null) scrD1 = scrD1 + "'"+date1+"' ";
    
    if(date2 == null)scrD2 = ""; 
    if(date2!=null) scrD2 = scrD2 + "'"+date2+"' ";
    
    if(id == null && nom == null && prenom == null && date1 == null && date2 == null){
        scr = "";
        scrId = "";
        scrNom = "";
        scrPrenom = "";
        scrD1 = "";
        scrD2 = "";
    }
   
    Patient[] farany = null;
    ArrayList<Patient> val = new ArrayList<Patient>(50);
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry;
        if(id.compareTo("")!=0)qry = "select * from patient where idpatient ="+id;
        else qry= "select * from patient"+scr+scrId+scrNom+scrPrenom+scrD1+scrD2;//+scrPrenom+scrD1+scrD2;
        System.out.println(qry);
        
         //qry = "select * from medecin where nomMedecin like 'R%' and prenomMedecin like 'm%' and datedenaissance >'1800/01/01'"; 
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val.add(new Patient(rs.getString("idpatient"),rs.getString("nompatient"),rs.getString("prenompatient"),rs.getString("datedenaissance")));                
        }
        farany = new Patient[val.size()];     
        //for(int j = 0; j < farany.length; j++)System.out.println(val.get(j));
        return val.toArray(farany);
    }
    catch (Exception e) 
    {
        //throw new Exception("erreur d'insertion dans la base");
        throw e;
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }                     
 }

public Patient getPatient(String nom, String prenom)throws Exception
{        
    String scr = " where ";    
    String scrNom = "nompatient=";
    String scrPrenom = "AND prenompatient=";           
   
    Patient[] farany = null;
    ArrayList<Patient> val = new ArrayList<Patient>(50);
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry= "select * from patient"+scr+scrNom+"'"+nom+"'"+scrPrenom+"'"+prenom+"'";//+scrPrenom+scrD1+scrD2;
        System.out.println(qry);                
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val.add(new Patient(rs.getString("idpatient"),rs.getString("nompatient"),rs.getString("prenompatient"),rs.getString("datedenaissance")));                
        }
        farany = new Patient[val.size()];     
        //for(int j = 0; j < farany.length; j++)System.out.println(val.get(j));
        return val.toArray(farany)[0];
    }
    catch (Exception e) 
    {
        //throw new Exception("erreur d'insertion dans la base");
        throw e;
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }                     
 }



public Medecin[] getMedecin(String id, String nom, String prenom, String date1, String date2)throws Exception
{        
    String scr = " where ";
    String scrId = "idMedecin like ";
    String scrNom = "AND nomMedecin like ";
    String scrPrenom = "AND prenomMedecin like ";
    String scrD1 = "AND datedenaissance > ";
    String scrD2 = "AND datedenaissance < ";   
    
    if(id.compareTo("")==0 ){
        scrId = "";
        scrNom = " nomMedecin like ";
    }
   // if(id.compareTo("*")==0)scrId = scrId +id+" ";
    if(nom.compareTo("")==0){
        scrNom = "";
        if(id.compareTo("")==0)scrPrenom = " prenomMedecin like ";
    }
    if(nom.compareTo("")!=0)scrNom = scrNom + "'"+nom+"%' "; 
    if(prenom.compareTo("")==0){
        scrPrenom = "";
        if(nom.compareTo("")==0 && id.compareTo("")==0)scrD1 = "datedenaissance >";
    }
    if(prenom.compareTo("")!=0) scrPrenom = scrPrenom + "'"+prenom+"%' ";
    if(date1 == null){
        scrD1 = "";
        if(nom == null && id == null && date1 == null)scrD2 = "datedenaissance <";
    }
    if(date1!=null) scrD1 = scrD1 + "'"+date1+"' ";
    
    if(date2 == null)scrD2 = ""; 
    if(date2!=null) scrD2 = scrD2 + "'"+date2+"' ";
    
    if(id == null && nom == null && prenom == null && date1 == null && date2 == null){
        scr = "";
        scrId = "";
        scrNom = "";
        scrPrenom = "";
        scrD1 = "";
        scrD2 = "";
    }
   
    Medecin[] farany = null;
    ArrayList<Medecin> val = new ArrayList<Medecin>(50);
    Connection con = null;
    try
    {
        con = createConnection();        
        Statement stat = con.createStatement();
        String qry;
        if(id.compareTo("")!=0)qry = "select * from medecin where idMedecin ="+id;
        else qry= "select * from medecin"+scr+scrId+scrNom+scrPrenom+scrD1+scrD2;//+scrPrenom+scrD1+scrD2;
        System.out.println(qry);
        
         //qry = "select * from medecin where nomMedecin like 'R%' and prenomMedecin like 'm%' and datedenaissance >'1800/01/01'"; 
        ResultSet rs = stat.executeQuery(qry);    
        while(rs.next())
        {
            val.add(new Medecin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));                
        }
        farany = new Medecin[val.size()];     
        //for(int j = 0; j < farany.length; j++)System.out.println(val.get(j));
        return val.toArray(farany);
    }
    catch (Exception e) 
    {
        //throw new Exception("erreur d'insertion dans la base");
        throw e;
    }
    finally
    {
        if(con != null)
        {
            try 
            {
                con.close();
            }         
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }           
    //return farany;            
 }

    public boolean insertMed(String nom,String prenom,String datedenaissance,String salaire,int spe)throws Exception
	{  	    
	    Connection con = null;
	    try
	    {
	        con = createConnection();        
	        Statement stat = con.createStatement();
                String qr = "SELECT count(*) FROM medecin";
                //ResultSet r = stat.executeQuery(qr);r.next();int t = new Integer(r.getString(1)).intValue()+1;
	        //String qry = "INSERT INTO Medecin VALUES("+id+",'"+nom+"','"+prenom+"','"+datedenaissance+"',"+salaire+",now(),1)";
                String qry = "INSERT INTO Medecin(nommedecin,prenommedecin,datedenaissance,salairemedecin,debut,idspecialisation) VALUES('"+nom+"','"+prenom+"','"+datedenaissance+"',"+salaire+",now(),"+Integer.toString(spe)+")";
	        ResultSet rs = stat.executeQuery(qry);    
	        return true;
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
                //throw new Exception("erreur dans la base");
	    }
	    finally
	    {
	        if(con != null)
	        {
	            try 
	            {
	                con.close();
	            }         
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }           
            return false;            
	 }


     /*public Connection createConnection() {
      System.out.println("Creating postgres DataBase Connection");
      Connection connection = null;

      try {

       // Provide database Driver according to your database
       Class.forName("org.postgresql.Driver");

       // Provide URL, database and credentials according to your database 
       connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hpt2.0", "postgres","itu");

      } catch (Exception e) {
       e.printStackTrace();
       return null;
      }
      if(connection != null){
       System.out.println("Connection created successfully....");
      }
      return connection;
     }*/
     
     public Connection createConnection() throws Exception
    {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/hpt2.0";
      String user = "postgres";
      String passwd = "itu";
      Connection conn = DriverManager.getConnection(url, user, passwd);
	return conn;
    }
     
}


