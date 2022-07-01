package database;

import javax.xml.crypto.Data;
import java.io.Closeable;
import java.sql.*;

public class Database implements Closeable {
    private String _username;
    private String _password;
    private Connection db;

    private static Database _db = new Database();
    private static Connection Instance;

    public static Connection getInstance() {
        if (Instance == null) {
            _db = new Database();
        }
        return Instance;
    }

    private Database() {
        try {
            setUsername("a11796472");
            setPassword("a11796472");

            db = connect();
            Instance = db;
            System.out.println(Instance);
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void setUsername(String username) {
        this._username = username;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    protected Connection connect() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@orclgrad1.icmc.usp.br:1521/pdb_elaine.icmc.usp.br", _username, _password);
    }

    /*
    public ResultSet query(String queryString) throws SQLException{
        Connection con = connect();
        Statement stmt = con.createStatement();
        return stmt.executeQuery(queryString);
    }
    */

    public void close() {
        try {
            db.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
}
