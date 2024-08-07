<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>프로젝트 생성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4 text-center"><b>프로젝트 생성</b></h2>
           
         <!-- 오류 메시지 표시 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-2">${errorMessage}</div>
    </c:if>
    
     <form action="addProject.do" method="post">
    
            <div class="mb-3">
                <label for="projectCode" class="form-label">프로젝트 코드</label>
                <input type="text" class="form-control" id="projectCode" name="projectCode" required>
            </div>
            <div class="mb-3">
                <label for="projectName" class="form-label">프로젝트명</label>
                <input type="text" class="form-control" id="projectName" name="projectName" required>
            </div>
            <div class="mb-3">
                <label for="projectGroup" class="form-label">프로젝트 그룹</label>
                <input type="text" class="form-control" id="projectGroup" name="projectGroup" required>
            </div>
            <div class="mb-3">
                <label for="projectMemo" class="form-label">프로젝트 메모</label>
                <textarea class="form-control" id="projectMemo" name="projectMemo" rows="3"></textarea>
            </div>
              <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">생성</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
