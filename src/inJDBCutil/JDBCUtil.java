package inJDBCutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class JDBCUtil {

    //    * Task to get the properties from the application file and return the connection
    public static Connection getJdbcConnection() throws IOException, SQLException {
        FileInputStream FIS = new FileInputStream("Application.properties");
        Properties p = new Properties();
        p.load(FIS);
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    //    * Task to close the connection
    public static void closeConnection(Connection connection, PreparedStatement preparedstatement, ResultSet resultSet) throws SQLException {
        if (connection != null)
            connection.close();
        if (preparedstatement != null)
            preparedstatement.close();
        if (resultSet != null)
            resultSet.close();
    }
}
