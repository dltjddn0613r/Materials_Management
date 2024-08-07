<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>외화검색</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center"><b>외화등록</b></h2>
    
    
         <!-- 오류 메시지 표시 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-2">${errorMessage}</div>
    </c:if>
    
    
    <form action="addExchangeRate.do" method="post">
        <!-- 환율 코드 -->
        <div class="mb-3">
            <label for="exchangeRateCode" class="form-label">환율 코드</label>
            <input type="text" class="form-control" id="exchangeRateCode" name="exchangeRateCode" required>
            <c:if test="${errors['exchangeRateCode']}">
                <div class="alert alert-danger mt-2">환율 코드는 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 환율명 -->
        <div class="mb-3">
            <label for="exchangeRateName" class="form-label">환율명</label>
            <input type="text" class="form-control" id="exchangeRateName" name="exchangeRateName" required>
            <c:if test="${errors['exchangeRateName']}">
                <div class="alert alert-danger mt-2">환율명 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 환율 -->
        <div class="mb-3">
            <label for="exchangeRate" class="form-label">환율</label>
            <input type="text" class="form-control" id="exchangeRate" name="exchangeRate" required>
            <c:if test="${errors['exchangeRate']}">
                <div class="alert alert-danger mt-2">환율은 필수 입력 항목입니다.</div>
            </c:if>
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
