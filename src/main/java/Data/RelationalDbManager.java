package Data;

import java.sql.*;

public class RelationalDbManager {
    private String ip;
    private String username = "kaya";
    private String password = "18821882";
    private String dbname;
    private int port;
    private Statement statement = null;
    private Connection conn = null;

    private void Commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Sql transaction commit error:" + e.getMessage());
        }
    }

    private void RollBack() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            System.out.println("Sql Rollback error:" + e.getMessage());
        }
    }

    public void Connect() {
        //String preurl = "tjdbc:mysql://" + ip + ":" + port + "/" + dbname;
        String url = "jdbc:mysql://64.226.113.128:3306/maindb?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            System.out.println("Connection Success.");
        } catch (Exception e) {
            System.out.println("Mysql driver can not found! ");
        }
    }

    public void GetData() {

        try {
            String query = "select * from Car";

            statement = conn.createStatement();
            var data = statement.executeQuery(query);
            while (data.next()) {
                System.out.println(data.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Error while creating the statement, Error:" + e.getMessage());
        }


    }

    public void InsertData(int id, String name) {
        try {
            String insertQuery = "insert into Car (id,name) values ('" + id + "','" + name + "' ) ";
            statement = conn.createStatement();
            statement.executeUpdate(insertQuery);
            Commit();

            System.out.println("insert operation success.");
        } catch (SQLException e) {
            RollBack();
            System.out.println("error on insert operation:" + e.getMessage());
        }

    }

    public void UpdateData(int id, String name) {


        try {
            String updateQuery = "update Car set  name='" + name + "' where id='" + id + "' ";
            statement = conn.createStatement();
            statement.executeUpdate(updateQuery);
            conn.commit();
            System.out.println("update operation success.");
        } catch (SQLException e) {
            RollBack();
            System.out.println("error on update operation:" + e.getMessage());
        }

    }

    public void DeleteData(int id) {

        try {
            String deleteQuery = "delete from Car where id='" + id + "' ";
            statement = conn.createStatement();
            statement.executeUpdate(deleteQuery);
            Commit();
            System.out.println("delete operation success.");
        } catch (SQLException e) {
            RollBack();
            System.out.println("error on delete operation:" + e.getMessage());
        }

    }
}
