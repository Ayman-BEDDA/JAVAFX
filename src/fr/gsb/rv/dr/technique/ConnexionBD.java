package fr.gsb.rv.dr.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import fr.gsb.rv.dr.entites.Visiteur;
import fr.gsb.rv.dr.modeles.ModeleGsbRv;
public class ConnexionBD {
    
    private static String dbURL = "jdbc:mysql://localhost:3306/gsbrv" ;
    private static String user = "dev" ;
    private static String password = "azerty" ;
    
    private static Connection connexion = null ;
    
    
    
    private ConnexionBD() throws ConnexionException {
        try {
            Class.forName( "com.mysql.jdbc.Driver" ) ;
            connexion = (Connection) DriverManager.getConnection(dbURL, user, password) ;
            
            System.out.println( "Connexion réussie" );
            
        }
        catch( Exception e ){
            throw new ConnexionException() ;
        }
    }
    
    
    
    public static Connection getConnexion() throws ConnexionException {
        if( connexion == null ){
            new ConnexionBD() ;
        }
        return connexion ;
    }
}
