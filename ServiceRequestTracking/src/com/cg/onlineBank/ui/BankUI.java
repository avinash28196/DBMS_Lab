package com.cg.onlineBank.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.onlineBank.dao.ServiceTrackerDAOImpl;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;
import com.cg.onlineBank.service.ITrackingService;
import com.cg.onlineBank.service.TrackingServiceImpl;

public class BankUI {
	
	static Scanner scan = null;
	static ServiceTrackerBean bean = null;
	static BankCustomerBean cBean = null;
	static ITrackingService service = null;
	
	
	public static void main(String[] args){
		
		service = new TrackingServiceImpl();
		scan = new Scanner(System.in);
		
		System.out.println("Service Tracking System");
		System.out.println("***********************************");
		
		while(true)
		{
			System.out.println("1.To select Account Number and to know Request.");
			System.out.println("2.Enter the service request number");
			System.out.println("3.To check the stauts of all service Request");
			System.out.println("4.To Enter A/C Number");
			System.out.println("5.20 Service Request raised in last 180 days");
			System.out.println("6.Fund Transfer System.");
			
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				fetchServiceRequestID();
				break;
			case 2:
				fetchServiceDetailsByID();
				break;
			case 3:
				statusOfAllRequest();
				break;
			case 4:
				fetchServiceDetailsByAccountID();
				break;
			case 5:
				getRequestHistory();
				break;
			case 6:
				fundTransfer();
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 10:
				System.exit(0);
				break;
				
			}
			
		}
	}


	private static void fundTransfer() {
		System.out.println("Fund Transfer System");
		System.out.println("***********************************");
		
		while(true)
		{
			System.out.println("1.Your own  bank account across India.");
			System.out.println("2.Fund Transfer Across Other  account of same bank across india");
	
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				fundTransferOwnAcoount();
				break;
			case 2:
				fetchServiceRequestID();
				break;
		
			}
			
		}
		
	}



	private static void fundTransferOwnAcoount() {
		
		System.out.println("Enter the PAN Number:");
		String pan = scan.next();
		ArrayList<BankCustomerBean> accountList = null;
		accountList = service.getAccountNumber(pan);
		
		for(BankCustomerBean bean:accountList){
			
			System.out.println("Account ID is :" + cBean.getAccountID() );
			System.out.println("Account Type is :" + cBean.getAccountType());
			
		}
		
	}


	private static void getRequestHistory() {
		ArrayList<ServiceTrackerBean> list = null;
		list = service.getRequestHistory();
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceRequestID() {
		System.out.println("Enter the Account ID");
		int AccountID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceRequestID(AccountID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Service ID " +bean.getServiceID());
		}
		
	}

		


	private static void statusOfAllRequest() {
		ArrayList<ServiceTrackerBean> list = null;
		list = service.statusOfAllRequest();
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceDetailsByAccountID() {
		System.out.println("Enter the Account ID");
		int AccountID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceDetailsByAccountID(AccountID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceDetailsByID() {
		
		System.out.println("Enter the Service ID You want to track");
		int serviceID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceDetailsByID(serviceID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("-----------------------------------------");
			System.out.println("");
		}
		
	}

}
