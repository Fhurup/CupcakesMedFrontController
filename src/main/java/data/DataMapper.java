package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMapper {

    DBConnector connector = null;

    public DataMapper(DBConnector connector) {
        this.connector = connector;
    }

    /**
     * The getUser method is used to find a user from the database by their
     * email which is used as the primary key in the database and the return
     * that user.
     *
     * @param email
     * @return User
     * @throws DataException
     */
    public User getUser(String email) throws DataException {
        try {
            String query = "select * from `User` where email='" + email + "';";
            Connection connection = connector.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            rs.next();
            Role role = Role.valueOf(rs.getString("role"));
            return new User(rs.getString("username"), rs.getString("password"), rs.getInt("balance"), rs.getString("email"), role);
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * The makeUser method is used to insert a new user into the database. If
     * successful it returns true, otherwise it returns false.
     *
     * @param username
     * @param password
     * @param balance
     * @param email
     * @param role
     * @return boolean
     */
    public boolean makeUser(String username, String password, int balance, String email, Role role) {
        try {
            String query = "insert into `User` values ('" + username + "', '" + password + "', " + balance + ", '" + email + "', '" + role + "');";
            Connection connection = connector.getConnection();
            connection.createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
/**
 * 
 * Method takes an Arraylist(Cupcakes) order and inserts into database
 * if successful returns true
 * @param order
 * @return boolean
 */
    
    public boolean takeOrder(ArrayList<Cupcake> order) {
        try {
            int ID1 = (int) Math.random() * 10000000;

            for (Cupcake cc : order) {
                String query = "insert into `OrderLine` values ('" + cc.getCupcakeTop() + "', '" + cc.getCupcakeButtom() + "', " + cc.getAmount() + "," + ID1 + ");";
                Connection connection = connector.getConnection();
                connection.createStatement().executeUpdate(query);
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * The validateUser method checks if the given password matches the user with the given email.
     * If it does match it returns true, otherwise it returns false.
     * @param email
     * @param password
     * @return boolean
     */
    public boolean validateUser(String email, String password) {
        try {
            if (getUser(email) == null) {
                return false;
            } else if (getUser(email).getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
/**
 * Method takes all data from CupcakeBottom table in sql Database and creates a new CupCakeBottom object
 * for each row in database and return an arraylist of all the CupcakeBottoms
 * @return ArrayList<CupcakeButtom>
 * @throws DataException 
 */
    public ArrayList<CupcakeButtom> getAllCupcakeButtoms() throws DataException {
        ArrayList<CupcakeButtom> AllCupcakeButtoms = new ArrayList();
        try {
            String query = "SELECT * FROM `CupcakeBottom`;";
            Connection connection = connector.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                AllCupcakeButtoms.add(new CupcakeButtom(rs.getString("Bottom"), rs.getInt("price")));
            }
        } catch (SQLException ex) {
            throw new DataException(ex);
        }

        return AllCupcakeButtoms;
    }
/**
 * Method takes all data from CupcakeTop table in sql Database and creates a new CupCakeTop object
 * for each row in database and return an arraylist of all the CupcakeTops
 * @return ArrayList<CupcakeTop>
 * @throws DataException 
 */
    public ArrayList<CupcakeTop> getAllCupcakeTops() throws DataException {
        ArrayList<CupcakeTop> AllCupcakeTops = new ArrayList();
        try {
            String query = "SELECT * FROM `CupcakeTop`;";
            Connection connection = connector.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                AllCupcakeTops.add(new CupcakeTop(rs.getString("topping"), rs.getInt("price")));
            }
        } catch (SQLException ex) {
            throw new DataException(ex);
        }

        return AllCupcakeTops;
    }

    public static void main(String[] args) throws SQLException, DataException {
        DBConnector connector = new DBConnector();
        DataMapper dm = new DataMapper(connector);
        ArrayList cc = new ArrayList();
        CupcakeButtom kk = new CupcakeButtom("Blue cheese", 10);
        CupcakeTop kt = new CupcakeTop("Almond", 10);
        cc.add(new Cupcake(kt, kk, 1));
        if (dm.takeOrder(cc));
        {
            System.out.println("suoperb");
            System.out.println(cc);
        }
//       dm.makeUser("frederiktest", "1234", 700, "frederik@frederik.com", Role.U);
        //System.out.println(dm.validateUser("frederik@frederik.com", "1235"));
        //System.out.println(dm.validateUser("frederik@frederik.co", "1234"));

    }

}
