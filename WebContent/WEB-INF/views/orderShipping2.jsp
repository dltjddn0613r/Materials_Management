<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 주석 -->0
<html >
<head>
    <meta charset="UTF-8">
    <title>주문서출고처리</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 기본 레이아웃 스타일 */
        body {
            display: flex; /* Flexbox를 사용하여 레이아웃 구성 */
            min-height: 100vh; /* 최소 높이를 화면 전체로 설정 */
            margin: 0; /* 기본 여백 제거 */
        }

        .accordion-container {
            width: 250px; /* 사이드바 너비 설정 */
            background-color: #f8f9fa; /* 배경색 설정 */
            padding: 10px; /* 여백 추가 */
            position: fixed; /* 고정 위치 설정 */
            height: 100%; /* 화면 높이에 맞춤 */
            overflow-y: auto; /* 세로 스크롤 추가 */
        }

        .main-content {
            margin-left: 250px; /* 사이드바 너비만큼 여백 추가 */
            padding: 20px; /* 여백 추가 */
            width: calc(100% - 250px); /* 사이드바를 제외한 너비 설정 */
        }

        .clickable-item {
            display: block; /* 블록 레벨 요소로 설정 */
            padding: 10px; /* 여백 추가 */
            margin-bottom: 5px; /* 하단 여백 추가 */
            background-color: #e9ecef; /* 배경색 설정 */
            border: 1px solid #dee2e6; /* 테두리 설정 */
            border-radius: 5px; /* 모서리 둥글게 */
            text-decoration: none; /* 링크 기본 스타일 제거 */
            color: #000; /* 텍스트 색상 설정 */
        }

        .clickable-item:hover {
            background-color: #d8d8d8; /* 호버 시 배경색 변경 */
        }
    </style>
</head>
<body>
    <div class="accordion-container">
        <div class="accordion" id="accordionPanelsStayOpenExample">
            <!-- 견적서 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#quoteAccordion" aria-expanded="true" aria-controls="quoteAccordion">
                       견적서
                    </button>
                </h2>
                <div id="quoteAccordion" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <a href="quoteView.jsp" class="clickable-item">견적서 조회</a>
                        <a href="quoteInput.jsp" class="clickable-item">견적서 입력</a>
                        <a href="quoteStatus.jsp" class="clickable-item">견적서 현황</a>
                        <a href="unorderedStatus.jsp" class="clickable-item">미주문 현황</a>
                    </div>
                </div>
            </div>
            <!-- 주문서 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#orderAccordion" aria-expanded="false" aria-controls="orderAccordion">
                       주문서
                    </button>
                </h2>
                <div id="orderAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="orderView.jsp" class="clickable-item">주문서 조회</a>
                        <a href="orderInput.jsp" class="clickable-item">주문서 입력</a>
                        <a href="orderStatus.jsp" class="clickable-item">주문서 현황</a>
                        <a href="orderShipping.jsp" class="clickable-item">주문서 출고처리</a>
                        <a href="unsoldStatus.jsp" class="clickable-item">미판매현황</a>
                    </div>
                </div>
            </div>
            <!-- 판매 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#salesAccordion" aria-expanded="false" aria-controls="salesAccordion">
                        판매
                    </button>
                </h2>
                <div id="salesAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="salesView.jsp" class="clickable-item">판매 조회</a>
                        <a href="salesInput.jsp" class="clickable-item">판매 입력</a>
                        <a href="salesInput2.jsp" class="clickable-item">판매 입력2</a>
                        <a href="salesPriceChange.jsp" class="clickable-item">판매단가 일관변경</a>
                        <a href="salesStatus.jsp" class="clickable-item">판매 현황</a>
                        <a href="paymentView.jsp" class="clickable-item">결제 내역 조회</a>
                        <a href="paymentComparison.jsp" class="clickable-item">결제 내역 자료비교</a>
                    </div>
                </div>
            </div>
            <!-- 출하지시서 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#shipmentOrderAccordion" aria-expanded="false" aria-controls="shipmentOrderAccordion">
                       출하지시서
                    </button>
                </h2>
                <div id="shipmentOrderAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="shipmentOrderView.jsp" class="clickable-item">출하지시서 조회</a>
                        <a href="shipmentOrderInput.jsp" class="clickable-item">출하지시서 입력</a>
                        <a href="shipmentOrderStatus.jsp" class="clickable-item">출하지시서 현황</a>
                    </div>
                </div>
            </div>
            <!-- 출하 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#shipmentAccordion" aria-expanded="false" aria-controls="shipmentAccordion">
                       출하
                    </button>
                </h2>
                <div id="shipmentAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="shipmentView.jsp" class="clickable-item">출하 조회</a>
                        <a href="shipmentInput.jsp" class="clickable-item">출하 입력</a>
                        <a href="shipmentStatus.jsp" class="clickable-item">출하 현황</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <h2 class="d-inline">주문서출고처리</h2>
        <div class="d-inline gap-2 d-md-flex justify-content-md-end">
            <input type="text" class="form-control d-inline" style="width: 200px;" placeholder="입력 후[Enter]" aria-label="Search">
            <button class="btn btn-primary">Search(F3)</button>
            <button class="btn btn-light">Option</button>
            <button class="btn btn-light">도움말</button>
        </div>
        
         <div>
<a href="#" class="btn btn-secondary btn-sm disabled" tabindex="-1" role="button" aria-disabled="true">미처리</a>
<a href="#" class="btn btn-primary btn-sm disabled" tabindex="-1" role="button" aria-disabled="true">처리</a>
        </div>
        <div class="mt-3">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll" aria-label="전체 선택"></th>
                        <th>일자</th>
                        <th>일자</th>
                        <th>거래처명</th>
                        <th>품목</th>
                        <th>출고수량</th>
                        <th>판매</th>
                        <th>인쇄</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty quotes}">
                            <c:forEach var="quote" items="${quotes}">
                                <tr>
                                    <td><input type="checkbox" class="rowCheck" aria-label="선택"></td>
                                    <td>${quote.quoteDate}</td>
                                    <td>${quote.customerCode}</td>
                                    <td>${quote.employeeCode}</td>
                                    <td>${quote.productCode}</td>
                                    <td>${quote.validityPeriod}</td>
                                    <td>${quote.totalAmount}</td>
                                    <td>${quote.status}</td>
                                    <td>${quote.createdVoucher}</td>
                                    <td><button class="btn btn-secondary">인쇄</button></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="10" class="text-center">견적서가 없습니다.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
            		<form action=""></form>
                    <button type="submit" class="btn btn-primary">판매입력</button>
                    <button type="submit" class="btn btn-light">Email</button>
                    <button type="submit" class="btn btn-light">인쇄</button>
                    <button type="submit" class="btn btn-light">Excel</button>
                    <button type="submit" class="btn btn-light">처리구분변경</button>
                    <button type="submit" class="btn btn-light">처리취소</button>
                   </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.getElementById('checkAll').addEventListener('click', function() {
            var checkboxes = document.querySelectorAll('.rowCheck');
            for (var checkbox of checkboxes) {
                checkbox.checked = this.checked;
            }
        });
    </script>
</body>
</html>
