<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신규 품목 등록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center"><b>신규 품목 등록</b></h2>
    
         <!-- 오류 메시지 표시 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-2">${errorMessage}</div>
    </c:if>
    
    
    <form action="addProduct.do" method="post">
        <!-- 품목 코드 -->
        <div class="mb-3">
            <label for="productCode" class="form-label">품목코드</label>
            <input type="text" class="form-control" id="productCode" name="productCode" required>
            <c:if test="${errors['productCode']}">
                <div class="alert alert-danger mt-2">품목 코드는 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 품목 명 -->
        <div class="mb-3">
            <label for="productName" class="form-label">품목명</label>
            <input type="text" class="form-control" id="productName" name="productName" required>
            <c:if test="${errors['productName']}">
                <div class="alert alert-danger mt-2">품목 명은 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 품목 그룹 -->
        <div class="mb-3">
            <label for="productGroup" class="form-label">품목그룹</label>
            <input type="text" class="form-control" id="productGroup" name="productGroup">
            <c:if test="${errors['productGroup']}">
                <div class="alert alert-danger mt-2">품목 그룹은 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 규격 -->
        <div class="mb-3">
            <label for="standard" class="form-label">규격</label>
            <input type="text" class="form-control" id="standard" name="standard">
            <c:if test="${errors['standard']}">
                <div class="alert alert-danger mt-2">규격은 필수 입력 항목입니다.</div>
            </c:if>
        </div>
<!-- 
        바코드
        <div class="mb-3">
            <label for="barcode" class="form-label">바코드</label>
            <input type="text" class="form-control" id="barcode" name="barcode">
           
        </div> -->

        <!-- 매입 가격 -->
        <div class="mb-3">
            <label for="purchasePrice" class="form-label">입고단가</label>
            <input type="number" class="form-control" id="purchasePrice" name="purchasePrice" required  min="0">
            <c:if test="${errors['purchasePrice']}">
                <div class="alert alert-danger mt-2">유효한 매입 가격을 입력해 주세요.</div>
            </c:if>
        </div>

        <!-- 판매 가격 -->
        <div class="mb-3">
            <label for="sellingPrice" class="form-label">출고단가</label>
            <input type="number" class="form-control" id="sellingPrice" name="sellingPrice" required min="0">
            <c:if test="${errors['sellingPrice']}">
                <div class="alert alert-danger mt-2">유효한 판매 가격을 입력해 주세요.</div>
            </c:if>
        </div>

        <!-- 생산 공정 -->
        <div class="mb-3">
            <label for="productionProcess" class="form-label">생산 공정</label>
            <textarea class="form-control" id="productionProcess" name="productionProcess"></textarea>
            <c:if test="${errors['productionProcess']}">
                <div class="alert alert-danger mt-2">생산 공정은 필수 입력 항목입니다.</div>
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
