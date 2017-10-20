/**********************************************************************
 * File                 : DBUtil.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Database info
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/

package com.igate.moviebooking.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	
	static Connection conn = null;
	

	public static Connection getConnection() {
		try{
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:/jdbc/oracleDS");
		conn = ds.getConnection();
		}
		catch(SQLException e){
			
		}
		catch(NamingException e){
			
		}
		return conn;
	 	
	}

}