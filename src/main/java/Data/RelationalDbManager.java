package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RelationalDbManager {

    private String ip;
    private String username = "kaya";
    private String password = "18821882";
    private String dbname;
    private int port;

    private Statement statement = null;


    private Connection conn = null;

    public void Connect() {

        String preurl = "tjdbc:mysql://" + ip + ":" + port + "/" + dbname;
        String url = "jdbc:mysql://64.226.113.128:3306/maindb";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Mysql driver can not found! ");
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Success.");
        } catch (SQLException e) {
            System.out.println("Connection Error!");
            System.out.println(e.getMessage());
        }


    }

    public void GetData() {

        try {
            String query = "select * from Car ";
            statement = conn.createStatement();
            var data = statement.executeQuery(query);
            while (data.next()) {
                System.out.println(data.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Error while creating the statement, Error:" + e.getMessage());
        }


    }


}
