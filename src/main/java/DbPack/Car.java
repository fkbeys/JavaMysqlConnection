package DbPack;

import java.sql.Connection;
import java.sql.Driver;

public class Car {

    private String ip;
    private String username;
    private String dbname;
    private int port;

    private Connection conn = null;

    public void Baglanti() {

        String preurl = "tjdbc:mysql://" + ip + ":" + port + "/" + dbname;
        String url = "tjdbc:mysql://64.226.113.128:3306/maindb";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Mysql driver can not found! ");
        }






    }


}
