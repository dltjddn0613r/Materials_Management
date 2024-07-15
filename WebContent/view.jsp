<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>출하 조회</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    .table-container {
        margin: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>출하 조회</h2>
        <div class="d-flex mb-3">
            <input type="text" class="form-control me-2" placeholder="검색..." aria-label="Search">
            <button class="btn btn-primary" type="button">검색</button>
        </div>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>일자-No.</th>
                    <th>창고명</th>
                    <th>품목명</th>
                    <th>수량합계</th>
                    <th>거래처명</th>
                    <th>인쇄</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-15 / 001</td>
                    <td>창고 A</td>
                    <td>품목 A</td>
                    <td>100</td>
                    <td>ABC Corp</td>
                    <td><button class="btn btn-secondary">인쇄</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-16 / 002</td>
                    <td>창고 B</td>
                    <td>품목 B</td>
                    <td>200</td>
                    <td>XYZ Corp</td>
                    <td><button class="btn btn-secondary">인쇄</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-17 / 003</td>
                    <td>창고 C</td>
                    <td>품목 C</td>
                    <td>150</td>
                    <td>LMN Corp</td>
                    <td><button class="btn btn-secondary">인쇄</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-18 / 004</td>
                    <td>창고 D</td>
                    <td>품목 D</td>
                    <td>250</td>
                    <td>PQR Corp</td>
                    <td><button class="btn btn-secondary">인쇄</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>2024-07-19 / 005</td>
                    <td>창고 E</td>
                    <td>품목 E</td>
                    <td>300</td>
                    <td>STU Corp</td>
                    <td><button class="btn btn-secondary">인쇄</button></td>
                </tr>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
