/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonctions;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITU
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }    
    
    @Test
    public void testGetPatient() {        
        System.out.println("getPatient by id");         
        Patient[] result = null;
        Patient[] expResult = new Patient[1];
        expResult[0] = new Patient("1", "RAKOTOARIVONY", "Ernesto", "2000-01-16");
        Login instance = new Login();                
        String idr = "1";        
        try {
            result = instance.getPatient(idr, "", "", "", "");        
            assertEquals(expResult[0].getId(), result[0].getId());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("getPatient by nom='r'");          
        idr = "e";        
        try {
            result = instance.getPatient("", "", idr, "1900-01-01", "3000-12-31");        
            assertEquals(expResult[0].getId(), result[0].getId());
        }                
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("getPatient by nom='n'");          
        idr = "r";  
        expResult = new Patient[2];
        expResult[0] = new Patient("1", "RAKOTOARIVONY", "Ernesto", "2000-01-16");
        expResult[1] = new Patient("2", "RAZAFINDRAZAKA", "Felicite", "1990-01-21");
        try {
            result = instance.getPatient("", idr, "", "1900-01-01", "3000-12-31");        
            assertEquals(expResult[0].getId(), result[0].getId());
        }                
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
