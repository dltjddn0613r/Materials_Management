<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>판매단가일괄변경</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">판매단가일괄변경</h2>
        <form action="quoteInput" method="post">
            <div class="mb-3">
                <label for="quoteDate" class="form-label">구분</label>
                <input type="date" class="form-control" id="quoteDate" name="quoteDate" required>
            </div>
            <div class="mb-3">
                <label for="customerCode" class="form-label">거래처 코드</label>
                <input type="text" class="form-control" id="customerCode" name="customerCode" required>
            </div>
            <div class="mb-3">
                <label for="employeeCode" class="form-label">담당자 코드</label>
                <input type="text" class="form-control" id="employeeCode" name="employeeCode" required>
            </div>
            <div class="mb-3">
                <label for="productCode" class="form-label">품목 코드</label>
                <input type="text" class="form-control" id="productCode" name="productCode" required>
            </div>
            <div class="mb-3">
                <label for="validityPeriod" class="form-label">유효기간</label>
                <input type="date" class="form-control" id="validityPeriod" name="validityPeriod">
            </div>
            <div class="mb-3">
                <label for="totalAmount" class="form-label">견적 금액 합계</label>
                <input type="number" class="form-control" id="totalAmount" name="totalAmount" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">진행 상태</label>
                <input type="text" class="form-control" id="status" name="status" required>
            </div>
            <div class="mb-3">
                <label for="createdVoucher" class="form-label">생성한 전표</label>
                <input type="text" class="form-control" id="createdVoucher" name="createdVoucher">
            </div>
            <button type="submit" class="btn btn-primary">저장</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
