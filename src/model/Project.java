package model;

public class Project {
    private String projectCode;
    private String projectName;
    private String projectGroup;
    private String projectMemo;

    public Project(String projectCode, String projectName, String projectGroup, String projectMemo) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectGroup = projectGroup;
        this.projectMemo = projectMemo;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectGroup() {
        return projectGroup;
    }

    public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public void setProjectMemo(String projectMemo) {
		this.projectMemo = projectMemo;
	}

	public String getProjectMemo() {
        return projectMemo;
    }
}
