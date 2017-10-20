/**********************************************************************
 * File                 : IScoreManagementService.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Service Layer Interface for the Application
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/
package com.cg.scoreManagement.service;

import java.util.ArrayList;

import com.cg.scoreManagement.bean.ScoreBean;
import com.cg.scoreManagement.exception.ScoreManagementException;

public interface IScoreManagementService {

	ArrayList<ScoreBean> retrieveDetails() throws ScoreManagementException;

	int calculateTotal(int modulePracticleTest, int moduleTheoryTest,int assignment);

	String calculateGrade(int total);

	int addDetails(ScoreBean bean) throws ScoreManagementException;

}
