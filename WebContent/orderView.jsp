<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>�ֹ��� ��ȸ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            min-height: 100vh;
        }
        .accordion-container {
            width: 250px; /* ���̵���� �ʺ� ���� */
            background-color: #f8f9fa; /* ���� ���� */
            padding: 10px; /* ���� �߰� */
        }
        .main-content {
            flex-grow: 1; /* ���� �������� ���� ������ �����ϵ��� ���� */
            padding: 20px; /* ���� �߰� */
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
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#quoteAccordion" aria-expanded="false" aria-controls="quoteAccordion">
                       ������
                    </button>
                </h2>
                <div id="quoteAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="quoteView.jsp" class="clickable-item">������ ��ȸ</a>
                        <a href="quoteInput.jsp" class="clickable-item">������ �Է�</a>
                        <a href="quoteStatus.jsp" class="clickable-item">������ ��Ȳ</a>
                        <a href="unorderedStatus.jsp" class="clickable-item">���ֹ� ��Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- �ֹ��� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#orderAccordion" aria-expanded="true" aria-controls="orderAccordion">
                       �ֹ���
                    </button>
                </h2>
                <div id="orderAccordion" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <a href="orderView.jsp" class="clickable-item">�ֹ��� ��ȸ</a>
                        <a href="orderInput.jsp" class="clickable-item">�ֹ��� �Է�</a>
                        <a href="orderStatus.jsp" class="clickable-item">�ֹ��� ��Ȳ</a>
                        <a href="orderShipping.jsp" class="clickable-item">�ֹ��� ���ó��</a>
                        <a href="unsoldStatus.jsp" class="clickable-item">���Ǹ���Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- �Ǹ� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#salesAccordion" aria-expanded="false" aria-controls="salesAccordion">
                        �Ǹ�
                    </button>
                </h2>
                <div id="salesAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="salesView.jsp" class="clickable-item">�Ǹ� ��ȸ</a>
                        <a href="salesInput.jsp" class="clickable-item">�Ǹ� �Է�</a>
                        <a href="salesInput2.jsp" class="clickable-item">�Ǹ� �Է�2</a>
                        <a href="salesPriceChange.jsp" class="clickable-item">�ǸŴܰ� �ϰ�����</a>
                        <a href="salesStatus.jsp" class="clickable-item">�Ǹ� ��Ȳ</a>
                        <a href="paymentView.jsp" class="clickable-item">���� ���� ��ȸ</a>
                        <a href="paymentComparison.jsp" class="clickable-item">���� ���� �ڷ��</a>
                    </div>
                </div>
            </div>
            <!-- �������ü� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#shipmentOrderAccordion" aria-expanded="false" aria-controls="shipmentOrderAccordion">
                       �������ü�
                    </button>
                </h2>
                <div id="shipmentOrderAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="shipmentOrderView.jsp" class="clickable-item">�������ü� ��ȸ</a>
                        <a href="shipmentOrderInput.jsp" class="clickable-item">�������ü� �Է�</a>
                        <a href="shipmentOrderStatus.jsp" class="clickable-item">�������ü� ��Ȳ</a>
                    </div>
                </div>
            </div>
            <!-- ���� -->
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#shipmentAccordion" aria-expanded="false" aria-controls="shipmentAccordion">
                       ����
                    </button>
                </h2>
                <div id="shipmentAccordion" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <a href="shipmentView.jsp" class="clickable-item">���� ��ȸ</a>
                        <a href="shipmentInput.jsp" class="clickable-item">���� �Է�</a>
                        <a href="shipmentStatus.jsp" class="clickable-item">���� ��Ȳ</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <h2 class="d-inline">�ֹ��� ��ȸ</h2>
        <div class="d-inline">
            <input type="text" class="form-control d-inline" style="width: 200px;" placeholder="�˻�..." aria-label="Search">
            <button class="btn btn-primary">�˻�</button>
        </div>
        <div class="mt-3">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll"></th>
                        <th>����</th>
                        <th>No.</th>
                        <th>�ŷ�ó��</th>
                        <th>����ڸ�</th>
                        <th>ǰ���</th>
                        <th>��������</th>
                        <th>�ֹ��ݾ��հ�</th>
                        <th>�������</th>
                        <th>������ ��ǥ</th>
                        <th>�μ�</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="checkbox" class="rowCheck"></td>
                        <td>2024-07-15</td>
                        <td>001</td>
                        <td>XYZ Ltd.</td>
                        <td>Jane Smith</td>
                        <td>Item B</td>
                        <td>2024-08-20</td>
                        <td>2000.00</td>
                        <td>�Ϸ�</td>
                        <td>Voucher 2</td>
                        <td><button class="btn btn-secondary">�μ�</button></td>
                    </tr>
                    <!-- �߰� ������ �� -->
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
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
