package sdet27genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * This class contains generic methods specific to dB.
 * @author anils
 *
 */
public class DatabaseUtility {

	//step-1 :- register the database
	//step-2 :- get connection with database
	//step-3 :- issue the create statement
	//step-4 :- execute the query
	//step-5 :- close the connection
	
	Connection con=null;
	
	/**
	 * This method will establish connection with the database
	 */
	public void connectToDB() throws SQLException {
		
		Driver driver = new Driver();
		
	  DriverManager.registerDriver(driver);
	  
	  con=DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
		
	}
	/**
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return 
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable {
		
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			
			 String value = result.getString(columnIndex);
			 
			 if(value.equalsIgnoreCase(value)) {
				 flag=true;
				 break;
			 }
			
		    }
		
		if(flag) {
			System.out.println(expData+"   Data Verified");
			return expData;
		}
		else {
			System.out.println("Data is not present");
			return "";
		}
	}
	
	
		
	
	public void closeDB() throws Throwable {
		con.close();
		
	}
}
