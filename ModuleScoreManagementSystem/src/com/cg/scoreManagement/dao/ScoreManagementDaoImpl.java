/**********************************************************************
 * File                 : ScoreManagementDaoImpl.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Communication with database for e.g CURD operations
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/

package com.cg.scoreManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.scoreManagement.bean.ScoreBean;
import com.cg.scoreManagement.dbutil.DBUtil;
import com.cg.scoreManagement.exception.ScoreManagementException;


public class ScoreManagementDaoImpl implements IScoreManagementDao {

	
	//Array list is stored with Trainee Id that is retrieved from the database 
	@Override
	public ArrayList<ScoreBean> retrieveDetails() throws ScoreManagementException {
		Connection conn= null;
		ArrayList <ScoreBean> list = new ArrayList <ScoreBean> ();
		try{
			conn = DBUtil.getConnection();
			String sql = "Select * from STUDENT_SCORE";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt(1);
				list.add(new ScoreBean(id));
				System.out.println(list);
				
			}
		
		
		}
		catch(SQLException e) {
			throw new ScoreManagementException("Error while fetching values::"+ e.getMessage());
		}
		
		return list;
	}
	
	//Inserting the data into the database.
	@Override
	public int addDetails(ScoreBean bean) throws ScoreManagementException {
		Connection conn = null;
		int row = 0;
		int value = 0;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into STUDENT_SCORE1 values(?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getTraineeId());
			ps.setString(2, bean.getModuleName());
			ps.setInt(3,bean.getModulePracticleTest());
			ps.setInt(4, bean.getModuleTheoryTest());
			ps.setInt(5, bean.getAssignment());
			ps.setInt(6, bean.getTotal());
			ps.setString(7, bean.getGrade());
			
			
			row = ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("select TraineeId from STUDENT_SCORE");
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()){
				value = rs.getInt(1);
			}
			return value;
		}
		catch(SQLException e){
			throw new ScoreManagementException("Error while fetching values::"+ e.getMessage());
			
		}
	
	}

}
