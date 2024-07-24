<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>견적서 입력</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>견적서 입력</h2>
        <form action="${pageContext.request.contextPath}/insertQuote" method="post">
            <div class="mb-3">
                <label for="quoteDate" class="form-label">일자</label>
                <input type="date" class="form-control" id="quoteDate" name="quoteDate" required>
            </div>
            <div class="mb-3">
                <label for="quoteNumber" class="form-label">견적번호</label>
                <input type="text" class="form-control" id="quoteNumber" name="quoteNumber" required>
            </div>
            <div class="mb-3">
                <label for="customerCode" class="form-label">거래처명</label>
                <input type="text" class="form-control" id="customerCode" name="customerCode" required>
            </div>
            <div class="mb-3">
                <label for="employeeCode" class="form-label">담당자명</label>
                <input type="text" class="form-control" id="employeeCode" name="employeeCode" required>
            </div>
            <div class="mb-3">
                <label for="productCode" class="form-label">품목명</label>
                <input type="text" class="form-control" id="productCode" name="productCode" required>
            </div>
            <div class="mb-3">
                <label for="validityPeriod" class="form-label">유효기간</label>
                <input type="date" class="form-control" id="validityPeriod" name="validityPeriod">
            </div>
            <div class="mb-3">
                <label for="totalAmount" class="form-label">견적금액합계</label>
                <input type="number" step="0.01" class="form-control" id="totalAmount" name="totalAmount" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">진행상태</label>
                <input type="text" class="form-control" id="status" name="status">
            </div>
            <button type="submit" class="btn btn-primary">저장</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
