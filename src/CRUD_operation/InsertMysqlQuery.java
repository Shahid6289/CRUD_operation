package CRUD_operation;

import inJDBCutil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMysqlQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null) {
                String sql = "insert into student(Name, Rollnum, City) values(?,?,?)";
                preparedstatement = connection.prepareStatement(sql);
                if (preparedstatement != null) {
                    preparedstatement.setString(1, "Vishal");
                    preparedstatement.setInt(2, 20);
                    preparedstatement.setString(3, "Pune");
                    int rows = preparedstatement.executeUpdate();
                    if (rows == 1)
                        System.out.println("Data inserted successfully");
                    else
                        System.out.println("Data not inserted");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeConnection(connection, preparedstatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
