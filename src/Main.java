import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database db = Database.Instance;

        db.setUsername("");
        db.setPassword("");
        try {
            ResultSet rs = db.query("SELECT * FROM time");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
        } catch (SQLException e) {
            System.out.println("Cant execute query" + e.toString());
        }

    }
}
