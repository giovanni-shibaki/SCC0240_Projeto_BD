package database;

import java.sql.*;

public class Database {
    private String _username;
    private String _password;
    public static Database Instance = new Database();

    private Database() {}

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

    public ResultSet query(String queryString) throws SQLException{
        Connection con = connect();
        Statement stmt = con.createStatement();
        return stmt.executeQuery(queryString);
    }
}
