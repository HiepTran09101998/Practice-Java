package Praction;

import java.sql.*;

public class studentController {
    public void insertStudent(student student) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root","");
                Statement stmt = conn.createStatement()
        ) {
            String sqlInsert = "insert into student values (" + " '" + student.getId() + "', '"  + student.getName() + "', '"  + student.getAddress() + "', '"+ student.getPhone() + "'" +")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectStudent() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root","");
                Statement stmt = conn.createStatement()
        ){
            System.out.println("============================================================================");
            ResultSet rset = stmt.executeQuery("select * from student");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            for ( int i = 1; i <= numColumns; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            for (int i = 1 ; i <= numColumns; i++){
                System.out.printf("%-30s",
                        "(" + rsetMD.getColumnName(i) + ")");
            }
            System.out.println();

            while (rset.next()) {
                for (int i = 1; i <= numColumns; ++i) {
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
