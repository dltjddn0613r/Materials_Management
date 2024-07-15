<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="mvc.model.Quote" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>견적서 조회</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            min-height: 100vh;
        }
        .accordion-container {
            width: 250px; /* 사이드바의 너비 설정 */
            background-color: #f8f9fa; /* 배경색 설정 */
            padding: 10px; /* 여백 추가 */
        }
        .main-content {
            flex-grow: 1; /* 메인 콘텐츠가 남은 공간을 차지하도록 설정 */
            padding: 20px; /* 여백 추가 */
        }
        .clickable-item {
            display: block;
            padding: 10px;
            margin-bottom: 5px;
            background-color: #e9ecef;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            text-decoration: none;
            color: #000;
        }
        .clickable-item:hover {
            background-color: #d8d8d8;
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
        <h2 class="d-inline">견적서 조회</h2>
        <div class="d-inline">
            <input type="text" class="form-control d-inline" style="width: 200px;" placeholder="검색창." aria-label="Search">
            <button class="btn btn-primary">검색</button>
        </div>
        <div class="mt-3">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll"></th>
                        <th>일자</th>
                        <th>No.</th>
                        <th>거래처명</th>
                        <th>담당자명</th>
                        <th>품목명</th>
                        <th>유효기간</th>
                        <th>견적금액합계</th>
                        <th>진행상태</th>
                        <th>생성한 전표</th>
                        <th>인쇄</th>
                    </tr>
                </thead>
              <tbody>
    <%
        List<Quote> quotes = (List<Quote>) request.getAttribute("quotes");
        if (quotes != null && !quotes.isEmpty()) { // quotes가 null이 아니고 비어있지 않은 경우
            for (Quote quote : quotes) {
    %>
                <tr>
                            <td><input type="checkbox" class="rowCheck"></td>
                            <td>${quote.date}</td>
                            <td>${quote.id}</td>
                            <td>${quote.clientName}</td>
                            <td>${quote.clientName}</td>
                            <td>${quote.itemName}</td>
                            <td>${quote.date}</td>
                            <td>${quote.totalAmount}</td>
                            <td>${quote.status}</td>
                            <td>생성한 전표</td>
                            <td><button class="btn btn-secondary">인쇄</button></td>
                        </tr>

    <%
            }
        } else {
    %>
            <tr>
                <td colspan="11" class="text-center">견적서가 없습니다.</td>
            </tr>
    <%
        }
    %>
</tbody>
            </table>
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
