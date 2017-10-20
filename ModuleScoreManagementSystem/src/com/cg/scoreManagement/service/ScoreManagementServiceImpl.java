/**********************************************************************
 * File                 : ScoreManagementServiceImpl.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Implmentation of Service Layer
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/

package com.cg.scoreManagement.service;

import java.util.ArrayList;

import com.cg.scoreManagement.bean.ScoreBean;
import com.cg.scoreManagement.dao.IScoreManagementDao;
import com.cg.scoreManagement.dao.ScoreManagementDaoImpl;
import com.cg.scoreManagement.exception.ScoreManagementException;


public class ScoreManagementServiceImpl implements IScoreManagementService {
	IScoreManagementDao dao= null;
	
	
	// ArrayList to Store the bean data
	@Override
	public ArrayList<ScoreBean> retrieveDetails() throws ScoreManagementException {
		IScoreManagementDao dao = new ScoreManagementDaoImpl();
		return dao.retrieveDetails();
	}
	
	//sub module to calculate the total marks 
	@Override
	public int calculateTotal(int modulePracticleTest, int moduleTheoryTest,int assignment){
		
			int mpt = modulePracticleTest;
			int mtt = moduleTheoryTest;
			int assign = assignment;
		    int tot = mpt + mtt + assign;
		
	return tot;
	}
	
	
	//sub module to calculate the grade
	@Override
	public String calculateGrade(int total) {
		String grade=null;
		if(total>90)
			grade="S";
		else if(total>80)
			grade="A";
		else if(total>70)
			grade="B";
		else if(total>60)
			grade="C";
		else if(total>50)
			grade="D";
			else
			grade="U";
		return grade;
	}
	
	
	// method to add bean value into database
	@Override
	public int addDetails(ScoreBean bean) throws ScoreManagementException {
		IScoreManagementDao dao = new ScoreManagementDaoImpl();
		return dao.addDetails(bean);
	}

}
