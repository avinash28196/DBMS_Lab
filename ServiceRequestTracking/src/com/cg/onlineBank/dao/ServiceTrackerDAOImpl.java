package com.cg.onlineBank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.onlineBank.dbutil.DBUtil;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;
import com.cg.onlineBank.service.ITrackingService;


public class ServiceTrackerDAOImpl implements IServiceTrackerDAO{
	Connection con = null;
	int result = 0;
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = serviceID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where Service_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> statusOfAllRequest() {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER";		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select SERVICE_ID from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				
				
				list.add(new ServiceTrackerBean(ServiceId));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> getRequestHistory() {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = DBUtil.getConnection();
			String sql = "select * from Service_Tracker  where (sysdate-Service_Raised_Date)>180" ;	
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<BankCustomerBean> getAccountNumber(String pan) {
		ArrayList <BankCustomerBean> list = new ArrayList<BankCustomerBean>();
		try{
			String pancard = pan;
			Connection conn = DBUtil.getConnection();
			String sql = "select ACCOUNT_ID,ACCOUNTTYPE from BCUSTOMER  where PANCARD=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,pan);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
				int accountID = rs.getInt(1);	
		  	    String accountType = rs.getString(2);
		  	    
				
				list.add(new BankCustomerBean(accountID,accountType));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

}
