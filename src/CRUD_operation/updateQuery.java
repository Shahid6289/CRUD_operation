package CRUD_operation;

import inJDBCutil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        Scanner sc = new Scanner(System.in);
        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null) {
                String sql = "update from student set City = ? where id = ?";
                preparedstatement = connection.prepareStatement(sql);
                if (preparedstatement != null) {
                    System.out.println("Enter the ID of the student which you want to update");
                    int id = sc.nextInt();
                    System.out.println("Enter the new City of the student");
                    String city = sc.next();

                    preparedstatement.setString(1, city);
                    preparedstatement.setInt(2, id);

                    int rows = preparedstatement.executeUpdate();
                    if (rows == 1)
                        System.out.println("Data updated successfully");
                    else
                        System.out.println("Data not updated");
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
