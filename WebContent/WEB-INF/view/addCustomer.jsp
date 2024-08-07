<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>거래처 등록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center"><b>거래처 등록</b></h2>
    
     <!-- 오류 메시지 표시 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-2">${errorMessage}</div>
    </c:if>
    
    <form action="addCustomer.do" method="post">
        <!-- 고객 코드 -->
        <div class="mb-3">
            <label for="customerCode" class="form-label">거래처코드</label>
            <input type="text" class="form-control" id="customerCode" name="customerCode" required>
            <c:if test="${errors['customerCode']}">
                <div class="alert alert-danger mt-2">거래처코드는 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- 고객 명 -->
        <div class="mb-3">
            <label for="customerName" class="form-label">상호(이름)</label>
            <input type="text" class="form-control" id="customerName" name="customerName" required>
            <c:if test="${errors['customerName']}">
                <div class="alert alert-danger mt-2">상호(이름)은 필수 입력 항목입니다.</div>
            </c:if>
        </div>

        <!-- CEO 이름 -->
        <div class="mb-3">
            <label for="ceoName" class="form-label">대표자명</label>
            <input type="text" class="form-control" id="ceoName" name="ceoName">
        </div>

        <!-- 사업 유형 -->
        <div class="mb-3">
            <label for="businessType" class="form-label">업태</label>
            <input type="text" class="form-control" id="businessType" name="businessType">
        </div>

        <!-- 산업 -->
        <div class="mb-3">
            <label for="industry" class="form-label">종목</label>
            <input type="text" class="form-control" id="industry" name="industry">
        </div>

        <!-- 전화 번호 -->
        <div class="mb-3">
            <label for="phone" class="form-label">전화</label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>

        <!-- 팩스 -->
        <div class="mb-3">
            <label for="fax" class="form-label">Fax</label>
            <input type="text" class="form-control" id="fax" name="fax">
        </div>

        <!-- 검색 내용 -->
        <div class="mb-3">
            <label for="searchContent" class="form-label">검색창내용</label>
            <input type="text" class="form-control" id="searchContent" name="searchContent">
        </div>

        <!-- 모바일 -->
        <div class="mb-3">
            <label for="mobile" class="form-label">모바일</label>
            <input type="text" class="form-control" id="mobile" name="mobile">
        </div>

        <!-- 우편번호 -->
        <div class="mb-3">
            <label for="postalCode" class="form-label">우편번호</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode">
        </div>

        <!-- 주소 -->
        <div class="mb-3">
            <label for="address1" class="form-label">주소</label>
            <input type="text" class="form-control" id="address1" name="address1">
        </div>

        <!-- 웹사이트 -->
        <div class="mb-3">
            <label for="website" class="form-label">홈페이지</label>
            <input type="text" class="form-control" id="website" name="website">
        </div>

      <!--   담당 직원 
        <div class="mb-3">
            <label for="responsibleEmployee" class="form-label">담당 직원</label>
            <input type="text" class="form-control" id="responsibleEmployee" name="responsibleEmployee">
        </div> -->

        <!-- 이메일 -->
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" id="email" name="email">
        </div>

        <!-- 제출 버튼 -->
        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">등록</button>
        </div>
    </form>
</div>
</body>
</html>
