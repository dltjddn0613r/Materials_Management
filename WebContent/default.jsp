<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            min-height: 100vh; /* 전체 높이 */
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
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                       견적서
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <a href="controller?action=quoteView" class="clickable-item">견적서 조회</a>
                        <a href="controller?action=quoteInput" class="clickable-item">견적서 입력</a>
                        <a href="controller?action=quoteStatus" class="clickable-item">견적서 현황</a>
                        <a href="controller?action=unorderedStatus" class="clickable-item">미주문 현황</a>
                    </div>
                </div>
            </div>
            <!-- 주문서 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                       주문서
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=orderView" class="clickable-item">주문서 조회</a>
                        <a href="controller?action=orderInput" class="clickable-item">주문서 입력</a>
                        <a href="controller?action=orderStatus" class="clickable-item">주문서 현황</a>
                        <a href="controller?action=orderShipping" class="clickable-item">주문서 출고처리</a>
                        <a href="controller?action=unsoldStatus" class="clickable-item">미판매현황</a>
                    </div>
                </div>
            </div>
            <!-- 판매 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                        판매
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=salesView" class="clickable-item">판매 조회</a>
                        <a href="controller?action=salesInput" class="clickable-item">판매 입력</a>
                        <a href="controller?action=salesInput2" class="clickable-item">판매 입력2</a>
                        <a href="controller?action=salesPriceChange" class="clickable-item">판매단가 일관변경</a>
                        <a href="controller?action=salesStatus" class="clickable-item">판매 현황</a>
                        <a href="controller?action=paymentView" class="clickable-item">결제 내역 조회</a>
                        <a href="controller?action=paymentComparison" class="clickable-item">결제 내역 자료비교</a>
                    </div>
                </div>
            </div>
            <!-- 출하지시서 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="false" aria-controls="panelsStayOpen-collapseFour">
                       출하지시서
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=shipmentOrderView" class="clickable-item">출하지시서 조회</a>
                        <a href="controller?action=shipmentOrderInput" class="clickable-item">출하지시서 입력</a>
                        <a href="controller?action=shipmentOrderStatus" class="clickable-item">출하지시서 현황</a>
                    </div>
                </div>
            </div>
            <!-- 출하 -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFive" aria-expanded="false" aria-controls="panelsStayOpen-collapseFive">
                       출하
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseFive" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=shipmentView" class="clickable-item">출하 조회</a>
                        <a href="controller?action=shipmentInput" class="clickable-item">출하 입력</a>
                        <a href="controller?action=shipmentStatus" class="clickable-item">출하 현황</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <!-- 여기에 메인 콘텐츠가 들어갑니다. -->
        <h2>메인 콘텐츠 제목</h2>
        <p>여기에 메인 콘텐츠 내용을 추가하세요.</p>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
