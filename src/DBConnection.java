import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DBConnection {

    private final String url;
    private final String user;
    private final String pass;
    private Connection con;

    public DBConnection(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeTrafficData(String haltestelle, String linie, Boolean ankunftsverspaetung, String ankunftszeit_Soll, String ankuftszeit_Real, Boolean faellt_Aus) {
        try {;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "INSERT INTO `opendata`.`traffic` (`haltestelle`, `linie`, `Ankunftsverspaetung`, `Ankunftszeit_Soll`, `Ankuftszeit_Real`,`Faellt_Aus`)VALUES("
                            + haltestelle + ","
                            + linie + ","
                            + ankunftsverspaetung + ","
                            + ankunftszeit_Soll + ","
                            + ankuftszeit_Real + ","
                            + faellt_Aus + ""
                            + ");"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
