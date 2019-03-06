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

    //mangler at handle situation hvor man prøver at lave en ny bruger med mail der allerede eksistere (PK)
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


    public boolean validateUser(String email, String password) {
        try {
            if (getUser(email) == null){
                return false;
            }
            else if (getUser(email).getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (DataException ex) {
            return false;
        }
    }

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
//        dm.makeUser("frederiktest", "1234", 700, "frederik@frederik.com", Role.U);
        //System.out.println(dm.validateUser("frederik@frederik.com", "1235"));
        //System.out.println(dm.validateUser("frederik@frederik.co", "1234"));
        

    }

}
