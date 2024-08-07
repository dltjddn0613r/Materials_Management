<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세 검색</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function openPopup(url, field) {
            // 팝업 창을 열고 데이터 설정
            const popup = window.open(url, 'popup', 'width=800,height=600,scrollbars=yes,resizable=yes');
            popup.onunload = function () {
                // 팝업 창이 닫힐 때 부모 창의 필드에 값 설정
                if (popup.selectedData) {
                    document.getElementById(field).value = popup.selectedData;
                }
            };
        }

        function setDateRange() {
            var startDate = document.getElementById("startDate").value;
            var endDate = document.getElementById("endDate").value;

            if (startDate && endDate && new Date(startDate) > new Date(endDate)) {
                alert("종료 날짜는 시작 날짜 이후여야 합니다.");
                return false;
            }
            return true;
        }

        function sendSearchData() {
            if (setDateRange()) {
                var data = {
                    startDate: document.getElementById("startDate").value,
                    endDate: document.getElementById("endDate").value,
                    warehouse: document.getElementById("warehouse").value,
                    project: document.getElementById("project").value,
                    customer: document.getElementById("customer").value,
                    productCode: document.getElementById("productCode").value,
                    productStandard: document.getElementById("productStandard").value,
                    employee: document.getElementById("employee").value
                };
                window.opener.postMessage(data, window.location.origin);
                window.close();
            }
        }
    </script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4 text-center"><b>상세 검색</b></h2>
        <form onsubmit="return false;">
            <!-- 기준일자 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">기준일자</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="date" class="form-control" id="startDate" required>
                        <span class="input-group-addon">~</span>
                        <input type="date" class="form-control" id="endDate" required>
                    </div>
                </div>
            </div>

            <!-- 창고 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">창고</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="text" class="form-control" id="warehouse" readonly>
                        <button type="button" class="btn btn-outline-secondary" onclick="openPopup('warehouseSearch.do', 'warehouse')">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- 프로젝트 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">프로젝트</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="text" class="form-control" id="project" readonly>
                        <button type="button" class="btn btn-outline-secondary" onclick="openPopup('projectSearch.do', 'project')">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- 거래처 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">거래처</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="text" class="form-control" id="customer" readonly>
                        <button type="button" class="btn btn-outline-secondary" onclick="openPopup('customerSearch.do', 'customer')">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- 품목코드 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">품목코드</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="text" class="form-control" id="productCode" readonly>
                        <button type="button" class="btn btn-outline-secondary" onclick="openPopup('productSearch.do', 'productCode')">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- 규격 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">규격</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="productStandard">
                </div>
            </div>

            <!-- 담당자 -->
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">담당자</label>
                <div class="col-sm-9">
                    <div class="input-group">
                        <input type="text" class="form-control" id="employee" readonly>
                        <button type="button" class="btn btn-outline-secondary" onclick="openPopup('employeeSearch.do', 'employee')">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-primary" onclick="sendSearchData()">검색</button>
                <button type="button" class="btn btn-secondary ms-3" onclick="window.close()">닫기</button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
