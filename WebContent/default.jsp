<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .accordion-container {
            width: 200px; /* ���ϴ� �ʺ�� ������ */
            margin-left: 0; /* ���� ���� */
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
            <!-- ������ -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                       ������
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <a href="controller?action=quoteView" class="clickable-item" id="quoteView">������ ��ȸ</a>
                        <a href="controller?action=quoteInput" class="clickable-item" id="quoteInput">������ �Է�</a>
                        <a href="controller?action=quoteStatus" class="clickable-item" id="quoteStatus">������ ��Ȳ</a>
                        <a href="controller?action=unorderedStatus" class="clickable-item" id="unorderedStatus">���ֹ� ��Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- �ֹ��� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                       �ֹ���
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=orderView" class="clickable-item" id="orderView">�ֹ��� ��ȸ</a>
                        <a href="controller?action=orderInput" class="clickable-item" id="orderInput">�ֹ��� �Է�</a>
                        <a href="controller?action=orderStatus" class="clickable-item" id="orderStatus">�ֹ��� ��Ȳ</a>
                        <a href="controller?action=orderShipping" class="clickable-item" id="orderShipping">�ֹ��� ���ó��</a>
                        <a href="controller?action=unsoldStatus" class="clickable-item" id="unsoldStatus">���Ǹ���Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- �Ǹ� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                        �Ǹ�
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=salesView" class="clickable-item" id="salesView">�Ǹ� ��ȸ</a>
                        <a href="controller?action=salesInput" class="clickable-item" id="salesInput">�Ǹ� �Է�</a>
                        <a href="controller?action=salesInput2" class="clickable-item" id="salesInput2">�Ǹ� �Է�2</a>
                        <a href="controller?action=salesPriceChange" class="clickable-item" id="salesPriceChange">�ǸŴܰ� �ϰ�����</a>
                        <a href="controller?action=salesStatus" class="clickable-item" id="salesStatus">�Ǹ� ��Ȳ</a>
                        <a href="controller?action=paymentView" class="clickable-item" id="paymentView">���� ���� ��ȸ</a>
                        <a href="controller?action=paymentComparison" class="clickable-item" id="paymentComparison">���� ���� �ڷ��</a>
                    </div>
                </div>
            </div>
            <!-- �������ü� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="false" aria-controls="panelsStayOpen-collapseFour">
                       �������ü�
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=shipmentOrderView" class="clickable-item" id="shipmentOrderView">�������ü� ��ȸ</a>
                        <a href="controller?action=shipmentOrderInput" class="clickable-item" id="shipmentOrderInput">�������ü� �Է�</a>
                        <a href="controller?action=shipmentOrderStatus" class="clickable-item" id="shipmentOrderStatus">�������ü� ��Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- ���� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFive" aria-expanded="false" aria-controls="panelsStayOpen-collapseFive">
                       ����
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseFive" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="controller?action=shipmentView" class="clickable-item" id="shipmentView">���� ��ȸ</a>
                        <a href="controller?action=shipmentInput" class="clickable-item" id="shipmentInput">���� �Է�</a>
                        <a href="controller?action=shipmentStatus" class="clickable-item" id="shipmentStatus">���� ��Ȳ</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
