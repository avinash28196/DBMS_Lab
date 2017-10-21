package com.cg.onlineBank.dao;

import java.util.ArrayList;

import com.cg.onlineBank.dto.ServiceTrackerBean;

public interface IServiceTrackerDAO {
	
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID);
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID);
	
}
