package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ProjectDAO;
import jdbc.connection.ConnectionProvider;
import model.Project;

public class ProjectInputService {
	private ProjectDAO projectDao = new ProjectDAO();

	public void addProject(ProjectInputRequest req) {
        try (Connection conn = ConnectionProvider.getConnection()) {
        	Project project = new Project(
                req.getProjectCode(), req.getProjectName(), req.getProjectGroup(), req.getProjectMemo()               
            );
            projectDao.insert(conn, project);
        } catch (SQLException e) {
            throw new RuntimeException("직원 추가 중 오류가 발생했습니다.", e);
        }
    }
}
