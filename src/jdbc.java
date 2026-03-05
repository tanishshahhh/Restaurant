import java.sql.*;

public class jdbc{
    public static Connection getOracleConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "Tanish2006#");
    }
}
