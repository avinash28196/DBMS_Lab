/**********************************************************************
 * File                 : ScoreManagmentController.java
 * Author Name          : Avinash Ramesh
 * Desc                 : Servelet Controller for the Aplloication
 * Version              : 1.0
 * Last Modified Date   : 10-Nov-2017
 *********************************************************************
*/
package com.cg.scoreManagement.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.scoreManagement.bean.ScoreBean;
import com.cg.scoreManagement.exception.ScoreManagementException;
import com.cg.scoreManagement.service.IScoreManagementService;
import com.cg.scoreManagement.service.ScoreManagementServiceImpl;




@WebServlet("*.obj")
public class ScoreManagmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IScoreManagementService service = new ScoreManagementServiceImpl();
	ScoreBean bean = new ScoreBean();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		
		String target = null;
		
		switch(path)
		{
		case "/retrieve.obj":
			ArrayList<ScoreBean> list;
			try {
				list = service.retrieveDetails();
				HttpSession session=request.getSession();
				session.setAttribute("list", list);
				target = "AddAssessment.jsp";
				break;
			} catch (ScoreManagementException e) {
				e.printStackTrace();
			}
	
			
		
		case "/studentinfo.obj":
			
			String Sid = request.getParameter("traineeId");
			int traineeId = Integer.parseInt(Sid);
			String module =request.getParameter("moduleName");
			String MPT = request.getParameter("practicleTest");
			int modulePracticleTest = Integer.parseInt(MPT);
			String MTT = request.getParameter("theoryTest");
			int moduleTheoryTest = Integer.parseInt(MTT);
			String AssignMark = request.getParameter("assignment");
			int assignment = Integer.parseInt(AssignMark);
			
			int total = service.calculateTotal(modulePracticleTest,moduleTheoryTest,assignment);
			String grade = service.calculateGrade(total);
			
			bean.setTraineeId(traineeId);
			bean.setModuleName(module);
			bean.setModulePracticleTest(modulePracticleTest);
			bean.setModuleTheoryTest(moduleTheoryTest);
			bean.setTraineeId(assignment);
			bean.setTotal(total);
			bean.setGrade(grade);
			
			
			
			int res;
			try {
				res = service.addDetails(bean);
				if(res>0){
					HttpSession session2 = request.getSession();
					session2.setAttribute("sid",bean);
					target="ModuleScore.jsp";
				}
				else
				{
					target = "error.jsp";
				}
			} catch (ScoreManagementException e) {
				
				e.printStackTrace();
			}
			
			break;

		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
		
	}



}
