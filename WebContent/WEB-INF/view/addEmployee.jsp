<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원검색</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center"><b>사원(담당)등록</b></h2>
    
    
         <!-- 오류 메시지 표시 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-2">${errorMessage}</div>
    </c:if>
    
    
    <form action="addEmployee.do" method="post">
        <!-- 직원 코드 -->
        <div class="mb-3">
            <label for="employeeCode" class="form-label">사원(담당)등록</label>
            <input type="text" class="form-control" id="employeeCode" name="employeeCode" required>
            <c:if test="${errors['employeeCode']}">
                <div class="alert alert-danger mt-2">직원 코드는 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 직원 이름 -->
        <div class="mb-3">
            <label for="employeeName" class="form-label">사원(담당)명</label>
            <input type="text" class="form-control" id="employeeName" name="employeeName" required>
            <c:if test="${errors['employeeName']}">
                <div class="alert alert-danger mt-2">직원 이름은 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 검색 내용 -->
        <div class="mb-3">
            <label for="searchContent" class="form-label">검색창내용</label>
            <input type="text" class="form-control" id="searchContent" name="searchContent">
        </div>

     <!--  
        <div class="mb-3">
            <label for="menuCodeUsage" class="form-label">코드사용메뉴</label>
            <input type="text" class="form-control" id="menuCodeUsage" name="menuCodeUsage">
        </div> -->

        <!-- 메모 -->
        <div class="mb-3">
            <label for="memo" class="form-label">적요</label>
            <textarea class="form-control" id="memo" name="memo" rows="3"></textarea>
        </div>

        <!-- 연락처 -->
        <div class="mb-3">
            <label for="contactNumber" class="form-label">담당자연락처</label>
            <input type="text" class="form-control" id="contactNumber" name="contactNumber">
        </div>

        <!-- 이메일 -->
        <div class="mb-3">
            <label for="email" class="form-label">담당자Email</label>
            <input type="text" class="form-control" id="email" name="email">
        </div>

        <!-- 제출 버튼 -->
        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">저장</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
