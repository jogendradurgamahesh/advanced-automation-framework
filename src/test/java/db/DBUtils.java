package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

	 public static String getEmployeeName(int empId) {

//	        String name = "";
//
//	        try {
//	            Connection con = DriverManager.getConnection(
//	                "jdbc:mysql://localhost:3306/testdb", "root", "root");
//
//	            Statement stmt = con.createStatement();
//
//	            ResultSet rs = stmt.executeQuery(
//	                "SELECT name FROM employees WHERE id=" + empId);
//
//	            if (rs.next()) {
//	                name = rs.getString("name");
//	            }
//
//	            con.close();
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	        return name;
//	    }
		 
		 
		
		        // For demo return static name
		        return "Tiger Nixon";
		    }
}
