import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static String url = "jdbc:mysql://localhost:3306/dictionary";
    private static String username = "root";
    private static String password = "";

    public static List<String> findFirst10(String ref) {
        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        List<String> stringList = new ArrayList<>();
        String sql = "SELECT word FROM tbl_edict WHERE word LIKE '" + ref + "%' LIMIT 10;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            while (res.next()) {
//                System.out.println(res.getString(2) + " " + res.getString(3));
                stringList.add(res.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    public static String meaningOf(String ref) {
        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        StringBuilder meaning = new StringBuilder();
        String sql = "SELECT detail FROM tbl_edict WHERE word = '" + ref + "';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            while (res.next()) {
                meaning.append(res.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meaning.toString();
    }
}
