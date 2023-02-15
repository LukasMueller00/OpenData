import java.util.List;

public class OpenData {
    public static void main(String[] args) {
        List traffic = List.of(APIConsumer.getTraffic());
        System.out.println(traffic.get(1));
//        DBConnection con = new DBConnection("jdbc:mysql://localhost:3306/lfjd-analytics", "root", "password");
//        con.connect();
//        con.writeTrafficData();
    }
}
