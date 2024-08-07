package service;

import java.util.Map;

public class ProjectInputRequest {
    private String projectCode;
    private String projectName;
    private String projectGroup;
    private String projectMemo;

    public ProjectInputRequest(String projectCode, String projectName, String projectGroup, String projectMemo) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectGroup = projectGroup;
        this.projectMemo = projectMemo;
    }

    public void validate(Map<String, Boolean> errors) {
        checkEmpty(errors, projectCode, "employeeCode");
        checkEmpty(errors, projectName, "employeeName");
        // 필요한 다른 필드들에 대한 검증 추가
    }

    private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            errors.put(fieldName, Boolean.TRUE);
        }
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

	public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectGroup() {
        return projectGroup;
    }

    public String getProjectMemo() {
        return projectMemo;
    }
}
