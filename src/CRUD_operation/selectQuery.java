package CRUD_operation;

import inJDBCutil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class selectQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        Scanner sc = new Scanner(System.in);
        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null) {
                String sql = "select * from student where id = ?";
                preparedstatement = connection.prepareStatement(sql);
                if (preparedstatement != null) {
                    System.out.println("Enter the ID of the student");
                    int id = sc.nextInt();
                    preparedstatement.setInt(1, id);
                    resultset = preparedstatement.executeQuery();
                    if (resultset != null){
                        if (resultset.next()){
                            System.out.println("ID\t\tName\t\tRollnum\t\tCity");
                            System.out.println(resultset.getInt(1)+"\t\t"+resultset.getString(2)+"\t\t\t"+resultset.getInt(3)+"\t\t"+resultset.getString(4));
                        }
                        else
                            System.out.println("No data found");
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeConnection(connection, preparedstatement, resultset);
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
