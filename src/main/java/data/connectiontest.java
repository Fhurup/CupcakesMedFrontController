
package data;

import java.sql.SQLException;


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
