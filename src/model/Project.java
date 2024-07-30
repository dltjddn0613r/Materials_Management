package model;

public class Project {

	private String projectCode;
	private String projectName;
	private String projectMenu;
	private String projectMemo;
	
	public Project(String projectCode, String projectName, String projectMenu, String projectMemo) {
		
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectMenu = projectMenu;
		this.projectMemo = projectMemo;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectMenu() {
		return projectMenu;
	}

	public String getProjectMemo() {
		return projectMemo;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectMenu(String projectMenu) {
		this.projectMenu = projectMenu;
	}

	public void setProjectMemo(String projectMemo) {
		this.projectMemo = projectMemo;
	}
	
	
}
