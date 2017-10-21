package com.cg.onlineBank.service;

import java.util.ArrayList;

import com.cg.onlineBank.dao.ServiceTrackerDAOImpl;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;

public class TrackingServiceImpl implements ITrackingService {
	ServiceTrackerDAOImpl dao = null;
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceDetailsByID(serviceID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceDetailsByAccountID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> statusOfAllRequest() {
		dao = new ServiceTrackerDAOImpl();
		return dao.statusOfAllRequest();
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceRequestID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> getRequestHistory() {
		dao = new ServiceTrackerDAOImpl();
		return dao.getRequestHistory();
	}

	@Override
	public ArrayList<BankCustomerBean> getAccountNumber(String pan) {
		dao = new ServiceTrackerDAOImpl();
		return dao.getAccountNumber(pan);
	}

}
