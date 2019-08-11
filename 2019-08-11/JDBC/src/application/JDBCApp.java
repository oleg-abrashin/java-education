package application;

import java.sql.*;

public class JDBCApp {

    public static void main(String[] args) throws SQLException {

        Connection connection
                = DriverManager.getConnection(
                          "jdbc:mysql://localhost/java_db?useSSL=false&serverTimezone=UTC",
                         "root",
                            ""
        );

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM person";

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){

            System.out.println(
                    new Person(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt("age"),
                            resultSet.getDouble(4),
                            resultSet.getBoolean(5)
                    ));

        }



    }

}
