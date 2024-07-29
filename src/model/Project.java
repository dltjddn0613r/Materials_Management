package model;

public class Project {

	private String ProjectCode;
	private String ProjectName;
	private String ProjectMenu;
	private String ProjectMemo;
	
	public Project(String projectCode, String projectName, String projectMenu, String projectMemo) {
		
		this.ProjectCode = projectCode;
		this.ProjectName = projectName;
		this.ProjectMenu = projectMenu;
		this.ProjectMemo = projectMemo;
	}

	public String getProjectCode() {
		return ProjectCode;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public String getProjectMenu() {
		return ProjectMenu;
	}

	public String getProjectMemo() {
		return ProjectMemo;
	}

	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public void setProjectMenu(String projectMenu) {
		ProjectMenu = projectMenu;
	}

	public void setProjectMemo(String projectMemo) {
		ProjectMemo = projectMemo;
	}
	
	
}
