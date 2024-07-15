<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��ȸ</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    .table-container {
        margin: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>���� ��ȸ</h2>
        <div class="d-flex mb-3">
            <input type="text" class="form-control me-2" placeholder="�˻�..." aria-label="Search">
            <button class="btn btn-primary" type="button">�˻�</button>
        </div>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>����-No.</th>
                    <th>â���</th>
                    <th>ǰ���</th>
                    <th>�����հ�</th>
                    <th>�ŷ�ó��</th>
                    <th>�μ�</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-15 / 001</td>
                    <td>â�� A</td>
                    <td>ǰ�� A</td>
                    <td>100</td>
                    <td>ABC Corp</td>
                    <td><button class="btn btn-secondary">�μ�</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-16 / 002</td>
                    <td>â�� B</td>
                    <td>ǰ�� B</td>
                    <td>200</td>
                    <td>XYZ Corp</td>
                    <td><button class="btn btn-secondary">�μ�</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-17 / 003</td>
                    <td>â�� C</td>
                    <td>ǰ�� C</td>
                    <td>150</td>
                    <td>LMN Corp</td>
                    <td><button class="btn btn-secondary">�μ�</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-18 / 004</td>
                    <td>â�� D</td>
                    <td>ǰ�� D</td>
                    <td>250</td>
                    <td>PQR Corp</td>
                    <td><button class="btn btn-secondary">�μ�</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-19 / 005</td>
                    <td>â�� E</td>
                    <td>ǰ�� E</td>
                    <td>300</td>
                    <td>STU Corp</td>
                    <td><button class="btn btn-secondary">�μ�</button></td>
                </tr>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
