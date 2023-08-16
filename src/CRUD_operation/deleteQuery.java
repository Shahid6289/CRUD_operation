package CRUD_operation;

import inJDBCutil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        Scanner sc = new Scanner(System.in);
        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null) {
                String sql = "delete from student where id = ?";
                preparedstatement = connection.prepareStatement(sql);
                if (preparedstatement != null) {
                    System.out.println("Enter the ID of the student which you want to delete");
                    int id = sc.nextInt();

                    preparedstatement.setInt(1, id);

                    int rows = preparedstatement.executeUpdate();
                    if (rows == 1)
                        System.out.println("Row deleted successfully");
                    else
                        System.out.println("Row not updated");
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
