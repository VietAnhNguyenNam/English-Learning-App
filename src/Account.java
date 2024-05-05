import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private static String url = "jdbc:mysql://localhost:3306/english_learning_app";
    private static String username = "root";
    private static String password = "";

    public static void newAccount(String accountName, String accountPassword) {
        accountName = accountName.replace("'", "''");
        String hashedPassword = BCrypt.hashpw(accountPassword, BCrypt.gensalt());

        Connection con = null;
        Statement statement = null;
        String sql = "INSERT INTO accounts (username, password) VALUES ('" + accountName + "', '" + hashedPassword + "');";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean alreadyExist(String accountName) {
        accountName = accountName.replace("'", "''");

        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        String sql = "SELECT username FROM accounts WHERE username = '" + accountName + "';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeQuery(sql);
            res = statement.executeQuery(sql);
            if (res.next()) {
                return true;
            } else {
                return false;
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
        return true;
    }

    // if password is correct, return user_id, else return -1
    public static int checkPassword(String accountName, String enteredPassword) {
        String hashedPassword = "";
        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        String sql = "SELECT id, password FROM accounts WHERE username = '" + accountName + "';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            if (res.next()) {
                hashedPassword = res.getString(2);
                if (BCrypt.checkpw(enteredPassword, hashedPassword)) {
                    return res.getInt(1);
                }
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
        return -1;
    }

//    public static int getUserId(String accountName) {
//        Connection con = null;
//        Statement statement = null;
//        ResultSet res = null;
//        String sql = "SELECT id FROM accounts WHERE username = '" + accountName + "';";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, username, password);
//            statement = con.createStatement();
//            res = statement.executeQuery(sql);
//            if (res.next()) {
//                return res.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (res != null) res.close();
//                if (statement != null) statement.close();
//                if (con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return -1;
//    }

    public static List<String[]> getConversation(int userId) {
        List<String[]> returnStrings = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        String sql = "SELECT role, message FROM conversation WHERE user_id = " + userId + " ORDER BY id;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            while (res.next()) {
                returnStrings.add(new String[]{res.getString(1), res.getString(2)});
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
        return returnStrings;
    }

    public static void addMessage(int userId, String role, String message) {
        message = message.replace("'", "''");
        Connection con = null;
        Statement statement = null;
        String sql = "INSERT INTO conversation (user_id, role, message) VALUES ('" + userId + "', '" + role + "', '" + message + "');";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteConversation(int userId) {
        Connection con = null;
        Statement statement = null;
        String sql = "DELETE FROM conversation WHERE user_id = " + userId + ";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getSavedWords(int userId) {
        List<String> returnStrings = new ArrayList<>();

        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        String sql = "SELECT word FROM saved_words WHERE user_id = " + userId + ";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            while (res.next()) {
                returnStrings.add(res.getString(1));
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
        return returnStrings;
    }

    public static boolean savedWord(int userId, String word) {
        boolean found;

        Connection con = null;
        Statement statement = null;
        ResultSet res = null;
        String sql = "SELECT word FROM saved_words WHERE user_id = " + userId + " AND word = '" + word + "';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            found = res.next();
        } catch (Exception e) {
            found = true;
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
        return found;
    }

    public static void deleteSavedWord(int userId, String word) {
        Connection con = null;
        Statement statement = null;
        String sql = "DELETE FROM saved_words WHERE user_id = " + userId + " AND word = '" + word + "';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addToSavedWords(int userId, String word) {
        Connection con = null;
        Statement statement = null;
        String sql = "INSERT INTO saved_words (user_id, word) VALUES (" + userId + ", '" + word + "');";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
