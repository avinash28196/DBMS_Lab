package com.cg.scoreManagement.bean;

public class ScoreBean {
	private int traineeId;
	private String moduleName;
	private int modulePracticleTest;
	private int moduleTheoryTest;
	private int assignment;
	private int total;
	private String grade;
	
	public ScoreBean(){
		
	}
	
	

	public int getTraineeId() {
		return traineeId;
	}
	
	public ScoreBean(int traineeId) {
	super();
	this.traineeId = traineeId;
	}



	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getModulePracticleTest() {
		return modulePracticleTest;
	}

	public void setModulePracticleTest(int modulePracticleTest) {
		this.modulePracticleTest = modulePracticleTest;
	}

	public int getModuleTheoryTest() {
		return moduleTheoryTest;
	}

	public void setModuleTheoryTest(int moduleTheoryTest) {
		this.moduleTheoryTest = moduleTheoryTest;
	}

	public int getAssignment() {
		return assignment;
	}

	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public ScoreBean(int traineeId, String moduleName, int modulePracticleTest,
			int moduleTheoryTest, int assignment, int total, String grade) {
		super();
		this.traineeId = traineeId;
		this.moduleName = moduleName;
		this.modulePracticleTest = modulePracticleTest;
		this.moduleTheoryTest = moduleTheoryTest;
		this.assignment = assignment;
		this.total = total;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "" + traineeId;
	}
	
	
	

	
	
	
	
	
}
