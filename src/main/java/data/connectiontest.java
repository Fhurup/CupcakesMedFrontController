
package data;

import java.sql.SQLException;

/**
 * This class is used to check if the DBConnector can connect to the given database.
 */
public class connectiontest {
    public static void main(String[] args) {
        connectiontest t = new connectiontest();
        DBConnector d = t.getdb();
        System.out.println("Nåede så langt");
    }
    
    public DBConnector getdb(){
        try {
            DBConnector db = new DBConnector();
            return db;
        } catch (SQLException ex) {
            System.out.println("Fejl ved forbindelse");
        }
        return null;
    }
}
