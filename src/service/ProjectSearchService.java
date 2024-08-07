package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProjectDAO;
import jdbc.connection.ConnectionProvider;
import model.Project;

public class ProjectSearchService {
    private ProjectDAO projectDao = new ProjectDAO();
    private int size = 10; 

    
    public ProjectPage searchProjects(String searchQuery, int pageNo) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            int total = projectDao.searchCount(conn, searchQuery); // 전체 검색 결과 수 가져오기

            List<Project> content = null;
            if (total > 0) {
                int firstRow = (pageNo - 1) * size + 1; // 첫 번째 행 계산
                int endRow = firstRow + size - 1; // 마지막 행 계산
                content = projectDao.search(conn, searchQuery, firstRow, endRow); // 검색어에 따른 상품 목록 가져오기
            }
            return new ProjectPage(total, pageNo, size, content); // 페이지에 맞는 결과 반환
        } catch (SQLException e) {
            throw new RuntimeException("상품 검색 중 오류가 발생했습니다.", e);
        }
    }
}
