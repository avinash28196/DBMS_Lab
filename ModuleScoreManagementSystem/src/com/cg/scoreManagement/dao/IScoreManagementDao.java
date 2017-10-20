/**********************************************************************
 * File                 : IScoreManagementDao.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Interface for DAO Layer
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/

package com.cg.scoreManagement.dao;

import java.util.ArrayList;

import com.cg.scoreManagement.bean.ScoreBean;
import com.cg.scoreManagement.exception.ScoreManagementException;

public interface IScoreManagementDao {

	ArrayList<ScoreBean> retrieveDetails() throws ScoreManagementException;

	int addDetails(ScoreBean bean) throws ScoreManagementException;

}
