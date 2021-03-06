package com.cybertek.tests.day20_jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class MySQLJDBCConnectionDemo {
    /**
     * Vytrack Database connection information
     * Username      cybertek_user
     * Password      cybertek_user
     * qa3 url       107.23.27.171
     * port number   3306
     * sid          bitnami_orocrm
     * JAVA CODE USING SELENIUM ---> Chrome DRIVER --> CHROME BROWSER
     * JAVA CODE USING JDBC --> DB DRIVER ---> DATABASE
     */

    @Test
    public void test() throws SQLException {
      String url = "jdbc:mysql://107.23.27.171:3306/bitnami_orocrm";
      String username = "cybertek_user";
      String password = "cybertek_user";

      //helps to connect to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        //helps to write and execute queries
        Statement statement =  connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                           ResultSet.CONCUR_READ_ONLY);

        String query = "select first_name, last_name, description from orocrm_contact";

        //stores the result of the query
        ResultSet resultSet = statement.executeQuery(query);


        while (resultSet.next()){
            int colCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= colCount ; i++) {
                String cellValue = resultSet.getString(i);
                System.out.print(cellValue+"\t");
            }
            System.out.println();
        }
        // connection must to be closed
        resultSet.close();
        statement.close();
        connection.close();

    }
}
